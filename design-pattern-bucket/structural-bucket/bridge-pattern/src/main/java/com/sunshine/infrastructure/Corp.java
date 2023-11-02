package com.sunshine.infrastructure;

import com.sunshine.infrastructure.product.Product;

/**
 * @author Mokairui
 * @description 一个公司的抽象
 * @since 2023/11/1
 */
public abstract class Corp {
    
    // 定义一个产品对象, 抽象的, 不知道具体是什么产品
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }
    
    // 定义公司的对外暴露的方法: 挣钱
    public void makeMoney() {
        // 先生成产品
        this.product.beProducted();
        // 然后销售
        this.product.beSelled();
    }
    
}
