package com.epam.info.handling.logic.interpreter.expression.impl;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import org.junit.Test;

public class TerminalExpressionPowTests {
    private static final Integer FIRST_NUMBER = 12;
    private static final Integer SECOND_NUMBER = 3;
    private static final Integer ANSWER = 1728;

    @Test
    public void testInterpretShouldPushResultOfExponentiationTwoNumbersToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionPow = new TerminalExpressionPow();

        new TerminalExpressionCommonTests().testInterpret(expressionPow, FIRST_NUMBER, SECOND_NUMBER, ANSWER);
    }
}
