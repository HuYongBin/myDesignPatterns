package com.hyb.visitor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * Date: 13-11-15
 * Time: 下午3:09
 *
 * @author Hu YongBin
 */
public class ConcreteVisitor implements Visitor {

    //在本方法中,我们实现了对Collection的元素的成功访问
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            visit(iterator.next());
        }
    }

    public void visitString(StringElement stringE) {
        System.out.println("'" + stringE.getValue() + "'");
    }

    public void visitFloat(FloatElement floatE) {
        System.out.println(floatE.getValue().toString() + "f");
    }

    public void visit(Object o) {
        String className = o.getClass().getName(); //获取类名称，这里是包含包名的全称
        String methodName = "visit" + className.substring(className.lastIndexOf(".") + 1);//组合获取方法名称
        try {
            //根据方法名从该类中获取相应的方法
            Method m = this.getClass().getMethod(methodName, new Class[]{o.getClass()});
            m.invoke(this, new Object[]{o});
        } catch (NoSuchMethodException e) {
            defaultVisit(o);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void defaultVisit(Object o) {
        if (o instanceof Visitable) {
            ((Visitable) o).accept(this);
        } else {
            throw new UnsupportedOperationException("Can not visit "+o.getClass().getName());
        }
    }
}