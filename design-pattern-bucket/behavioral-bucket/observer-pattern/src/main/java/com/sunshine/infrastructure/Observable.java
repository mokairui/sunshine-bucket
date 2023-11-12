package com.sunshine.infrastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mokairui
 * @description 被观察者统一的处理接口, 用来维护所有观察者, 同时提供推送消息的接口给所有被观察者使用
 * @since 2023/11/12
 */
public abstract class Observable implements Observer {

    //定义个变长数组，存放所有的观察者
    private final List<Observer> observerList = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void update(String context) {
        for (Observer observer : observerList) {
            observer.update(context);
        }
    }
}
