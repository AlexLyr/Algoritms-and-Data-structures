package ru.algoritms.datastructures.hashtable;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        return value.hashCode() % slots.length;
    }

    public int seekSlot(String value) {
        int firstIndex = hashFun(value);
        int limiter = firstIndex;
        while (slots[firstIndex] != null) {
            firstIndex = firstIndex + step;
            if (firstIndex > slots.length - 1) {
                firstIndex = firstIndex - slots.length + 1;
            }
            if(firstIndex == limiter) {
                return -1;
            }
        }
        return firstIndex;
    }

    public int put(String value) {
        // записываем значение по хэш-функции
        int index = seekSlot(value);
        if(index != -1) {
            slots[index] = value;
        }
        return index;
    }

    public int find(String value) {
        int firstIndex = hashFun(value);
        int limiter = firstIndex;
        if (slots[firstIndex] != null) {
            return firstIndex;
        } else {
            while (true) {
                if (value.equals(slots[firstIndex])) {
                    return firstIndex;
                }
                firstIndex = firstIndex + step;
                if (firstIndex > slots.length - 1) {
                    firstIndex = firstIndex - slots.length + 1;
                }
                if (firstIndex == limiter) {
                    return -1;
                }
            }
        }
    }
}