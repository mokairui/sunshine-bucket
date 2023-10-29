package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 工厂类型都是基于多态来创建其具体的子类, 所以所有的具体对象应该都有一个约束的抽象父类或则接口
 * @since 2023/10/29
 */
public interface Human {
    
    void laugh();
    
    void cry();
    
    void talk();
    
}
