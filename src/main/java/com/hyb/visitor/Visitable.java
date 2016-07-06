package com.hyb.visitor;

/**
 * Date: 13-11-15
 * Time: 下午3:06
 *
 * @author Hu YongBin
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
