package com.hyb.interpreter;

public class QiExpression extends Expression {
    @Override
    public String GetPostfix() {
        return "千";
    }

    @Override
    public int Multiplier() {
        return 1000;
    }
}
