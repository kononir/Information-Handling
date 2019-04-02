package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.logic.sorter.Sorter;
import com.epam.info.handling.logic.sorter.comporator.CompositeChildrenNumberComparator;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterBySentenceNumber implements Sorter<Composite> {

    @Override
    public List<Composite> sort(List<Composite> composites) {
        List<Composite> sortable = new ArrayList<>(composites);

        sortable.sort(new CompositeChildrenNumberComparator());

        return sortable;
    }
}
