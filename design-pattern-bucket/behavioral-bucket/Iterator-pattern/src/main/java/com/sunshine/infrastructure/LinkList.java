package com.sunshine.infrastructure;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author Mokairui
 * @description 这里用自定义一个单项链表来掩饰迭代器的使用, 迭代器使用 java 是提供了 Iterable 和 Iterator 两个接口
 * @since 2023/11/5
 */
public class LinkList<T> implements Iterable<T> {

    private Node<T> head;
    private int count;

    public LinkList() {
        this.head = new Node<>(null, null);
        this.count = 0;
    }

    // 清空链表
    public void clear() {
        head.next = null;
        this.count = 0;
    }

    // 获取链表的长度
    public int length() {
        return count;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public T get(int index) {
        Node<T> node = this.head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    // 向链表中添加元素t
    public void insert(T t) {
        // 找到最后一个节点
        Node<T> n = head;
        while (n.next != null) {
            n = n.next;
        }
        // 创建新的节点, 保存元素 t
        // 让当前最后一个节点指向新节点
        n.next = new Node<>(t, null);
        // 元素个数+1
        count++;
    }

    // 向指定位置i处, 添加元素
    public void insert(int i, T t) {
        // 找到i位置的前一个索引
        Node<T> n = head;
        for (int index = 0; index <= i - 1; index++) {
            n = n.next;
        }
        Node<T> preNode = n.next;
        // 创建新的节点, 保存元素 t
        // 让当前最后一个节点指向新节点
        n.next = new Node<>(t, preNode);
        // 元素个数+1
        count++;
    }

    // 删除指定位置i处的元素, 并返回被删除的元素
    public T remove(int i) {
        // 找到i位置的前一个节点
        Node<T> pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        // 要找到i位置的节点
        Node<T> curr = pre.next;
        // 找到i位置的下一个节点
        // 前一个节点指向下一个节点
        pre.next = curr.next;
        // 元素个数 -1
        count--;
        return curr.item;
    }

    // 查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        // 从头节点开始, 依次找到每一个节点, 取出item, 和t比较, 如果相同就找到了
        Node<T> n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    // 反转链表
    public void reverse() {
        // 判断当前链表是否是空链表, 如果是空链表, 则结束运行, 如果不是, 则调用重载的reverse方法完成重载
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    // 反转指定的节点node, 并把反转厚的节点返回
    private Node<T> reverse(Node<T> node) {
        if (node.next == null) {
            head.next = node;
            return node;
        }
        // 递归的反转当前节点node的下一个节点: 返回值就是链表反转后, 当前节点的上一个节点
        Node<T> pre = reverse(node.next);
        // 让返回的节点的下一个节点变为当前节点node
        pre.next = node;
        // 把当前节点的下一个节点变为null
        node.next = null;
        return node;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new Literator<>(head);
    }
}
