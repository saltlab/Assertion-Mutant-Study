package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for {@link DefaultXYDataset}.
 */
public class DefaultXYDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        DefaultXYDataset d2 = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        double[] x2 = new double[] { 1.0, 2.0, 3.0 };
        double[] y2 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data2 = new double[][] { x2, y2 };
        d1.addSeries("S1", data1);
        d2.addSeries("S1", data2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultXYDataset d1 = new DefaultXYDataset();
        DefaultXYDataset d2 = (DefaultXYDataset) d1.clone();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        d2 = (DefaultXYDataset) d1.clone();
        x1[1] = 2.2;
        x1[1] = 2.0;
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultXYDataset d1 = new DefaultXYDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        DefaultXYDataset d2 = (DefaultXYDataset) TestUtilities.serialised(d1);
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        d2 = (DefaultXYDataset) TestUtilities.serialised(d1);
        assertEquals(d1, d2);
    }

    /**
     * Some checks for the getSeriesKey(int) method.
     */
    public void testGetSeriesKey() {
        DefaultXYDataset d = createSampleDataset1();
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
     * Some checks for the indexOf(Comparable) method.
     */
    public void testIndexOf() {
        DefaultXYDataset d = createSampleDataset1();
    }

    static final double EPSILON = 0.0000000001;

    /**
     * Some tests for the addSeries() method.
     */
    public void testAddSeries() {
        DefaultXYDataset d = new DefaultXYDataset();
        d.addSeries("S1", new double[][] { { 1.0 }, { 2.0 } });
        d.addSeries("S1", new double[][] { { 11.0 }, { 12.0 } });
        boolean pass = false;
        try {
            d.addSeries(null, new double[][] { { 1.0 }, { 2.0 } });
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Creates a sample dataset for testing.
     *
     * @return A sample dataset.
     */
    public DefaultXYDataset createSampleDataset1() {
        DefaultXYDataset d = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d.addSeries("S1", data1);
        double[] x2 = new double[] { 1.0, 2.0, 3.0 };
        double[] y2 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data2 = new double[][] { x2, y2 };
        d.addSeries("S2", data2);
        return d;
    }
}
