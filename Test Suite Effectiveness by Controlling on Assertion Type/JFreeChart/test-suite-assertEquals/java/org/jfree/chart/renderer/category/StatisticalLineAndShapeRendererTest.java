package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.Range;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StatisticalLineAndShapeRenderer} class.
 */
public class StatisticalLineAndShapeRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        StatisticalLineAndShapeRenderer r1 = new StatisticalLineAndShapeRenderer();
        StatisticalLineAndShapeRenderer r2 = new StatisticalLineAndShapeRenderer();
        r1.setErrorIndicatorPaint(Color.red);
        r2.setErrorIndicatorPaint(Color.red);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        StatisticalLineAndShapeRenderer r1 = new StatisticalLineAndShapeRenderer();
        StatisticalLineAndShapeRenderer r2 = new StatisticalLineAndShapeRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StatisticalLineAndShapeRenderer r1 = new StatisticalLineAndShapeRenderer();
        StatisticalLineAndShapeRenderer r2 = (StatisticalLineAndShapeRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StatisticalLineAndShapeRenderer r1 = new StatisticalLineAndShapeRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StatisticalLineAndShapeRenderer r1 = new StatisticalLineAndShapeRenderer();
        StatisticalLineAndShapeRenderer r2 = (StatisticalLineAndShapeRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Draws the chart with a {@code null} info object to make sure that
     * no exceptions are thrown (particularly by code in the renderer).
     */
    public void testDrawWithNullInfo() {
        try {
            DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
            dataset.add(1.0, 2.0, "S1", "C1");
            dataset.add(3.0, 4.0, "S1", "C2");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new StatisticalLineAndShapeRenderer());
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, null);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * A simple test for bug report 1562759.
     */
    public void test1562759() {
        StatisticalLineAndShapeRenderer r = new StatisticalLineAndShapeRenderer(true, false);
        r = new StatisticalLineAndShapeRenderer(false, true);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        StatisticalLineAndShapeRenderer r = new StatisticalLineAndShapeRenderer();
        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
        dataset.add(1.0, 0.5, "R1", "C1");
        dataset.add(-2.0, 0.2, "R1", "C2");
        dataset.add(null, null, "R1", "C3");
        dataset.add(5.0, 1.0, "R2", "C3");
        r.setSeriesVisible(1, Boolean.FALSE);
    }
}
