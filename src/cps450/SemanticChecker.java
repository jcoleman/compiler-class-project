package cps450;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import cps450.oodle.analysis.*;
import cps450.oodle.node.*;

public class SemanticChecker extends DepthFirstAdapter {

	SymbolTable symbolTable;
	Hashtable<Node, Type> decorations;
	Integer errorCount;
	
	public SemanticChecker() {
		super();
		symbolTable = new SymbolTable();
		decorations = new Hashtable<Node, Type>();
		errorCount = 0;
		Type.intialize();
	}
	
	private String locationFor(Token t) {
		return SourceHolder.instance().getFilenameFor(t) + ":" + SourceHolder.instance().getLineNumberFor(t) + "," + t.getPos();
	}
	
	private void reportError(Token t, String errorText) {
		this.errorCount++;
		System.out.println(locationFor(t) + ":" + errorText);
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
			reportError(node.getName(), "Variable '" + node.getName().getText() + "' previously defined at "  + previousDeclaration.getDeclaration().getLocation() + ".");
		}
		symbolTable.push(node.getName().getText(), decl);
	}

	@Override
	public void inAMethodDeclaration(AMethodDeclaration node) {
		// Get the parameter types
		ArrayList<Type> argumentTypes = new ArrayList<Type>();
		for (Iterator<PArgumentDeclaration> i = node.getArgumentDeclaration().iterator(); i.hasNext();) {
			AArgumentDeclaration arg = (AArgumentDeclaration)i.next();
			argumentTypes.add( typeFor(arg.getType()) );
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

	public Integer getErrorCount() {
		return this.errorCount;
	}
	
}
