package com.sunshine.infrastructure.product;

/**
 * @author Mokairui
 * @description 公司的产品, 抽象出两个方法 生成 和 出售
 * @since 2023/11/1
 */
public abstract class Product {

    //甭管是什么产品它总要是能被生产出来
    public abstract void beProducted();

    //生产出来的东西，一定要销售出去，否则扩本呀
    public abstract void beSelled();

}
