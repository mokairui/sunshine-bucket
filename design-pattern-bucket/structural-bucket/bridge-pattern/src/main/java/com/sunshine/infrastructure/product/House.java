package com.sunshine.infrastructure.product;

/**
 * @author Mokairui
 * @description 房地产
 * @since 2023/11/1
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这个样子的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}
