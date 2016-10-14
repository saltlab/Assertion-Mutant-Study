package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DateTickMarkPosition} class.
 */
public class DateTickMarkPositionTest {

    /**
     * Test equals() method.
     */
    public void testEquals() {
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DateTickMarkPosition a1 = DateTickMarkPosition.END;
        DateTickMarkPosition a2 = DateTickMarkPosition.END;
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateTickMarkPosition p1 = DateTickMarkPosition.MIDDLE;
        DateTickMarkPosition p2 = (DateTickMarkPosition) TestUtilities.serialised(p1);
    }
}
