package cps450;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cps450.oodle.analysis.*;
import cps450.oodle.node.*;

public class SemanticChecker extends DepthFirstAdapter {

	SymbolTable symbolTable;
	Hashtable<Node, Type> typeDecorations;
	Integer errorCount;
	
	public SemanticChecker() {
		super();
		symbolTable = new SymbolTable();
		typeDecorations = new Hashtable<Node, Type>();
		errorCount = 0;
		Type.intialize();
		
		symbolTable.push("out", new VariableDeclaration(Type.getType("out"), "SYSTEM DECLARED"));
		ArrayList<Type> outTypes = new ArrayList<Type>();
		outTypes.add(Type.getType("int"));
		symbolTable.push("writeint", new MethodDeclaration(Type.getType("void"), "SYSTEM DECLARED", outTypes));
		symbolTable.push("in", new VariableDeclaration(Type.getType("in"), "SYSTEM DECLARED"));
		symbolTable.push("readint", new MethodDeclaration(Type.getType("int"), "SYSTEM DECLARED", new ArrayList<Type>()));
		symbolTable.beginScope();
	}
	
	private String locationFor(Token t) {
		return SourceHolder.instance().getFilenameFor(t) + ":" + SourceHolder.instance().getLineNumberFor(t) + "," + t.getPos();
	}
	
	private void reportError(Token t, String errorText) {
		this.errorCount++;
		String output = "";
		if (t != null) {
			output += locationFor(t) + ":";
		}
		System.out.println(output + errorText);
	}
	
	private Type typeFor(PType type) {
		if (type == null) {
			return Type.getType("void");
		} else if (type instanceof AIntegerType) {
			return Type.getType("int");
		} else if (type instanceof AStringType) {
			return Type.getType("string");
		} else if (type instanceof ABooleanType) {
			return Type.getType("boolean");
		} else if (type instanceof AOtherType) {
			return Type.getType(((AOtherType)type).getId().getText());
		}
		return null; // TODO: throw exception
	}
	
	@Override
	public void outAVarDeclaration(AVarDeclaration node) {
		Declaration decl = new VariableDeclaration( typeFor(node.getType()), locationFor(node.getName()) );
		Symbol previousDeclaration = symbolTable.scopeContains(node.getName().getText());
		if (previousDeclaration != null) {
			reportError(node.getName(), "Variable '" + node.getName().getText() + "' previously defined at "  + previousDeclaration.getDeclaration().getLocation());
		}
		symbolTable.push(node.getName().getText(), decl);
	}

	@Override
	public void outACallExpression(ACallExpression node) {
		Type returnType = Type.getType("error");
		
		Symbol symbol = symbolTable.lookup(node.getMethod().getText());
		if (symbol == null) {
			reportError(node.getMethod(), "Used undefined method '" + node.getMethod().getText() + "'");
		} else {
			MethodDeclaration decl = (MethodDeclaration) symbol.getDeclaration();
			// Check count of arguments
			Integer actualArgCount = node.getArguments().size();
			if (decl.getArgumentCount() != actualArgCount) {
				reportError(node.getMethod(), "Wrong number of arguments given to method call: expected " + decl.getArgumentCount() + " got " + actualArgCount);
			} else {
				// Size is correct, check types
				int i = 0;
				for (Iterator<PExpression> args = node.getArguments().iterator(); args.hasNext();) {
					PExpression arg = args.next();
					Type argType = typeDecorations.get(arg);
					Type correctArgType = decl.getArgumentTypes().get(i);
					if (argType != correctArgType) {
						reportError(node.getMethod(), "Wrong type encountered in method call at argument " + (i+1) + ": expected '" + correctArgType.getName() + "' found '" + argType.getName() + "'");
					}
					i++;
				}
			}
			returnType = decl.getType();
		}
		
		typeDecorations.put(node, returnType);
	}

	@Override
	public void inAMethodDeclaration(AMethodDeclaration node) {
		// Get the parameter types
		ArrayList<Type> argumentTypes = new ArrayList<Type>();
		for (Iterator<PArgumentDeclaration> i = node.getArgumentDeclaration().iterator(); i.hasNext();) {
			AArgumentDeclaration arg = (AArgumentDeclaration)i.next();
			argumentTypes.add( typeFor(arg.getType()) );
		}
		
		// Verify that the naming on both ends is the same
		if (!node.getBeginName().getText().equals(node.getEndName().getText())) {
			reportError(node.getEndName(), "Expected " + node.getBeginName().getText() + " ending the method declaration, but instead found " + node.getEndName().getText());
		}
		
		// Only allow one method declaration for now...
		if (!node.getBeginName().getText().equals("start")) {
			reportError(node.getBeginName(), "Method declarations other than 'start' not yet supported");
		}
		
		// Push the method declaration onto the symbol table
		MethodDeclaration declaration = new MethodDeclaration( typeFor(node.getType()), locationFor(node.getBeginName()), argumentTypes );
		Symbol previousDeclaration = symbolTable.scopeContains(node.getBeginName().getText());
		if (previousDeclaration != null) {
			reportError(node.getBeginName(), "Method '" + node.getBeginName().getText() + "' previously defined at " + previousDeclaration.getDeclaration().getLocation() + ".");
		}
		symbolTable.push(node.getBeginName().getText(), declaration);
		
		// Increment the scope
		symbolTable.beginScope();
		
		// Add the method name as a variable (for assigning the return value)
		VariableDeclaration returnDecl = new VariableDeclaration( typeFor(node.getType()), locationFor(node.getBeginName()) );
		symbolTable.push(node.getBeginName().getText(), returnDecl);
	}

