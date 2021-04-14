package ru.algoritms.datastructures;

import java.util.ArrayList;

public class TestLinkedList {


    public static void main(String[] args) {
        TestLinkedList testClass = new TestLinkedList();
        testClass.runTests();
    }

    public void runTests() {
        shouldRemoveValueFromFullLinkedList();
        shouldRemoveFirstValueFromFullLinkedList();
        shouldRemoveLastValueFromFullLinkedList();
        shouldNotRemoveValueFromFullLinkedList();
        shouldNotRemoveValueFromEmptyLinkedList();
        listShouldBeEmptyAfterRemoveLastElementInCollection();
        listShouldHaveOneElementAfterRemoveAllDuplicates();
        listShouldBeEmptyAfterRemoveAllDuplicates();
        listShouldHaveOneElementAfterRemoveElementInCollection();
        listShouldBeEmptyAfterRemoveFromEmptyList();
        listShouldRemoveAllLastElementsFromList();
        listShouldBeEmptyAfterClearAll();
        shouldFindAllElements();
        sizeOfListShouldBeSeven();
        sizeOfListShouldBeZero();
        sizeOfListShouldBeOne();
        elementShouldBeInserted();
        elementShouldBeInsertedInEmptyList();
        elementShouldBeInsertedInStart();
        shoudSummarizeListElements();
    }

    public void shouldRemoveValueFromFullLinkedList() {
        LinkedList fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(2);
        if (fullList.find(2) != null || !wasRemoved) {
            System.err.println("shouldRemoveValueFromFullLinkedList was not passed");
        } else {
            System.out.println("shouldRemoveValueFromFullLinkedList was passed");
        }
    }

    public void shouldRemoveFirstValueFromFullLinkedList() {
        LinkedList fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(1);
        if (fullList.find(1) != null || !wasRemoved || fullList.head.value != 2 || fullList.tail.value != 6) {
            System.err.println("shouldRemoveFirstValueFromFullLinkedList was not passed");
        } else {
            System.out.println("shouldRemoveFirstValueFromFullLinkedList was passed");
        }
    }

    public void shouldNotRemoveValueFromFullLinkedList() {
        LinkedList fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(7);
        if (fullList.find(7) != null || wasRemoved || fullList.head.value != 1 || fullList.tail.value != 6) {
            System.err.println("shouldNotRemoveValueFromFullLinkedList was not passed");
        }
        System.out.println("shouldNotRemoveValueFromFullLinkedList was passed");
    }

    public void shouldRemoveLastValueFromFullLinkedList() {
        LinkedList fullList = TestData.getFullList();
        boolean wasRemoved = fullList.remove(6);
        if (fullList.find(6) != null || !wasRemoved || fullList.head.value != 1 || fullList.tail.value != 5) {
            System.err.println("shouldRemoveLastValueFromFullLinkedList was not passed");
        } else {
            System.out.println("shouldRemoveLastValueFromFullLinkedList was passed");
        }
    }

    public void shouldNotRemoveValueFromEmptyLinkedList() {
        LinkedList emptyList = TestData.getEmptyList();
        boolean wasRemoved = emptyList.remove(6);
        if (emptyList.find(6) != null || wasRemoved) {
            System.err.println("shouldNotRemoveValueFromEmptyLinkedList was not passed");
        } else {
            System.out.println("shouldNotRemoveValueFromEmptyLinkedList was passed");

        }
    }

    public void listShouldBeEmptyAfterRemoveLastElementInCollection() {
        LinkedList singleElementList = TestData.getSingleElementList();
        boolean wasRemoved = singleElementList.remove(1);
        if (singleElementList.find(1) != null || !wasRemoved || singleElementList.head != null || singleElementList.tail != null) {
            System.err.println("listShouldBeEmptyAfterRemoveLastElementInCollection was not passed");
        } else {
            System.out.println("listShouldBeEmptyAfterRemoveLastElementInCollection was passed");

        }
    }

