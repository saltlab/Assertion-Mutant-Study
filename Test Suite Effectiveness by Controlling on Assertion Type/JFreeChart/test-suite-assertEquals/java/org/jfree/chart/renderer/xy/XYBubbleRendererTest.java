package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYBubbleRenderer} class.
 */
public class XYBubbleRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYBubbleRenderer r1 = new XYBubbleRenderer();
        XYBubbleRenderer r2 = new XYBubbleRenderer();
        r1 = new XYBubbleRenderer(XYBubbleRenderer.SCALE_ON_RANGE_AXIS);
        r2 = new XYBubbleRenderer(XYBubbleRenderer.SCALE_ON_RANGE_AXIS);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYBubbleRenderer r1 = new XYBubbleRenderer();
        XYBubbleRenderer r2 = new XYBubbleRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYBubbleRenderer r1 = new XYBubbleRenderer();
        XYBubbleRenderer r2 = (XYBubbleRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYBubbleRenderer r1 = new XYBubbleRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYBubbleRenderer r1 = new XYBubbleRenderer();
        XYBubbleRenderer r2 = (XYBubbleRenderer) TestUtilities.serialised(r1);
    }

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    public void testGetLegendItemSeriesIndex() {
        DefaultXYZDataset d1 = new DefaultXYZDataset();
        double[] x = { 2.1, 2.3, 2.3, 2.2, 2.2, 1.8, 1.8, 1.9, 2.3, 3.8 };
        double[] y = { 14.1, 11.1, 10.0, 8.8, 8.7, 8.4, 5.4, 4.1, 4.1, 25 };
        double[] z = { 2.4, 2.7, 2.7, 2.2, 2.2, 2.2, 2.1, 2.2, 1.6, 4 };
        double[][] s1 = new double[][] { x, y, z };
        d1.addSeries("S1", s1);
        x = new double[] { 2.1 };
        y = new double[] { 14.1 };
        z = new double[] { 2.4 };
        double[][] s2 = new double[][] { x, y, z };
        d1.addSeries("S2", s2);
        DefaultXYZDataset d2 = new DefaultXYZDataset();
        x = new double[] { 2.1 };
        y = new double[] { 14.1 };
        z = new double[] { 2.4 };
        double[][] s3 = new double[][] { x, y, z };
        d2.addSeries("S3", s3);
        x = new double[] { 2.1 };
        y = new double[] { 14.1 };
        z = new double[] { 2.4 };
        double[][] s4 = new double[][] { x, y, z };
        d2.addSeries("S4", s4);
        x = new double[] { 2.1 };
        y = new double[] { 14.1 };
        z = new double[] { 2.4 };
        double[][] s5 = new double[][] { x, y, z };
        d2.addSeries("S5", s5);
        XYBubbleRenderer r = new XYBubbleRenderer();
        XYPlot plot = new XYPlot(d1, new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, d2);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
