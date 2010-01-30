/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AClassDef extends PClassDef
{
    private TKlass _klass_;
    private TId _begin_;
    private PClassInheritance _classInheritance_;
    private TIs _is_;
    private final LinkedList<TEol> _eol_ = new LinkedList<TEol>();
    private final LinkedList<PVarDeclaration> _varDeclaration_ = new LinkedList<PVarDeclaration>();
    private final LinkedList<PMethodDeclaration> _methodDeclaration_ = new LinkedList<PMethodDeclaration>();
    private TEnd _end_;
    private TId _classEnd_;

    public AClassDef()
    {
        // Constructor
    }

    public AClassDef(
        @SuppressWarnings("hiding") TKlass _klass_,
        @SuppressWarnings("hiding") TId _begin_,
        @SuppressWarnings("hiding") PClassInheritance _classInheritance_,
        @SuppressWarnings("hiding") TIs _is_,
        @SuppressWarnings("hiding") List<TEol> _eol_,
        @SuppressWarnings("hiding") List<PVarDeclaration> _varDeclaration_,
        @SuppressWarnings("hiding") List<PMethodDeclaration> _methodDeclaration_,
        @SuppressWarnings("hiding") TEnd _end_,
        @SuppressWarnings("hiding") TId _classEnd_)
    {
        // Constructor
        setKlass(_klass_);

        setBegin(_begin_);

        setClassInheritance(_classInheritance_);

        setIs(_is_);

        setEol(_eol_);

        setVarDeclaration(_varDeclaration_);

        setMethodDeclaration(_methodDeclaration_);

        setEnd(_end_);

        setClassEnd(_classEnd_);

    }

    @Override
    public Object clone()
    {
        return new AClassDef(
            cloneNode(this._klass_),
            cloneNode(this._begin_),
            cloneNode(this._classInheritance_),
            cloneNode(this._is_),
            cloneList(this._eol_),
            cloneList(this._varDeclaration_),
            cloneList(this._methodDeclaration_),
            cloneNode(this._end_),
            cloneNode(this._classEnd_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassDef(this);
    }

    public TKlass getKlass()
    {
        return this._klass_;
    }

    public void setKlass(TKlass node)
    {
        if(this._klass_ != null)
        {
            this._klass_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._klass_ = node;
    }

    public TId getBegin()
    {
        return this._begin_;
    }

    public void setBegin(TId node)
    {
        if(this._begin_ != null)
        {
            this._begin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._begin_ = node;
    }

    public PClassInheritance getClassInheritance()
    {
        return this._classInheritance_;
    }

    public void setClassInheritance(PClassInheritance node)
    {
        if(this._classInheritance_ != null)
        {
            this._classInheritance_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classInheritance_ = node;
    }

    public TIs getIs()
    {
        return this._is_;
    }

    public void setIs(TIs node)
    {
        if(this._is_ != null)
        {
            this._is_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._is_ = node;
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

    public LinkedList<PVarDeclaration> getVarDeclaration()
    {
        return this._varDeclaration_;
    }

    public void setVarDeclaration(List<PVarDeclaration> list)
    {
        this._varDeclaration_.clear();
        this._varDeclaration_.addAll(list);
        for(PVarDeclaration e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PMethodDeclaration> getMethodDeclaration()
    {
        return this._methodDeclaration_;
    }

    public void setMethodDeclaration(List<PMethodDeclaration> list)
    {
        this._methodDeclaration_.clear();
        this._methodDeclaration_.addAll(list);
        for(PMethodDeclaration e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TEnd getEnd()
    {
        return this._end_;
    }

    public void setEnd(TEnd node)
    {
        if(this._end_ != null)
        {
            this._end_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._end_ = node;
    }

    public TId getClassEnd()
    {
        return this._classEnd_;
    }

    public void setClassEnd(TId node)
    {
        if(this._classEnd_ != null)
        {
            this._classEnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classEnd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._klass_)
            + toString(this._begin_)
            + toString(this._classInheritance_)
            + toString(this._is_)
            + toString(this._eol_)
            + toString(this._varDeclaration_)
            + toString(this._methodDeclaration_)
            + toString(this._end_)
            + toString(this._classEnd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._klass_ == child)
        {
            this._klass_ = null;
            return;
        }

        if(this._begin_ == child)
        {
            this._begin_ = null;
            return;
        }

        if(this._classInheritance_ == child)
        {
            this._classInheritance_ = null;
            return;
        }

        if(this._is_ == child)
        {
            this._is_ = null;
            return;
        }

        if(this._eol_.remove(child))
        {
            return;
        }

        if(this._varDeclaration_.remove(child))
        {
            return;
        }

        if(this._methodDeclaration_.remove(child))
        {
            return;
        }

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        if(this._classEnd_ == child)
        {
            this._classEnd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._klass_ == oldChild)
        {
            setKlass((TKlass) newChild);
            return;
        }

        if(this._begin_ == oldChild)
        {
            setBegin((TId) newChild);
            return;
        }

        if(this._classInheritance_ == oldChild)
        {
            setClassInheritance((PClassInheritance) newChild);
            return;
        }

        if(this._is_ == oldChild)
        {
            setIs((TIs) newChild);
            return;
        }

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

        for(ListIterator<PVarDeclaration> i = this._varDeclaration_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVarDeclaration) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PMethodDeclaration> i = this._methodDeclaration_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethodDeclaration) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._end_ == oldChild)
        {
            setEnd((TEnd) newChild);
            return;
        }

        if(this._classEnd_ == oldChild)
        {
            setClassEnd((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
