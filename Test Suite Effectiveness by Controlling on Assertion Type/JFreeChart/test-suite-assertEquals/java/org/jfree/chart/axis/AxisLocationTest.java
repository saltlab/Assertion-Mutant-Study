package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link AxisLocation} class.
 */
public class AxisLocationTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        AxisLocation a1 = AxisLocation.TOP_OR_RIGHT;
        AxisLocation a2 = AxisLocation.TOP_OR_RIGHT;
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        AxisLocation location1 = AxisLocation.BOTTOM_OR_RIGHT;
        AxisLocation location2 = (AxisLocation) TestUtilities.serialised(location1);
        boolean same = location1 == location2;
    }
}
