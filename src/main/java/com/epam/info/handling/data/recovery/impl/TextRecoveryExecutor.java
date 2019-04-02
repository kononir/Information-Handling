package com.epam.info.handling.data.recovery.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.data.recovery.RecoveryExecutor;
import com.epam.info.handling.data.recovery.exception.TextRecoveryInvalidLexemeValueException;

import java.util.List;
import java.util.ListIterator;

public class TextRecoveryExecutor implements RecoveryExecutor {
    private static final Component LAST = null;
    private static final String PARAGRAPH_SPLITTER = "\n\t";
    private static final String SPACE_SPLITTER = " ";
    private static final String PUNCTUATION_MARKS_REGEXP = "\\.{3}|[.?!,:;]";

    @Override
    public String executeRecovery(Component component) throws TextRecoveryInvalidLexemeValueException {
        return "\t" + executeComponentRecovery(component, LAST, PARAGRAPH_SPLITTER);
    }

    private String executeComponentRecovery(Component currComposite, Component nextComposite, String splitter)
            throws TextRecoveryInvalidLexemeValueException {
        String result;
        
        List<Component> children = currComposite.getChildren();
        if (children.isEmpty()) {
            result = executeLexemeRecovery((Lexeme) currComposite, (Lexeme) nextComposite);
        } else {
            result = executeChildrenRecovery(children, splitter);
        }
        
        return result;
    }
    
    private String executeChildrenRecovery(List<Component> children, String splitter)
            throws TextRecoveryInvalidLexemeValueException {
        StringBuilder result = new StringBuilder();
        
        ListIterator<Component> iterator = children.listIterator();
        while (iterator.hasNext()) {
            result.append(executeChildRecovery(iterator, splitter));
        }
        
        return result.toString();
    }

    private String executeChildRecovery(ListIterator<Component> childrenIterator, String splitter)
            throws TextRecoveryInvalidLexemeValueException {
        StringBuilder result = new StringBuilder();

        Component currChild = childrenIterator.next();

        if (childrenIterator.hasNext()) {
            Component nextChild = childrenIterator.next();
            result.append(executeChildRecoveryWithContext(currChild, nextChild, splitter));
            childrenIterator.previous();
        } else {
            result.append(executeComponentRecovery(currChild, LAST, SPACE_SPLITTER));
        }

        return result.toString();
    }

    private String executeChildRecoveryWithContext(Component currChild, Component nextChild, String splitter)
            throws TextRecoveryInvalidLexemeValueException {
        StringBuilder result = new StringBuilder(executeComponentRecovery(currChild, nextChild, SPACE_SPLITTER));

        List<Component> subChildren = nextChild.getChildren();
        if (!subChildren.isEmpty()) {
            result.append(splitter);
        }

        return result.toString();
    }

    private String executeLexemeRecovery(Lexeme currLexeme, Lexeme nextLexeme)
            throws TextRecoveryInvalidLexemeValueException {
        String result;
        String currLexemeValue = currLexeme.getValue();

        if (currLexemeValue == null) {
            throw new TextRecoveryInvalidLexemeValueException("Lexeme value is null");
        }

        if (nextLexeme != null) {
            result = executeLexemeRecoveryWithContext(currLexemeValue, nextLexeme);
        } else {
            result = currLexemeValue;
        }

        return result;
    }

    private String executeLexemeRecoveryWithContext(String currLexemeValue, Lexeme nextLexeme)
            throws TextRecoveryInvalidLexemeValueException {
        String result;
        String nextLexemeValue = nextLexeme.getValue();

        if (nextLexemeValue == null) {
            throw new TextRecoveryInvalidLexemeValueException("Lexeme value is null");
        }

        if (nextLexemeValue.matches(PUNCTUATION_MARKS_REGEXP)) {
            result = currLexemeValue;
        } else {
            result = currLexemeValue + SPACE_SPLITTER;
        }

        return result;
    }
}
