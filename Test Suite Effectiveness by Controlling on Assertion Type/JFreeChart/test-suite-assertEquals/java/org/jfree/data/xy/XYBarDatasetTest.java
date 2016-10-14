package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Some tests for the {@link XYBarDataset} class.
 */
public class XYBarDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        DefaultXYDataset d2 = new DefaultXYDataset();
        double[] x2 = new double[] { 1.0, 2.0, 3.0 };
        double[] y2 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data2 = new double[][] { x2, y2 };
        d2.addSeries("S1", data2);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = new XYBarDataset(d2, 5.0);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = (XYBarDataset) bd1.clone();
        d1 = (DefaultXYDataset) bd1.getUnderlyingDataset();
        d1.addSeries("S2", new double[][] { { 1.0 }, { 2.0 } });
        DefaultXYDataset d2 = (DefaultXYDataset) bd2.getUnderlyingDataset();
        d2.addSeries("S2", new double[][] { { 1.0 }, { 2.0 } });
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[][] data1 = new double[][] { x1, y1 };
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = (XYBarDataset) TestUtilities.serialised(bd1);
    }
}
