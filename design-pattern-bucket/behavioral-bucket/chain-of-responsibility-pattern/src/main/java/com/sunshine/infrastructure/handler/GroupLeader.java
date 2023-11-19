package com.sunshine.infrastructure.handler;

import com.sunshine.infrastructure.LeaveRequest;

/**
 * @author Mokairui
 * @description 小组长处理请假条
 * @since 2023/11/19
 */
public class GroupLeader extends Handler {
    public GroupLeader() {
        super(0, Handler.NUM_THREE);
    }

    @Override
    public void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent() + "。");
        System.out.println("小组长审批：同意");
    }
}
