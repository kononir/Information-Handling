package com.epam.info.handling.logic.interpreter.expression.impl;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import org.junit.Test;

public class TerminalExpressionSubtractTests {
    private static final Integer FIRST_NUMBER = 12;
    private static final Integer SECOND_NUMBER = 3;
    private static final Integer ANSWER = 9;

    @Test
    public void testInterpretShouldPushResultOfSubtractingTwoNumbersToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionSubtract = new TerminalExpressionSubtract();

        new TerminalExpressionCommonTests().testInterpret(expressionSubtract, FIRST_NUMBER, SECOND_NUMBER, ANSWER);
    }
}
