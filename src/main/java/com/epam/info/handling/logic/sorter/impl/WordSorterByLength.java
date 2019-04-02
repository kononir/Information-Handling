package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.data.composite.impl.lexeme.LexemeType;
import com.epam.info.handling.logic.sorter.Sorter;
import com.epam.info.handling.logic.sorter.comporator.LexemeLengthComparator;

import java.util.List;
import java.util.stream.Collectors;

public class WordSorterByLength implements Sorter<Lexeme> {

    @Override
    public List<Lexeme> sort(List<Lexeme> lexemes) {
        return lexemes.stream()
                .filter(lexeme -> lexeme.getType() == LexemeType.WORD)
                .sorted(new LexemeLengthComparator())
                .collect(Collectors.toList());
    }
}
