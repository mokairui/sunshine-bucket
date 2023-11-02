package com.sunshine.infrastructure.product;

/**
 * @author Mokairui
 * @description 生成衣服的公司
 * @since 2023/11/2
 */
public class Clothes extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的衣服是这个样子的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的衣服卖出去了...");
    }
}
