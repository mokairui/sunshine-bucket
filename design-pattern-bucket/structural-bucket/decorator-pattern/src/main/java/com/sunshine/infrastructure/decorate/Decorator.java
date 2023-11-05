package com.sunshine.infrastructure.decorate;

import com.sunshine.infrastructure.SchoolReport;

/**
 * @author Mokairui
 * @description 装饰器 装饰器和代理都是增强现有方法功能, 但是装饰器可以累加, 这点代理是直接做不到的除非多次代理
 * @since 2023/11/5
 */
public class Decorator extends SchoolReport {
    
    // 需要被装饰的对象, 因为是装饰也就是增强原有的方法, 那也就是还是需要调用
    private SchoolReport sr;

    public Decorator(SchoolReport schoolReport) {
        this.sr = schoolReport;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
