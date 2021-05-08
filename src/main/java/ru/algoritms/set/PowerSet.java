package ru.algoritms.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PowerSet {
    private final LinkedList<String>[] arrayOfLists;
    private int elements;

    public PowerSet() {
        arrayOfLists = new LinkedList[20000];
        elements = 0;
    }

    public int size() {
        return elements;
    }

    public void put(String value) {
        if (value == null) return;
        if (bucketInsert(value)) {
            elements++;
        }
    }

    public boolean get(String value) {
        if (value == null) return false;
        return find(value) != null;
    }

    public boolean remove(String value) {
        if (value == null) return false;
        boolean removed = bucketRemove(value);
        if (removed) {
            elements--;
        }
        return removed;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        if (set2 == null || set2.size() == 0) return result;
        for (LinkedList<String> list : arrayOfLists) {
            if (list == null) continue;
            for (String val : list) {
                if (set2.get(val)) {
                    result.put(val);
                }
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        powerSet.putAll(this);
        powerSet.putAll(set2);
        return powerSet;
    }

    public PowerSet difference(PowerSet set2) {
        if (set2 == null || set2.size() == 0) return this;
        PowerSet result = new PowerSet();
        for (LinkedList<String> list : arrayOfLists) {
            if (list == null) continue;
            for (String val : list) {
                if (!set2.get(val)) {
                    result.put(val);
                }
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        if (set2 == null || set2.size() == 0) return true;
        return set2.toList().stream().allMatch(this::get);
    }

    public boolean putAll(PowerSet powerSet) {
        if (powerSet == null || powerSet.size() == 0) return false;
        powerSet.toList().forEach(this::put);
        return true;
    }

    public List<String> toList() {
        if (elements == 0) return null;
        List<String> list = new ArrayList<>();
        for (LinkedList<String> bucket : arrayOfLists) {
            if (bucket == null) continue;
            bucket.forEach(list::add);
        }
        return list;
    }

    private int hashFun(String value) {
        return Math.abs(value.hashCode() % arrayOfLists.length);
    }

    private boolean bucketInsert(String value) {
        int index = hashFun(value);
        if (arrayOfLists[index] == null) {
            arrayOfLists[index] = new LinkedList<>();
        } else if (arrayOfLists[index].contains(value)) {
            return false;
        }
        return arrayOfLists[index].add(value);
    }

    private boolean bucketRemove(String value) {
        int index = hashFun(value);
        LinkedList<String> bucket = arrayOfLists[index];
        if (bucket == null) return false;
        return bucket.remove(value);
    }

    private String find(String value) {
        int index = hashFun(value);
        LinkedList<String> bucket = arrayOfLists[index];
        if (bucket == null) return null;
        return bucket.stream()
                .filter(it -> it.equals(value))
                .findFirst()
                .orElse(null);
    }
}