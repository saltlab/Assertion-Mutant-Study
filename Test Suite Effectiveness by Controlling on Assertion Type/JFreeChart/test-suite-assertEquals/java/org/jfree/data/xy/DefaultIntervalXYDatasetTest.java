package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Some tests for the {@link DefaultIntervalXYDataset} class.
 */
public class DefaultIntervalXYDatasetTest {

    /**
     * Some checks for the getSeriesCount() method.
     */
    public void testGetSeriesCount() {
        DefaultIntervalXYDataset d = new DefaultIntervalXYDataset();
        d = createSampleDataset1();
    }

    /**
     * Some checks for the getSeriesKey(int) method.
     */
    public void testGetSeriesKey() {
        DefaultIntervalXYDataset d = createSampleDataset1();
        boolean pass = false;
        try {
            d.getSeriesKey(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            d.getSeriesKey(2);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getItemCount() method.
     */
    public void testGetItemCount() {
        DefaultIntervalXYDataset d = createSampleDataset1();
        boolean pass = false;
        try {
            d.getItemCount(2);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the getXValue() method.
     */
    public void testGetXValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some checks for the getYValue() method.
     */
    public void testGetYValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some checks for the getStartXValue() method.
     */
    public void testGetStartXValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some checks for the getEndXValue() method.
     */
    public void testGetEndXValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some checks for the getStartYValue() method.
     */
    public void testGetStartYValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some checks for the getEndYValue() method.
     */
    public void testGetEndYValue() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset();
        DefaultIntervalXYDataset d2 = new DefaultIntervalXYDataset();
        d1 = createSampleDataset1();
        d2 = createSampleDataset1();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset();
        DefaultIntervalXYDataset d2 = (DefaultIntervalXYDataset) d1.clone();
        d1 = createSampleDataset1();
        d2 = (DefaultIntervalXYDataset) d1.clone();
    }

    /**
     * Another test for cloning.
     */
    public void testCloning2() throws CloneNotSupportedException {
        DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        d1.addSeries("S1", data1);
        DefaultIntervalXYDataset d2 = (DefaultIntervalXYDataset) d1.clone();
        x1[0] = 111.1;
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset();
        DefaultIntervalXYDataset d2 = (DefaultIntervalXYDataset) TestUtilities.serialised(d1);
        d1 = createSampleDataset1();
        d2 = (DefaultIntervalXYDataset) TestUtilities.serialised(d1);
    }

    /**
     * Some checks for the indexOf(Comparable) method.
     */
    public void testIndexOf() {
        DefaultIntervalXYDataset d = createSampleDataset1();
    }

    /**
     * Some tests for the addSeries() method.
     */
    public void testAddSeries() {
        DefaultIntervalXYDataset d = new DefaultIntervalXYDataset();
        d.addSeries("S1", new double[][] { { 1.0 }, { 0.5 }, { 1.5 }, { 2.0 }, { 2.5 }, { 1.5 } });
        d.addSeries("S1", new double[][] { { 1.1 }, { 0.6 }, { 1.6 }, { 2.1 }, { 2.6 }, { 1.6 } });
        boolean pass = false;
        try {
            d.addSeries(null, new double[][] { { 1.1 }, { 0.6 }, { 1.6 }, { 2.1 }, { 2.6 }, { 1.6 } });
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Creates a sample dataset for testing.
     *
     * @return A sample dataset.
     */
    public DefaultIntervalXYDataset createSampleDataset1() {
        DefaultIntervalXYDataset d = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        d.addSeries("S1", data1);
        double[] x2 = new double[] { 11.0, 12.0, 13.0 };
        double[] x2Start = new double[] { 10.9, 11.9, 12.9 };
        double[] x2End = new double[] { 11.1, 12.1, 13.1 };
        double[] y2 = new double[] { 14.0, 15.0, 16.0 };
        double[] y2Start = new double[] { 11.09, 12.09, 13.09 };
        double[] y2End = new double[] { 11.11, 12.11, 13.11 };
        double[][] data2 = new double[][] { x2, x2Start, x2End, y2, y2Start, y2End };
        d.addSeries("S2", data2);
        return d;
    }
}
