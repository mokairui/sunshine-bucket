package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 成绩单, 最上层父类, 被装饰目标和装饰器都应该是他的子类
 * @since 2023/11/5
 */
public abstract class SchoolReport {
    
    // 展示成绩
    public abstract void report();
    
    // 成绩单需要签字
    public abstract void sign(String name);
    
}
