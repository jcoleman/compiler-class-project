/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.analysis;

import cps450.oodle.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAStart(AStart node);
    void caseAClassTail(AClassTail node);
    void caseAClassInheritance(AClassInheritance node);
    void caseAClassDef(AClassDef node);
    void caseAVarDeclaration(AVarDeclaration node);
    void caseAVarTypeDeclaration(AVarTypeDeclaration node);
    void caseAVarInstantiation(AVarInstantiation node);
    void caseAMethodDeclaration(AMethodDeclaration node);
    void caseAArgumentList(AArgumentList node);
    void caseAArgumentDeclarationHead(AArgumentDeclarationHead node);
    void caseAArgumentDeclaration(AArgumentDeclaration node);
    void caseAIntVarType(AIntVarType node);
    void caseAStringVarType(AStringVarType node);
    void caseABooleanVarType(ABooleanVarType node);
    void caseAIdVarType(AIdVarType node);
    void caseAArrayVarType(AArrayVarType node);
    void caseATest2ArrayVarType(ATest2ArrayVarType node);
    void caseAStatementList(AStatementList node);
    void caseAStatementHead(AStatementHead node);
    void caseAAssignmentStatement(AAssignmentStatement node);
    void caseAIfStatement(AIfStatement node);
    void caseALoopStatement(ALoopStatement node);
    void caseACallStatement(ACallStatement node);
    void caseATest3AssignmentStatement(ATest3AssignmentStatement node);
    void caseATest4IfStatement(ATest4IfStatement node);
    void caseAIfStatementElse(AIfStatementElse node);
    void caseATest5LoopStatement(ATest5LoopStatement node);
    void caseAObjectCallStatement(AObjectCallStatement node);
    void caseANormalCallStatement(ANormalCallStatement node);
    void caseAExpressionList(AExpressionList node);
    void caseAExpressionHead(AExpressionHead node);
    void caseANegateUnaryOperator(ANegateUnaryOperator node);
    void caseANotUnaryOperator(ANotUnaryOperator node);
    void caseAMultiplyMultOperator(AMultiplyMultOperator node);
    void caseADivideMultOperator(ADivideMultOperator node);
    void caseAAddAddOperator(AAddAddOperator node);
    void caseASubtractAddOperator(ASubtractAddOperator node);
    void caseAEqualRelationalOperator(AEqualRelationalOperator node);
    void caseAGreaterRelationalOperator(AGreaterRelationalOperator node);
    void caseAGreaterEqualRelationalOperator(AGreaterEqualRelationalOperator node);
    void caseAObjectCall(AObjectCall node);
    void caseAMethodCall(AMethodCall node);
    void caseABracketOperation(ABracketOperation node);
    void caseAGetAtReference(AGetAtReference node);
    void caseAExpression(AExpression node);
    void caseAOrOrExpression(AOrOrExpression node);
    void caseAExpr1OrExpression(AExpr1OrExpression node);
    void caseAAndAndExpression(AAndAndExpression node);
    void caseAExpr2AndExpression(AExpr2AndExpression node);
    void caseARelationalRelationalExpression(ARelationalRelationalExpression node);
    void caseAExpr3RelationalExpression(AExpr3RelationalExpression node);
    void caseAConcatConcatExpression(AConcatConcatExpression node);
    void caseAExpr4ConcatExpression(AExpr4ConcatExpression node);
    void caseAAddAddExpression(AAddAddExpression node);
    void caseAExpr5AddExpression(AExpr5AddExpression node);
    void caseAMultExpression(AMultExpression node);
    void caseAExpr6MultExpression(AExpr6MultExpression node);
    void caseAUnaryUnaryExpression(AUnaryUnaryExpression node);
    void caseAExpr7UnaryExpression(AExpr7UnaryExpression node);
    void caseAGetAtObjectCallExpression(AGetAtObjectCallExpression node);
    void caseACallObjectCallExpression(ACallObjectCallExpression node);
    void caseAExpr8ObjectCallExpression(AExpr8ObjectCallExpression node);
    void caseACallCallExpression(ACallCallExpression node);
    void caseAExpr8CallExpression(AExpr8CallExpression node);
    void caseAIdRealExpression(AIdRealExpression node);
    void caseAStringRealExpression(AStringRealExpression node);
    void caseAIntRealExpression(AIntRealExpression node);
    void caseATrueRealExpression(ATrueRealExpression node);
    void caseAFalseRealExpression(AFalseRealExpression node);
    void caseANullRealExpression(ANullRealExpression node);
    void caseAMeRealExpression(AMeRealExpression node);
    void caseANewRealExpression(ANewRealExpression node);

    void caseTIf(TIf node);
    void caseTWhile(TWhile node);
    void caseTBoolean(TBoolean node);
    void caseTBegin(TBegin node);
    void caseTKlass(TKlass node);
    void caseTElse(TElse node);
    void caseTEnd(TEnd node);
    void caseTFalse(TFalse node);
    void caseTFrom(TFrom node);
    void caseTInherits(TInherits node);
    void caseTInt(TInt node);
    void caseTIs(TIs node);
    void caseTLoop(TLoop node);
    void caseTMe(TMe node);
    void caseTNew(TNew node);
    void caseTNot(TNot node);
    void caseTNull(TNull node);
    void caseTString(TString node);
    void caseTThen(TThen node);
    void caseTTrue(TTrue node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTBang(TBang node);
    void caseTComma(TComma node);
    void caseTSemicolon(TSemicolon node);
    void caseTColon(TColon node);
    void caseTPeriod(TPeriod node);
    void caseTGteOp(TGteOp node);
    void caseTGtOp(TGtOp node);
    void caseTEqOp(TEqOp node);
    void caseTPlusOp(TPlusOp node);
    void caseTMinusOp(TMinusOp node);
    void caseTMultOp(TMultOp node);
    void caseTDivOp(TDivOp node);
    void caseTConcatOp(TConcatOp node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTAssignmentOp(TAssignmentOp node);
    void caseTLBracket(TLBracket node);
    void caseTRBracket(TRBracket node);
    void caseTId(TId node);
    void caseTIntlit(TIntlit node);
    void caseTStrlit(TStrlit node);
    void caseTIllegalString(TIllegalString node);
    void caseTUnterminatedString(TUnterminatedString node);
    void caseTContinuation(TContinuation node);
    void caseTEol(TEol node);
    void caseTBlank(TBlank node);
    void caseTComment(TComment node);
    void caseTIllegalChar(TIllegalChar node);
    void caseEOF(EOF node);
}
