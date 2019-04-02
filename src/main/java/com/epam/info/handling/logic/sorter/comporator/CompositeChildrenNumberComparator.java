package com.epam.info.handling.logic.sorter.comporator;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;

import java.util.Comparator;
import java.util.List;

public class CompositeChildrenNumberComparator implements Comparator<Composite> {

    @Override
    public int compare(Composite component1, Composite component2) {
        List<Component> children1 = component1.getChildren();
        List<Component> children2 = component2.getChildren();

        return children1.size() - children2.size();
    }
}
