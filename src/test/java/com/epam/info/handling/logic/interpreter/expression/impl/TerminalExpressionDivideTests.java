package com.epam.info.handling.logic.interpreter.expression.impl;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import org.junit.Test;

public class TerminalExpressionDivideTests {
    private static final Integer FIRST_NUMBER = 12;
    private static final Integer SECOND_NUMBER = 3;
    private static final Integer ANSWER = 4;

    @Test
    public void testInterpretShouldPushResultOfDividingTwoNumbersToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionDivide = new TerminalExpressionDivide();

        new TerminalExpressionCommonTests().testInterpret(expressionDivide, FIRST_NUMBER, SECOND_NUMBER, ANSWER);
    }
}
