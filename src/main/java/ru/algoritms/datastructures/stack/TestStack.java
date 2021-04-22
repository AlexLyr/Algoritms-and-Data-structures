package ru.algoritms.datastructures.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

public class TestStack {
    Stack<Integer> integerStack;


    @Before
    public void createStack() {
        integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        integerStack.push(6);
        integerStack.push(7);
    }

    @Test
    public void testPopStack() {
        Integer pop = integerStack.pop();
        Assert.assertEquals((Integer) 7, pop);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(7, integerStack.size());
        integerStack = new Stack<>();
        Assert.assertEquals(0, integerStack.size());
    }

    @Test
    public void testPeek() {
        Assert.assertEquals((Integer) 7, integerStack.peek());
        integerStack.pop();
        Assert.assertEquals((Integer) 6, integerStack.peek());
    }

    @Test
    public void testPush() {
        Stack<Integer> list = new Stack<>();
        Assert.assertEquals(0, list.size());
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(5);
        Assert.assertEquals(4, list.size());
        Assert.assertEquals((Integer) 5, list.peek());

        Integer[] expected = new Integer[]{1, 2, 3, 5};
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Integer pop = list.pop();
            Assert.assertEquals(expected[len - 1 - i], pop);
        }
    }

    @Test
    public void testParenthesisCounter() {
        String testString1 = "(())";
        String testString2 = "(()()(())";
        String testString3 = "())(\" , \"))((";
        String testString4 = "((())";
        String testString5 = ")";
        String testString6 = "(";
        String testString7 = "))";
        String testString8 = ")(";
        String testString9 = "((";
        Predicate<String> predicate = ParenthesisCounter::isParentesisBalanced;
        Assert.assertTrue(predicate.test(testString1));
        Assert.assertFalse(predicate.test(testString2));
        Assert.assertFalse(predicate.test(testString3));
        Assert.assertFalse(predicate.test(testString4));
        Assert.assertFalse(predicate.test(testString5));
        Assert.assertFalse(predicate.test(testString6));
        Assert.assertFalse(predicate.test(testString7));
        Assert.assertFalse(predicate.test(testString8));
        Assert.assertFalse(predicate.test(testString9));
    }
}
