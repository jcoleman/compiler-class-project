/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AMinusOperator extends POperator
{
    private TMinusOp _op_;

    public AMinusOperator()
    {
        // Constructor
    }

    public AMinusOperator(
        @SuppressWarnings("hiding") TMinusOp _op_)
    {
        // Constructor
        setOp(_op_);

    }

    @Override
    public Object clone()
    {
        return new AMinusOperator(
            cloneNode(this._op_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusOperator(this);
    }

    public TMinusOp getOp()
    {
        return this._op_;
    }

    public void setOp(TMinusOp node)
    {
        if(this._op_ != null)
        {
            this._op_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._op_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._op_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._op_ == child)
        {
            this._op_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._op_ == oldChild)
        {
            setOp((TMinusOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
