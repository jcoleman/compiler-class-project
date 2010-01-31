/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AGetAtObjectCallExpression extends PObjectCallExpression
{
    private TId _id_;
    private final LinkedList<PGetAtOperation> _getAtOperation_ = new LinkedList<PGetAtOperation>();

    public AGetAtObjectCallExpression()
    {
        // Constructor
    }

    public AGetAtObjectCallExpression(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") List<PGetAtOperation> _getAtOperation_)
    {
        // Constructor
        setId(_id_);

        setGetAtOperation(_getAtOperation_);

    }

    @Override
    public Object clone()
    {
        return new AGetAtObjectCallExpression(
            cloneNode(this._id_),
            cloneList(this._getAtOperation_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGetAtObjectCallExpression(this);
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

    public LinkedList<PGetAtOperation> getGetAtOperation()
    {
        return this._getAtOperation_;
    }

    public void setGetAtOperation(List<PGetAtOperation> list)
    {
        this._getAtOperation_.clear();
        this._getAtOperation_.addAll(list);
        for(PGetAtOperation e : list)
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
            + toString(this._id_)
            + toString(this._getAtOperation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._getAtOperation_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        for(ListIterator<PGetAtOperation> i = this._getAtOperation_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PGetAtOperation) newChild);
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
