/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AArrayVarType extends PVarType
{
    private PArrayVarType _arrayVarType_;

    public AArrayVarType()
    {
        // Constructor
    }

    public AArrayVarType(
        @SuppressWarnings("hiding") PArrayVarType _arrayVarType_)
    {
        // Constructor
        setArrayVarType(_arrayVarType_);

    }

    @Override
    public Object clone()
    {
        return new AArrayVarType(
            cloneNode(this._arrayVarType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayVarType(this);
    }

    public PArrayVarType getArrayVarType()
    {
        return this._arrayVarType_;
    }

    public void setArrayVarType(PArrayVarType node)
    {
        if(this._arrayVarType_ != null)
        {
            this._arrayVarType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayVarType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arrayVarType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arrayVarType_ == child)
        {
            this._arrayVarType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arrayVarType_ == oldChild)
        {
            setArrayVarType((PArrayVarType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
