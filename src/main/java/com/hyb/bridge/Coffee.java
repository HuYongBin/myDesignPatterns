package com.hyb.bridge;

/**
 * Date: 13-11-14
 * Time: 下午4:44
 *
 * @author Hu YongBin
 */
public abstract class Coffee {
    CoffeeImp coffeeImp;

    public void setCoffeeImp() {
        this.coffeeImp = CoffeeImpSingleton.getTheCoffeeImp();
    }

    public CoffeeImp getCoffeeImp() {
        return this.coffeeImp;
    }

    public abstract void pourCoffee();
}

