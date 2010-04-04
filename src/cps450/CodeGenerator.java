package cps450;

import java.io.File;
import java.util.Hashtable;
import java.util.Stack;
import java.io.PrintWriter;

import cps450.oodle.analysis.*;
import cps450.oodle.node.*;

public class CodeGenerator extends DepthFirstAdapter {
	
	PrintWriter writer;

	int ifStatementCount = 0;
	Stack<Integer> ifStatementCounts;
	int loopStatementCount;
	Stack<Integer> loopStatementCounts;
	Hashtable<String, ClassDeclaration> classTable;
	Hashtable<Node, Type> typeDecorations;
	MethodDeclaration currentMethodDeclaration = null;
	ClassDeclaration currentClassDeclaration = null;
	
	public CodeGenerator(PrintWriter _writer, Hashtable<String, ClassDeclaration> _classTable, Hashtable<Node, Type> _typeDecorations) {
		super();
		writer = _writer;
		ifStatementCounts = new Stack<Integer>();
		loopStatementCounts = new Stack<Integer>();
		classTable = _classTable;
		typeDecorations = _typeDecorations;
	}
	
	private void emit(String sourceLine) {
		writer.println(sourceLine);
	}
	
	private void emitOodleStatement(Token token) {
		emit("");
		emit("# " + token.getLine() + ": " + SourceHolder.instance().getLine(token.getLine()-1));
	}
	
	/*
	 * Start the generated with the predefined data directives. 
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inAStart(cps450.oodle.node.AStart)
	 */
	@Override
	public void inAStart(AStart node) {
		emit(".data");
		emit(".comm _out, 4, 4");
		emit(".comm _in, 4, 4");
	}

	/*
	 * Start the generated with the predefined data directives. 
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inAClassDef(cps450.oodle.node.AClassDef)
	 */
	@Override
	public void inAClassDef(AClassDef node) {
		currentClassDeclaration = classTable.get(node.getBeginName().getText());
	}
	
	/*
	 * Generate assembly for addition expressions.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAAddExpression(cps450.oodle.node.AAddExpression)
	 */
	@Override
	public void outAAddExpression(AAddExpression node) {
		emit("popl %eax # AddExpression");
		emit("popl %ebx");
		
		if (node.getOperator() instanceof APlusOperator) {
			emit("addl %eax, %ebx");
		} else if (node.getOperator() instanceof AMinusOperator) {
			emit("subl %eax, %ebx");
		}
		
		emit("pushl %ebx # Store AddExpression result");
	}
	
	/*
	 * Generate assembly for And expressions.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAAndExpression(cps450.oodle.node.AAndExpression)
	 */
	@Override
	public void outAAndExpression(AAndExpression node) {
		emit("popl %eax # AndExpression");
		emit("popl %ebx");
		emit("andl %ebx, %eax");
		emit("pushl %eax # Store AndExpression result");
	}
	
	/*
	 * Output a comment with the oodle source.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inAAssignmentStatement(cps450.oodle.node.AAssignmentStatement)
	 */
	@Override
	public void inAAssignmentStatement(AAssignmentStatement node) {
		emitOodleStatement(node.getId());
	}
	
	/*
	 * Generate assembly for assignment statements.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAAssignmentStatement(cps450.oodle.node.AAssignmentStatement)
	 */
	@Override
	public void outAAssignmentStatement(AAssignmentStatement node) {
		emit("popl %eax # AssignmentStatement");
		
		String name = node.getId().getText();
		Type type = typeDecorations.get(node);
		ClassDeclaration klass = classTable.get(type.getName());
		
		VariableDeclaration local = currentMethodDeclaration.getVariable(name);
		if (local != null) {
			emit("movl %eax, " + local.getStackOffset() + "(%ebp) # Get local variable '" + name + "'");
		} else {
			emit("movl %eax, _" + node.getId().getText());
		}
	}
	
	/*
	 * Generate assembly for method calls
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outACallExpression(cps450.oodle.node.ACallExpression)
	 */
	@Override
	public void outACallExpression(ACallExpression node) {
		emit("call " + node.getMethod().getText());
		emit("addl $" + (node.getArguments().size() * 4) + ", %esp # Clean up the argument values");
		if (node.getObject() != null) {
			emit("popl %ebx # Clean up the Object Expression");
		}
		emit("pushl %eax # Assume that we got a return value");
	}
	
	/*
	 * Output a comment with the oodle source.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inACallStatement(cps450.oodle.node.ACallStatement)
	 */
	@Override
	public void inACallStatement(ACallStatement node) {
		ACallExpression expr = (ACallExpression)node.getExpression();
		emitOodleStatement(expr.getMethod());
	}
	
