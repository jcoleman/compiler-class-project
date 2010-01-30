/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.parser;

import cps450.oodle.node.*;
import cps450.oodle.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 0;
    }

    @Override
    public void caseTWhile(@SuppressWarnings("unused") TWhile node)
    {
        this.index = 1;
    }

    @Override
    public void caseTBoolean(@SuppressWarnings("unused") TBoolean node)
    {
        this.index = 2;
    }

    @Override
    public void caseTBegin(@SuppressWarnings("unused") TBegin node)
    {
        this.index = 3;
    }

    @Override
    public void caseTKlass(@SuppressWarnings("unused") TKlass node)
    {
        this.index = 4;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 5;
    }

    @Override
    public void caseTEnd(@SuppressWarnings("unused") TEnd node)
    {
        this.index = 6;
    }

    @Override
    public void caseTFalse(@SuppressWarnings("unused") TFalse node)
    {
        this.index = 7;
    }

    @Override
    public void caseTFrom(@SuppressWarnings("unused") TFrom node)
    {
        this.index = 8;
    }

    @Override
    public void caseTInherits(@SuppressWarnings("unused") TInherits node)
    {
        this.index = 9;
    }

    @Override
    public void caseTInt(@SuppressWarnings("unused") TInt node)
    {
        this.index = 10;
    }

    @Override
    public void caseTIs(@SuppressWarnings("unused") TIs node)
    {
        this.index = 11;
    }

    @Override
    public void caseTLoop(@SuppressWarnings("unused") TLoop node)
    {
        this.index = 12;
    }

    @Override
    public void caseTMe(@SuppressWarnings("unused") TMe node)
    {
        this.index = 13;
    }

    @Override
    public void caseTNew(@SuppressWarnings("unused") TNew node)
    {
        this.index = 14;
    }

    @Override
    public void caseTNot(@SuppressWarnings("unused") TNot node)
    {
        this.index = 15;
    }

    @Override
    public void caseTNull(@SuppressWarnings("unused") TNull node)
    {
        this.index = 16;
    }

    @Override
    public void caseTString(@SuppressWarnings("unused") TString node)
    {
        this.index = 17;
    }

    @Override
    public void caseTThen(@SuppressWarnings("unused") TThen node)
    {
        this.index = 18;
    }

    @Override
    public void caseTTrue(@SuppressWarnings("unused") TTrue node)
    {
        this.index = 19;
    }

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 20;
    }

    @Override
    public void caseTOr(@SuppressWarnings("unused") TOr node)
    {
        this.index = 21;
    }

    @Override
    public void caseTBang(@SuppressWarnings("unused") TBang node)
    {
        this.index = 22;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 23;
    }

    @Override
    public void caseTSemicolon(@SuppressWarnings("unused") TSemicolon node)
    {
        this.index = 24;
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        this.index = 25;
    }

    @Override
    public void caseTPeriod(@SuppressWarnings("unused") TPeriod node)
    {
        this.index = 26;
    }

    @Override
    public void caseTGteOp(@SuppressWarnings("unused") TGteOp node)
    {
        this.index = 27;
    }

    @Override
    public void caseTGtOp(@SuppressWarnings("unused") TGtOp node)
    {
        this.index = 28;
    }

    @Override
    public void caseTEqOp(@SuppressWarnings("unused") TEqOp node)
    {
        this.index = 29;
    }

    @Override
    public void caseTPlusOp(@SuppressWarnings("unused") TPlusOp node)
    {
        this.index = 30;
    }

    @Override
    public void caseTMinusOp(@SuppressWarnings("unused") TMinusOp node)
    {
        this.index = 31;
    }

    @Override
    public void caseTMultOp(@SuppressWarnings("unused") TMultOp node)
    {
        this.index = 32;
    }

    @Override
    public void caseTDivOp(@SuppressWarnings("unused") TDivOp node)
    {
        this.index = 33;
    }

    @Override
    public void caseTConcatOp(@SuppressWarnings("unused") TConcatOp node)
    {
        this.index = 34;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 35;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 36;
    }

    @Override
    public void caseTAssignmentOp(@SuppressWarnings("unused") TAssignmentOp node)
    {
        this.index = 37;
    }

    @Override
    public void caseTLBracket(@SuppressWarnings("unused") TLBracket node)
    {
        this.index = 38;
    }

    @Override
    public void caseTRBracket(@SuppressWarnings("unused") TRBracket node)
    {
        this.index = 39;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 40;
    }

    @Override
    public void caseTIntlit(@SuppressWarnings("unused") TIntlit node)
    {
        this.index = 41;
    }

    @Override
    public void caseTStrlit(@SuppressWarnings("unused") TStrlit node)
    {
        this.index = 42;
    }

    @Override
    public void caseTIllegalString(@SuppressWarnings("unused") TIllegalString node)
    {
        this.index = 43;
    }

    @Override
    public void caseTUnterminatedString(@SuppressWarnings("unused") TUnterminatedString node)
    {
        this.index = 44;
    }

    @Override
    public void caseTEol(@SuppressWarnings("unused") TEol node)
    {
        this.index = 45;
    }

    @Override
    public void caseTIllegalChar(@SuppressWarnings("unused") TIllegalChar node)
    {
        this.index = 46;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 47;
    }
}
