package com.epam.info.handling.logic.interpreter.context;

public interface Context<T extends Number> {
    void pushValue(T value);
    T popValue();
}
