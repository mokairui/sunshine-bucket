package com.sunshine.infrastructure;

import com.sunshine.infrastructure.product.Product;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/2
 */
public class HouseCorp extends Corp {
    //定义传递一个House产品进来
    public HouseCorp(Product product) {
        super(product);
    }

    //房地产公司很High了，赚钱，计算利润
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司挣大钱了...");
    }
}
