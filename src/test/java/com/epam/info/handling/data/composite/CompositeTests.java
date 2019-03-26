package com.epam.info.handling.data.composite;

import com.epam.info.handling.data.composite.impl.Composite;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompositeTests {
    private static final int FIRST = 0;

    @Test
    public void testAddShouldAddNewComponentToCompositeListWhenGivenComponent() {
        Component component = new Composite();
        Component givenComponent = new Composite();

        component.add(givenComponent);

        List<Component> children = component.getChildren();
        Component child = children.get(FIRST);
        Assert.assertEquals(Composite.class, child.getClass());
    }
}