	@Override
	public void inAStart(AStart node) {
		if (node.getClassDef().size() != 1) {
			reportError(null, "You must define exactly one class");
		}
	}

	@Override
	public void inAClassDef(AClassDef node) {
		// Verify that the naming on both ends is the same
		if (!node.getBeginName().getText().equals(node.getEndName().getText())) {
			reportError(node.getEndName(), "Expected " + node.getBeginName().getText() + " ending the class definition, but instead found " + node.getEndName().getText());
		}
	}

	@Override
	public void outAArgumentDeclaration(AArgumentDeclaration node) {
		Declaration decl = new VariableDeclaration( typeFor(node.getType()), locationFor(node.getName()) );
		if (symbolTable.scopeContains(node.getName().getText()) != null) {
			reportError(node.getName(), "Argument '" + node.getName().getText() + "' previously defined.");
		}
		symbolTable.push(node.getName().getText(), decl);
	}

	@Override
	public void outAMethodDeclaration(AMethodDeclaration node) {
		symbolTable.endScope();
	}

	@Override
	public void outAAddExpression(AAddExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = (node.getOperator() instanceof APlusOperator ? ((APlusOperator)node.getOperator()).getOp() : ((AMinusOperator)node.getOperator()).getOp());

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both integers
			Type expectedType = Type.getType("int");
			if (lt != expectedType) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type '" + expectedType.getName() + "' got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = lt;
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAAndExpression(AAndExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = node.getAnd();

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both booleans
			Type expectedType = Type.getType("boolean");
			if (lt != expectedType) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type '" + expectedType.getName() + "' got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = lt;
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAAssignmentStatement(AAssignmentStatement node) {
		// TODO: Need to implement checking on array accessing assignments
		Type result = Type.getType("error");
		
		Declaration decl = null;
		Symbol id = symbolTable.lookup(node.getId().getText());
		if (id == null) {
			reportError(node.getId(), "Attempted to assign a value to an undefined variable '" + node.getId().getText() + "'");
		} else {
			decl = id.getDeclaration();
			if (decl instanceof VariableDeclaration) {
				Type expectedType = decl.getType();
				Type exprType = typeDecorations.get(node.getValue());
				if (exprType != expectedType) {
					reportError(node.getId(), "Expected expression of type '" + expectedType.getName() + "' got '" + exprType.getName() + "' at assignment to variable '" + node.getId().getText() + "'");
				} else {
					result = exprType;
				}
			} else {
				reportError(node.getId(), "Attempted to assign a value to a non-variable identifier '" + node.getId().getText() + "'");
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAComparisonExpression(AComparisonExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = null;
		if (node.getOperator() instanceof AGreaterOperator) {
			token = ((AGreaterOperator)node.getOperator()).getOp();
		} else if (node.getOperator() instanceof AGreaterEqualOperator) {
			token = ((AGreaterEqualOperator)node.getOperator()).getOp();
		} else if (node.getOperator() instanceof AEqualOperator) {
			token = ((AEqualOperator)node.getOperator()).getOp();
		}

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both integers or strings
			Type integer = Type.getType("int");
			Type string = Type.getType("string");
			if (!(lt == integer || lt == string)) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type 'integer' or 'string' in comparison got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = Type.getType("boolean");
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAConcatenationExpression(AConcatenationExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = node.getConcatOp();

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both strings
			Type expectedType = Type.getType("string");
			if (lt != expectedType) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type '" + expectedType.getName() + "' got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = lt;
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAIdentifierExpression(AIdentifierExpression node) {
		Type result = Type.getType("error");
		
		Symbol symbol = symbolTable.lookup(node.getId().getText());
		if (symbol == null) {
			reportError(node.getId(), "Attempted to used undeclared variable '" + node.getId().getText() + "' in expression");
		} else {
			Declaration decl = symbol.getDeclaration();
			if (decl instanceof VariableDeclaration) {
				result = decl.getType();
			} else {
				reportError(node.getId(), "Attempted to use a non-variable identifier in an expression context");
			}
		}
		typeDecorations.put(node, result);
	}

	@Override
	public void outAIfStatement(AIfStatement node) {
		Type result = Type.getType("error");
		Type actualType = typeDecorations.get(node.getExpression());
		Type expectedType = Type.getType("boolean");
		Token token = node.getIf();
		
		if (actualType != expectedType) {
			reportError(token, "Expected expression of type '" + expectedType.getName() + "' got '" + actualType.getName() + "' in if conditional expression");
		} else {
			result = actualType;
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAIntegerExpression(AIntegerExpression node) {
		typeDecorations.put(node, Type.getType("int"));
	}

	@Override
	public void outALoopStatement(ALoopStatement node) {
		Type result = Type.getType("error");
		Type actualType = typeDecorations.get(node.getCase());
		Type expectedType = Type.getType("boolean");
		Token token = node.getLoop();
		
		if (actualType != expectedType) {
			reportError(token, "Expected expression of type '" + expectedType.getName() + "' got '" + actualType.getName() + "' in loop conditional expression");
		} else {
			result = actualType;
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAMultExpression(AMultExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = (node.getOperator() instanceof AMultOperator ? ((AMultOperator)node.getOperator()).getOp() : ((ADivOperator)node.getOperator()).getOp());

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both integers
			Type expectedType = Type.getType("int");
			if (lt != expectedType) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type '" + expectedType.getName() + "' got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = lt;
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outANullExpression(ANullExpression node) {
		typeDecorations.put(node, Type.getType("null"));
	}

	@Override
	public void outAOrExpression(AOrExpression node) {
		Type result = Type.getType("error");
		Type lt = typeDecorations.get(node.getExpr1());
		Type rt = typeDecorations.get(node.getExpr2());
		Token token = node.getOr();

		if (lt != rt) {
			reportError(token, "Found expressions of mismatched types ('" + lt.getName() + "' and '" + rt.getName() + "') at operator " + token.getText());
		} else {
			// Types match, now check to see that they are both booleans
			Type expectedType = Type.getType("boolean");
			if (lt != expectedType) { // only need to check one side since we already know they are the same type
				reportError(token, "Expected expressions of type '" + expectedType.getName() + "' got '" + lt.getName() + "' at operator " + token.getText());
			} else {
				result = lt;
			}
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAStringExpression(AStringExpression node) {
		typeDecorations.put(node, Type.getType("string"));
	}

	@Override
	public void outATrueExpression(ATrueExpression node) {
		typeDecorations.put(node, Type.getType("boolean"));
	}

	@Override
	public void outAUnaryExpression(AUnaryExpression node) {
		Type result = Type.getType("error");
		Type actualType = typeDecorations.get(node.getExpression());
		Type expectedType = null;
		Token token = null;
		
		if (node.getOperator() instanceof ANotOperator) {
			expectedType = Type.getType("boolean");
			token = ((ANotOperator)node.getOperator()).getOp();
		} else if (node.getOperator() instanceof AMinusOperator) {
			expectedType = Type.getType("int");
			token = ((AMinusOperator)node.getOperator()).getOp();
		} else if (node.getOperator() instanceof APlusOperator) {
			expectedType = Type.getType("int");
			token = ((APlusOperator)node.getOperator()).getOp();
		}
		
		
		if (actualType != expectedType) {
			reportError(token, "Expected expression of type '" + expectedType.getName() + "' got '" + actualType.getName() + "' at operator " + token.getText());
		} else {
			result = actualType;
		}
		
		typeDecorations.put(node, result);
	}

	@Override
	public void outAArrayExpression(AArrayExpression node) {
		reportError(node.getId(), "Arrays are not yet supported");
	}

	@Override
	public void outAFalseExpression(AFalseExpression node) {
		typeDecorations.put(node, Type.getType("boolean"));
	}

	@Override
	public void outAMeExpression(AMeExpression node) {
		reportError(node.getMe(), "Referencing the current object by 'me' is not yet supported");
	}

	@Override
	public void outANewObjectExpression(ANewObjectExpression node) {
		reportError(node.getNew(), "Instantiation of classes not yet supported");
	}

	@Override
	public void inAConcatenationExpression(AConcatenationExpression node) {
		reportError(node.getConcatOp(), "String concatenation not yet supported");
	}

	@Override
	public void inAStringExpression(AStringExpression node) {
		reportError(node.getStrlit(), "Strings not yet supported");
	}

	@Override
	public void inAStringType(AStringType node) {
		reportError(node.getString(), "Strings not yet supported");
	}

	public Integer getErrorCount() {
		return this.errorCount;
	}
	
}
