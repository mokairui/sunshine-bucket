package com.sunshine.business01.infrastructure.factory;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public enum HumanEnum {
    YellowMaleHuman("com.sunshine.business01.infrastructure.impl.YellowMaleHuman"),
    YellowFemaleHuman("com.sunshine.business01.infrastructure.impl.YellowFemaleHuman"),
    WhiteMaleHuman("com.sunshine.business01.infrastructure.impl.WhiteMaleHuman"),
    WhiteFemaleHuman("com.sunshine.business01.infrastructure.impl.WhiteFemaleHuman"),
    BlackMaleHuman("com.sunshine.business01.infrastructure.impl.BlackMaleHuman"),
    BlackFemaleHuman("com.sunshine.business01.infrastructure.impl.BlackFemaleHuman");
    
    private String value = "";
    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
