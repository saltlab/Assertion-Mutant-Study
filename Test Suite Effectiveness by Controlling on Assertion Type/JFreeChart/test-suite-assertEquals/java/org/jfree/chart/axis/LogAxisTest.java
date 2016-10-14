package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;
import org.junit.Test;

/**
 * Tests for the {@link LogAxis} class.
 */
public class LogAxisTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LogAxis a1 = new LogAxis("Test");
        LogAxis a2 = (LogAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        LogAxis a1 = new LogAxis("Test");
        LogAxis a2 = new LogAxis("Test");
        a1.setBase(2.0);
        a2.setBase(2.0);
        a1.setSmallestValue(0.1);
        a2.setSmallestValue(0.1);
        a1.setMinorTickCount(8);
        a2.setMinorTickCount(8);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        LogAxis a1 = new LogAxis("Test");
        LogAxis a2 = new LogAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    private static final double EPSILON = 0.0000001;

    /**
     * Test the translation of Java2D values to data values.
     */
    public void testTranslateJava2DToValue() {
        LogAxis axis = new LogAxis();
        axis.setRange(50.0, 100.0);
        Rectangle2D dataArea = new Rectangle2D.Double(10.0, 50.0, 400.0, 300.0);
        double y1 = axis.java2DToValue(75.0, dataArea, RectangleEdge.LEFT);
        double y2 = axis.java2DToValue(75.0, dataArea, RectangleEdge.RIGHT);
        double x1 = axis.java2DToValue(75.0, dataArea, RectangleEdge.TOP);
        double x2 = axis.java2DToValue(75.0, dataArea, RectangleEdge.BOTTOM);
        axis.setInverted(true);
        double y3 = axis.java2DToValue(75.0, dataArea, RectangleEdge.LEFT);
        double y4 = axis.java2DToValue(75.0, dataArea, RectangleEdge.RIGHT);
        double x3 = axis.java2DToValue(75.0, dataArea, RectangleEdge.TOP);
        double x4 = axis.java2DToValue(75.0, dataArea, RectangleEdge.BOTTOM);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LogAxis a1 = new LogAxis("Test Axis");
        LogAxis a2 = (LogAxis) TestUtilities.serialised(a1);
    }

    /**
     * A simple test for the auto-range calculation looking at a
     * LogAxis used as the range axis for a CategoryPlot.
     */
    public void testAutoRange1() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100.0, "Row 1", "Column 1");
        dataset.setValue(200.0, "Row 1", "Column 2");
        JFreeChart chart = ChartFactory.createBarChart("Test", "Categories", "Value", dataset);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LogAxis axis = new LogAxis("Log(Y)");
        plot.setRangeAxis(axis);
    }

    /**
     * A simple test for the auto-range calculation looking at a
     * NumberAxis used as the range axis for a CategoryPlot.  In this
     * case, the original dataset is replaced with a new dataset.
     */
    public void testAutoRange3() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100.0, "Row 1", "Column 1");
        dataset.setValue(200.0, "Row 1", "Column 2");
        JFreeChart chart = ChartFactory.createLineChart("Test", "Categories", "Value", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LogAxis axis = new LogAxis("Log(Y)");
        plot.setRangeAxis(axis);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(900.0, "Row 1", "Column 1");
        dataset2.setValue(1000.0, "Row 1", "Column 2");
        plot.setDataset(dataset2);
    }

    /**
     * Checks that the auto-range for the domain axis on an XYPlot is
     * working as expected.
     */
    public void testXYAutoRange1() {
        XYSeries series = new XYSeries("Series 1");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createScatterPlot("Test", "X", "Y", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        LogAxis axis = new LogAxis("Log(Y)");
        plot.setRangeAxis(axis);
    }

    /**
     * Checks that the auto-range for the range axis on an XYPlot is
     * working as expected.
     */
    public void testXYAutoRange2() {
        XYSeries series = new XYSeries("Series 1");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createScatterPlot("Test", "X", "Y", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        LogAxis axis = new LogAxis("Log(Y)");
        plot.setRangeAxis(axis);
    }

    /**
     * Some checks for the setLowerBound() method.
     */
    public void testSetLowerBound() {
        LogAxis axis = new LogAxis("X");
        axis.setRange(0.0, 10.0);
        axis.setLowerBound(5.0);
        axis.setLowerBound(10.0);
    }

    /**
     * Checks the default value for the tickMarksVisible flag.
     */
    public void testTickMarksVisibleDefault() {
        LogAxis axis = new LogAxis("Log Axis");
    }

    /**
     * Checks that a TickUnit with a size of 0 doesn't crash.
     */
    public void testRefreshTicksWithZeroTickUnit() {
        LogAxis axis = new LogAxis();
        AxisState state = new AxisState();
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D area = new Rectangle2D.Double(0.0, 0.0, 200, 100);
        axis.refreshTicks(g2, state, area, RectangleEdge.TOP);
    }
}
