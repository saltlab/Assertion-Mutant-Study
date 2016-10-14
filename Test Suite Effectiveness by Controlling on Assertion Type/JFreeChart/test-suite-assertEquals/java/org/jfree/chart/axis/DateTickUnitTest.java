package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DateTickUnit} class.
 */
public class DateTickUnitTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DateTickUnit t1 = new DateTickUnit(DateTickUnit.DAY, 1);
        DateTickUnit t2 = new DateTickUnit(DateTickUnit.DAY, 1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DateTickUnit t1 = new DateTickUnit(DateTickUnit.DAY, 1);
        DateTickUnit t2 = new DateTickUnit(DateTickUnit.DAY, 1);
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateTickUnit a1 = new DateTickUnit(DateTickUnit.DAY, 7);
        DateTickUnit a2 = (DateTickUnit) TestUtilities.serialised(a1);
    }
}
