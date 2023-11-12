package com.sunshine.infrastructure.executer;

import com.sunshine.infrastructure.Observable;

/**
 * @author Mokairui
 * @description 需要被观察的对象 继承 观察者父类, 在自己的方法中调用父类通知所有的 观察者
 * @since 2023/11/12
 */
public class HanFeiZi extends Observable {

    //韩非子要吃饭了
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        //通知所有的观察者
        super.update("韩非子在吃饭");
    }

    //韩非子开始娱乐了,古代人没啥娱乐，你能想到的就那么多
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        super.update("韩非子在娱乐");
    }

}
