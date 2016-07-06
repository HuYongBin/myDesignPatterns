package com.hyb.interpreter;

public class GeExpression extends Expression {
    @Override
    public String GetPostfix() {
        return "";
    }

    @Override
    public int Multiplier() {
        return 1;
    }

    @Override
    public int GetLength() {
        return 1;
    }
}