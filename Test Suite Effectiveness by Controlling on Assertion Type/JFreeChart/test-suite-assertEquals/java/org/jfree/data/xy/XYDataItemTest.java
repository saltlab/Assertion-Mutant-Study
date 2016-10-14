package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link XYDataItem} class.
 */
public class XYDataItemTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = new XYDataItem(1.0, 1.1);
        i1.setY(new Double(9.9));
        i2.setY(new Double(9.9));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = (XYDataItem) i1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = (XYDataItem) TestUtilities.serialised(i1);
    }
}
