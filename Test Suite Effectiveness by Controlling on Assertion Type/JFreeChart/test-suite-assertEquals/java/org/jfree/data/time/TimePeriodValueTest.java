package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link TimePeriodValue} class.
 */
public class TimePeriodValueTest {

    /**
     * Test that an instance is equal to itself.
     */
    public void testEqualsSelf() {
        TimePeriodValue tpv = new TimePeriodValue(new Day(), 55.75);
    }

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        TimePeriodValue tpv1 = new TimePeriodValue(new Day(30, 7, 2003), 55.75);
        TimePeriodValue tpv2 = new TimePeriodValue(new Day(30, 7, 2003), 55.75);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimePeriodValue tpv1 = new TimePeriodValue(new Day(30, 7, 2003), 55.75);
        TimePeriodValue tpv2 = (TimePeriodValue) TestUtilities.serialised(tpv1);
    }
}
