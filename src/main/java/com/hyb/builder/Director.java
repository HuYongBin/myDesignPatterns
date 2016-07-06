package com.hyb.builder;

/**
 * Date: 13-11-14
 * Time: 下午4:15
 *
 * @author Hu YongBin
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 将部件partA partB partC最后组成复杂对象
    //这里是将车轮 方向盘和发动机组装成汽车的过程
    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }

}


