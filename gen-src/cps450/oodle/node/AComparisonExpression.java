/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AComparisonExpression extends PExpression
{
    private POperator _operator_;
    private PExpression _expr1_;
    private PExpression _expr2_;

    public AComparisonExpression()
    {
        // Constructor
    }

    public AComparisonExpression(
        @SuppressWarnings("hiding") POperator _operator_,
        @SuppressWarnings("hiding") PExpression _expr1_,
        @SuppressWarnings("hiding") PExpression _expr2_)
    {
        // Constructor
        setOperator(_operator_);

        setExpr1(_expr1_);

        setExpr2(_expr2_);

    }

    @Override
    public Object clone()
    {
        return new AComparisonExpression(
            cloneNode(this._operator_),
            cloneNode(this._expr1_),
            cloneNode(this._expr2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComparisonExpression(this);
    }

    public POperator getOperator()
    {
        return this._operator_;
    }

    public void setOperator(POperator node)
    {
        if(this._operator_ != null)
        {
            this._operator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operator_ = node;
    }

    public PExpression getExpr1()
    {
        return this._expr1_;
    }

    public void setExpr1(PExpression node)
    {
        if(this._expr1_ != null)
        {
            this._expr1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr1_ = node;
    }

    public PExpression getExpr2()
    {
        return this._expr2_;
    }

    public void setExpr2(PExpression node)
    {
        if(this._expr2_ != null)
        {
            this._expr2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._operator_)
            + toString(this._expr1_)
            + toString(this._expr2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._operator_ == child)
        {
            this._operator_ = null;
            return;
        }

        if(this._expr1_ == child)
        {
            this._expr1_ = null;
            return;
        }

        if(this._expr2_ == child)
        {
            this._expr2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._operator_ == oldChild)
        {
            setOperator((POperator) newChild);
            return;
        }

        if(this._expr1_ == oldChild)
        {
            setExpr1((PExpression) newChild);
            return;
        }

        if(this._expr2_ == oldChild)
        {
            setExpr2((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}