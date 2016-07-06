package com.hyb.interpreter;

import java.util.ArrayList;

public class WaExpression extends Expression {
    @Override
    public String GetPostfix() {
        return "万";
    }

    @Override
    public int Multiplier() {
        return 10000;
    }

    @Override
    public void Interpret(Context ctx) {
        if (ctx.getStatement().endsWith("零")) {
            String tempstr = ctx.getStatement();
            tempstr = tempstr.substring(0, tempstr.length() - 1);
            ctx.setStatement(tempstr);

            return;
        }

        if (ctx.getStatement().length() == 0) {
            // 处理完成，返回
            return;
        } else {
            ArrayList<Expression> stxTree = new ArrayList<Expression>();
            stxTree.add(new GeExpression());
            stxTree.add(new ShExpression());
            stxTree.add(new BaExpression());
            stxTree.add(new QiExpression());

            if (ctx.getStatement().endsWith(GetPostfix())) {
                long tempdata = ctx.getData();
                ctx.setData(0);

                String tempstr = ctx.getStatement();
                tempstr = tempstr.substring(0, tempstr.length() - 1);
                ctx.setStatement(tempstr);

                for (Expression exp : stxTree) {
                    exp.Interpret(ctx);
                }

                ctx.setData(tempdata + ctx.getData() * this.Multiplier());

                return;
            }
        }
    }
}
