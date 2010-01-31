/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AMultMultExpression extends PMultExpression
{
    private PMultExpression _multExpression_;
    private PMultOperator _multOperator_;
    private PCallExpression _callExpression_;

    public AMultMultExpression()
    {
        // Constructor
    }

    public AMultMultExpression(
        @SuppressWarnings("hiding") PMultExpression _multExpression_,
        @SuppressWarnings("hiding") PMultOperator _multOperator_,
        @SuppressWarnings("hiding") PCallExpression _callExpression_)
    {
        // Constructor
        setMultExpression(_multExpression_);

        setMultOperator(_multOperator_);

        setCallExpression(_callExpression_);

    }

    @Override
    public Object clone()
    {
        return new AMultMultExpression(
            cloneNode(this._multExpression_),
            cloneNode(this._multOperator_),
            cloneNode(this._callExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultMultExpression(this);
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

    public PMultOperator getMultOperator()
    {
        return this._multOperator_;
    }

    public void setMultOperator(PMultOperator node)
    {
        if(this._multOperator_ != null)
        {
            this._multOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._multOperator_ = node;
    }

    public PCallExpression getCallExpression()
    {
        return this._callExpression_;
    }

    public void setCallExpression(PCallExpression node)
    {
        if(this._callExpression_ != null)
        {
            this._callExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._callExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._multExpression_)
            + toString(this._multOperator_)
            + toString(this._callExpression_);
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

        if(this._multOperator_ == child)
        {
            this._multOperator_ = null;
            return;
        }

        if(this._callExpression_ == child)
        {
            this._callExpression_ = null;
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

        if(this._multOperator_ == oldChild)
        {
            setMultOperator((PMultOperator) newChild);
            return;
        }

        if(this._callExpression_ == oldChild)
        {
            setCallExpression((PCallExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}