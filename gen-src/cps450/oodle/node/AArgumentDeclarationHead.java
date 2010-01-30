/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AArgumentDeclarationHead extends PArgumentDeclarationHead
{
    private PArgumentDeclaration _argumentDeclaration_;
    private TSemicolon _semicolon_;

    public AArgumentDeclarationHead()
    {
        // Constructor
    }

    public AArgumentDeclarationHead(
        @SuppressWarnings("hiding") PArgumentDeclaration _argumentDeclaration_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setArgumentDeclaration(_argumentDeclaration_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new AArgumentDeclarationHead(
            cloneNode(this._argumentDeclaration_),
            cloneNode(this._semicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArgumentDeclarationHead(this);
    }

    public PArgumentDeclaration getArgumentDeclaration()
    {
        return this._argumentDeclaration_;
    }

    public void setArgumentDeclaration(PArgumentDeclaration node)
    {
        if(this._argumentDeclaration_ != null)
        {
            this._argumentDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argumentDeclaration_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._argumentDeclaration_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._argumentDeclaration_ == child)
        {
            this._argumentDeclaration_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._argumentDeclaration_ == oldChild)
        {
            setArgumentDeclaration((PArgumentDeclaration) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}