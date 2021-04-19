package ru.algoritms.datastructures.dynamicarray;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (new_capacity < 16) {
            new_capacity = 16;
        }
        T[] temp = (T[]) new Object[new_capacity];
        for (int i = 0; i < count; i++) {
            temp[i] = array[i];
        }
        capacity = new_capacity;
        array = temp;
    }

    public T getItem(int index) {
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        return array[index];
    }

    public void append(T itm) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index > count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        if (count + 1 >= capacity) {
            makeArray(capacity * 2);
        }
        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        for (int i = index; i <= count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        array[count] = null;
        int nextCapacitylessStep = (int) (capacity / 1.5);
        if (nextCapacitylessStep < 16) {
            nextCapacitylessStep = 16;
        }
        if (count < capacity * 0.5) {
            makeArray(nextCapacitylessStep);
        }
    }

}