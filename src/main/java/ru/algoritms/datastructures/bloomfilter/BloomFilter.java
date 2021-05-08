package ru.algoritms.datastructures.bloomfilter;

public class BloomFilter {
    public int filter_len;

    private int bitArray;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bitArray = 0;
    }

    public int hash1(String str1) {
        int hashCode1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hashCode1 = (hashCode1 * 17 + code) % filter_len;
        }
        return hashCode1;
    }

    public int hash2(String str1) {
        int hashCode1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hashCode1 = (hashCode1 * 223 + code) % filter_len;
        }
        return hashCode1;
    }

    public void add(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);
        int firstMask = 1 << hash1;
        int secondMask = 1 << hash2;
        bitArray = bitArray | firstMask;
        bitArray = bitArray | secondMask;
    }

    public boolean isValue(String str1) {
        int firstCheck = bitArray & (1 << hash1(str1));
        int secondCheck = bitArray & (1 << hash2(str1));
        if(firstCheck != 0 && secondCheck != 0) {
            return true;
        } else return false;
    }
}