package org.jfree.chart.labels;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link ItemLabelAnchor} class.
 */
public class ItemLabelAnchorTest {

    /**
     * Test the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Serialize an instance, restore it, and check for identity.
     */
    public void testSerialization() {
        ItemLabelAnchor a1 = ItemLabelAnchor.INSIDE1;
        ItemLabelAnchor a2 = (ItemLabelAnchor) TestUtilities.serialised(a1);
    }
}
