package com.epam.info.handling.logic.interpreter.impl;

import com.epam.info.handling.logic.interpreter.ExpressionInterpreter;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionParserException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionTextException;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import com.epam.info.handling.logic.interpreter.expression.impl.NonTerminalExpressionNumber;
import com.epam.info.handling.logic.interpreter.expression.impl.TerminalExpressionAdd;
import com.epam.info.handling.logic.interpreter.expression.parser.ExpressionParser;
import com.epam.info.handling.logic.interpreter.expression.parser.impl.ArithmeticExpressionParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ArithmeticExpressionInterpreterTests {
    private static final Integer OPERAND = 5;
    private static final Integer ANSWER = 10;

    private static final String INTERPRETED_LINE = "5_5+";
    private static final String NULL_LINE = null;

    private static final ExpressionParser<Integer> NULL_PARSER = null;

    @Test
    public void testCalculateShouldReturnResultOfAddingTwoNumbersWhenGivenListWithThreeExpressionsToAdd()
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        AbstractExpression<Integer> firstExpressionNumber = new NonTerminalExpressionNumber(OPERAND);
        AbstractExpression<Integer> secondExpressionNumber = new NonTerminalExpressionNumber(OPERAND);
        AbstractExpression<Integer> expressionAdd = new TerminalExpressionAdd();

        List<AbstractExpression<Integer>> expressions = Arrays.asList(
                firstExpressionNumber,
                secondExpressionNumber,
                expressionAdd
        );

        ExpressionParser<Integer> expressionParser = mock(ArithmeticExpressionParser.class);
        when(expressionParser.parse(INTERPRETED_LINE)).thenReturn(expressions);

        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter(expressionParser);

        Integer actual = interpreter.calculate(INTERPRETED_LINE);

        Assert.assertEquals(ANSWER, actual);
        verify(expressionParser, atLeastOnce()).parse(INTERPRETED_LINE);
    }

    @Test(expected = InvalidExpressionTextException.class)
    public void testCalculateShouldThrowInvalidExpressionTextExceptionWhenGivenNullExpression()
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        ExpressionParser<Integer> expressionParser = new ArithmeticExpressionParser();
        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter(expressionParser);

        interpreter.calculate(NULL_LINE);

        Assert.fail();
    }

    @Test(expected = InvalidExpressionParserException.class)
    public void testCalculateShouldThrowInvalidExpressionParserExceptionWhenGivenNullParser()
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        ExpressionInterpreter<Integer> interpreter = new ArithmeticExpressionInterpreter(NULL_PARSER);

        interpreter.calculate(INTERPRETED_LINE);

        Assert.fail();
    }
}
