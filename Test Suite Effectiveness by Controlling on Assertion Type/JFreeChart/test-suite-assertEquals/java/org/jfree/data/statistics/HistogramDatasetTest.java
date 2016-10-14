package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.junit.Test;

/**
 * Tests for the {@link HistogramDataset} class.
 */
public class HistogramDatasetTest implements DatasetChangeListener {

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks that the correct values are assigned to bins.
     */
    public void testBins() {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 6.0, 12.0, 5.0, 6.3, 4.5 };
        HistogramDataset hd = new HistogramDataset();
        hd.addSeries("Series 1", values, 5);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 6.0, 12.0, 5.0, 6.3, 4.5 };
        HistogramDataset d1 = new HistogramDataset();
        d1.addSeries("Series 1", values, 5);
        HistogramDataset d2 = new HistogramDataset();
        d2.addSeries("Series 1", values, 5);
        d1.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
        d2.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 6.0, 12.0, 5.0, 6.3, 4.5 };
        HistogramDataset d1 = new HistogramDataset();
        d1.addSeries("Series 1", values, 5);
        HistogramDataset d2 = (HistogramDataset) d1.clone();
        d1.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
        d2.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 6.0, 12.0, 5.0, 6.3, 4.5 };
        HistogramDataset d1 = new HistogramDataset();
        d1.addSeries("Series 1", values, 5);
        HistogramDataset d2 = (HistogramDataset) TestUtilities.serialised(d1);
        d1.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
        d2.addSeries("Series 2", new double[] { 1.0, 2.0, 3.0 }, 2);
    }

    /**
     * A test for a bug reported in the forum where the series name isn't being
     * returned correctly.
     */
    public void testGetSeriesKey() {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 6.0, 12.0, 5.0, 6.3, 4.5 };
        HistogramDataset d1 = new HistogramDataset();
        d1.addSeries("Series 1", values, 5);
    }

    /**
     * Some checks for the addSeries() method.
     */
    public void testAddSeries() {
        double[] values = { -1.0, 0.0, 0.1, 0.9, 1.0, 1.1, 1.9, 2.0, 3.0 };
        HistogramDataset d = new HistogramDataset();
        d.addSeries("S1", values, 2, 0.0, 2.0);
    }

    /**
     * Another check for the addSeries() method.
     */
    public void testAddSeries2() {
        double[] values = { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 };
        HistogramDataset hd = new HistogramDataset();
        hd.addSeries("S1", values, 5);
    }

    /**
     * This test is derived from a reported bug.
     */
    public void testBinBoundaries() {
        double[] values = { -5.000000000000286E-5 };
        int bins = 1260;
        double minimum = -0.06307522528160199;
        double maximum = 0.06297522528160199;
        HistogramDataset d = new HistogramDataset();
        d.addSeries("S1", values, bins, minimum, maximum);
    }

    /**
     * Some checks for bug 1553088.  An IndexOutOfBoundsException is thrown
     * when a data value is *very* close to the upper limit of the last bin.
     */
    public void test1553088() {
        double[] values = { -1.0, 0.0, -Double.MIN_VALUE, 3.0 };
        HistogramDataset d = new HistogramDataset();
        d.addSeries("S1", values, 2, -1.0, 0.0);
    }

    /**
     * A test to show the limitation addressed by patch 2902842.
     */
    public void test2902842() {
        this.lastEvent = null;
        double[] values = { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 };
        HistogramDataset hd = new HistogramDataset();
        hd.addChangeListener(this);
        hd.addSeries("S1", values, 5);
    }

    /**
     * A reference to the last event received by the datasetChanged() method.
     */
    private DatasetChangeEvent lastEvent;

    /**
     * Receives event notification.
     *
     * @param event  the event.
     */
    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        this.lastEvent = event;
    }
}
