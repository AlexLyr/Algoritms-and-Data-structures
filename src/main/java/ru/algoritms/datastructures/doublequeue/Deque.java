package ru.algoritms.datastructures.doublequeue;

import java.util.*;

public class Deque<T> {
    private LinkedList<T> list;

    public Deque() {
        list = new LinkedList<>();
    }

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addTail(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        if (list.size() != 0) {
            return list.removeFirst();
        }
        return null;
    }

    public T removeTail() {
        if (list.size() != 0) {
            return list.removeLast();
        }
        return null;
    }

    public int size() {
        return list.size();
    }
}