package com.epam.info.handling.logic.interpreter.context;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerContext implements Context<Integer> {
    private Deque<Integer> values = new ArrayDeque<>();

    public void pushValue(Integer value) {
        values.push(value);
    }

    public Integer popValue() {
        return values.pop();
    }

    private static final Integer VALUE = 10;

    @Test
    public void testPushShouldPushGivenValueToValues() {
        IntegerContext context = new IntegerContext();

        context.pushValue(VALUE);

        Deque<Integer> values = context.values;
        Assert.assertEquals(VALUE, values.pop());
    }

    @Test
    public void testPopShouldPopAndReturnValueFromValues() {
        IntegerContext context = new IntegerContext();
        Deque<Integer> values = context.values;
        values.push(VALUE);

        Integer actual = context.popValue();

        Assert.assertEquals(VALUE, actual);
    }
}
