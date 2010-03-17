/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.analysis;

import java.util.*;
import cps450.oodle.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAStart(AStart node)
    {
        defaultCase(node);
    }

    public void caseAClassDef(AClassDef node)
    {
        defaultCase(node);
    }

    public void caseAVarDeclaration(AVarDeclaration node)
    {
        defaultCase(node);
    }

    public void caseAMethodDeclaration(AMethodDeclaration node)
    {
        defaultCase(node);
    }

    public void caseAArgumentDeclaration(AArgumentDeclaration node)
    {
        defaultCase(node);
    }

    public void caseAOtherType(AOtherType node)
    {
        defaultCase(node);
    }

    public void caseAIntegerType(AIntegerType node)
    {
        defaultCase(node);
    }

    public void caseAStringType(AStringType node)
    {
        defaultCase(node);
    }

    public void caseABooleanType(ABooleanType node)
    {
        defaultCase(node);
    }

    public void caseAArrayType(AArrayType node)
    {
        defaultCase(node);
    }

    public void caseAIfHelper(AIfHelper node)
    {
        defaultCase(node);
    }

    public void caseAElseHelper(AElseHelper node)
    {
        defaultCase(node);
    }

    public void caseALoopHelper(ALoopHelper node)
    {
        defaultCase(node);
    }

    public void caseAAssignmentStatement(AAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    public void caseALoopStatement(ALoopStatement node)
    {
        defaultCase(node);
    }

    public void caseACallStatement(ACallStatement node)
    {
        defaultCase(node);
    }

    public void caseAOrExpression(AOrExpression node)
    {
        defaultCase(node);
    }

    public void caseAAndExpression(AAndExpression node)
    {
        defaultCase(node);
    }

    public void caseAComparisonExpression(AComparisonExpression node)
    {
        defaultCase(node);
    }

    public void caseAConcatenationExpression(AConcatenationExpression node)
    {
        defaultCase(node);
    }

    public void caseAAddExpression(AAddExpression node)
    {
        defaultCase(node);
    }

    public void caseAMultExpression(AMultExpression node)
    {
        defaultCase(node);
    }

    public void caseAUnaryExpression(AUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAArrayExpression(AArrayExpression node)
    {
        defaultCase(node);
    }

    public void caseACallExpression(ACallExpression node)
    {
        defaultCase(node);
    }

    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        defaultCase(node);
    }

    public void caseAStringExpression(AStringExpression node)
    {
        defaultCase(node);
    }

    public void caseAIntegerExpression(AIntegerExpression node)
    {
        defaultCase(node);
    }

    public void caseATrueExpression(ATrueExpression node)
    {
        defaultCase(node);
    }

    public void caseAFalseExpression(AFalseExpression node)
    {
        defaultCase(node);
    }

    public void caseANullExpression(ANullExpression node)
    {
        defaultCase(node);
    }

    public void caseAMeExpression(AMeExpression node)
    {
        defaultCase(node);
    }

    public void caseANewObjectExpression(ANewObjectExpression node)
    {
        defaultCase(node);
    }

    public void caseANotOperator(ANotOperator node)
    {
        defaultCase(node);
    }

    public void caseAPlusOperator(APlusOperator node)
    {
        defaultCase(node);
    }

    public void caseAMinusOperator(AMinusOperator node)
    {
        defaultCase(node);
    }

    public void caseAMultOperator(AMultOperator node)
    {
        defaultCase(node);
    }

    public void caseADivOperator(ADivOperator node)
    {
        defaultCase(node);
    }

    public void caseAEqualOperator(AEqualOperator node)
    {
        defaultCase(node);
    }

    public void caseAGreaterOperator(AGreaterOperator node)
    {
        defaultCase(node);
    }

    public void caseAGreaterEqualOperator(AGreaterEqualOperator node)
    {
        defaultCase(node);
    }

    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    public void caseTBoolean(TBoolean node)
    {
        defaultCase(node);
    }

    public void caseTBegin(TBegin node)
    {
        defaultCase(node);
    }

    public void caseTKlass(TKlass node)
    {
        defaultCase(node);
    }

    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    public void caseTEnd(TEnd node)
    {
        defaultCase(node);
    }

    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    public void caseTFrom(TFrom node)
    {
        defaultCase(node);
    }

    public void caseTInherits(TInherits node)
    {
        defaultCase(node);
    }

    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    public void caseTIs(TIs node)
    {
        defaultCase(node);
    }

    public void caseTLoop(TLoop node)
    {
        defaultCase(node);
    }

    public void caseTMe(TMe node)
    {
        defaultCase(node);
    }

    public void caseTNew(TNew node)
    {
        defaultCase(node);
    }

    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    public void caseTNull(TNull node)
    {
        defaultCase(node);
    }

    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    public void caseTBang(TBang node)
    {
        defaultCase(node);
    }

    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    public void caseTSemicolon(TSemicolon node)
    {
        defaultCase(node);
    }

    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    public void caseTPeriod(TPeriod node)
    {
        defaultCase(node);
    }

    public void caseTGteOp(TGteOp node)
    {
        defaultCase(node);
    }

    public void caseTGtOp(TGtOp node)
    {
        defaultCase(node);
    }

    public void caseTEqOp(TEqOp node)
    {
        defaultCase(node);
    }

    public void caseTPlusOp(TPlusOp node)
    {
        defaultCase(node);
    }

    public void caseTMinusOp(TMinusOp node)
    {
        defaultCase(node);
    }

    public void caseTMultOp(TMultOp node)
    {
        defaultCase(node);
    }

    public void caseTDivOp(TDivOp node)
    {
        defaultCase(node);
    }

    public void caseTConcatOp(TConcatOp node)
    {
        defaultCase(node);
    }

    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    public void caseTAssignmentOp(TAssignmentOp node)
    {
        defaultCase(node);
    }

    public void caseTLBracket(TLBracket node)
    {
        defaultCase(node);
    }

    public void caseTRBracket(TRBracket node)
    {
        defaultCase(node);
    }

    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    public void caseTIntlit(TIntlit node)
    {
        defaultCase(node);
    }

    public void caseTStrlit(TStrlit node)
    {
        defaultCase(node);
    }

    public void caseTIllegalString(TIllegalString node)
    {
        defaultCase(node);
    }

    public void caseTUnterminatedString(TUnterminatedString node)
    {
        defaultCase(node);
    }

    public void caseTContinuation(TContinuation node)
    {
        defaultCase(node);
    }

    public void caseTEol(TEol node)
    {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    public void caseTIllegalChar(TIllegalChar node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
