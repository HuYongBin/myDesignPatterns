package com.hyb.interpreter;

public class ShExpression extends Expression {
    @Override
    public String GetPostfix() {
        return "十";
    }

    @Override
    public int Multiplier() {
        return 10;
    }
}