	/*
	 * Generate assembly to cleanup after the call statements.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outACallStatement(cps450.oodle.node.ACallStatement)
	 */
	@Override
	public void outACallStatement(ACallStatement node) {
		emit("popl %eax # Cleanup unused return value in CallStatement");
	}
	
	/*
	 * Generate assembly for the comparison expressions.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAComparisonExpression(cps450.oodle.node.AComparisonExpression)
	 */
	@Override
	public void outAComparisonExpression(AComparisonExpression node) {
		emit("popl %eax # ComparisonExpression");
		emit("popl %ebx");
		emit("cmpl %eax, %ebx");
		
		if (node.getOperator() instanceof AEqualOperator) {
			emit("sete %al # Equal");
		} else if (node.getOperator() instanceof AGreaterOperator) {
			emit("setg %al # Greater");
		} else if (node.getOperator() instanceof AGreaterEqualOperator) {
			emit("setge %al # GreaterOrEqual");
		}
		emit("movzbl %al, %eax");
		
		emit("pushl %eax # Store ComparisonExpression result");
	}
	
	/*
	 * Generate assembly for a false keyword.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAFalseExpression(cps450.oodle.node.AFalseExpression)
	 */
	@Override
	public void outAFalseExpression(AFalseExpression node) {
		emit("pushl $0 # FalseExpression");
	}
	
	/*
	 * Generate assembly to evaluate the value of a variable.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAIdentifierExpression(cps450.oodle.node.AIdentifierExpression)
	 */
	@Override
	public void outAIdentifierExpression(AIdentifierExpression node) {
		String name = node.getId().getText();
		Type type = typeDecorations.get(node);
		ClassDeclaration klass = classTable.get(type.getName());
		
		VariableDeclaration local = currentMethodDeclaration.getVariable(name);
		if (local != null) {
			emit("pushl " + local.getStackOffset() + "(%ebp) # Push local variable '" + name + "'");
		} else {
			emit("pushl _" + name);
		}
	}
	
	/*
	 * Output oodle source as comment in assembly.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inAIfStatement(cps450.oodle.node.AIfStatement)
	 */
	@Override
	public void inAIfStatement(AIfStatement node) {
		emitOodleStatement(node.getIf());
	}
	
	/*
	 * Generate the assembly to test the if expression and execute the correct statements.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAIfHelper(cps450.oodle.node.AIfHelper)
	 */
	@Override
	public void outAIfHelper(AIfHelper node) {
		this.ifStatementCounts.push(this.ifStatementCount);
		this.ifStatementCount++;
		emit("popl %eax # Get comparison value for IfStatement");
		emit("cmpl $0, %eax");
		emit("jne _true_statements_" + this.ifStatementCounts.peek());
		emit("jmp _false_statements_" + this.ifStatementCounts.peek());
		emit("_true_statements_" + this.ifStatementCounts.peek() + ":");
	}
	
	/*
	 * Generate the code in the middle of the if so we only execute the correct statements.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAElseHelper(cps450.oodle.node.AElseHelper)
	 */
	@Override
	public void outAElseHelper(AElseHelper node) {
		emit("jmp _end_if_statement_" + this.ifStatementCounts.peek());
		emit("_false_statements_" + this.ifStatementCounts.peek() + ":");
	}
	
	/*
	 * Generate the end label for the if statements.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAIfStatement(cps450.oodle.node.AIfStatement)
	 */
	@Override
	public void outAIfStatement(AIfStatement node) {
		emit("_end_if_statement_" + this.ifStatementCounts.peek() + ":");
		
		this.ifStatementCounts.pop();
	}
	
	/*
	 * Generate assembly to evaluate an integer literal.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAIntegerExpression(cps450.oodle.node.AIntegerExpression)
	 */
	@Override
	public void outAIntegerExpression(AIntegerExpression node) {
		emit("pushl $" + node.getIntlit().getText());
	}
	
	/*
	 * Output oodle source as a comment.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inALoopStatement(cps450.oodle.node.ALoopStatement)
	 */
	@Override
	public void inALoopStatement(ALoopStatement node) {
		emitOodleStatement(node.getLoop());
		
		this.loopStatementCounts.push(this.loopStatementCount);
		this.loopStatementCount++;
		
		emit("_begin_loop_statement_" + this.loopStatementCounts.peek() + ":");
	}
	
	/*
	 * Generate test expression evaluation in loop statement
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outALoopHelper(cps450.oodle.node.ALoopHelper)
	 */
	@Override
	public void outALoopHelper(ALoopHelper node) {
		emit("popl %eax # Get comparison value for LoopStatement");
		emit("cmpl $0, %eax");
		emit("jne _loop_statements_" + this.loopStatementCounts.peek());
		emit("jmp _end_loop_statement_" + this.loopStatementCounts.peek());
		emit("_loop_statements_" + this.loopStatementCounts.peek() + ":");
	}
	
