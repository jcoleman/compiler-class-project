/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AMeExpression extends PExpression
{
    private TMe _me_;

    public AMeExpression()
    {
        // Constructor
    }

    public AMeExpression(
        @SuppressWarnings("hiding") TMe _me_)
    {
        // Constructor
        setMe(_me_);

    }

    @Override
    public Object clone()
    {
        return new AMeExpression(
            cloneNode(this._me_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMeExpression(this);
    }

    public TMe getMe()
    {
        return this._me_;
    }

    public void setMe(TMe node)
    {
        if(this._me_ != null)
        {
            this._me_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._me_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._me_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._me_ == child)
        {
            this._me_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._me_ == oldChild)
        {
            setMe((TMe) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
