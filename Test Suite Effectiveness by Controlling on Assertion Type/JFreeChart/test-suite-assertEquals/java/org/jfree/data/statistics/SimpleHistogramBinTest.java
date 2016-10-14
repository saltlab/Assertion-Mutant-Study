package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link SimpleHistogramBin} class.
 */
public class SimpleHistogramBinTest {

    /**
     * Some checks for the accepts() method.
     */
    public void testAccepts() {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(1.0, 2.0);
        SimpleHistogramBin bin2 = new SimpleHistogramBin(1.0, 2.0, false, false);
    }

    /**
     * Some checks for the overlapsWith() method.
     */
    public void testOverlapsWidth() {
        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0);
        SimpleHistogramBin b2 = new SimpleHistogramBin(2.0, 3.0);
        SimpleHistogramBin b3 = new SimpleHistogramBin(3.0, 4.0);
        SimpleHistogramBin b4 = new SimpleHistogramBin(0.0, 5.0);
        SimpleHistogramBin b5 = new SimpleHistogramBin(2.0, 3.0, false, true);
        SimpleHistogramBin b6 = new SimpleHistogramBin(2.0, 3.0, true, false);
    }

    /**
     * Ensure that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0);
        SimpleHistogramBin b2 = new SimpleHistogramBin(1.0, 2.0);
        b1 = new SimpleHistogramBin(1.1, 2.0, true, true);
        b2 = new SimpleHistogramBin(1.1, 2.0, true, true);
        b1 = new SimpleHistogramBin(1.1, 2.2, true, true);
        b2 = new SimpleHistogramBin(1.1, 2.2, true, true);
        b1 = new SimpleHistogramBin(1.1, 2.2, false, true);
        b2 = new SimpleHistogramBin(1.1, 2.2, false, true);
        b1 = new SimpleHistogramBin(1.1, 2.2, false, false);
        b2 = new SimpleHistogramBin(1.1, 2.2, false, false);
        b1.setItemCount(99);
        b2.setItemCount(99);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        SimpleHistogramBin b1 = new SimpleHistogramBin(1.1, 2.2, false, true);
        b1.setItemCount(99);
        SimpleHistogramBin b2 = (SimpleHistogramBin) b1.clone();
        b2.setItemCount(111);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0, false, true);
        b1.setItemCount(123);
        SimpleHistogramBin b2 = (SimpleHistogramBin) TestUtilities.serialised(b1);
    }
}
