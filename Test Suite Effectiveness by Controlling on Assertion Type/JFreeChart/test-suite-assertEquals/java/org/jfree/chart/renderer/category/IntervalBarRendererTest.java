package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link IntervalBarRenderer} class.
 */
public class IntervalBarRendererTest {

    /**
     * Problem that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        IntervalBarRenderer r1 = new IntervalBarRenderer();
        IntervalBarRenderer r2 = new IntervalBarRenderer();
        BarRenderer br = new BarRenderer();
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        IntervalBarRenderer r1 = new IntervalBarRenderer();
        IntervalBarRenderer r2 = new IntervalBarRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        IntervalBarRenderer r1 = new IntervalBarRenderer();
        IntervalBarRenderer r2 = (IntervalBarRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        IntervalBarRenderer r1 = new IntervalBarRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        IntervalBarRenderer r1 = new IntervalBarRenderer();
        IntervalBarRenderer r2 = (IntervalBarRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Draws the chart with a {@code null} info object to make sure that
     * no exceptions are thrown (particularly by code in the renderer).
     */
    public void testDrawWithNullInfo() {
        try {
            double[][] starts = new double[][] { { 0.1, 0.2, 0.3 }, { 0.3, 0.4, 0.5 } };
            double[][] ends = new double[][] { { 0.5, 0.6, 0.7 }, { 0.7, 0.8, 0.9 } };
            DefaultIntervalCategoryDataset dataset = new DefaultIntervalCategoryDataset(starts, ends);
            IntervalBarRenderer renderer = new IntervalBarRenderer();
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), renderer);
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, null);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        IntervalBarRenderer r = new IntervalBarRenderer();
        DefaultIntervalCategoryDataset dataset = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        double[][] starts = new double[][] { { 0.1, 0.2, 0.3 }, { 0.3, 0.4, 0.5 } };
        double[][] ends = new double[][] { { 0.5, 0.6, 0.7 }, { 0.7, 0.8, 0.9 } };
        dataset = new DefaultIntervalCategoryDataset(starts, ends);
        r.setIncludeBaseInRange(false);
        r.setIncludeBaseInRange(true);
        r.setSeriesVisible(1, Boolean.FALSE);
    }
}
