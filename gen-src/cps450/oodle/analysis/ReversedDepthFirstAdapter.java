/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.analysis;

import java.util.*;
import cps450.oodle.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
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
        node.getEOF().apply(this);
        node.getPStart().apply(this);
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
            List<TEol> copy = new ArrayList<TEol>(node.getEnd());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PClassTail> copy = new ArrayList<PClassTail>(node.getClassTail());
            Collections.reverse(copy);
            for(PClassTail e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getClassDef() != null)
        {
            node.getClassDef().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getBegin());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        outAStart(node);
    }

    public void inAClassTail(AClassTail node)
    {
        defaultIn(node);
    }

    public void outAClassTail(AClassTail node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassTail(AClassTail node)
    {
        inAClassTail(node);
        if(node.getClassDef() != null)
        {
            node.getClassDef().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        outAClassTail(node);
    }

    public void inAClassInheritance(AClassInheritance node)
    {
        defaultIn(node);
    }

    public void outAClassInheritance(AClassInheritance node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassInheritance(AClassInheritance node)
    {
        inAClassInheritance(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getFrom() != null)
        {
            node.getFrom().apply(this);
        }
        if(node.getInherits() != null)
        {
            node.getInherits().apply(this);
        }
        outAClassInheritance(node);
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
        if(node.getClassEnd() != null)
        {
            node.getClassEnd().apply(this);
        }
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        {
            List<PMethodDeclaration> copy = new ArrayList<PMethodDeclaration>(node.getMethodDeclaration());
            Collections.reverse(copy);
            for(PMethodDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDeclaration> copy = new ArrayList<PVarDeclaration>(node.getVarDeclaration());
            Collections.reverse(copy);
            for(PVarDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIs() != null)
        {
            node.getIs().apply(this);
        }
        if(node.getClassInheritance() != null)
        {
            node.getClassInheritance().apply(this);
        }
        if(node.getBegin() != null)
        {
            node.getBegin().apply(this);
        }
        if(node.getKlass() != null)
        {
            node.getKlass().apply(this);
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
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getVarInstantiation() != null)
        {
            node.getVarInstantiation().apply(this);
        }
        if(node.getVarTypeDeclaration() != null)
        {
            node.getVarTypeDeclaration().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAVarDeclaration(node);
    }

    public void inAVarTypeDeclaration(AVarTypeDeclaration node)
    {
        defaultIn(node);
    }

    public void outAVarTypeDeclaration(AVarTypeDeclaration node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarTypeDeclaration(AVarTypeDeclaration node)
    {
        inAVarTypeDeclaration(node);
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        outAVarTypeDeclaration(node);
    }

    public void inAVarInstantiation(AVarInstantiation node)
    {
        defaultIn(node);
    }

    public void outAVarInstantiation(AVarInstantiation node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarInstantiation(AVarInstantiation node)
    {
        inAVarInstantiation(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getEqOp() != null)
        {
            node.getEqOp().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        outAVarInstantiation(node);
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
        {
            List<TEol> copy = new ArrayList<TEol>(node.getMethodEnd());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMethodDecEnd() != null)
        {
            node.getMethodDecEnd().apply(this);
        }
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        if(node.getStatementList() != null)
        {
            node.getStatementList().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getMethodMiddle());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBegin() != null)
        {
            node.getBegin().apply(this);
        }
        {
            List<PVarDeclaration> copy = new ArrayList<PVarDeclaration>(node.getVarDeclaration());
            Collections.reverse(copy);
            for(PVarDeclaration e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getMethodBegin());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIs() != null)
        {
            node.getIs().apply(this);
        }
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getArgumentList() != null)
        {
            node.getArgumentList().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getMethodDecBegin() != null)
        {
            node.getMethodDecBegin().apply(this);
        }
        outAMethodDeclaration(node);
    }

    public void inAArgumentList(AArgumentList node)
    {
        defaultIn(node);
    }

    public void outAArgumentList(AArgumentList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArgumentList(AArgumentList node)
    {
        inAArgumentList(node);
        if(node.getArgumentDeclaration() != null)
        {
            node.getArgumentDeclaration().apply(this);
        }
        {
            List<PArgumentDeclarationHead> copy = new ArrayList<PArgumentDeclarationHead>(node.getArgumentDeclarationHead());
            Collections.reverse(copy);
            for(PArgumentDeclarationHead e : copy)
            {
                e.apply(this);
            }
        }
        outAArgumentList(node);
    }

    public void inAArgumentDeclarationHead(AArgumentDeclarationHead node)
    {
        defaultIn(node);
    }

    public void outAArgumentDeclarationHead(AArgumentDeclarationHead node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArgumentDeclarationHead(AArgumentDeclarationHead node)
    {
        inAArgumentDeclarationHead(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getArgumentDeclaration() != null)
        {
            node.getArgumentDeclaration().apply(this);
        }
        outAArgumentDeclarationHead(node);
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
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArgumentDeclaration(node);
    }

    public void inAIntVarType(AIntVarType node)
    {
        defaultIn(node);
    }

    public void outAIntVarType(AIntVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntVarType(AIntVarType node)
    {
        inAIntVarType(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntVarType(node);
    }

    public void inAStringVarType(AStringVarType node)
    {
        defaultIn(node);
    }

    public void outAStringVarType(AStringVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringVarType(AStringVarType node)
    {
        inAStringVarType(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringVarType(node);
    }

    public void inABooleanVarType(ABooleanVarType node)
    {
        defaultIn(node);
    }

    public void outABooleanVarType(ABooleanVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABooleanVarType(ABooleanVarType node)
    {
        inABooleanVarType(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outABooleanVarType(node);
    }

    public void inAIdVarType(AIdVarType node)
    {
        defaultIn(node);
    }

    public void outAIdVarType(AIdVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdVarType(AIdVarType node)
    {
        inAIdVarType(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdVarType(node);
    }

    public void inAArrayVarType(AArrayVarType node)
    {
        defaultIn(node);
    }

    public void outAArrayVarType(AArrayVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayVarType(AArrayVarType node)
    {
        inAArrayVarType(node);
        if(node.getArrayVarType() != null)
        {
            node.getArrayVarType().apply(this);
        }
        outAArrayVarType(node);
    }

    public void inATest2ArrayVarType(ATest2ArrayVarType node)
    {
        defaultIn(node);
    }

    public void outATest2ArrayVarType(ATest2ArrayVarType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATest2ArrayVarType(ATest2ArrayVarType node)
    {
        inATest2ArrayVarType(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        outATest2ArrayVarType(node);
    }

    public void inAStatementList(AStatementList node)
    {
        defaultIn(node);
    }

    public void outAStatementList(AStatementList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementList(AStatementList node)
    {
        inAStatementList(node);
        {
            List<PStatementHead> copy = new ArrayList<PStatementHead>(node.getStatementHead());
            Collections.reverse(copy);
            for(PStatementHead e : copy)
            {
                e.apply(this);
            }
        }
        outAStatementList(node);
    }

    public void inAStatementHead(AStatementHead node)
    {
        defaultIn(node);
    }

    public void outAStatementHead(AStatementHead node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementHead(AStatementHead node)
    {
        inAStatementHead(node);
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAStatementHead(node);
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
        if(node.getAssignmentStatement() != null)
        {
            node.getAssignmentStatement().apply(this);
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
        if(node.getIfStatement() != null)
        {
            node.getIfStatement().apply(this);
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
        if(node.getLoopStatement() != null)
        {
            node.getLoopStatement().apply(this);
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
        if(node.getCallStatement() != null)
        {
            node.getCallStatement().apply(this);
        }
        outACallStatement(node);
    }

    public void inATest3AssignmentStatement(ATest3AssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outATest3AssignmentStatement(ATest3AssignmentStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATest3AssignmentStatement(ATest3AssignmentStatement node)
    {
        inATest3AssignmentStatement(node);
        if(node.getVarInstantiation() != null)
        {
            node.getVarInstantiation().apply(this);
        }
        if(node.getGetAtOperation() != null)
        {
            node.getGetAtOperation().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outATest3AssignmentStatement(node);
    }

    public void inAGetAtOperation(AGetAtOperation node)
    {
        defaultIn(node);
    }

    public void outAGetAtOperation(AGetAtOperation node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGetAtOperation(AGetAtOperation node)
    {
        inAGetAtOperation(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        outAGetAtOperation(node);
    }

    public void inATest4IfStatement(ATest4IfStatement node)
    {
        defaultIn(node);
    }

    public void outATest4IfStatement(ATest4IfStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATest4IfStatement(ATest4IfStatement node)
    {
        inATest4IfStatement(node);
        if(node.getIfEnd() != null)
        {
            node.getIfEnd().apply(this);
        }
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        if(node.getIfStatementElse() != null)
        {
            node.getIfStatementElse().apply(this);
        }
        if(node.getStatementList() != null)
        {
            node.getStatementList().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getBeginIf() != null)
        {
            node.getBeginIf().apply(this);
        }
        outATest4IfStatement(node);
    }

    public void inAIfStatementElse(AIfStatementElse node)
    {
        defaultIn(node);
    }

    public void outAIfStatementElse(AIfStatementElse node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatementElse(AIfStatementElse node)
    {
        inAIfStatementElse(node);
        if(node.getStatementList() != null)
        {
            node.getStatementList().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        outAIfStatementElse(node);
    }

    public void inATest5LoopStatement(ATest5LoopStatement node)
    {
        defaultIn(node);
    }

    public void outATest5LoopStatement(ATest5LoopStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATest5LoopStatement(ATest5LoopStatement node)
    {
        inATest5LoopStatement(node);
        if(node.getLoopEnd() != null)
        {
            node.getLoopEnd().apply(this);
        }
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        if(node.getStatementList() != null)
        {
            node.getStatementList().apply(this);
        }
        {
            List<TEol> copy = new ArrayList<TEol>(node.getEol());
            Collections.reverse(copy);
            for(TEol e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        if(node.getLoopBegin() != null)
        {
            node.getLoopBegin().apply(this);
        }
        outATest5LoopStatement(node);
    }

    public void inATest6CallStatement(ATest6CallStatement node)
    {
        defaultIn(node);
    }

    public void outATest6CallStatement(ATest6CallStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATest6CallStatement(ATest6CallStatement node)
    {
        inATest6CallStatement(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpressionList() != null)
        {
            node.getExpressionList().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getObjectCall() != null)
        {
            node.getObjectCall().apply(this);
        }
        outATest6CallStatement(node);
    }

    public void inAObjectCall(AObjectCall node)
    {
        defaultIn(node);
    }

    public void outAObjectCall(AObjectCall node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjectCall(AObjectCall node)
    {
        inAObjectCall(node);
        if(node.getPeriod() != null)
        {
            node.getPeriod().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAObjectCall(node);
    }

    public void inAExpressionList(AExpressionList node)
    {
        defaultIn(node);
    }

    public void outAExpressionList(AExpressionList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpressionList(AExpressionList node)
    {
        inAExpressionList(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        {
            List<PExpressionHead> copy = new ArrayList<PExpressionHead>(node.getExpressionHead());
            Collections.reverse(copy);
            for(PExpressionHead e : copy)
            {
                e.apply(this);
            }
        }
        outAExpressionList(node);
    }

    public void inAExpressionHead(AExpressionHead node)
    {
        defaultIn(node);
    }

    public void outAExpressionHead(AExpressionHead node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpressionHead(AExpressionHead node)
    {
        inAExpressionHead(node);
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAExpressionHead(node);
    }

    public void inAIdExpression(AIdExpression node)
    {
        defaultIn(node);
    }

    public void outAIdExpression(AIdExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdExpression(AIdExpression node)
    {
        inAIdExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdExpression(node);
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

    public void inAIntExpression(AIntExpression node)
    {
        defaultIn(node);
    }

    public void outAIntExpression(AIntExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntExpression(AIntExpression node)
    {
        inAIntExpression(node);
        if(node.getIntlit() != null)
        {
            node.getIntlit().apply(this);
        }
        outAIntExpression(node);
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
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
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
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
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
        if(node.getNull() != null)
        {
            node.getNull().apply(this);
        }
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
        if(node.getMe() != null)
        {
            node.getMe().apply(this);
        }
        outAMeExpression(node);
    }

    public void inANewExpression(ANewExpression node)
    {
        defaultIn(node);
    }

    public void outANewExpression(ANewExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewExpression(ANewExpression node)
    {
        inANewExpression(node);
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        if(node.getNew() != null)
        {
            node.getNew().apply(this);
        }
        outANewExpression(node);
    }
}