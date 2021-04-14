package ru.algoritms.datastructures.bidirectionlinkedlist;



import java.util.ArrayList;

public class TestBidirectionalLinkedList {


    public static void main(String[] args) {
        TestBidirectionalLinkedList testClass = new TestBidirectionalLinkedList();
        testClass.runTests();
    }

    public void runTests() {
        shouldFindElementInList();
        shouldFindAllElementsInList();
        shouldRemoveValueFromFullLinkedList2();
        shouldRemoveFirstValueFromFullLinkedList2();
        shouldRemoveLastValueFromFullLinkedList2();
        shouldNotRemoveValueFromFullLinkedList2();
        shouldNotRemoveValueFromEmptyLinkedList2();
        listShouldBeEmptyAfterRemoveLastElementInCollection();
        listShouldHaveOneElementAfterRemoveElementInCollection();
        listShouldHaveOneElementAfterRemoveAllDuplicates();
        listShouldBeEmptyAfterRemoveAllDuplicates();
        listShouldHaveOneElementAfterRemoveElementInCollection();
        listShouldBeEmptyAfterRemoveFromEmptyList();
        listShouldRemoveAllLastElementsFromList();
        elementShouldBeInserted();
        elementShouldBeInsertedInEmptyList();
        elementShouldBeInsertedInStart();
        sizeOfListShouldBeSeven();
        sizeOfListShouldBeZero();
        sizeOfListShouldBeOne();
        listShouldBeEmptyAfterClearAll();
    }

    public void shouldFindElementInList() {
        LinkedList2 fullList = TestData.getFullList();
        if (fullList.find(2).value != 2 || fullList.find(14) != null) {
            System.err.println("shouldFindElementInList was not passed");
        } else {
            System.out.println("shouldFindElementInList was passed");
        }
    }

    public void shouldFindAllElementsInList() {
        LinkedList2 duplicates = TestData.getFullListWithDuplicates();
        LinkedList2 singleList = TestData.getSingleElementList();
        LinkedList2 emptyList = TestData.getEmptyList();
        ArrayList<Node> twos = duplicates.findAll(2);
        ArrayList<Node> ones = duplicates.findAll(1);
        ArrayList<Node> onesFromSingleList = singleList.findAll(1);
        ArrayList<Node> sixes = duplicates.findAll(6);
        ArrayList<Node> empty = emptyList.findAll(2);

        if (twos.size() != 3 || twos.get(0).value != 2 || twos.get(1).value != 2 || twos.get(2).value != 2) {
            System.err.println("shouldFindAllElements was not passed on twos");
        } else if (ones.size() != 3 || ones.get(0).value != 1 || ones.get(1).value != 1 || ones.get(2).value != 1) {
            System.err.println("shouldFindAllElements was not passed on ones");
        } else if (sixes.get(0).value != 6) {
            System.err.println("shouldFindAllElements was not passed on sixes");
        } else if (!empty.isEmpty()) {
            System.err.println("shouldFindAllElements was not passed on empty");
        } else if (onesFromSingleList.get(0).value != 1) {
            System.err.println("shouldFindAllElements was not passed on single");
        } else {
            System.out.println("shouldFindAllElements was passed");
        }
    }

    public void shouldRemoveValueFromFullLinkedList2() {
        LinkedList2 fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(2);
        if (fullList.find(2) != null || !wasRemoved) {
            System.err.println("shouldRemoveValueFromFullLinkedList2 was not passed");
        } else {
            System.out.println("shouldRemoveValueFromFullLinkedList2 was passed");
        }
    }

    public void shouldRemoveFirstValueFromFullLinkedList2() {
        LinkedList2 fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(1);
        if (fullList.find(1) != null || !wasRemoved || fullList.head.value != 2 || fullList.tail.value != 6) {
            System.err.println("shouldRemoveFirstValueFromFullLinkedList2 was not passed");
        } else {
            System.out.println("shouldRemoveFirstValueFromFullLinkedList2 was passed");
        }
    }

    public void shouldNotRemoveValueFromFullLinkedList2() {
        LinkedList2 fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(7);
        if (fullList.find(7) != null || wasRemoved || fullList.head.value != 1 || fullList.tail.value != 6) {
            System.err.println("shouldNotRemoveValueFromFullLinkedList2 was not passed");
        }
        System.out.println("shouldNotRemoveValueFromFullLinkedList2 was passed");
    }

    public void shouldRemoveLastValueFromFullLinkedList2() {
        LinkedList2 fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(6);
        if (fullList.find(6) != null || !wasRemoved || fullList.head.value != 1 || fullList.tail.value != 5) {
            System.err.println("shouldRemoveLastValueFromFullLinkedList2 was not passed");
        } else {
            System.out.println("shouldRemoveLastValueFromFullLinkedList2 was passed");
        }
    }

    public void shouldNotRemoveValueFromEmptyLinkedList2() {
        LinkedList2 emptyList = TestData.getEmptyList();
        boolean wasRemoved = emptyList.remove(6);
        if (emptyList.find(6) != null || wasRemoved) {
            System.err.println("shouldNotRemoveValueFromEmptyLinkedList2 was not passed");
        } else {
            System.out.println("shouldNotRemoveValueFromEmptyLinkedList2 was passed");

        }
    }

    public void listShouldBeEmptyAfterRemoveLastElementInCollection() {
        LinkedList2 singleElementList = TestData.getSingleElementList();
        boolean wasRemoved = singleElementList.remove(1);
        if (singleElementList.find(1) != null || !wasRemoved || singleElementList.head != null || singleElementList.tail != null) {
            System.err.println("listShouldBeEmptyAfterRemoveLastElementInCollection was not passed");
        } else {
            System.out.println("listShouldBeEmptyAfterRemoveLastElementInCollection was passed");

        }
    }

