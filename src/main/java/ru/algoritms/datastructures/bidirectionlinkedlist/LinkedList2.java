package ru.algoritms.datastructures.bidirectionlinkedlist;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public void addInHead(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            _item.next = head;
            _item.next.prev = _item;
            this.head = _item;
        }
    }

    public Node find(int _value) {
        Node currentNode = this.head;
        Node reverseCurrentNode = this.tail;
        while (currentNode != null) {
            if (currentNode.value == _value) {
                return currentNode;
            } else if (reverseCurrentNode.value == _value) {
                return reverseCurrentNode;
            } else {
                currentNode = currentNode.next;
                reverseCurrentNode = reverseCurrentNode.prev;
            }
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == _value) {
                nodes.add(currentNode);
            }
            currentNode = currentNode.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node nodeToRemove = this.find(_value);
        if (nodeToRemove != null) {
            this.unlink(nodeToRemove);
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        ArrayList<Node> nodesToRemove = this.findAll(_value);
        nodesToRemove.forEach(this::unlink);
    }

    public void clear() {
        Node next;
        for (Node current = this.head; current != null; current = next) {
            next = current.next;
            current.prev = null;
            current.next = null;
        }
        this.tail = null;
        this.head = null;
    }

    public int count() {
        Node next;
        int count = 0;
        for (Node current = this.head; current != null; current = next) {
            next = current.next;
            count++;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.head == null) {
            addInTail(_nodeToInsert);
        } else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            _nodeToInsert.next.prev = _nodeToInsert;
            this.head = _nodeToInsert;
        } else {
            Node nodeThatWasNext = _nodeAfter.next;
            if (nodeThatWasNext == null) {
                this.tail = _nodeToInsert;
                _nodeAfter.next = _nodeToInsert;
                _nodeToInsert.prev = _nodeAfter;
            } else {
                _nodeAfter.next = _nodeToInsert;
                _nodeToInsert.next = nodeThatWasNext;
                _nodeToInsert.prev = _nodeAfter;
                nodeThatWasNext.prev = _nodeToInsert;
            }
        }
    }

    private void unlink(Node currentNode) {
        Node prev = currentNode.prev;
        Node next = currentNode.next;
        if (prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
            currentNode.prev = null;
            currentNode.next = null;
            currentNode = null;
        } else if (prev == null && next == null) {
            this.head = null;
            this.tail = null;
            currentNode = null;
        } else if (prev == null) {
            next.prev = null;
            this.head = next;
            currentNode = null;
        } else {
            currentNode.prev = null;
            this.tail = prev;
            prev.next = null;
            currentNode = null;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}