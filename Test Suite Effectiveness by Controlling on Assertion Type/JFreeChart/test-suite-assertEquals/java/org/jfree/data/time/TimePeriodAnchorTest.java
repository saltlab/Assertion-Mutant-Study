package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link TimePeriodAnchor} class.
 */
public class TimePeriodAnchorTest {

    /**
     * Test the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Serialize an instance, restore it, and check for identity.
     */
    public void testSerialization() {
        TimePeriodAnchor a1 = TimePeriodAnchor.START;
        TimePeriodAnchor a2 = (TimePeriodAnchor) TestUtilities.serialised(a1);
    }
}
