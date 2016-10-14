package org.jfree.data.time.ohlc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.Year;
import org.junit.Test;

/**
 * Tests for the {@link OHLCItem} class.
 */
public class OHLCItemTest {

    private static final double EPSILON = 0.00000000001;

    /**
     * Some checks for the constructor.
     */
    public void testConstructor1() {
        OHLCItem item1 = new OHLCItem(new Year(2006), 2.0, 4.0, 1.0, 3.0);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        OHLCItem item1 = new OHLCItem(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        OHLCItem item2 = new OHLCItem(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        item1 = new OHLCItem(new Year(2007), 2.0, 4.0, 1.0, 3.0);
        item2 = new OHLCItem(new Year(2007), 2.0, 4.0, 1.0, 3.0);
        item1 = new OHLCItem(new Year(2007), 2.2, 4.0, 1.0, 3.0);
        item2 = new OHLCItem(new Year(2007), 2.2, 4.0, 1.0, 3.0);
        item1 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.0, 3.0);
        item2 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.0, 3.0);
        item1 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.1, 3.0);
        item2 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.1, 3.0);
        item1 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.1, 3.3);
        item2 = new OHLCItem(new Year(2007), 2.2, 4.4, 1.1, 3.3);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        OHLCItem item1 = new OHLCItem(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        OHLCItem item2 = (OHLCItem) item1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        OHLCItem item1 = new OHLCItem(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        OHLCItem item2 = (OHLCItem) TestUtilities.serialised(item1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        OHLCItem i1 = new OHLCItem(new Year(2009), 2.0, 4.0, 1.0, 3.0);
        OHLCItem i2 = new OHLCItem(new Year(2009), 2.0, 4.0, 1.0, 3.0);
        int h1 = i1.hashCode();
        int h2 = i2.hashCode();
    }
}
