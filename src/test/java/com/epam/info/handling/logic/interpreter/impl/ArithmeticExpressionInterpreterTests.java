package com.epam.info.handling.logic.interpreter.impl;

import com.epam.info.handling.logic.interpreter.ExpressionInterpreter;
import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.context.IntegerContext;
import com.epam.info.handling.logic.interpreter.exception.InvalidContextException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionsException;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import com.epam.info.handling.logic.interpreter.expression.impl.NonTerminalExpressionNumber;
import com.epam.info.handling.logic.interpreter.expression.impl.TerminalExpressionAdd;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ArithmeticExpressionInterpreterTests {
    private static final Integer ANSWER = 10;

    @Test
    public void testCalculateShouldReturnResultOfAddingTwoNumbersWhenGivenListWithThreeExpressionsToAdd()
            throws InvalidExpressionsException, InvalidContextException {
        Context<Integer> context = mock(IntegerContext.class);
        when(context.popValue()).thenReturn(ANSWER);

        AbstractExpression<Integer> firstExpressionNumber = mock(NonTerminalExpressionNumber.class);
        AbstractExpression<Integer> secondExpressionNumber = mock(NonTerminalExpressionNumber.class);
        AbstractExpression<Integer> expressionAdd = mock(TerminalExpressionAdd.class);

        List<AbstractExpression<Integer>> expressions = Arrays.asList(
                firstExpressionNumber,
                secondExpressionNumber,
                expressionAdd
        );

        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter();

        Integer actual = interpreter.calculate(expressions, context);

        Assert.assertEquals(ANSWER, actual);

        verify(firstExpressionNumber, atLeastOnce()).interpret(context);
        verify(secondExpressionNumber, atLeastOnce()).interpret(context);
        verify(expressionAdd, atLeastOnce()).interpret(context);

        verify(context, atLeastOnce()).popValue();
    }

    @Test(expected = InvalidExpressionsException.class)
    public void testCalculateShouldThrowInvalidExpressionsExceptionWhenGivenNullExpressions()
            throws InvalidExpressionsException, InvalidContextException {
        List<AbstractExpression<Integer>> expressions = null;

        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter();
        Context<Integer> context = new IntegerContext();

        interpreter.calculate(expressions, context);

        Assert.fail();
    }

    @Test(expected = InvalidExpressionsException.class)
    public void testCalculateShouldThrowInvalidExpressionsExceptionWhenGivenEmptyExpressions()
            throws InvalidExpressionsException, InvalidContextException {
        List<AbstractExpression<Integer>> expressions = new ArrayList<>();

        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter();
        Context<Integer> context = new IntegerContext();

        interpreter.calculate(expressions, context);
    }

    @Test(expected = InvalidContextException.class)
    public void testCalculateShouldThrowInvalidExpressionsExceptionWhenGivenEmptyContext()
            throws InvalidExpressionsException, InvalidContextException {
        AbstractExpression<Integer> expression = new TerminalExpressionAdd();
        List<AbstractExpression<Integer>> expressions = Collections.singletonList(expression);

        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter();
        Context<Integer> context = null;

        interpreter.calculate(expressions, context);
    }
}
