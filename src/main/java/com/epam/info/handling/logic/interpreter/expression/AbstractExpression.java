package com.epam.info.handling.logic.interpreter.expression;

import com.epam.info.handling.logic.interpreter.context.Context;

public interface AbstractExpression<T extends Number> {
    void interpret(Context<T> context);
}
