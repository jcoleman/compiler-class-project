/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AObjectCall extends PObjectCall
{
    private PExpression _expression_;
    private TPeriod _period_;

    public AObjectCall()
    {
        // Constructor
    }

    public AObjectCall(
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TPeriod _period_)
    {
        // Constructor
        setExpression(_expression_);

        setPeriod(_period_);

    }

    @Override
    public Object clone()
    {
        return new AObjectCall(
            cloneNode(this._expression_),
            cloneNode(this._period_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAObjectCall(this);
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    public TPeriod getPeriod()
    {
        return this._period_;
    }

    public void setPeriod(TPeriod node)
    {
        if(this._period_ != null)
        {
            this._period_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._period_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression_)
            + toString(this._period_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._period_ == child)
        {
            this._period_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._period_ == oldChild)
        {
            setPeriod((TPeriod) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}