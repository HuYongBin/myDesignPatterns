package com.hyb.flyweight;

import java.util.Hashtable;

/**
 * Date: 13-11-14
 * Time: 下午5:10
 *
 * @author Hu YongBin
 */
public class FlyweightFactory {
    //Flyweight pool
    private Hashtable flyweights = new Hashtable();

    public Flyweight getFlyweight(Object key) {


        Flyweight flyweight = (Flyweight) flyweights.get(key);


        if (flyweight == null) {
            //产生新的ConcreteFlyweight
            flyweight = new ConcreteFlyweight();
            flyweights.put(key, flyweight);
        }


        return flyweight;
    }
}
