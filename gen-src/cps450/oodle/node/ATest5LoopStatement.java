/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ATest5LoopStatement extends PLoopStatement
{
    private TLoop _loopBegin_;
    private TWhile _while_;
    private PExpression _expression_;
    private final LinkedList<TEol> _eol_ = new LinkedList<TEol>();
    private PStatementList _statementList_;
    private TEnd _end_;
    private TLoop _loopEnd_;

    public ATest5LoopStatement()
    {
        // Constructor
    }

    public ATest5LoopStatement(
        @SuppressWarnings("hiding") TLoop _loopBegin_,
        @SuppressWarnings("hiding") TWhile _while_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") List<TEol> _eol_,
        @SuppressWarnings("hiding") PStatementList _statementList_,
        @SuppressWarnings("hiding") TEnd _end_,
        @SuppressWarnings("hiding") TLoop _loopEnd_)
    {
        // Constructor
        setLoopBegin(_loopBegin_);

        setWhile(_while_);

        setExpression(_expression_);

        setEol(_eol_);

        setStatementList(_statementList_);

        setEnd(_end_);

        setLoopEnd(_loopEnd_);

    }

    @Override
    public Object clone()
    {
        return new ATest5LoopStatement(
            cloneNode(this._loopBegin_),
            cloneNode(this._while_),
            cloneNode(this._expression_),
            cloneList(this._eol_),
            cloneNode(this._statementList_),
            cloneNode(this._end_),
            cloneNode(this._loopEnd_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATest5LoopStatement(this);
    }

    public TLoop getLoopBegin()
    {
        return this._loopBegin_;
    }

    public void setLoopBegin(TLoop node)
    {
        if(this._loopBegin_ != null)
        {
            this._loopBegin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._loopBegin_ = node;
    }

    public TWhile getWhile()
    {
        return this._while_;
    }

    public void setWhile(TWhile node)
    {
        if(this._while_ != null)
        {
            this._while_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._while_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
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

    public PStatementList getStatementList()
    {
        return this._statementList_;
    }

    public void setStatementList(PStatementList node)
    {
        if(this._statementList_ != null)
        {
            this._statementList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statementList_ = node;
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

    public TLoop getLoopEnd()
    {
        return this._loopEnd_;
    }

    public void setLoopEnd(TLoop node)
    {
        if(this._loopEnd_ != null)
        {
            this._loopEnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._loopEnd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._loopBegin_)
            + toString(this._while_)
            + toString(this._expression_)
            + toString(this._eol_)
            + toString(this._statementList_)
            + toString(this._end_)
            + toString(this._loopEnd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._loopBegin_ == child)
        {
            this._loopBegin_ = null;
            return;
        }

        if(this._while_ == child)
        {
            this._while_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._eol_.remove(child))
        {
            return;
        }

        if(this._statementList_ == child)
        {
            this._statementList_ = null;
            return;
        }

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        if(this._loopEnd_ == child)
        {
            this._loopEnd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._loopBegin_ == oldChild)
        {
            setLoopBegin((TLoop) newChild);
            return;
        }

        if(this._while_ == oldChild)
        {
            setWhile((TWhile) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
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

        if(this._statementList_ == oldChild)
        {
            setStatementList((PStatementList) newChild);
            return;
        }

        if(this._end_ == oldChild)
        {
            setEnd((TEnd) newChild);
            return;
        }

        if(this._loopEnd_ == oldChild)
        {
            setLoopEnd((TLoop) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
