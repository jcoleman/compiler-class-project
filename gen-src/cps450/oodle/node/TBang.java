/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class TBang extends Token
{
    public TBang()
    {
        super.setText("!");
    }

    public TBang(int line, int pos)
    {
        super.setText("!");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TBang(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTBang(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TBang text.");
    }
}
