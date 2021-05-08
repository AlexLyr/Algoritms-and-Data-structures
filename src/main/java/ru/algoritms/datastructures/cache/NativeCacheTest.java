package ru.algoritms.datastructures.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NativeCacheTest {

    private NativeCache<String> cache;

    @Before
    public void setup() {
        cache = new NativeCache<>(17, String.class);
    }

    @Test
    public void testPut() {
        cache.put("test", "test");
        Assert.assertEquals("test", cache.slots[13]);
        Assert.assertEquals("test", cache.values[13]);
        Assert.assertEquals(1, cache.hits[13]);

        cache.put("test", "new test");
        Assert.assertEquals("test", cache.slots[13]);
        Assert.assertEquals("new test", cache.values[13]);
        Assert.assertEquals(2, cache.hits[13]);

        cache.put("mother", "motherlorde");
        Assert.assertEquals("mother", cache.slots[9]);
        Assert.assertEquals("motherlorde", cache.values[9]);
        Assert.assertEquals(1, cache.hits[9]);

        cache.put("mother", "new motherlorde");
        Assert.assertEquals("mother", cache.slots[9]);
        Assert.assertEquals("new motherlorde", cache.values[9]);
        Assert.assertEquals(2, cache.hits[9]);

    }
}