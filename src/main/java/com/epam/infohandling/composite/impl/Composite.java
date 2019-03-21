package com.epam.infohandling.composite.impl;

import com.epam.infohandling.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }
}
