package com.sunshine.client;

import com.sunshine.infrastructure.LeaveRequest;
import com.sunshine.infrastructure.handler.GeneralManager;
import com.sunshine.infrastructure.handler.GroupLeader;
import com.sunshine.infrastructure.handler.NormalManager;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/19
 */
public class Client {

    public static void main(String[] args) {
        //创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明",1,"身体不适");

        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        NormalManager manager = new NormalManager();
        GeneralManager generalManager = new GeneralManager();

        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //小明提交请假申请
        groupLeader.handleLeave(leave);
    }
    
}
