package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 普通员工, 其中实现提供访问者访问的方法 accept, 里面就是调用访问者的访问方法将自身也就是当前对象传递入方法中
 * @since 2023/11/21
 */
public class CommonEmployee extends Employee {

    //工作内容，这个非常重要，以后的职业规划就是靠这个了
    private String job;
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    //我允许访问者过来访问
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }

}
