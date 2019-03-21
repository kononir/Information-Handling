package com.epam.infohandling.logic;

import com.epam.infohandling.composite.Component;

import java.util.List;

public interface Sorter {
    List<Component> sort(List<Component> sorted);
}
