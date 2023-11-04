package com.sunshine.infrastructure.client;

import com.sunshine.infrastructure.AddRequirementCommand;
import com.sunshine.infrastructure.Command;
import com.sunshine.infrastructure.support.Invoker;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/4
 */
public class Client {

    public static void main(String[] args) {
        // 定义我们的接头人
        Invoker invoker = new Invoker(); // 接头人就是我小三

        // 客户要求增加一项需求
        System.out.println("-------------客户要求增加一项需求-----------------");
        // 客户给我们下命令来
        Command command = new AddRequirementCommand();

        // 接头人接收到命令
        invoker.setCommand(command);

        // 接头人执行命令
        invoker.action();
    }

}
