package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 增加一条需求的命令, 命令实际内容
 * @since 2023/11/4
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        // 找到需求
        super.rg.find();
        // 增加一份需求
        super.rg.add();
        // 给出计划
        super.rg.plan();
    }
}
