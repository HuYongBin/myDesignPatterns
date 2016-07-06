package com.hyb.visitor;

import java.util.Collection;

/**
 * Date: 13-11-15
 * Time: 下午3:08
 *
 * @author Hu YongBin
 */
public interface Visitor {
    public void visitString(StringElement stringE);

    public void visitFloat(FloatElement floatE);

    public void visitCollection(Collection collection);
}

