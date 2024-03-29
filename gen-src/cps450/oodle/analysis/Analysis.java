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
    void caseAClassDef(AClassDef node);
    void caseAVarDeclaration(AVarDeclaration node);
    void caseAMethodDeclaration(AMethodDeclaration node);
    void caseAArgumentDeclaration(AArgumentDeclaration node);
    void caseAOtherType(AOtherType node);
    void caseAIntegerType(AIntegerType node);
    void caseAStringType(AStringType node);
    void caseABooleanType(ABooleanType node);
    void caseAArrayType(AArrayType node);
    void caseAIfHelper(AIfHelper node);
    void caseAElseHelper(AElseHelper node);
    void caseALoopHelper(ALoopHelper node);
    void caseAAssignmentStatement(AAssignmentStatement node);
    void caseAIfStatement(AIfStatement node);
    void caseALoopStatement(ALoopStatement node);
    void caseACallStatement(ACallStatement node);
    void caseAOrExpression(AOrExpression node);
    void caseAAndExpression(AAndExpression node);
    void caseAComparisonExpression(AComparisonExpression node);
    void caseAConcatenationExpression(AConcatenationExpression node);
    void caseAAddExpression(AAddExpression node);
    void caseAMultExpression(AMultExpression node);
    void caseAUnaryExpression(AUnaryExpression node);
    void caseAArrayExpression(AArrayExpression node);
    void caseACallExpression(ACallExpression node);
    void caseAIdentifierExpression(AIdentifierExpression node);
    void caseAStringExpression(AStringExpression node);
    void caseAIntegerExpression(AIntegerExpression node);
    void caseATrueExpression(ATrueExpression node);
    void caseAFalseExpression(AFalseExpression node);
    void caseANullExpression(ANullExpression node);
    void caseAMeExpression(AMeExpression node);
    void caseANewObjectExpression(ANewObjectExpression node);
    void caseANotOperator(ANotOperator node);
    void caseAPlusOperator(APlusOperator node);
    void caseAMinusOperator(AMinusOperator node);
    void caseAMultOperator(AMultOperator node);
    void caseADivOperator(ADivOperator node);
    void caseAEqualOperator(AEqualOperator node);
    void caseAGreaterOperator(AGreaterOperator node);
    void caseAGreaterEqualOperator(AGreaterEqualOperator node);

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
