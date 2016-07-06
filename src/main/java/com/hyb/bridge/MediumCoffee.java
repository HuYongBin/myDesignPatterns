package com.hyb.bridge;

/**
 * Date: 13-11-14
 * Time: 下午4:46
 *
 * @author Hu YongBin
 */
//中杯
public class MediumCoffee extends Coffee {
    public MediumCoffee() {
        setCoffeeImp();
    }

    public void pourCoffee() {
        CoffeeImp coffeeImp = this.getCoffeeImp();
        //我们以重复次数来说明是冲中杯还是大杯 ,重复2次是中杯
        for (int i = 0; i < 2; i++) {
            coffeeImp.pourCoffeeImp();
        }

    }
}

