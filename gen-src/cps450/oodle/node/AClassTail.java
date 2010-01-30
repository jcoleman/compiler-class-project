/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AClassTail extends PClassTail
{
    private final LinkedList<TEol> _eol_ = new LinkedList<TEol>();
    private PClassDef _classDef_;

    public AClassTail()
    {
        // Constructor
    }

    public AClassTail(
        @SuppressWarnings("hiding") List<TEol> _eol_,
        @SuppressWarnings("hiding") PClassDef _classDef_)
    {
        // Constructor
        setEol(_eol_);

        setClassDef(_classDef_);

    }

    @Override
    public Object clone()
    {
        return new AClassTail(
            cloneList(this._eol_),
            cloneNode(this._classDef_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassTail(this);
    }

    public LinkedList<TEol> getEol()
    {
        return this._eol_;
    }

    public void setEol(List<TEol> list)
    {
        this._eol_.clear();
        this._eol_.addAll(list);
        for(TEol e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PClassDef getClassDef()
    {
        return this._classDef_;
    }

    public void setClassDef(PClassDef node)
    {
        if(this._classDef_ != null)
        {
            this._classDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classDef_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._eol_)
            + toString(this._classDef_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._eol_.remove(child))
        {
            return;
        }

        if(this._classDef_ == child)
        {
            this._classDef_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<TEol> i = this._eol_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((TEol) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._classDef_ == oldChild)
        {
            setClassDef((PClassDef) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
