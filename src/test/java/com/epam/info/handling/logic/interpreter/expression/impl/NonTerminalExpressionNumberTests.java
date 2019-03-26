package com.epam.info.handling.logic.interpreter.expression.impl;

import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.context.IntegerContext;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NonTerminalExpressionNumberTests {
    private static final Integer NUMBER_VALUE = 10;

    @Test
    public void testInterpretShouldPushValueToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionNumber = new NonTerminalExpressionNumber(NUMBER_VALUE);
        Context<Integer> context = mock(IntegerContext.class);

        expressionNumber.interpret(context);

        verify(context, atLeastOnce()).pushValue(NUMBER_VALUE);
    }
}
