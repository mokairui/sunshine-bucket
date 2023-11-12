package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 观察者统一接口, 也可以让被观察者处理类一样实现, 当然被观察者也可以重新定义一个接口
 * @since 2023/11/12
 */
public interface Observer {
    
    void update(String context);
    
}
