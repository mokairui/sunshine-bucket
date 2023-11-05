package com.sunshine.infrastructure.decorate.support;

import com.sunshine.infrastructure.SchoolReport;
import com.sunshine.infrastructure.decorate.Decorator;

/**
 * @author Mokairui
 * @description 高分数的装饰器
 * @since 2023/11/5
 */
public class HighScoreDecorator extends Decorator {
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80"); 
        super.report();
    }
}
