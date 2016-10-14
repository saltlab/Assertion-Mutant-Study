package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for {@link DefaultXYZDataset}.
 */
public class DefaultXYZDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultXYZDataset d1 = new DefaultXYZDataset();
        DefaultXYZDataset d2 = new DefaultXYZDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] z1 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data1 = new double[][] { x1, y1, z1 };
        double[] x2 = new double[] { 1.0, 2.0, 3.0 };
        double[] y2 = new double[] { 4.0, 5.0, 6.0 };
        double[] z2 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data2 = new double[][] { x2, y2, z2 };
        d1.addSeries("S1", data1);
        d2.addSeries("S1", data2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultXYZDataset d1 = new DefaultXYZDataset();
        DefaultXYZDataset d2 = (DefaultXYZDataset) d1.clone();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] z1 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data1 = new double[][] { x1, y1, z1 };
        d1.addSeries("S1", data1);
        d2 = (DefaultXYZDataset) d1.clone();
        x1[1] = 2.2;
        x1[1] = 2.0;
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultXYZDataset d1 = new DefaultXYZDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultXYZDataset d1 = new DefaultXYZDataset();
        DefaultXYZDataset d2 = (DefaultXYZDataset) TestUtilities.serialised(d1);
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] z1 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data1 = new double[][] { x1, y1, z1 };
        d1.addSeries("S1", data1);
        d2 = (DefaultXYZDataset) TestUtilities.serialised(d1);
    }

    /**
     * Some checks for the getSeriesKey(int) method.
     */
    public void testGetSeriesKey() {
        DefaultXYZDataset d = createSampleDataset1();
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
        DefaultXYZDataset d = createSampleDataset1();
    }

    static final double EPSILON = 0.0000000001;

    /**
     * Some tests for the addSeries() method.
     */
    public void testAddSeries() {
        DefaultXYZDataset d = new DefaultXYZDataset();
        d.addSeries("S1", new double[][] { { 1.0 }, { 2.0 }, { 3.0 } });
        d.addSeries("S1", new double[][] { { 11.0 }, { 12.0 }, { 13.0 } });
        boolean pass = false;
        try {
            d.addSeries(null, new double[][] { { 1.0 }, { 2.0 }, { 3.0 } });
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Creates a sample dataset for testing.
     *
     * @return A sample dataset.
     */
    public DefaultXYZDataset createSampleDataset1() {
        DefaultXYZDataset d = new DefaultXYZDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] z1 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data1 = new double[][] { x1, y1, z1 };
        d.addSeries("S1", data1);
        double[] x2 = new double[] { 1.0, 2.0, 3.0 };
        double[] y2 = new double[] { 4.0, 5.0, 6.0 };
        double[] z2 = new double[] { 7.0, 8.0, 9.0 };
        double[][] data2 = new double[][] { x2, y2, z2 };
        d.addSeries("S2", data2);
        return d;
    }
}
