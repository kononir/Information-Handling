package com.epam.info.handling.logic.interpreter.expression.parser;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import com.epam.info.handling.logic.interpreter.expression.impl.*;
import com.epam.info.handling.logic.interpreter.expression.parser.impl.ArithmeticExpressionParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArithmeticExpressionParserTests {
    private static final String ONE_NUMBER = "56";
    private static final String TWO_NUMBERS_ADDING = "56_44+";
    private static final String TWO_NUMBERS_SUBTRACTING = "56_44-";
    private static final String TWO_NUMBERS_MULTIPLYING = "56_44*";
    private static final String TWO_NUMBERS_DIVIDING = "56_44/";
    private static final String TWO_NUMBERS_EXPONENTIATION = "56_44^";

    private static final Integer FIRST_NUMBER = 56;
    private static final Integer SECOND_NUMBER = 44;

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    @Test
    public void testParseShouldReturnListWithOneNonTerminalExpressionWhenGivenOnlyOneNumber() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(ONE_NUMBER);

        checkFirstNonTerminalExpression(expressions);
    }

    @Test
    public void testParseShouldReturnListWithTwoNonTerminalAndOneTerminalAddExpressionsWhenGivenAddingOfTwoNumbers() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(TWO_NUMBERS_ADDING);

        checkFirstNonTerminalExpression(expressions);
        checkSecondNonTerminalExpression(expressions);

        AbstractExpression<Integer> thirdExpression = expressions.get(THIRD);
        Assert.assertEquals(TerminalExpressionAdd.class, thirdExpression.getClass());
    }

    @Test
    public void testParseShouldReturnListWithTwoNonTerminalAndOneTerminalSubtractExpressionsWhenGivenSubtractingOfTwoNumbers() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(TWO_NUMBERS_SUBTRACTING);

        checkFirstNonTerminalExpression(expressions);
        checkSecondNonTerminalExpression(expressions);

        AbstractExpression<Integer> thirdExpression = expressions.get(THIRD);
        Assert.assertEquals(TerminalExpressionSubtract.class, thirdExpression.getClass());
    }

    @Test
    public void testParseShouldReturnListWithTwoNonTerminalAndOneTerminalMultiplyExpressionsWhenGivenMultiplyingOfTwoNumbers() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(TWO_NUMBERS_MULTIPLYING);

        checkFirstNonTerminalExpression(expressions);
        checkSecondNonTerminalExpression(expressions);

        AbstractExpression<Integer> thirdExpression = expressions.get(THIRD);
        Assert.assertEquals(TerminalExpressionMultiply.class, thirdExpression.getClass());
    }

    @Test
    public void testParseShouldReturnListWithTwoNonTerminalAndOneTerminalDivideExpressionsWhenGivenDividingOfTwoNumbers() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(TWO_NUMBERS_DIVIDING);

        checkFirstNonTerminalExpression(expressions);
        checkSecondNonTerminalExpression(expressions);

        AbstractExpression<Integer> thirdExpression = expressions.get(THIRD);
        Assert.assertEquals(TerminalExpressionDivide.class, thirdExpression.getClass());
    }

    @Test
    public void testParseShouldReturnListWithTwoNonTerminalAndOneTerminalPowExpressionsWhenGivenExponentiationOfTwoNumbers() {
        ExpressionParser<Integer> parser = new ArithmeticExpressionParser();

        List<AbstractExpression<Integer>> expressions = parser.parse(TWO_NUMBERS_EXPONENTIATION);

        checkFirstNonTerminalExpression(expressions);
        checkSecondNonTerminalExpression(expressions);

        AbstractExpression<Integer> thirdExpression = expressions.get(THIRD);
        Assert.assertEquals(TerminalExpressionPow.class, thirdExpression.getClass());
    }

    private void checkFirstNonTerminalExpression(List<AbstractExpression<Integer>> expressions) {
        AbstractExpression<Integer> firstExpression = expressions.get(FIRST);
        Assert.assertEquals(NonTerminalExpressionNumber.class, firstExpression.getClass());
        NonTerminalExpressionNumber firstExpressionNumber = (NonTerminalExpressionNumber) firstExpression;
        Assert.assertEquals(FIRST_NUMBER, firstExpressionNumber.getValue());
    }

    private void checkSecondNonTerminalExpression(List<AbstractExpression<Integer>> expressions) {
        AbstractExpression<Integer> secondExpression = expressions.get(SECOND);
        Assert.assertEquals(NonTerminalExpressionNumber.class, secondExpression.getClass());
        NonTerminalExpressionNumber secondExpressionNumber = (NonTerminalExpressionNumber) secondExpression;
        Assert.assertEquals(SECOND_NUMBER, secondExpressionNumber.getValue());
    }
}
