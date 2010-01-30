/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ACallStatement extends PStatement
{
    private PCallStatement _callStatement_;

    public ACallStatement()
    {
        // Constructor
    }

    public ACallStatement(
        @SuppressWarnings("hiding") PCallStatement _callStatement_)
    {
        // Constructor
        setCallStatement(_callStatement_);

    }

    @Override
    public Object clone()
    {
        return new ACallStatement(
            cloneNode(this._callStatement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACallStatement(this);
    }

    public PCallStatement getCallStatement()
    {
        return this._callStatement_;
    }

    public void setCallStatement(PCallStatement node)
    {
        if(this._callStatement_ != null)
        {
            this._callStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._callStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._callStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._callStatement_ == child)
        {
            this._callStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._callStatement_ == oldChild)
        {
            setCallStatement((PCallStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
