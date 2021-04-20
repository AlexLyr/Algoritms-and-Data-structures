package ru.algoritms.datastructures.dynamicarray;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        if (new_capacity <= count) {
            return;
        } else if (new_capacity < 16) {
            capacity = 16;
        } else {
            capacity = new_capacity;
        }

        if (array == null) {
            array = (T[]) Array.newInstance(clazz, capacity);
        } else {
            array = Arrays.copyOf(array, capacity);
        }
    }

    public T getItem(int index) {
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        return array[index];
    }

    public void append(T itm) {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index > count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index must be more than 0 or less than %s", count));
        }
        int moveElementsCount = count - index - 1;
        if (moveElementsCount > 0) {
            System.arraycopy(array, index + 1, array, index, moveElementsCount);
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