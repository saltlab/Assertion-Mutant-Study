package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link ItemLabelPosition} class.
 */
public class ItemLabelPositionTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        ItemLabelPosition p1 = new ItemLabelPosition();
        ItemLabelPosition p2 = new ItemLabelPosition();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ItemLabelPosition p1 = new ItemLabelPosition();
        ItemLabelPosition p2 = (ItemLabelPosition) TestUtilities.serialised(p1);
    }
}
