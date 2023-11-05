package com.sunshine.infrastructure;

import java.util.Iterator;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/5
 */
public class Literator<T> implements Iterator<T> {

    private final Node<T> node;

    public Literator(Node<T> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node.next != null;
    }

    @Override
    public T next() {
        return node.next.item;
    }
}
