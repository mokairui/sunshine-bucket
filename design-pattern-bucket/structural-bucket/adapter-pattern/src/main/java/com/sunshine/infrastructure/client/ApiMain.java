package com.sunshine.infrastructure.client;

import com.sunshine.infrastructure.IUserInfo;
import com.sunshine.infrastructure.adapter.OuterUserInfoAdapter;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/31
 */
public class ApiMain {
    public static void main(String[] args) {
        // 没有与外系统连接的时候，是这样写的
        // IUserInfo youngGirl = new UserInfo();

        // 如果这时需要接入一个外部系统, 但是外部系统的对象和系统内部不一样则使用适配器, 这里一样可以获取到原接口了, 具体业务逻辑还是一样
        IUserInfo youngGirl = new OuterUserInfoAdapter(); //我们只修改了这一句好
        //从数据库中查到101个
        for(int i=0;i<101;i++){
            youngGirl.getMobileNumber();
        }
    }
}
