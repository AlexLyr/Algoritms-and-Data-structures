package ru.algoritms.datastructures;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node currentNode = this.head;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.value == _value) {
                unlink(previousNode, currentNode);
                return true;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        Node currentNode = this.head;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.value == _value) {
                unlink(previousNode, currentNode);
                if (previousNode != null) {
                    currentNode = previousNode.next;
                } else {
                    currentNode = this.head;
                }
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

        }
    }

    public void clear() {
        Node next;
        for (Node current = this.head; current != null; current = next) {
            next = current.next;
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
            this.head = _nodeToInsert;
        } else {
            Node nodeThatWasNext = _nodeAfter.next;
            if (nodeThatWasNext == null) {
                this.tail = _nodeToInsert;
            }
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.next = nodeThatWasNext;
        }
    }

    private void unlink(Node previousNode, Node currentNode) {
        if (currentNode.next == null) {
            this.tail = previousNode;
        }
        if (previousNode == null) {
            this.head = currentNode.next;
        }
        if (previousNode != null) {
            previousNode.next = currentNode.next;
        }
        currentNode.next = null;
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}

class ListSummarizer {

    public static LinkedList sumarizeElements(LinkedList sourceList, LinkedList listToSummarize) {
        LinkedList result = new LinkedList();
        if (sourceList.count() != listToSummarize.count()) {
            throw new IllegalArgumentException("Lists must have the same length");
        } else {
            Node next;
            Node nextToSummarize = listToSummarize.head;
            for (Node current = sourceList.head; current != null; current = next) {
                int value = current.value + nextToSummarize.value;
                next = current.next;
                nextToSummarize = nextToSummarize.next;
                result.addInTail(new Node(value));
            }
        }
        return result;
    }
}