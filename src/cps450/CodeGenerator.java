package cps450;

import java.io.File;
import java.io.PrintWriter;

import cps450.oodle.analysis.*;
import cps450.oodle.node.*;

public class CodeGenerator extends DepthFirstAdapter {
	
	PrintWriter writer;
	int ifStatementCount = 0;
	
	public CodeGenerator(PrintWriter _writer) {
		super();
		writer = _writer;
	}
	
	private void emit(String sourceLine) {
		System.out.println(sourceLine);
		writer.println(sourceLine);
	}

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

	@Override
	public void outAAndExpression(AAndExpression node) {
		emit("popl %eax # AndExpression");
		emit("popl %ebx");
		emit("andl %ebx, %eax");
		emit("pushl %eax # Store AndExpression result");
	}

	@Override
	public void outAAssignmentStatement(AAssignmentStatement node) {
		emit("popl %eax # AssignmentStatement");
		emit("movl %eax, _" + node.getId().getText());
	}

	@Override
	public void outACallExpression(ACallExpression node) {
		if (node.getObject() != null) {
			emit("popl %eax # Clean up the Object Expression");
		}
	}

	@Override
	public void outACallStatement(ACallStatement node) {
		// TODO Auto-generated method stub
		super.outACallStatement(node);
	}

	@Override
	public void outAComparisonExpression(AComparisonExpression node) {
		emit("popl %eax # ComparisonExpression");
		emit("popl %ebx");
		emit("cmpl %ebx, %eax");
		
		if (node.getOperator() instanceof AEqualOperator) {
			emit("sete %eax # Equal");
		} else if (node.getOperator() instanceof AGreaterOperator) {
			emit("setg %eax # Greater");
		} else if (node.getOperator() instanceof AGreaterEqualOperator) {
			emit("setge %eax # GreaterOrEqual");
		}
		emit("movzbl %eax");
		
		emit("pushl %eax # Store ComparisonExpression result");
	}

	@Override
	public void outAFalseExpression(AFalseExpression node) {
		emit("pushl $0 # FalseExpression");
	}

	@Override
	public void outAIdentifierExpression(AIdentifierExpression node) {
		emit("movl _" + node.getId().getText() + ", %eax");
		emit("pushl %eax");
	}

	@Override
	public void outAIfStatement(AIfStatement node) {
		// TODO Auto-generated method stub
		super.outAIfStatement(node);
	}

	@Override
	public void outAIntegerExpression(AIntegerExpression node) {
		emit("pushl $" + node.getIntlit().getText());
	}

	@Override
	public void outALoopStatement(ALoopStatement node) {
		// TODO Auto-generated method stub
		super.outALoopStatement(node);
	}

	@Override
	public void outAMethodDeclaration(AMethodDeclaration node) {
		// TODO Auto-generated method stub
		super.outAMethodDeclaration(node);
	}

	@Override
	public void outAMultExpression(AMultExpression node) {
		emit("popl %eax # MultExpression");
		emit("popl %ebx");
		
		if (node.getOperator() instanceof AMultOperator) {
			emit("imull %ebx, %eax");
		} else if (node.getOperator() instanceof ADivOperator) {
			emit("cdq");
			emit("idivl %ebx");
		}
		
		emit("pushl %eax # Store MultExpression result");
	}

	@Override
	public void outANullExpression(ANullExpression node) {
		emit("pushl $0");
	}

	@Override
	public void outAOrExpression(AOrExpression node) {
		emit("popl %eax # AndExpression");
		emit("popl %ebx");
		emit("orl %ebx, %eax");
		emit("pushl %eax # Store AndExpression result");
	}

	@Override
	public void outATrueExpression(ATrueExpression node) {
		emit("pushl $1 # TrueExpression");
	}

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

	@Override
	public void outAVarDeclaration(AVarDeclaration node) {
		emit(".comm " + node.getName().getText() + ", 4, 4");
	}
	
	
	
}
