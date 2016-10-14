package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link RangeType} class.
 */
public class RangeTypeTest {

    /**
     * Some checks for the equals() method.
     */
    @Test
    public void testEquals() {
        assertEquals(RangeType.FULL, RangeType.FULL);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        RangeType r1 = RangeType.FULL;
        RangeType r2 = RangeType.FULL;
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        RangeType r1 = RangeType.FULL;
        RangeType r2 = (RangeType) TestUtilities.serialised(r1);
    }
}
