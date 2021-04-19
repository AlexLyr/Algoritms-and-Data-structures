package ru.algoritms.datastructures.dynamicarray;

public class TestDynArray {

    public static void main(String[] args) {
        TestDynArray tests = new TestDynArray();
        tests.runTests();
    }

    private void runTests() {
        shouldCreateNewArrayWithCapacity();
        shouldAppendElements();
        shouldGetElements();
        shouldInsertElements();
        shouldRemoveElements();
    }

    private void shouldCreateNewArrayWithCapacity() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        if (array.count != 0 || array.capacity != 16) {
            System.err.println("shouldCreateNewArrayWithCapacity was not passed");
        } else {
            System.out.println("shouldCreateNewArrayWithCapacity was passed");
        }
    }

    private void shouldAppendElements() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(4);
        array.append(67);
        array.append(124);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        if (array.count != 17 || array.capacity != 32) {
            System.err.println("shouldAppendElements was not passed");
        } else {
            System.out.println("shouldAppendElements was passed");
        }
    }

    private void shouldGetElements() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(4);
        array.append(67);
        array.append(124);
        array.append(11);
        Integer elem = array.getItem(2);
        if (array.count != 4
                || array.capacity != 16
                || elem != 124) {
            System.err.println("shouldGetElements was not passed");
        } else {
            System.out.println("shouldGetElements was passed");
        }
    }

    private void shouldInsertElements() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(4);
        array.append(67);
        array.append(124);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.append(11);
        array.insert(1001, 4);
        if (array.count != 17
                || array.capacity != 32
                || array.getItem(3) != 11 || array.getItem(4) != 1001) {
            System.err.println("shouldInsertElements was not passed");
        } else {
            System.out.println("shouldInsertElements was passed");
        }
    }

    private void shouldRemoveElements() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(4);
        array.insert(1001, 1);
        array.remove(0);
        array.remove(0);
        if (array.count != 17
                || array.capacity != 32
                || array.getItem(3) != 11 || array.getItem(4) != 1001) {
            System.err.println("shouldRemoveElements was not passed");
        } else {
            System.out.println("shouldRemoveElements was passed");
        }
    }


}
