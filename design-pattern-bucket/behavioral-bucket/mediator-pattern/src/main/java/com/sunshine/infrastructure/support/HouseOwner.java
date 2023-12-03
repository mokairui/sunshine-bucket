package com.sunshine.infrastructure.support;

import com.sunshine.infrastructure.Mediator;
import com.sunshine.infrastructure.Person;

/**
 * @author Mokairui
 * @description
 * @since 2023/12/3
 */
public class HouseOwner extends Person {
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //和中介联系（沟通）
    public void contact(String message) {
        mediator.constact(message,this);
    }

    //获取信息
    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到的信息是：" + message);
    }
    
}
