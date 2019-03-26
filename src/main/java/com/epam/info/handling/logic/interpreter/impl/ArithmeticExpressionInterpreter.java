package com.epam.info.handling.logic.interpreter.impl;

import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.ExpressionInterpreter;
import com.epam.info.handling.logic.interpreter.exception.InvalidContextException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionsException;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;

import java.util.List;

public class ArithmeticExpressionInterpreter implements ExpressionInterpreter<Integer> {

    @Override
    public Integer calculate(List<AbstractExpression<Integer>> expressions, Context<Integer> context)
            throws InvalidExpressionsException, InvalidContextException {
        if (expressions == null) {
            throw new InvalidExpressionsException("Expressions is null");
        }

        if (expressions.isEmpty()) {
            throw new InvalidExpressionsException("Expressions is empty");
        }

        if (context == null) {
            throw new InvalidContextException("Context is null");
        }

        for (AbstractExpression<Integer> expression : expressions) {
            expression.interpret(context);
        }

        return context.popValue();
    }
}
