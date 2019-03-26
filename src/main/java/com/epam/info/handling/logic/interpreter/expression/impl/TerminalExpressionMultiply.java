package com.epam.info.handling.logic.interpreter.expression.impl;

import com.epam.info.handling.logic.interpreter.context.Context;
import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;

public class TerminalExpressionMultiply implements AbstractExpression<Integer> {

    @Override
    public void interpret(Context<Integer> context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