	/*
	 * Generate the end label of a loop statement and reset to the beginning of the loop.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outALoopStatement(cps450.oodle.node.ALoopStatement)
	 */
	@Override
	public void outALoopStatement(ALoopStatement node) {
		emit("jmp _begin_loop_statement_" + this.loopStatementCounts.peek());
		emit("_end_loop_statement_" + this.loopStatementCounts.peek() + ":");
		
		this.loopStatementCounts.pop();
	}
	
	/*
	 * Generate assembly labels for a method beginning.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#inAMethodDeclaration(cps450.oodle.node.AMethodDeclaration)
	 */
	@Override
	public void inAMethodDeclaration(AMethodDeclaration node) {
		currentMethodDeclaration = currentClassDeclaration.getMethod(node.getBeginName().getText());
		emit(".text");
		if (node.getBeginName().getText().equals("start")) {
			emit(".global main");
			emit("main:");
		}
		
		emit("\n# Method: " + node.getBeginName().getText());
		
		emit(node.getBeginName().getText() + ":");
		
		// Activation record
		emit("pushl %ebp");
		emit("movl %esp, %ebp");
		emit("subl $" + ((currentMethodDeclaration.getLocalCount()) * 4) + ", %esp # Make space for local variables");
	}
	
	/*
	 * Generate the assembly to end the program.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAMethodDeclaration(cps450.oodle.node.AMethodDeclaration)
	 */
	@Override
	public void outAMethodDeclaration(AMethodDeclaration node) {
		// Set return value
		emit("movl " + currentMethodDeclaration.getVariable(node.getBeginName().getText()).getStackOffset() + "(%ebp), %eax # Set return value");
		
		// Cleanup activation record
		emit("addl $" + ((node.getVarDeclaration().size() + 1) * 4) + ", %esp # Cleanup local variables");
		
		// Replace old EBP value
		emit("popl %ebp");
		
		if (node.getBeginName().getText().equals("start")) {
			emit("push $0");
			emit("call exit");
		}
		
		emit("ret");
	}
	
	/*
	 * Generate assembly to evaluate multiplication and division operations.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAMultExpression(cps450.oodle.node.AMultExpression)
	 */
	@Override
	public void outAMultExpression(AMultExpression node) {
		emit("popl %ebx # MultExpression");
		emit("popl %eax");
		
		if (node.getOperator() instanceof AMultOperator) {
			emit("imull %ebx, %eax");
		} else if (node.getOperator() instanceof ADivOperator) {
			emit("cdq");
			emit("idivl %ebx");
		}
		
		emit("pushl %eax # Store MultExpression result");
	}
	
	/*
	 * Generate code to save the value of null.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outANullExpression(cps450.oodle.node.ANullExpression)
	 */
	@Override
	public void outANullExpression(ANullExpression node) {
		emit("pushl $0");
	}
	
	/*
	 * Generate code to evaluate and Or expression.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAOrExpression(cps450.oodle.node.AOrExpression)
	 */
	@Override
	public void outAOrExpression(AOrExpression node) {
		emit("popl %eax # AndExpression");
		emit("popl %ebx");
		emit("orl %ebx, %eax");
		emit("pushl %eax # Store AndExpression result");
	}
	
	/*
	 * Generate code to evaluate the value of the true expression.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outATrueExpression(cps450.oodle.node.ATrueExpression)
	 */
	@Override
	public void outATrueExpression(ATrueExpression node) {
		emit("pushl $1 # TrueExpression");
	}
	
	/*
	 * Generate assembly code to evaluate unary (+/-) expressions.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAUnaryExpression(cps450.oodle.node.AUnaryExpression)
	 */
	@Override
	public void outAUnaryExpression(AUnaryExpression node) {
		emit("popl %eax # Begin UnaryExpression");
		if (node.getOperator() instanceof AMinusOperator) {
			emit("negl %eax");
		} else if (node.getOperator() instanceof ANotOperator) {
			emit("xorl $1, %eax # Not");
		}
		emit("pushl %eax # End UnaryExpression");
		
	}
	
	/*
	 * Generate assembly code to define a variable's storage space.
	 * @see cps450.oodle.analysis.DepthFirstAdapter#outAVarDeclaration(cps450.oodle.node.AVarDeclaration)
	 */
	@Override
	public void outAVarDeclaration(AVarDeclaration node) {
		if (currentMethodDeclaration == null) {
			emit(".comm _" + node.getName().getText() + ", 4, 4");
		}
	}
	
	
	
}
