package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link TimeSeriesDataItem} class.
 */
public class TimeSeriesDataItemTest {

    /**
     * Test that an instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        TimeSeriesDataItem item = new TimeSeriesDataItem(new Day(23, 9, 2001), 99.7);
    }

    /**
     * Test the equals() method.
     */
    public void testEquals() {
        TimeSeriesDataItem item1 = new TimeSeriesDataItem(new Day(23, 9, 2001), 99.7);
        TimeSeriesDataItem item2 = new TimeSeriesDataItem(new Day(23, 9, 2001), 99.7);
        item1.setValue(new Integer(5));
        item2.setValue(new Integer(5));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimeSeriesDataItem item1 = new TimeSeriesDataItem(new Day(23, 9, 2001), 99.7);
        TimeSeriesDataItem item2 = (TimeSeriesDataItem) TestUtilities.serialised(item1);
    }
}
