package com.epam.info.handling.logic.sorter.comporator;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeSymbolOccurrenceOrAlphabeticallyComparator implements Comparator<Lexeme> {
    private String desiredSymbol;

    public LexemeSymbolOccurrenceOrAlphabeticallyComparator(String desiredSymbol) {
        this.desiredSymbol = desiredSymbol;
    }

    @Override
    public int compare(Lexeme lexeme1, Lexeme lexeme2) {
        String lexemeValue1 = lexeme1.getValue();
        String lexemeValue2 = lexeme2.getValue();

        int lexeme1OccurrencesNumber = findOccurrencesNumber(lexemeValue1);
        int lexeme2OccurrencesNumber = findOccurrencesNumber(lexemeValue2);

        return lexeme1OccurrencesNumber != lexeme2OccurrencesNumber
                ? lexeme1OccurrencesNumber - lexeme2OccurrencesNumber
                : lexemeValue2.compareTo(lexemeValue1);
    }

    private int findOccurrencesNumber(String lexemeValue) {
        Pattern pattern = Pattern.compile(desiredSymbol);
        Matcher matcher = pattern.matcher(lexemeValue);

        int occurrencesNumber = 0;
        while (matcher.find()) {
            occurrencesNumber++;
        }

        return occurrencesNumber;
    }
}
