package com.sunshine.infrastructure.support;

import com.sunshine.infrastructure.Mediator;
import com.sunshine.infrastructure.Person;

/**
 * @author Mokairui
 * @description
 * @since 2023/12/3
 */
public class Tenant extends Person {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }
    
    // 和中介者联系
    public void contact(String message) {
        mediator.constact(message, this);
    }
    
    // 获取中介者送过来的信息
    public void getMessage(String message) {
        System.out.println("租房者" + name + "获取到的信息是：" + message);
    }
    
}
