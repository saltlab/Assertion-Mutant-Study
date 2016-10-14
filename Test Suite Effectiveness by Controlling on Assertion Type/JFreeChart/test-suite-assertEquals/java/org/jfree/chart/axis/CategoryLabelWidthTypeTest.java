package org.jfree.chart.axis;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link CategoryLabelWidthType} class.
 */
public class CategoryLabelWidthTypeTest {

    /**
     * Confirm that the equals() method distinguishes the known values.
     */
    public void testEquals() {
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CategoryLabelWidthType a1 = CategoryLabelWidthType.CATEGORY;
        CategoryLabelWidthType a2 = CategoryLabelWidthType.CATEGORY;
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryLabelWidthType w1 = CategoryLabelWidthType.RANGE;
        CategoryLabelWidthType w2 = (CategoryLabelWidthType) TestUtilities.serialised(w1);
    }
}
