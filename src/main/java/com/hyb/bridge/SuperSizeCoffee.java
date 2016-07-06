package com.hyb.bridge;

/**
 * Date: 13-11-14
 * Time: 下午4:47
 *
 * @author Hu YongBin
 */
//大杯
public class SuperSizeCoffee extends Coffee {
    public SuperSizeCoffee() {
        setCoffeeImp();
    }

    public void pourCoffee() {
        CoffeeImp coffeeImp = this.getCoffeeImp();
        //我们以重复次数来说明是冲中杯还是大杯 ,重复5次是大杯
        for (int i = 0; i < 5; i++) {

            coffeeImp.pourCoffeeImp();
        }

    }
}
