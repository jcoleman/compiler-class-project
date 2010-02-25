/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.analysis;

import java.util.*;
import cps450.oodle.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPStart().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAStart(AStart node)
    {
        defaultIn(node);
    }

    public void outAStart(AStart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStart(AStart node)
    {
        inAStart(node);
        {
            List<PClassDef> copy = new ArrayList<PClassDef>(node.getClassDef());
            for(PClassDef e : copy)
            {
                e.apply(this);
            }
        }
        outAStart(node);
    }

    public void inAClassDef(AClassDef node)
    {
        defaultIn(node);
    }

    public void outAClassDef(AClassDef node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassDef(AClassDef node)
    {
        inAClassDef(node);
        if(node.getBeginName() != null)
        {
            node.getBeginName().apply(this);
        }
        if(node.getExtends() != null)
        {
            node.getExtends().apply(this);
        }
        {
            List<PVarDeclaration> copy = new ArrayList<PVarDeclaration>(node.getVarDeclaration());
            for(PVarDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PMethodDeclaration> copy = new ArrayList<PMethodDeclaration>(node.getMethodDeclaration());
            for(PMethodDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getEndName() != null)
        {
            node.getEndName().apply(this);
        }
        outAClassDef(node);
    }

    public void inAVarDeclaration(AVarDeclaration node)
    {
        defaultIn(node);
    }

    public void outAVarDeclaration(AVarDeclaration node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarDeclaration(AVarDeclaration node)
    {
        inAVarDeclaration(node);
        if(node.getName() != null)
        {
            node.getName().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getInstantiation() != null)
        {
            node.getInstantiation().apply(this);
        }
        outAVarDeclaration(node);
    }

    public void inAMethodDeclaration(AMethodDeclaration node)
    {
        defaultIn(node);
    }

    public void outAMethodDeclaration(AMethodDeclaration node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethodDeclaration(AMethodDeclaration node)
    {
        inAMethodDeclaration(node);
        if(node.getBeginName() != null)
        {
            node.getBeginName().apply(this);
        }
        {
            List<PArgumentDeclaration> copy = new ArrayList<PArgumentDeclaration>(node.getArgumentDeclaration());
            for(PArgumentDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        {
            List<PVarDeclaration> copy = new ArrayList<PVarDeclaration>(node.getVarDeclaration());
            for(PVarDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getEndName() != null)
        {
            node.getEndName().apply(this);
        }
        outAMethodDeclaration(node);
    }

    public void inAArgumentDeclaration(AArgumentDeclaration node)
    {
        defaultIn(node);
    }

    public void outAArgumentDeclaration(AArgumentDeclaration node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArgumentDeclaration(AArgumentDeclaration node)
    {
        inAArgumentDeclaration(node);
        if(node.getName() != null)
        {
            node.getName().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAArgumentDeclaration(node);
    }

    public void inAOtherType(AOtherType node)
    {
        defaultIn(node);
    }

    public void outAOtherType(AOtherType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOtherType(AOtherType node)
    {
        inAOtherType(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAOtherType(node);
    }

    public void inAIntegerType(AIntegerType node)
    {
        defaultIn(node);
    }

    public void outAIntegerType(AIntegerType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerType(AIntegerType node)
    {
        inAIntegerType(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntegerType(node);
    }

    public void inAStringType(AStringType node)
    {
        defaultIn(node);
    }

    public void outAStringType(AStringType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringType(AStringType node)
    {
        inAStringType(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringType(node);
    }

    public void inABooleanType(ABooleanType node)
    {
        defaultIn(node);
    }

    public void outABooleanType(ABooleanType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        inABooleanType(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outABooleanType(node);
    }

    public void inAArrayType(AArrayType node)
    {
        defaultIn(node);
    }

    public void outAArrayType(AArrayType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayType(AArrayType node)
    {
        inAArrayType(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAArrayType(node);
    }

    public void inAAssignmentStatement(AAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignmentStatement(AAssignmentStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignmentStatement(AAssignmentStatement node)
    {
        inAAssignmentStatement(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getArrayAccess());
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAAssignmentStatement(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getTrueCase());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getFalseCase());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAIfStatement(node);
    }

    public void inALoopStatement(ALoopStatement node)
    {
        defaultIn(node);
    }

    public void outALoopStatement(ALoopStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALoopStatement(ALoopStatement node)
    {
        inALoopStatement(node);
        if(node.getCase() != null)
        {
            node.getCase().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outALoopStatement(node);
    }

    public void inACallStatement(ACallStatement node)
    {
        defaultIn(node);
    }

    public void outACallStatement(ACallStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallStatement(ACallStatement node)
    {
        inACallStatement(node);
        if(node.getObject() != null)
        {
            node.getObject().apply(this);
        }
        if(node.getMethodCall() != null)
        {
            node.getMethodCall().apply(this);
        }
        outACallStatement(node);
    }

    public void inAOrExpression(AOrExpression node)
    {
        defaultIn(node);
    }

    public void outAOrExpression(AOrExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOrExpression(AOrExpression node)
    {
        inAOrExpression(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAOrExpression(node);
    }

    public void inAAndExpression(AAndExpression node)
    {
        defaultIn(node);
    }

    public void outAAndExpression(AAndExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExpression(AAndExpression node)
    {
        inAAndExpression(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAAndExpression(node);
    }

    public void inAComparisonExpression(AComparisonExpression node)
    {
        defaultIn(node);
    }

    public void outAComparisonExpression(AComparisonExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComparisonExpression(AComparisonExpression node)
    {
        inAComparisonExpression(node);
        if(node.getOperator() != null)
        {
            node.getOperator().apply(this);
        }
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAComparisonExpression(node);
    }

    public void inAConcatenationExpression(AConcatenationExpression node)
    {
        defaultIn(node);
    }

    public void outAConcatenationExpression(AConcatenationExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConcatenationExpression(AConcatenationExpression node)
    {
        inAConcatenationExpression(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAConcatenationExpression(node);
    }

    public void inAAddExpression(AAddExpression node)
    {
        defaultIn(node);
    }

    public void outAAddExpression(AAddExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAddExpression(AAddExpression node)
    {
        inAAddExpression(node);
        if(node.getOperator() != null)
        {
            node.getOperator().apply(this);
        }
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAAddExpression(node);
    }

    public void inAMultExpression(AMultExpression node)
    {
        defaultIn(node);
    }

    public void outAMultExpression(AMultExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExpression(AMultExpression node)
    {
        inAMultExpression(node);
        if(node.getOperator() != null)
        {
            node.getOperator().apply(this);
        }
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAMultExpression(node);
    }

    public void inAUnaryExpression(AUnaryExpression node)
    {
        defaultIn(node);
    }

    public void outAUnaryExpression(AUnaryExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnaryExpression(AUnaryExpression node)
    {
        inAUnaryExpression(node);
        if(node.getOperator() != null)
        {
            node.getOperator().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAUnaryExpression(node);
    }

    public void inAArrayExpression(AArrayExpression node)
    {
        defaultIn(node);
    }

    public void outAArrayExpression(AArrayExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayExpression(AArrayExpression node)
    {
        inAArrayExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAArrayExpression(node);
    }

    public void inAObjectCallExpression(AObjectCallExpression node)
    {
        defaultIn(node);
    }

    public void outAObjectCallExpression(AObjectCallExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjectCallExpression(AObjectCallExpression node)
    {
        inAObjectCallExpression(node);
        if(node.getObject() != null)
        {
            node.getObject().apply(this);
        }
        if(node.getMethodCall() != null)
        {
            node.getMethodCall().apply(this);
        }
        outAObjectCallExpression(node);
    }

    public void inACallExpression(ACallExpression node)
    {
        defaultIn(node);
    }

    public void outACallExpression(ACallExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallExpression(ACallExpression node)
    {
        inACallExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getExpression());
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        outACallExpression(node);
    }

    public void inAGroupExpression(AGroupExpression node)
    {
        defaultIn(node);
    }

    public void outAGroupExpression(AGroupExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGroupExpression(AGroupExpression node)
    {
        inAGroupExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAGroupExpression(node);
    }

    public void inAIdentifierExpression(AIdentifierExpression node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExpression(AIdentifierExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        inAIdentifierExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdentifierExpression(node);
    }

    public void inAStringExpression(AStringExpression node)
    {
        defaultIn(node);
    }

    public void outAStringExpression(AStringExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringExpression(AStringExpression node)
    {
        inAStringExpression(node);
        if(node.getStrlit() != null)
        {
            node.getStrlit().apply(this);
        }
        outAStringExpression(node);
    }

    public void inAIntegerExpression(AIntegerExpression node)
    {
        defaultIn(node);
    }

    public void outAIntegerExpression(AIntegerExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerExpression(AIntegerExpression node)
    {
        inAIntegerExpression(node);
        if(node.getIntlit() != null)
        {
            node.getIntlit().apply(this);
        }
        outAIntegerExpression(node);
    }

    public void inATrueExpression(ATrueExpression node)
    {
        defaultIn(node);
    }

    public void outATrueExpression(ATrueExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATrueExpression(ATrueExpression node)
    {
        inATrueExpression(node);
        outATrueExpression(node);
    }

    public void inAFalseExpression(AFalseExpression node)
    {
        defaultIn(node);
    }

    public void outAFalseExpression(AFalseExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node)
    {
        inAFalseExpression(node);
        outAFalseExpression(node);
    }

    public void inANullExpression(ANullExpression node)
    {
        defaultIn(node);
    }

    public void outANullExpression(ANullExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANullExpression(ANullExpression node)
    {
        inANullExpression(node);
        outANullExpression(node);
    }

    public void inAMeExpression(AMeExpression node)
    {
        defaultIn(node);
    }

    public void outAMeExpression(AMeExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMeExpression(AMeExpression node)
    {
        inAMeExpression(node);
        outAMeExpression(node);
    }

    public void inANewObjectExpression(ANewObjectExpression node)
    {
        defaultIn(node);
    }

    public void outANewObjectExpression(ANewObjectExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewObjectExpression(ANewObjectExpression node)
    {
        inANewObjectExpression(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outANewObjectExpression(node);
    }

    public void inANotOperator(ANotOperator node)
    {
        defaultIn(node);
    }

    public void outANotOperator(ANotOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotOperator(ANotOperator node)
    {
        inANotOperator(node);
        outANotOperator(node);
    }

    public void inAPlusOperator(APlusOperator node)
    {
        defaultIn(node);
    }

    public void outAPlusOperator(APlusOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusOperator(APlusOperator node)
    {
        inAPlusOperator(node);
        outAPlusOperator(node);
    }

    public void inAMinusOperator(AMinusOperator node)
    {
        defaultIn(node);
    }

    public void outAMinusOperator(AMinusOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusOperator(AMinusOperator node)
    {
        inAMinusOperator(node);
        outAMinusOperator(node);
    }

    public void inAMultOperator(AMultOperator node)
    {
        defaultIn(node);
    }

    public void outAMultOperator(AMultOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultOperator(AMultOperator node)
    {
        inAMultOperator(node);
        outAMultOperator(node);
    }

    public void inADivOperator(ADivOperator node)
    {
        defaultIn(node);
    }

    public void outADivOperator(ADivOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivOperator(ADivOperator node)
    {
        inADivOperator(node);
        outADivOperator(node);
    }

    public void inAEqualOperator(AEqualOperator node)
    {
        defaultIn(node);
    }

    public void outAEqualOperator(AEqualOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqualOperator(AEqualOperator node)
    {
        inAEqualOperator(node);
        outAEqualOperator(node);
    }

    public void inAGreaterOperator(AGreaterOperator node)
    {
        defaultIn(node);
    }

    public void outAGreaterOperator(AGreaterOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterOperator(AGreaterOperator node)
    {
        inAGreaterOperator(node);
        outAGreaterOperator(node);
    }

    public void inAGreaterEqualOperator(AGreaterEqualOperator node)
    {
        defaultIn(node);
    }

    public void outAGreaterEqualOperator(AGreaterEqualOperator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterEqualOperator(AGreaterEqualOperator node)
    {
        inAGreaterEqualOperator(node);
        outAGreaterEqualOperator(node);
    }
}
