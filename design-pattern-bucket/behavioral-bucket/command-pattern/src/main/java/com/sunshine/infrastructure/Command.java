package com.sunshine.infrastructure;

import com.sunshine.infrastructure.executer.CodeGroup;
import com.sunshine.infrastructure.executer.PageGroup;
import com.sunshine.infrastructure.executer.RequirementGroup;

/**
 * @author Mokairui
 * @description 命名父类或接口, 其中需要聚合命令的执行者, 对外提供一个的执行方法
 * @since 2023/11/4
 */
public abstract class Command {
    
    protected RequirementGroup rg = new RequirementGroup(); // 需求组
    protected PageGroup pg = new PageGroup(); // 美工组
    protected CodeGroup cg = new CodeGroup(); // 代码组
    
    // 执行命令的方法
    public abstract void execute();
    
}
