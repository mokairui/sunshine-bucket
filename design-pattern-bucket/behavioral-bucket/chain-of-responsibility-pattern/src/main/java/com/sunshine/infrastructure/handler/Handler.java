package com.sunshine.infrastructure.handler;

import com.sunshine.infrastructure.LeaveRequest;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/19
 */
public abstract class Handler {

    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    //该领导处理的请求天数区间
    private int numStart;
    private int numEnd;
    
    private Handler nextHandler;

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public final void handleMessage(LeaveRequest leave) {
        this.handleLeave(leave);
        if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            this.nextHandler.handleMessage(leave);
        } else {
            System.out.println("流程结束!");
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract void handleLeave(LeaveRequest leave);
}
