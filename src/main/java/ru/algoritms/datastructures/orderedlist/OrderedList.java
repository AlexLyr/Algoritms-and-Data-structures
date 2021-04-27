package ru.algoritms.datastructures.orderedlist;

import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        int result;
        if (v1 instanceof Number) {
            result = Double.compare(((Number) v1).doubleValue(), ((Number) v2).doubleValue());
        } else if (v1 instanceof String) {
            result = ((String) v1).trim().compareTo(((String) v2).trim());
        } else {
            return Integer.MIN_VALUE;
        }
        return Integer.compare(result, 0);
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        Node<T> temp = head;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (_ascending) {
                while (temp.next != null && compare(node.value, temp.value) >= 0) {
                    temp = temp.next;
                }
                if (compare(node.value, temp.value) >= 0) {
                    insertAfter(temp, node);
                } else {
                    insertBefore(temp, node);
                }
            } else {
                while (temp.next != null && compare(node.value, temp.value) < 0) {
                    temp = temp.next;
                }
                if (compare(node.value, temp.value) >= 0) {
                    insertBefore(temp, node);
                } else {
                    insertAfter(temp, node);
                }
            }

        }
    }

    private void insertBefore(Node<T> node, Node<T> nodeToInsert) {
        Node<T> wasPrev = node.prev;
        node.prev = nodeToInsert;
        nodeToInsert.next = node;
        nodeToInsert.prev = wasPrev;
        if (wasPrev != null) {
            wasPrev.next = nodeToInsert;
        } else {
            head = nodeToInsert;
        }
    }

    private void insertAfter(Node<T> node, Node<T> nodeToInsert) {
        Node<T> wasNext = node.next;
        node.next = nodeToInsert;
        nodeToInsert.next = wasNext;
        nodeToInsert.prev = node;
        if (wasNext != null) {
            wasNext.prev = nodeToInsert;
        } else {
            tail = nodeToInsert;
        }
    }

    public Node<T> find(T val) {
        if (count() == 0) {
            return null; // здесь будет ваш код
        }
        return _ascending ? findAscending(val) : findDescending(val);
    }

    public void delete(T val) {
        Node<T> node = find(val);
        if (node != null) {
            removeNode(node);
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        for (Node<T> temp = head; temp != null; ) {
            Node<T> t = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = t;
        }
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private Node<T> findAscending(T val) {
        if (compare(tail.value, val) == -1) {
            return null;
        }
        for (Node<T> node = head; node != null; node = node.next) {
            if (compare(node.value, val) == 1) {
                return null;
            } else if (compare(node.value, val) == 0) {
                return node;
            }
        }
        return null;
    }

    private Node<T> findDescending(T val) {
        if (compare(tail.value, val) == 1) {
            return null;
        }
        for (Node<T> node = head; node != null; node = node.next) {
            if (compare(node.value, val) == -1) {
                return null;
            } else if (compare(node.value, val) == 0) {
                return node;
            }
        }
        return null;
    }

    private void removeNode(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
    }
}