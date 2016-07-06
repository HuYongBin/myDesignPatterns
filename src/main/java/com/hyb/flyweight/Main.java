package com.hyb.flyweight;

/**
 * Date: 13-11-14
 * Time: 下午5:11
 *
 * @author Hu YongBin
 */
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly1 = factory.getFlyweight("Fred");
        Flyweight fly2 = factory.getFlyweight("Wilma");

    }
}
