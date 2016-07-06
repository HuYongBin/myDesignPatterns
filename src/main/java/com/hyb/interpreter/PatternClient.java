package com.hyb.interpreter;

import java.util.ArrayList;

public class PatternClient {
    public static void main(String[] args) {
        String chineseNumber = "九万六千六百八十九亿零七百三十一万六千八百三十九";
        Context ctx = new Context(chineseNumber);

        // 构造语法树
        ArrayList<Expression> syntaxTree = new ArrayList<Expression>();
        syntaxTree.add(new GeExpression());
        syntaxTree.add(new ShExpression());
        syntaxTree.add(new BaExpression());
        syntaxTree.add(new QiExpression());
        syntaxTree.add(new WaExpression());
        syntaxTree.add(new YiExpression());

        // 开始解释
        for (Expression exp : syntaxTree) {
            exp.Interpret(ctx);
        }

        System.out.println(chineseNumber + " = " + ctx.getData());
    }
}
