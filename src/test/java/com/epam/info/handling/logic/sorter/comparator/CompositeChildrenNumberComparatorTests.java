package com.epam.info.handling.logic.sorter.comparator;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.logic.sorter.comporator.CompositeChildrenNumberComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class CompositeChildrenNumberComparatorTests {
    private static final int ZERO = 0;

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenFirstCompositeHasMoreChildren() {
        Component firstComponent = new Composite();
        Component secondComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);
        firstComposite.add(secondComponent);

        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(thirdComponent);

        Comparator<Composite> comparator = new CompositeChildrenNumberComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstCompositeHasLessChildren() {
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);
        secondComposite.add(thirdComponent);

        Comparator<Composite> comparator = new CompositeChildrenNumberComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenCompositesHaveEqualNumberOfChildren() {
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);

        Comparator<Composite> comparator = new CompositeChildrenNumberComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertEquals(ZERO, actual);
    }
}
