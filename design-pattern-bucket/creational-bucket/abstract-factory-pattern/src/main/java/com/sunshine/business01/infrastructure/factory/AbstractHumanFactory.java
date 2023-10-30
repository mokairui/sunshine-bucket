package com.sunshine.business01.infrastructure.factory;

import com.sunshine.business01.infrastructure.Human;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public abstract class AbstractHumanFactory implements HumanFactory {
    
    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        
        if (!humanEnum.getValue().isEmpty()) {
            try {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return human;
    }
    
}
