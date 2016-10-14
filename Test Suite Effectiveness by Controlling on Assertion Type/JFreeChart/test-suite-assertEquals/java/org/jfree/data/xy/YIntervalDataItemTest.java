package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link YIntervalDataItem} class.
 */
public class YIntervalDataItemTest {

    private static final double EPSILON = 0.00000000001;

    /**
     * Some checks for the constructor.
     */
    public void testConstructor1() {
        YIntervalDataItem item1 = new YIntervalDataItem(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        YIntervalDataItem item1 = new YIntervalDataItem(1.0, 2.0, 1.5, 2.5);
        YIntervalDataItem item2 = new YIntervalDataItem(1.0, 2.0, 1.5, 2.5);
        item1 = new YIntervalDataItem(1.1, 2.0, 1.5, 2.5);
        item2 = new YIntervalDataItem(1.1, 2.0, 1.5, 2.5);
        item1 = new YIntervalDataItem(1.1, 2.2, 1.5, 2.5);
        item2 = new YIntervalDataItem(1.1, 2.2, 1.5, 2.5);
        item1 = new YIntervalDataItem(1.1, 2.2, 1.55, 2.5);
        item2 = new YIntervalDataItem(1.1, 2.2, 1.55, 2.5);
        item1 = new YIntervalDataItem(1.1, 2.2, 1.55, 2.55);
        item2 = new YIntervalDataItem(1.1, 2.2, 1.55, 2.55);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        YIntervalDataItem item1 = new YIntervalDataItem(1.0, 2.0, 1.5, 2.5);
        YIntervalDataItem item2 = (YIntervalDataItem) item1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        YIntervalDataItem item1 = new YIntervalDataItem(1.0, 2.0, 1.5, 2.5);
        YIntervalDataItem item2 = (YIntervalDataItem) TestUtilities.serialised(item1);
    }
}
