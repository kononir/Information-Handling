package com.epam.info.handling.logic.interpreter.impl;

import com.epam.info.handling.logic.interpreter.ExpressionInterpreter;
import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.context.IntegerContext;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionParserException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionTextException;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import com.epam.info.handling.logic.interpreter.expression.parser.ExpressionParser;

import java.util.List;

public class ArithmeticExpressionInterpreter implements ExpressionInterpreter<Integer> {
    private ExpressionParser<Integer> expressionParser;

    public ArithmeticExpressionInterpreter(ExpressionParser<Integer> expressionParser) {
        this.expressionParser = expressionParser;
    }

    @Override
    public Integer calculate(String expressionText)
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        if (expressionText == null) {
            throw new InvalidExpressionTextException("Expression text value is null");
        }

        if (expressionParser == null) {
            throw new InvalidExpressionParserException("Expression parser value is null");
        }

        List<AbstractExpression<Integer>> expressions = expressionParser.parse(expressionText);

        Context<Integer> context = new IntegerContext();

        for (AbstractExpression<Integer> expression : expressions) {
            expression.interpret(context);
        }

        return context.popValue();
    }
}
