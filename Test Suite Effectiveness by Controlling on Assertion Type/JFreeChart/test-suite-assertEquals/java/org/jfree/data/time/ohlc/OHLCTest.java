package org.jfree.data.time.ohlc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link OHLC} class.
 */
public class OHLCTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        OHLC i1 = new OHLC(2.0, 4.0, 1.0, 3.0);
        OHLC i2 = new OHLC(2.0, 4.0, 1.0, 3.0);
        i1 = new OHLC(2.2, 4.0, 1.0, 3.0);
        i2 = new OHLC(2.2, 4.0, 1.0, 3.0);
        i1 = new OHLC(2.2, 4.4, 1.0, 3.0);
        i2 = new OHLC(2.2, 4.4, 1.0, 3.0);
        i1 = new OHLC(2.2, 4.4, 1.1, 3.0);
        i2 = new OHLC(2.2, 4.4, 1.1, 3.0);
        i1 = new OHLC(2.2, 4.4, 1.1, 3.3);
        i2 = new OHLC(2.2, 4.4, 1.1, 3.3);
    }

    /**
     * This class is immutable.
     */
    public void testCloning() {
        OHLC i1 = new OHLC(2.0, 4.0, 1.0, 3.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        OHLC i1 = new OHLC(2.0, 4.0, 1.0, 3.0);
        OHLC i2 = (OHLC) TestUtilities.serialised(i1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        OHLC i1 = new OHLC(2.0, 4.0, 1.0, 3.0);
        OHLC i2 = new OHLC(2.0, 4.0, 1.0, 3.0);
        int h1 = i1.hashCode();
        int h2 = i2.hashCode();
    }
}
