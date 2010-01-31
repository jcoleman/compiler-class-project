/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ATest3AssignmentStatement extends PAssignmentStatement
{
    private TId _id_;
    private final LinkedList<PBracketOperation> _bracketOperation_ = new LinkedList<PBracketOperation>();
    private PVarInstantiation _varInstantiation_;

    public ATest3AssignmentStatement()
    {
        // Constructor
    }

    public ATest3AssignmentStatement(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") List<PBracketOperation> _bracketOperation_,
        @SuppressWarnings("hiding") PVarInstantiation _varInstantiation_)
    {
        // Constructor
        setId(_id_);

        setBracketOperation(_bracketOperation_);

        setVarInstantiation(_varInstantiation_);

    }

    @Override
    public Object clone()
    {
        return new ATest3AssignmentStatement(
            cloneNode(this._id_),
            cloneList(this._bracketOperation_),
            cloneNode(this._varInstantiation_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATest3AssignmentStatement(this);
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

    public LinkedList<PBracketOperation> getBracketOperation()
    {
        return this._bracketOperation_;
    }

    public void setBracketOperation(List<PBracketOperation> list)
    {
        this._bracketOperation_.clear();
        this._bracketOperation_.addAll(list);
        for(PBracketOperation e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PVarInstantiation getVarInstantiation()
    {
        return this._varInstantiation_;
    }

    public void setVarInstantiation(PVarInstantiation node)
    {
        if(this._varInstantiation_ != null)
        {
            this._varInstantiation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._varInstantiation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._bracketOperation_)
            + toString(this._varInstantiation_);
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

        if(this._bracketOperation_.remove(child))
        {
            return;
        }

        if(this._varInstantiation_ == child)
        {
            this._varInstantiation_ = null;
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

        for(ListIterator<PBracketOperation> i = this._bracketOperation_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBracketOperation) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._varInstantiation_ == oldChild)
        {
            setVarInstantiation((PVarInstantiation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
