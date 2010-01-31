/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ANegateUnaryOperator extends PUnaryOperator
{
    private TMinusOp _minusOp_;

    public ANegateUnaryOperator()
    {
        // Constructor
    }

    public ANegateUnaryOperator(
        @SuppressWarnings("hiding") TMinusOp _minusOp_)
    {
        // Constructor
        setMinusOp(_minusOp_);

    }

    @Override
    public Object clone()
    {
        return new ANegateUnaryOperator(
            cloneNode(this._minusOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANegateUnaryOperator(this);
    }

    public TMinusOp getMinusOp()
    {
        return this._minusOp_;
    }

    public void setMinusOp(TMinusOp node)
    {
        if(this._minusOp_ != null)
        {
            this._minusOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minusOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._minusOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._minusOp_ == child)
        {
            this._minusOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._minusOp_ == oldChild)
        {
            setMinusOp((TMinusOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
