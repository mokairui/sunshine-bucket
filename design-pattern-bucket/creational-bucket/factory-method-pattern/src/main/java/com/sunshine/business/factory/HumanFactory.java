package com.sunshine.business.factory;

import com.sunshine.infrastructure.Human;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/29
 */
public class HumanFactory {
    private static final Map<String, Human> humans = new HashMap<>(); 
    
    public static Human createHuman(Class<? extends Human> c) {
        Human human = null;
        try {
            if (humans.containsKey(c.getSimpleName())) {
                human = humans.get(c);
            } else {
                human = ((Human) Class.forName(c.getName()).newInstance());
                humans.put(c.getSimpleName(), human);
            }
        } catch (InstantiationException e) {
            System.out.println("必须指定人种的颜色");
        } catch (IllegalAccessException e) {
            System.out.println("人种定义错误！");
        } catch (ClassNotFoundException e) {
            System.out.println("混蛋，你指定的人种找不到！");
        }
        return human;
    }
}
