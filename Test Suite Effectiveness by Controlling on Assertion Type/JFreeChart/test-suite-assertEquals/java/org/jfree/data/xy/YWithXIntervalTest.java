package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link YWithXInterval} class.
 */
public class YWithXIntervalTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        YWithXInterval i1 = new YWithXInterval(1.0, 0.5, 1.5);
        YWithXInterval i2 = new YWithXInterval(1.0, 0.5, 1.5);
        i1 = new YWithXInterval(1.1, 0.5, 1.5);
        i2 = new YWithXInterval(1.1, 0.5, 1.5);
        i1 = new YWithXInterval(1.1, 0.55, 1.5);
        i2 = new YWithXInterval(1.1, 0.55, 1.5);
        i1 = new YWithXInterval(1.1, 0.55, 1.55);
        i2 = new YWithXInterval(1.1, 0.55, 1.55);
    }

    /**
     * This class is immutable.
     */
    public void testCloning() {
        YWithXInterval i1 = new YWithXInterval(1.0, 0.5, 1.5);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        YWithXInterval i1 = new YWithXInterval(1.0, 0.5, 1.5);
        YWithXInterval i2 = (YWithXInterval) TestUtilities.serialised(i1);
    }
}
