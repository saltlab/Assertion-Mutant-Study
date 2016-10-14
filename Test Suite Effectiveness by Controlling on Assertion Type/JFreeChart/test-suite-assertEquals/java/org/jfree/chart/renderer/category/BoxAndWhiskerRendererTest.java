package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link BoxAndWhiskerRenderer} class.
 */
public class BoxAndWhiskerRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        BoxAndWhiskerRenderer r1 = new BoxAndWhiskerRenderer();
        BoxAndWhiskerRenderer r2 = new BoxAndWhiskerRenderer();
        r1.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.blue));
        r2.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.blue));
        r1.setFillBox(!r1.getFillBox());
        r2.setFillBox(!r2.getFillBox());
        r1.setItemMargin(0.11);
        r2.setItemMargin(0.11);
        r1.setMaximumBarWidth(0.99);
        r2.setMaximumBarWidth(0.99);
        r1.setMeanVisible(false);
        r2.setMeanVisible(false);
        r1.setMedianVisible(false);
        r2.setMedianVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        BoxAndWhiskerRenderer r1 = new BoxAndWhiskerRenderer();
        BoxAndWhiskerRenderer r2 = new BoxAndWhiskerRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BoxAndWhiskerRenderer r1 = new BoxAndWhiskerRenderer();
        BoxAndWhiskerRenderer r2 = (BoxAndWhiskerRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        BoxAndWhiskerRenderer r1 = new BoxAndWhiskerRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BoxAndWhiskerRenderer r1 = new BoxAndWhiskerRenderer();
        BoxAndWhiskerRenderer r2 = (BoxAndWhiskerRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Draws the chart with a {@code null} info object to make sure that
     * no exceptions are thrown (particularly by code in the renderer).
     */
    public void testDrawWithNullInfo() {
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(0.0), new Double(4.0), new Double(0.5), new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, null);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * A check for bug 1572478 (for the vertical orientation).
     */
    public void testBug1572478Vertical() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset() {

            @Override
            public Number getQ1Value(int row, int column) {
                return null;
            }

            @Override
            public Number getQ1Value(Comparable rowKey, Comparable columnKey) {
                return null;
            }
        };
        List values = new ArrayList();
        values.add(new Double(1.0));
        values.add(new Double(10.0));
        values.add(new Double(100.0));
        dataset.add(values, "row", "column");
        CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("x"), new NumberAxis("y"), new BoxAndWhiskerRenderer());
        JFreeChart chart = new JFreeChart(plot);
        boolean success;
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, new ChartRenderingInfo());
            g2.dispose();
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * A check for bug 1572478 (for the horizontal orientation).
     */
    public void testBug1572478Horizontal() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset() {

            @Override
            public Number getQ1Value(int row, int column) {
                return null;
            }

            @Override
            public Number getQ1Value(Comparable rowKey, Comparable columnKey) {
                return null;
            }
        };
        List values = new ArrayList();
        values.add(new Double(1.0));
        values.add(new Double(10.0));
        values.add(new Double(100.0));
        dataset.add(values, "row", "column");
        CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("x"), new NumberAxis("y"), new BoxAndWhiskerRenderer());
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart chart = new JFreeChart(plot);
        boolean success;
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, new ChartRenderingInfo());
            g2.dispose();
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Some checks for the getLegendItem() method.
     */
    public void testGetLegendItem() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        List values = new ArrayList();
        values.add(new Double(1.10));
        values.add(new Double(1.45));
        values.add(new Double(1.33));
        values.add(new Double(1.23));
        dataset.add(values, "R1", "C1");
        BoxAndWhiskerRenderer r = new BoxAndWhiskerRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("x"), new NumberAxis("y"), r);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(0, 0);
        r.setSeriesVisibleInLegend(0, Boolean.FALSE);
        li = r.getLegendItem(0, 0);
    }

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    public void testGetLegendItemSeriesIndex() {
        DefaultCategoryDataset dataset0 = new DefaultCategoryDataset();
        dataset0.addValue(21.0, "R1", "C1");
        dataset0.addValue(22.0, "R2", "C1");
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        dataset1.addValue(23.0, "R3", "C1");
        dataset1.addValue(24.0, "R4", "C1");
        dataset1.addValue(25.0, "R5", "C1");
        BoxAndWhiskerRenderer r = new BoxAndWhiskerRenderer();
        CategoryPlot plot = new CategoryPlot(dataset0, new CategoryAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, dataset1);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }

    /**
     * Draws a chart where the dataset contains a null mean value.
     */
    public void testDrawWithNullMean() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(null, new Double(2.0), new Double(0.0), new Double(4.0), new Double(0.5), new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null median value.
     */
    public void testDrawWithNullMedian() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), null, new Double(0.0), new Double(4.0), new Double(0.5), new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null Q1 value.
     */
    public void testDrawWithNullQ1() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), null, new Double(4.0), new Double(0.5), new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null Q3 value.
     */
    public void testDrawWithNullQ3() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), null, new Double(0.5), new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null min regular value.
     */
    public void testDrawWithNullMinRegular() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), null, new Double(4.5), new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null max regular value.
     */
    public void testDrawWithNullMaxRegular() {
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(0.5), null, new Double(-0.5), new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * Draws a chart where the dataset contains a null min outlier value.
     */
    public void testDrawWithNullMinOutlier() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(0.5), new Double(4.5), null, new Double(5.5), null), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    /**
     * Draws a chart where the dataset contains a null max outlier value.
     */
    public void testDrawWithNullMaxOutlier() {
        boolean success;
        try {
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(0.5), new Double(4.5), new Double(-0.5), null, new java.util.ArrayList()), "S1", "C1");
            CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("Category"), new NumberAxis("Value"), new BoxAndWhiskerRenderer());
            ChartRenderingInfo info = new ChartRenderingInfo();
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, info);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }
}
