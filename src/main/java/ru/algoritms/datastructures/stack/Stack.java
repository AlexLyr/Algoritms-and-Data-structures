package ru.algoritms.datastructures.stack;

import java.util.*;

public class Stack<T> {
    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
        if (!list.isEmpty()) {
            return list.removeFirst();
        }
        return null;
    }

    public void push(T val) {
        list.addFirst(val);
    }

    public T peek() {
        if (!list.isEmpty()) {
            return list.getFirst();
        }
        return null;
    }
}