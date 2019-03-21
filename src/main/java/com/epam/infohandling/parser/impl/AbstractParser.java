package com.epam.infohandling.parser.impl;

import com.epam.infohandling.parser.Parser;

public abstract class AbstractParser implements Parser {
    private Parser successor;
/*
    public AbstractParser(Parser successor) {
        this.successor = successor;
    }
*/
    protected Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
