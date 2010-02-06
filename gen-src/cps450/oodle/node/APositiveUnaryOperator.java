/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class APositiveUnaryOperator extends PUnaryOperator
{
    private TPlusOp _plusOp_;

    public APositiveUnaryOperator()
    {
        // Constructor
    }

    public APositiveUnaryOperator(
        @SuppressWarnings("hiding") TPlusOp _plusOp_)
    {
        // Constructor
        setPlusOp(_plusOp_);

    }

    @Override
    public Object clone()
    {
        return new APositiveUnaryOperator(
            cloneNode(this._plusOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPositiveUnaryOperator(this);
    }

    public TPlusOp getPlusOp()
    {
        return this._plusOp_;
    }

    public void setPlusOp(TPlusOp node)
    {
        if(this._plusOp_ != null)
        {
            this._plusOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plusOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._plusOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._plusOp_ == child)
        {
            this._plusOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._plusOp_ == oldChild)
        {
            setPlusOp((TPlusOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}