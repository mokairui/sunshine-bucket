package com.sunshine.infrastructure;

import com.sunshine.infrastructure.product.Product;

/**
 * @author Mokairui
 * @description 山寨版的公司
 * @since 2023/11/2
 */
public class CounterfeitCorp extends Corp {
    
    public CounterfeitCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我挣钱拉...");
    }
}
