package com.epam.info.handling.logic.interpreter;

import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionParserException;
import com.epam.info.handling.logic.interpreter.exception.InvalidExpressionTextException;

public interface ExpressionInterpreter<T extends Number> {
    T calculate(String expressionValue) throws InvalidExpressionTextException, InvalidExpressionParserException;
}
