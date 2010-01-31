/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AExpr5AddExpression extends PAddExpression
{
    private PMultExpression _multExpression_;

    public AExpr5AddExpression()
    {
        // Constructor
    }

    public AExpr5AddExpression(
        @SuppressWarnings("hiding") PMultExpression _multExpression_)
    {
        // Constructor
        setMultExpression(_multExpression_);

    }

    @Override
    public Object clone()
    {
        return new AExpr5AddExpression(
            cloneNode(this._multExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpr5AddExpression(this);
    }

    public PMultExpression getMultExpression()
    {
        return this._multExpression_;
    }

    public void setMultExpression(PMultExpression node)
    {
        if(this._multExpression_ != null)
        {
            this._multExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._multExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._multExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._multExpression_ == child)
        {
            this._multExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._multExpression_ == oldChild)
        {
            setMultExpression((PMultExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
