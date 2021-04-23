package ru.algoritms.datastructures.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestQueue {

    private Queue<Integer> queue;

    @Before
    public void setup() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(10, queue.size());

        queue = new Queue<>();
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(11);
        Assert.assertEquals(11, queue.size());
    }

    @Test
    public void testDequeue() {
        Assert.assertEquals(10, queue.size());
        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(9, queue.size());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(8, queue.size());
        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
        Assert.assertEquals(7, queue.size());
        Assert.assertEquals(Integer.valueOf(4), queue.dequeue());
        Assert.assertEquals(6, queue.size());
        Assert.assertEquals(Integer.valueOf(5), queue.dequeue());
        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(Integer.valueOf(6), queue.dequeue());
        Assert.assertEquals(4, queue.size());
        Assert.assertEquals(Integer.valueOf(7), queue.dequeue());
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(Integer.valueOf(8), queue.dequeue());
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals(Integer.valueOf(9), queue.dequeue());
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertEquals(0, queue.size());

        Assert.assertNull(queue.dequeue());
        queue = new Queue<>();
        Assert.assertNull(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
    }
}
