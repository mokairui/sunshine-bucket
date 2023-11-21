package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 被访问者的抽象类, 里面提供一个抽象方法让具体的实现类中提供访问来访问
 * @since 2023/11/21
 */
public abstract class Employee {

    public final static int MALE = 0; //0代表是男性
    public final static int FEMALE = 1; //1代表是女性
    //甭管是谁，都有工资
    private String name;

    //只要是员工那就有薪水
    private int salary;

    //性别很重要
    private int sex;
    //以下是简单的getter/setter，不多说
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }

    //我允许一个访问者过来访问
    public abstract void accept(IVisitor visitor);

}
