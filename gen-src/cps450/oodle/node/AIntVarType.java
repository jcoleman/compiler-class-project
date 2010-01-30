/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AIntVarType extends PVarType
{
    private TInt _int_;

    public AIntVarType()
    {
        // Constructor
    }

    public AIntVarType(
        @SuppressWarnings("hiding") TInt _int_)
    {
        // Constructor
        setInt(_int_);

    }

    @Override
    public Object clone()
    {
        return new AIntVarType(
            cloneNode(this._int_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntVarType(this);
    }

    public TInt getInt()
    {
        return this._int_;
    }

    public void setInt(TInt node)
    {
        if(this._int_ != null)
        {
            this._int_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._int_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._int_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._int_ == child)
        {
            this._int_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._int_ == oldChild)
        {
            setInt((TInt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
