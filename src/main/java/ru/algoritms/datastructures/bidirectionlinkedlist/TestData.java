package ru.algoritms.datastructures.bidirectionlinkedlist;


public class TestData {

    private TestData() {

    }

    public static LinkedList2 getFullList() {
        LinkedList2 fullList = new LinkedList2();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(3));
        fullList.addInTail(new Node(4));
        fullList.addInTail(new Node(5));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList2 getFullListWithLastDuplicate() {
        LinkedList2 fullList = new LinkedList2();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(3));
        fullList.addInTail(new Node(4));
        fullList.addInTail(new Node(5));
        fullList.addInTail(new Node(6));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList2 getEmptyList() {
        return new LinkedList2();
    }

    public static LinkedList2 getFullListWithDuplicates() {
        LinkedList2 fullList = new LinkedList2();
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(1));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(6));
        return fullList;
    }

    public static LinkedList2 getOnlyDuplicates() {
        LinkedList2 fullList = new LinkedList2();
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        fullList.addInTail(new Node(2));
        return fullList;
    }

    public static LinkedList2 getSingleElementList() {
        LinkedList2 singleElementList = new LinkedList2();
        singleElementList.addInTail(new Node(1));
        return singleElementList;
    }

    public static LinkedList2 getDoubleElementList() {
        LinkedList2 singleElementList = new LinkedList2();
        singleElementList.addInTail(new Node(1));
        singleElementList.addInTail(new Node(2));
        return singleElementList;
    }
}
