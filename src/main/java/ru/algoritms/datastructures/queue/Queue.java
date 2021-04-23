package ru.algoritms.datastructures.queue;

import java.util.*;

public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (!list.isEmpty()) {
            return list.removeFirst();
        } else {
            return null; // null если очередь пустая
        }
    }

    public int size() {
        return list.size();
    }

}