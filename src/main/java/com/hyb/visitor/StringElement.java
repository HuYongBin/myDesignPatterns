package com.hyb.visitor;

/**
 * Date: 13-11-15
 * Time: 下午3:06
 *
 * @author Hu YongBin
 */
public class StringElement implements Visitable {

    private String value;


    public StringElement(String string) {
        value = string;
    }


    public String getValue() {
        return value;
    }


    //定义accept的具体内容 这里是很简单的一句调用


    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}



