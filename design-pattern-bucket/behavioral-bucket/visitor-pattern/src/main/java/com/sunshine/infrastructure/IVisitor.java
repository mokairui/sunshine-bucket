package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 访问者提供两个方法, 方法就是访问需要访问的对象, 而被访问者需要提供一个接口让访问者来进行访问
 * @since 2023/11/21
 */
public interface IVisitor {

    //首先定义我可以访问普通员工
    public void visit(CommonEmployee commonEmployee);

    //其次定义，我还可以访问部门经理
    public void visit(Manager manager);

}
