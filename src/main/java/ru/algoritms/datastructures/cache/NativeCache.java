package ru.algoritms.datastructures.cache;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    public int step;
    private static final int DEFAULT_SIZE = 10;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
        if (size <= DEFAULT_SIZE) {
            step = 1;
        } else {
            step = size / 10;
        }
    }

    private int hashFun(String key) {
        if (key.isEmpty()) return 0;
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = hash * 31 + c;
        }
        return Math.abs(hash % slots.length);
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        int distance = 0;
        for (int laps = 0; laps < step; laps = distance / size) {
            if (slots[index] == null || slots[index].equals(key)) {
                slots[index] = key;
                values[index] = value;
                hits[index]++;
                return;
            }
            index = (index + step) % size;
            distance += step;
        }
        int leastHitIndex = 0;
        for (int i = 1; i < size; i++) {
            leastHitIndex = hits[i] < hits[leastHitIndex] ? i : leastHitIndex;
        }
        leastHitIndex = hits[leastHitIndex] == hits[index] ? index : leastHitIndex;
        slots[leastHitIndex] = null;
        values[leastHitIndex] = null;
        hits[leastHitIndex] = 0;
        put(key, value);
    }

    public boolean isKey(String key) {
        return find(key) != -1;
    }

    public T get(String key) {
        int index = find(key);
        if (index != -1) {
            hits[index]++;
            return values[index];
        }
        return null;
    }

    private int find(String key) {
        int index = hashFun(key);
        int distance = 0;
        for (int laps = 0; laps < step; laps = distance / size) {
            if (slots[index] == null) break;
            else if (slots[index].equals(key)) return index;
            index = (index + step) % size;
            distance += step;
        }
        return -1;
    }
}