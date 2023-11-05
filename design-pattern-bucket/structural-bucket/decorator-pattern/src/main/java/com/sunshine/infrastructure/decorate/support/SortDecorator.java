package com.sunshine.infrastructure.decorate.support;

import com.sunshine.infrastructure.SchoolReport;
import com.sunshine.infrastructure.decorate.Decorator;

/**
 * @author Mokairui
 * @description 成绩排名的装饰器
 * @since 2023/11/5
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        System.out.println("我是排名第38名...");
        super.report();
    }
}
