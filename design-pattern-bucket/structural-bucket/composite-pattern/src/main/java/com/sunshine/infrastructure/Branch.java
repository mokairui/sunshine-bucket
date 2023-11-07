package com.sunshine.infrastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mokairui
 * @description 节点类, 不是叶子节点, 这个是下面还有分支, 所以需要定义一个 List 来存放里面其他的节点或则叶子节点
 * @since 2023/11/7
 */
public class Branch extends Corp {
    private List<Corp> subordinateList = new ArrayList<>();
    
    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    //增加一个下属，可能是小头目，也可能是个小兵
    public void addSubordinate(Corp corp) {
        corp.setParent(this); // 设置父节点
        this.subordinateList.add(corp);
    }

    //我有哪些下属
    public List<Corp> getSubordinate() {
        return this.subordinateList;
    }
}
