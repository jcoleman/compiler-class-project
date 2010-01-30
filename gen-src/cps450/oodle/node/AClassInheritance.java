/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AClassInheritance extends PClassInheritance
{
    private TInherits _inherits_;
    private TFrom _from_;
    private TId _id_;

    public AClassInheritance()
    {
        // Constructor
    }

    public AClassInheritance(
        @SuppressWarnings("hiding") TInherits _inherits_,
        @SuppressWarnings("hiding") TFrom _from_,
        @SuppressWarnings("hiding") TId _id_)
    {
        // Constructor
        setInherits(_inherits_);

        setFrom(_from_);

        setId(_id_);

    }

    @Override
    public Object clone()
    {
        return new AClassInheritance(
            cloneNode(this._inherits_),
            cloneNode(this._from_),
            cloneNode(this._id_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassInheritance(this);
    }

    public TInherits getInherits()
    {
        return this._inherits_;
    }

    public void setInherits(TInherits node)
    {
        if(this._inherits_ != null)
        {
            this._inherits_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inherits_ = node;
    }

    public TFrom getFrom()
    {
        return this._from_;
    }

    public void setFrom(TFrom node)
    {
        if(this._from_ != null)
        {
            this._from_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._from_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._inherits_)
            + toString(this._from_)
            + toString(this._id_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._inherits_ == child)
        {
            this._inherits_ = null;
            return;
        }

        if(this._from_ == child)
        {
            this._from_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._inherits_ == oldChild)
        {
            setInherits((TInherits) newChild);
            return;
        }

        if(this._from_ == oldChild)
        {
            setFrom((TFrom) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}