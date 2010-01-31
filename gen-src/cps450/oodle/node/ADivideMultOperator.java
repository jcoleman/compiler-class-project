/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ADivideMultOperator extends PMultOperator
{
    private TDivOp _divOp_;

    public ADivideMultOperator()
    {
        // Constructor
    }

    public ADivideMultOperator(
        @SuppressWarnings("hiding") TDivOp _divOp_)
    {
        // Constructor
        setDivOp(_divOp_);

    }

    @Override
    public Object clone()
    {
        return new ADivideMultOperator(
            cloneNode(this._divOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivideMultOperator(this);
    }

    public TDivOp getDivOp()
    {
        return this._divOp_;
    }

    public void setDivOp(TDivOp node)
    {
        if(this._divOp_ != null)
        {
            this._divOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._divOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._divOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._divOp_ == child)
        {
            this._divOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._divOp_ == oldChild)
        {
            setDivOp((TDivOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
