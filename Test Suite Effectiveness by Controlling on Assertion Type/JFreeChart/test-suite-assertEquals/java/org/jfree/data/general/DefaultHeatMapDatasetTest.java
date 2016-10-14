package org.jfree.data.general;

import org.jfree.chart.TestUtilities;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Somes tests for the {@link DefaultHeatMapDataset} class.
 *
 * @since 1.0.13
 */
public class DefaultHeatMapDatasetTest implements DatasetChangeListener {

    /** The last event received. */
    private DatasetChangeEvent lastEvent;

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        this.lastEvent = event;
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some general tests.
     */
    public void testGeneral() {
        DefaultHeatMapDataset d = new DefaultHeatMapDataset(10, 5, 0.0, 9.0, 0.0, 5.0);
        d.addChangeListener(this);
        d.setZValue(0, 0, 1.0, false);
        d.setZValue(1, 2, 2.0);
    }

    /**
     * Some tests for the equals() method.
     */
    public void testEquals() {
        DefaultHeatMapDataset d1 = new DefaultHeatMapDataset(5, 10, 1.0, 2.0, 3.0, 4.0);
        DefaultHeatMapDataset d2 = new DefaultHeatMapDataset(5, 10, 1.0, 2.0, 3.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 10, 1.0, 2.0, 3.0, 4.0);
        d2 = new DefaultHeatMapDataset(6, 10, 1.0, 2.0, 3.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 11, 1.0, 2.0, 3.0, 4.0);
        d2 = new DefaultHeatMapDataset(6, 11, 1.0, 2.0, 3.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 11, 2.0, 2.0, 3.0, 4.0);
        d2 = new DefaultHeatMapDataset(6, 11, 2.0, 2.0, 3.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 3.0, 4.0);
        d2 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 3.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 4.0, 4.0);
        d2 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 4.0, 4.0);
        d1 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 4.0, 5.0);
        d2 = new DefaultHeatMapDataset(6, 11, 2.0, 3.0, 4.0, 5.0);
        d1.setZValue(1, 2, 3.0);
        d2.setZValue(1, 2, 3.0);
        d1.setZValue(0, 0, Double.NEGATIVE_INFINITY);
        d2.setZValue(0, 0, Double.NEGATIVE_INFINITY);
        d1.setZValue(0, 1, Double.POSITIVE_INFINITY);
        d2.setZValue(0, 1, Double.POSITIVE_INFINITY);
        d1.setZValue(0, 2, Double.NaN);
        d2.setZValue(0, 2, Double.NaN);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultHeatMapDataset d1 = new DefaultHeatMapDataset(2, 3, -1.0, 4.0, -2.0, 5.0);
        d1.setZValue(0, 0, 10.0);
        d1.setZValue(0, 1, Double.NEGATIVE_INFINITY);
        d1.setZValue(0, 2, Double.POSITIVE_INFINITY);
        d1.setZValue(1, 0, Double.NaN);
        DefaultHeatMapDataset d2 = (DefaultHeatMapDataset) d1.clone();
        d1.setZValue(0, 0, 11.0);
        d2.setZValue(0, 0, 11.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultHeatMapDataset d1 = new DefaultHeatMapDataset(2, 3, -1.0, 4.0, -2.0, 5.0);
        d1.setZValue(0, 0, 10.0);
        d1.setZValue(0, 1, Double.NEGATIVE_INFINITY);
        d1.setZValue(0, 2, Double.POSITIVE_INFINITY);
        d1.setZValue(1, 0, Double.NaN);
        DefaultHeatMapDataset d2 = (DefaultHeatMapDataset) TestUtilities.serialised(d1);
    }
}
