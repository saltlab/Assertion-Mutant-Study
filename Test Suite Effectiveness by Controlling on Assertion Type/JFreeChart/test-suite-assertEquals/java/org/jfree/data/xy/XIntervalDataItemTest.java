package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link XIntervalDataItem} class.
 */
public class XIntervalDataItemTest {

    private static final double EPSILON = 0.00000000001;

    /**
     * Some checks for the constructor.
     */
    public void testConstructor1() {
        XIntervalDataItem item1 = new XIntervalDataItem(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XIntervalDataItem item1 = new XIntervalDataItem(1.0, 2.0, 3.0, 4.0);
        XIntervalDataItem item2 = new XIntervalDataItem(1.0, 2.0, 3.0, 4.0);
        item1 = new XIntervalDataItem(1.1, 2.0, 3.0, 4.0);
        item2 = new XIntervalDataItem(1.1, 2.0, 3.0, 4.0);
        item1 = new XIntervalDataItem(1.1, 2.2, 3.0, 4.0);
        item2 = new XIntervalDataItem(1.1, 2.2, 3.0, 4.0);
        item1 = new XIntervalDataItem(1.1, 2.2, 3.3, 4.0);
        item2 = new XIntervalDataItem(1.1, 2.2, 3.3, 4.0);
        item1 = new XIntervalDataItem(1.1, 2.2, 3.3, 4.4);
        item2 = new XIntervalDataItem(1.1, 2.2, 3.3, 4.4);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        XIntervalDataItem item1 = new XIntervalDataItem(1.0, 2.0, 3.0, 4.0);
        XIntervalDataItem item2 = (XIntervalDataItem) item1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XIntervalDataItem item1 = new XIntervalDataItem(1.0, 2.0, 3.0, 4.0);
        XIntervalDataItem item2 = (XIntervalDataItem) TestUtilities.serialised(item1);
    }
}
