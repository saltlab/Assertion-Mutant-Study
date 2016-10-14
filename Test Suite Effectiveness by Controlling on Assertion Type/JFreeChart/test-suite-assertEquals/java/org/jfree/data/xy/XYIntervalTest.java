package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link XYInterval} class.
 */
public class XYIntervalTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYInterval i1 = new XYInterval(1.0, 2.0, 3.0, 2.5, 3.5);
        XYInterval i2 = new XYInterval(1.0, 2.0, 3.0, 2.5, 3.5);
        i1 = new XYInterval(1.1, 2.0, 3.0, 2.5, 3.5);
        i2 = new XYInterval(1.1, 2.0, 3.0, 2.5, 3.5);
        i1 = new XYInterval(1.1, 2.2, 3.0, 2.5, 3.5);
        i2 = new XYInterval(1.1, 2.2, 3.0, 2.5, 3.5);
        i1 = new XYInterval(1.1, 2.2, 3.3, 2.5, 3.5);
        i2 = new XYInterval(1.1, 2.2, 3.3, 2.5, 3.5);
        i1 = new XYInterval(1.1, 2.2, 3.3, 2.6, 3.5);
        i2 = new XYInterval(1.1, 2.2, 3.3, 2.6, 3.5);
        i1 = new XYInterval(1.1, 2.2, 3.3, 2.6, 3.6);
        i2 = new XYInterval(1.1, 2.2, 3.3, 2.6, 3.6);
    }

    /**
     * This class is immutable.
     */
    public void testCloning() {
        XYInterval i1 = new XYInterval(1.0, 2.0, 3.0, 2.5, 3.5);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYInterval i1 = new XYInterval(1.0, 2.0, 3.0, 2.5, 3.5);
        XYInterval i2 = (XYInterval) TestUtilities.serialised(i1);
    }
}
