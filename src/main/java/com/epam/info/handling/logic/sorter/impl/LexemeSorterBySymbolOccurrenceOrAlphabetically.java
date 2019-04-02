package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.logic.sorter.Sorter;
import com.epam.info.handling.logic.sorter.comporator.LexemeSymbolOccurrenceOrAlphabeticallyComparator;

import java.util.ArrayList;
import java.util.List;

public class LexemeSorterBySymbolOccurrenceOrAlphabetically implements Sorter<Lexeme> {
    private String desiredSymbol;

    public LexemeSorterBySymbolOccurrenceOrAlphabetically(String desiredSymbol) {
        this.desiredSymbol = desiredSymbol;
    }

    @Override
    public List<Lexeme> sort(List<Lexeme> lexemes) {
        List<Lexeme> sortable = new ArrayList<>(lexemes);

        lexemes.sort(new LexemeSymbolOccurrenceOrAlphabeticallyComparator(desiredSymbol));

        return sortable;
    }
}
