package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link SimpleHistogramDataset} class.
 */
public class SimpleHistogramDatasetTest {

    /**
     * Ensure that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        SimpleHistogramDataset d1 = new SimpleHistogramDataset("Dataset 1");
        SimpleHistogramDataset d2 = new SimpleHistogramDataset("Dataset 1");
        d1.addBin(new SimpleHistogramBin(1.0, 2.0));
        d2.addBin(new SimpleHistogramBin(1.0, 2.0));
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        SimpleHistogramDataset d1 = new SimpleHistogramDataset("Dataset 1");
        SimpleHistogramDataset d2 = (SimpleHistogramDataset) d1.clone();
        d2.addBin(new SimpleHistogramBin(2.0, 3.0));
        d2.addObservation(2.3);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        SimpleHistogramDataset d1 = new SimpleHistogramDataset("D1");
        SimpleHistogramDataset d2 = (SimpleHistogramDataset) TestUtilities.serialised(d1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the clearObservations() method.
     */
    public void testClearObservations() {
        SimpleHistogramDataset d1 = new SimpleHistogramDataset("D1");
        d1.clearObservations();
        d1.addBin(new SimpleHistogramBin(0.0, 1.0));
        d1.addObservation(0.5);
    }

    /**
     * Some checks for the removeAllBins() method.
     */
    public void testRemoveAllBins() {
        SimpleHistogramDataset d1 = new SimpleHistogramDataset("D1");
        d1.addBin(new SimpleHistogramBin(0.0, 1.0));
        d1.addObservation(0.5);
        d1.addBin(new SimpleHistogramBin(2.0, 3.0));
        d1.removeAllBins();
    }
}
