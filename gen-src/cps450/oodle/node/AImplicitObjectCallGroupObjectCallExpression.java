/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AImplicitObjectCallGroupObjectCallExpression extends PGroupObjectCallExpression
{
    private PGroupObjectCallExpression _groupObjectCallExpression_;
    private PObjectCall _objectCall_;

    public AImplicitObjectCallGroupObjectCallExpression()
    {
        // Constructor
    }

    public AImplicitObjectCallGroupObjectCallExpression(
        @SuppressWarnings("hiding") PGroupObjectCallExpression _groupObjectCallExpression_,
        @SuppressWarnings("hiding") PObjectCall _objectCall_)
    {
        // Constructor
        setGroupObjectCallExpression(_groupObjectCallExpression_);

        setObjectCall(_objectCall_);

    }

    @Override
    public Object clone()
    {
        return new AImplicitObjectCallGroupObjectCallExpression(
            cloneNode(this._groupObjectCallExpression_),
            cloneNode(this._objectCall_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAImplicitObjectCallGroupObjectCallExpression(this);
    }

    public PGroupObjectCallExpression getGroupObjectCallExpression()
    {
        return this._groupObjectCallExpression_;
    }

    public void setGroupObjectCallExpression(PGroupObjectCallExpression node)
    {
        if(this._groupObjectCallExpression_ != null)
        {
            this._groupObjectCallExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._groupObjectCallExpression_ = node;
    }

    public PObjectCall getObjectCall()
    {
        return this._objectCall_;
    }

    public void setObjectCall(PObjectCall node)
    {
        if(this._objectCall_ != null)
        {
            this._objectCall_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._objectCall_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._groupObjectCallExpression_)
            + toString(this._objectCall_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._groupObjectCallExpression_ == child)
        {
            this._groupObjectCallExpression_ = null;
            return;
        }

        if(this._objectCall_ == child)
        {
            this._objectCall_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._groupObjectCallExpression_ == oldChild)
        {
            setGroupObjectCallExpression((PGroupObjectCallExpression) newChild);
            return;
        }

        if(this._objectCall_ == oldChild)
        {
            setObjectCall((PObjectCall) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}