package com.epam.info.handling.logic.interpreter.expression.parser;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;

import java.util.List;

public interface ExpressionParser<T extends Number> {
    List<AbstractExpression> parse(String expressionText);
}
