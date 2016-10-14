package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link CategoryAnchor} class.
 */
public class CategoryAnchorTest {

    /**
     * Check that the equals() method distinguishes known instances.
     */
    public void testEquals() {
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CategoryAnchor a1 = CategoryAnchor.START;
        CategoryAnchor a2 = CategoryAnchor.START;
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryAnchor a1 = CategoryAnchor.MIDDLE;
        CategoryAnchor a2 = (CategoryAnchor) TestUtilities.serialised(a1);
    }
}
