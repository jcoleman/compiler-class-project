/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ACallExpression extends PExpression
{
    private PExpression _object_;
    private TId _method_;
    private final LinkedList<PExpression> _arguments_ = new LinkedList<PExpression>();

    public ACallExpression()
    {
        // Constructor
    }

    public ACallExpression(
        @SuppressWarnings("hiding") PExpression _object_,
        @SuppressWarnings("hiding") TId _method_,
        @SuppressWarnings("hiding") List<PExpression> _arguments_)
    {
        // Constructor
        setObject(_object_);

        setMethod(_method_);

        setArguments(_arguments_);

    }

    @Override
    public Object clone()
    {
        return new ACallExpression(
            cloneNode(this._object_),
            cloneNode(this._method_),
            cloneList(this._arguments_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACallExpression(this);
    }

    public PExpression getObject()
    {
        return this._object_;
    }

    public void setObject(PExpression node)
    {
        if(this._object_ != null)
        {
            this._object_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._object_ = node;
    }

    public TId getMethod()
    {
        return this._method_;
    }

    public void setMethod(TId node)
    {
        if(this._method_ != null)
        {
            this._method_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._method_ = node;
    }

    public LinkedList<PExpression> getArguments()
    {
        return this._arguments_;
    }

    public void setArguments(List<PExpression> list)
    {
        this._arguments_.clear();
        this._arguments_.addAll(list);
        for(PExpression e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._object_)
            + toString(this._method_)
            + toString(this._arguments_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._object_ == child)
        {
            this._object_ = null;
            return;
        }

        if(this._method_ == child)
        {
            this._method_ = null;
            return;
        }

        if(this._arguments_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._object_ == oldChild)
        {
            setObject((PExpression) newChild);
            return;
        }

        if(this._method_ == oldChild)
        {
            setMethod((TId) newChild);
            return;
        }

        for(ListIterator<PExpression> i = this._arguments_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExpression) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}