package com.epam.info.handling.logic.interpreter;

import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.exception.InvalidContextException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionsException;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;

import java.util.List;

public interface ExpressionInterpreter<T extends Number> {
    T calculate(List<AbstractExpression<T>> expressions, Context<T> context) throws InvalidExpressionsException, InvalidContextException;
}
