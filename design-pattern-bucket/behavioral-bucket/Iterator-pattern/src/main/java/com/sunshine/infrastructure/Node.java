package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 节点
 * @since 2023/11/5
 */
public class Node<T> {
    
    protected T item;

    protected Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }
    
}
