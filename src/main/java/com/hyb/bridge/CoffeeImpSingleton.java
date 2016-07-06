package com.hyb.bridge;

/**
 * Date: 13-11-14
 * Time: 下午4:48
 *
 * @author Hu YongBin
 */
public class CoffeeImpSingleton {
    private static CoffeeImp coffeeImp;

    public CoffeeImpSingleton(CoffeeImp coffeeImpIn) {
        this.coffeeImp = coffeeImpIn;
    }

    public static CoffeeImp getTheCoffeeImp() {
        return coffeeImp;
    }
}