    public void listShouldHaveOneElementAfterRemoveElementInCollection() {
        LinkedList singleElementList = TestData.getDoubleElementList();
        boolean wasRemoved = singleElementList.remove(1);
        if (singleElementList.find(1) != null || !wasRemoved || singleElementList.head.value != 2 || singleElementList.tail.value != 2) {
            System.err.println("listShouldHaveOneElementAfterRemoveElementInCollection was not passed");
        } else {
            System.out.println("listShouldHaveOneElementAfterRemoveElementInCollection was passed");

        }
    }

    public void listShouldHaveOneElementAfterRemoveAllDuplicates() {
        LinkedList duplicates = TestData.getFullListWithDuplicates();
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
        LinkedList duplicates = TestData.getOnlyDuplicates();
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
        LinkedList duplicates = TestData.getEmptyList();
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
        LinkedList duplicates = TestData.getFullListWithLastDuplicate();
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

    public void listShouldBeEmptyAfterClearAll() {
        LinkedList duplicates = TestData.getFullListWithLastDuplicate();
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

    public void shouldFindAllElements() {
        LinkedList duplicates = TestData.getFullListWithDuplicates();
        LinkedList singleList = TestData.getSingleElementList();
        LinkedList emptyList = TestData.getEmptyList();
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

    public void sizeOfListShouldBeSeven() {
        LinkedList duplicates = TestData.getFullListWithLastDuplicate();
        if (duplicates.count() != 7) {
            System.err.println("sizeOfListShouldBeSeven was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeSeven was passed size is: " + duplicates.count());
        }
    }

    public void sizeOfListShouldBeZero() {
        LinkedList duplicates = TestData.getEmptyList();
        if (duplicates.count() != 0) {
            System.err.println("sizeOfListShouldBeZero was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeZero was passed size is: " + duplicates.count());
        }
    }

    public void sizeOfListShouldBeOne() {
        LinkedList duplicates = TestData.getSingleElementList();
        if (duplicates.count() != 1) {
            System.err.println("sizeOfListShouldBeOne was not passed size is: " + duplicates.count());
        } else {
            System.out.println("sizeOfListShouldBeOne was passed size is: " + duplicates.count());
        }
    }

    public void elementShouldBeInserted() {
        LinkedList list = TestData.getFullList();
        Node nodeToInsert = new Node(7);
        Node nodeAfter = list.find(5);
        list.insertAfter(nodeAfter, nodeToInsert);
        if (list.find(7) == null || list.find(5).next.value != 7) {
            System.err.println("elementShouldBeInserted was not passed");
        } else
            System.out.println("elementShouldBeInserted was passed");
    }

    public void elementShouldBeInsertedInEmptyList() {
        LinkedList list = TestData.getEmptyList();
        Node nodeToInsert = new Node(7);
        list.insertAfter(null, nodeToInsert);
        if (list.find(7) == null || list.tail.value != 7 || list.head.value != 7) {
            System.err.println("elementShouldBeInsertedInEmptyList was not passed");
        } else
            System.out.println("elementShouldBeInsertedInEmptyList was passed");
    }

    public void elementShouldBeInsertedInStart() {
        LinkedList list = TestData.getFullList();
        Node nodeToInsert = new Node(7);
        list.insertAfter(null, nodeToInsert);
        if (list.find(7) == null || list.head.value != 7) {
            System.err.println("elementShouldBeInsertedInStart was not passed");
        } else
            System.out.println("elementShouldBeInsertedInStart was passed");
    }

    public void shoudSummarizeListElements() {
        LinkedList list = TestData.getFullList();
        LinkedList list2 = TestData.getFullList();
        LinkedList sumarizeLists = ListSummarizer.sumarizeElements(list, list2);
        if (sumarizeLists.head.value == 2 && sumarizeLists.tail.value == 12) {
            System.out.println("Summarize lists test passed");
        } else {
            System.err.println("Summarize lists test not passed");
        }
    }
}
