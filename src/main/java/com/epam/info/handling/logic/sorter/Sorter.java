package com.epam.info.handling.logic.sorter;

import com.epam.info.handling.data.composite.Component;

import java.util.List;

public interface Sorter {
    List<Component> sort(List<Component> sorted);
}
