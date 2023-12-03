package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 抽象的联系组
 * @since 2023/12/3
 */
public abstract class Person {
    
    protected String name;
    
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
