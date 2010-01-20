/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class TComma extends Token
{
    public TComma()
    {
        super.setText(",");
    }

    public TComma(int line, int pos)
    {
        super.setText(",");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TComma(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTComma(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TComma text.");
    }
}
