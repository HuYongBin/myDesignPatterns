package com.hyb.interpreter;

import java.util.Hashtable;

public abstract class Expression {

    protected Hashtable<String, Integer> dictionary = new Hashtable<String, Integer>();

    public Expression() {
        dictionary.put("一", 1);
        dictionary.put("二", 2);
        dictionary.put("三", 3);
        dictionary.put("四", 4);
        dictionary.put("五", 5);
        dictionary.put("六", 6);
        dictionary.put("七", 7);
        dictionary.put("八", 8);
        dictionary.put("九", 9);
    }

    public void Interpret(Context ctx) {
        if (ctx.getStatement().length() == 0) {
            // 处理完成，返回
            return;
        } else if (ctx.getStatement().endsWith("零")) {
            String tempstr = ctx.getStatement();
            tempstr = tempstr.substring(0, tempstr.length() - 1);
            ctx.setStatement(tempstr);
            return;
        } else {
            for (String key : dictionary.keySet())// 相当于C#中的foreach
            {
                int value = dictionary.get(key).intValue();
                if (ctx.getStatement().endsWith(key + GetPostfix())) {
                    long tempdata = ctx.getData();
                    tempdata += value * Multiplier();
                    ctx.setData(tempdata);

                    String tempstr = ctx.getStatement();
                    tempstr = tempstr.substring(0, tempstr.length() - this.GetLength());
                    ctx.setStatement(tempstr);

                    return;
                }
            }
        }
    }

    public abstract String GetPostfix();

    public abstract int Multiplier();

    public int GetLength() {
        return this.GetPostfix().length() + 1;
    }
}
