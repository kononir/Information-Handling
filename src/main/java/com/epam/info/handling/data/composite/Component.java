package com.epam.info.handling.data.composite;

import java.util.List;

public interface Component {
    void add(Component component);
    List<Component> getChildren();
}
