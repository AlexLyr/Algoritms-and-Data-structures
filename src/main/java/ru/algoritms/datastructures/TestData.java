package ru.algoritms.datastructures;

public class TestData {

    private TestData() {

    }

    public static LinkedList getFullList() {
        LinkedList fullList = new LinkedList();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(3));
        fullList.addInTail(new Node(4));
        fullList.addInTail(new Node(5));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList getFullListWithLastDuplicate() {
        LinkedList fullList = new LinkedList();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(3));
        fullList.addInTail(new Node(4));
        fullList.addInTail(new Node(5));
        fullList.addInTail(new Node(6));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList getEmptyList() {
        return new LinkedList();
    }

    public static LinkedList getFullListWithDuplicates() {
        LinkedList fullList = new LinkedList();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList getOnlyDuplicates() {
        LinkedList fullList = new LinkedList();
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        return fullList;
    }

    public static LinkedList getSingleElementList() {
        LinkedList singleElementList = new LinkedList();
        singleElementList.addInTail(new Node(1));
        return singleElementList;
    }

    public static LinkedList getDoubleElementList() {
        LinkedList singleElementList = new LinkedList();
        singleElementList.addInTail(new Node(1));
        singleElementList.addInTail(new Node(2));
        return singleElementList;
    }
}
