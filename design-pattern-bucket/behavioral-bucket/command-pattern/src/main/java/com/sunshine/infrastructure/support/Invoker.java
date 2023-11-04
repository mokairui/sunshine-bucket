package com.sunshine.infrastructure.support;

import com.sunshine.infrastructure.Command;

/**
 * @author Mokairui
 * @description 中继者, 用于接收命令并执行
 * @since 2023/11/4
 */
public class Invoker {
    
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void action() {
        this.command.execute();
    }
}
