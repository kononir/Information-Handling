package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.logic.sorter.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphSorterBySentenceNumberTests {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedParagraphsWhenFirstParagraphHasMoreSentences() {
        Component firstSentenceComponent = new Composite();
        Component secondSentenceComponent = new Composite();
        Composite firstParagraphComposite = new Composite();
        firstParagraphComposite.add(firstSentenceComponent);
        firstParagraphComposite.add(secondSentenceComponent);

        Component thirdSentenceComponent = new Composite();
        Composite secondParagraphComposite = new Composite();
        secondParagraphComposite.add(thirdSentenceComponent);

        List<Composite> unsorted = Arrays.asList(
                firstParagraphComposite,
                secondParagraphComposite
        );

        Sorter<Composite> sorter = new ParagraphSorterBySentenceNumber();

        List<Composite> sorted = sorter.sort(unsorted);

        Composite firstSecondComposite = sorted.get(FIRST);
        Assert.assertEquals(secondParagraphComposite, firstSecondComposite);

        Composite secondSortedComposite = sorted.get(SECOND);
        Assert.assertEquals(firstParagraphComposite, secondSortedComposite);
    }
}
