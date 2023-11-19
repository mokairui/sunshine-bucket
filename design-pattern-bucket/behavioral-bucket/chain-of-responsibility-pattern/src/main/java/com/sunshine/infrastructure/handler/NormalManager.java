package com.sunshine.infrastructure.handler;

import com.sunshine.infrastructure.LeaveRequest;

/**
 * @version v1.0
 * @ClassName: GroupLeader
 * @Description: 部门经理类（具体的处理者）
 * @Author: 黑马程序员
 */
public class NormalManager extends Handler {

    public NormalManager() {
        super(Handler.NUM_ONE,Handler.NUM_THREE);
    }

    @Override
    public void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent() + "。");
        System.out.println("部门经理审批：同意");
    }
}