    public void listShouldHaveOneElementAfterRemoveElementInCollection() {
        LinkedList2 singleElementList = TestData.getDoubleElementList();
        boolean wasRemoved = singleElementList.remove(1);
        if (singleElementList.find(1) != null || !wasRemoved || singleElementList.head.value != 2 || singleElementList.tail.value != 2) {
            System.err.println("listShouldHaveOneElementAfterRemoveElementInCollection was not passed");
        } else {
            System.out.println("listShouldHaveOneElementAfterRemoveElementInCollection was passed");

        }
    }

    public void listShouldHaveOneElementAfterRemoveAllDuplicates() {
        LinkedList2 duplicates = TestData.getFullListWithDuplicates();
        duplicates.removeAll(2);
        duplicates.removeAll(1);
        if (duplicates.find(1) != null
                || duplicates.find(2) != null
                || duplicates.find(6) == null
                || duplicates.head.value != 6
                || duplicates.tail.value != 6) {
            System.err.println("listShouldHaveOneElementAfterRemoveAllDuplicates was not passed");
        } else {
            System.out.println("listShouldHaveOneElementAfterRemoveAllDuplicates was passed");
        }
    }

    public void listShouldBeEmptyAfterRemoveAllDuplicates() {
        LinkedList2 duplicates = TestData.getOnlyDuplicates();
        duplicates.removeAll(2);
        if (duplicates.find(1) != null
                || duplicates.find(2) != null
                || duplicates.find(6) != null
                || duplicates.head != null
                || duplicates.tail != null) {
            System.err.println("listShouldBeEmptyAfterRemoveAllDuplicates was not passed");
        } else {
            System.out.println("listShouldBeEmptyAfterRemoveAllDuplicates was passed");
        }
    }

    public void listShouldBeEmptyAfterRemoveFromEmptyList() {
        LinkedList2 duplicates = TestData.getEmptyList();
        duplicates.removeAll(2);
        if (duplicates.find(1) != null
                || duplicates.find(2) != null
                || duplicates.find(6) != null
                || duplicates.head != null
                || duplicates.tail != null) {
            System.err.println("listShouldBeEmptyAfterRemoveFromEmptyList was not passed");
        } else {
            System.out.println("listShouldBeEmptyAfterRemoveFromEmptyList was passed");
        }
    }

    public void listShouldRemoveAllLastElementsFromList() {
        LinkedList2 duplicates = TestData.getFullListWithLastDuplicate();
        duplicates.removeAll(6);
        if (duplicates.find(1) == null
                || duplicates.find(2) == null
                || duplicates.find(6) != null
                || duplicates.head.value != 1
                || duplicates.tail.value != 5) {
            System.err.println("listShouldRemoveAllLastElementsFromList was not passed");
        } else {
            System.out.println("listShouldRemoveAllLastElementsFromList was passed");
        }
    }

    public void elementShouldBeInserted() {
        LinkedList2 list = TestData.getFullList();
        Node nodeToInsert = new Node(7);
        Node nodeAfter = list.find(5);
        list.insertAfter(nodeAfter, nodeToInsert);
        if (list.find(7) == null || list.find(5).next.value != 7) {
            System.err.println("elementShouldBeInserted was not passed");
        } else
            System.out.println("elementShouldBeInserted was passed");
    }

    public void elementShouldBeInsertedInEmptyList() {
        LinkedList2 list = TestData.getEmptyList();
        Node nodeToInsert = new Node(7);
        list.insertAfter(null, nodeToInsert);
        if (list.find(7) == null || list.tail.value != 7 || list.head.value != 7) {
            System.err.println("elementShouldBeInsertedInEmptyList was not passed");
        } else
            System.out.println("elementShouldBeInsertedInEmptyList was passed");
    }

    public void elementShouldBeInsertedInStart() {
        LinkedList2 list = TestData.getFullList();
        Node nodeToInsert = new Node(7);
        list.addInHead(nodeToInsert);
        if (list.find(7) == null || list.head.value != 7) {
            System.err.println("elementShouldBeInsertedInStart was not passed");
        } else
            System.out.println("elementShouldBeInsertedInStart was passed");
    }

    public void sizeOfListShouldBeSeven() {
        LinkedList2 duplicates = TestData.getFullListWithLastDuplicate();
        if (duplicates.count() != 7) {
            System.err.println("sizeOfListShouldBeSeven was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeSeven was passed size is: " + duplicates.count());
        }
    }

    public void sizeOfListShouldBeZero() {
        LinkedList2 duplicates = TestData.getEmptyList();
        if (duplicates.count() != 0) {
            System.err.println("sizeOfListShouldBeZero was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeZero was passed size is: " + duplicates.count());
        }
    }

    public void sizeOfListShouldBeOne() {
        LinkedList2 duplicates = TestData.getSingleElementList();
        if (duplicates.count() != 1) {
            System.err.println("sizeOfListShouldBeOne was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeOne was passed size is: " + duplicates.count());
        }
    }

    public void listShouldBeEmptyAfterClearAll() {
        LinkedList2 duplicates = TestData.getFullListWithLastDuplicate();
        duplicates.clear();
        if (duplicates.find(1) != null
                || duplicates.find(2) != null
                || duplicates.find(3) != null
                || duplicates.find(4) != null
                || duplicates.find(5) != null
                || duplicates.find(6) != null
                || duplicates.head != null
                || duplicates.tail != null) {
            System.err.println("listShouldBeEmptyAfterClearAll was not passed");
        } else {
            System.out.println("listShouldBeEmptyAfterClearAll was passed");
        }
    }

}