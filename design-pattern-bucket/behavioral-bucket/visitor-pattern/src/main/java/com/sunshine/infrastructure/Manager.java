package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 同普通员工, 实现具体的供访问者访问的方法让访问者来进行访问
 * @since 2023/11/21
 */
public class Manager extends Employee {

    //这类人物的职责非常明确：业绩
    private String performance;
    public String getPerformance() {
        return performance;
    }
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    //部门经理允许访问者访问
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }

}
