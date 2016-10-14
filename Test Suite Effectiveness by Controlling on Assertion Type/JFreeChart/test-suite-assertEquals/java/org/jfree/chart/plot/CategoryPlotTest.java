package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.annotations.CategoryLineAnnotation;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.SortOrder;

/**
 * Tests for the {@link CategoryPlot} class.
 */
public class CategoryPlotTest {

    /**
     * Some checks for the constructor.
     */
    public void testConstructor() {
        CategoryPlot plot = new CategoryPlot();
    }

    /**
     * A test for a bug reported in the forum.
     */
    public void testAxisRange() {
        DefaultCategoryDataset datasetA = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetB = new DefaultCategoryDataset();
        datasetB.addValue(50.0, "R1", "C1");
        datasetB.addValue(80.0, "R1", "C1");
        CategoryPlot plot = new CategoryPlot(datasetA, new CategoryAxis(null), new NumberAxis(null), new LineAndShapeRenderer());
        plot.setDataset(1, datasetB);
        plot.setRenderer(1, new LineAndShapeRenderer());
        Range r = plot.getRangeAxis().getRange();
    }

    /**
     * Test that the equals() method differentiates all the required fields.
     */
    public void testEquals() {
        CategoryPlot plot1 = new CategoryPlot();
        CategoryPlot plot2 = new CategoryPlot();
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
        plot2.setOrientation(PlotOrientation.HORIZONTAL);
        plot1.setAxisOffset(new RectangleInsets(0.05, 0.05, 0.05, 0.05));
        plot2.setAxisOffset(new RectangleInsets(0.05, 0.05, 0.05, 0.05));
        plot1.setDomainAxis(new CategoryAxis("Category Axis"));
        plot2.setDomainAxis(new CategoryAxis("Category Axis"));
        plot1.setDomainAxis(11, new CategoryAxis("Secondary Axis"));
        plot2.setDomainAxis(11, new CategoryAxis("Secondary Axis"));
        plot1.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot2.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot1.setDomainAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot2.setDomainAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot1.setDrawSharedDomainAxis(!plot1.getDrawSharedDomainAxis());
        plot2.setDrawSharedDomainAxis(!plot2.getDrawSharedDomainAxis());
        plot1.setRangeAxis(new NumberAxis("Range Axis"));
        plot2.setRangeAxis(new NumberAxis("Range Axis"));
        plot1.setRangeAxis(11, new NumberAxis("Secondary Range Axis"));
        plot2.setRangeAxis(11, new NumberAxis("Secondary Range Axis"));
        plot1.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot2.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot1.setRangeAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot2.setRangeAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot1.mapDatasetToDomainAxis(11, 11);
        plot2.mapDatasetToDomainAxis(11, 11);
        plot1.mapDatasetToRangeAxis(11, 11);
        plot2.mapDatasetToRangeAxis(11, 11);
        plot1.setRenderer(new AreaRenderer());
        plot2.setRenderer(new AreaRenderer());
        plot1.setRenderer(11, new AreaRenderer());
        plot2.setRenderer(11, new AreaRenderer());
        plot1.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        plot2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        plot1.setColumnRenderingOrder(SortOrder.DESCENDING);
        plot2.setColumnRenderingOrder(SortOrder.DESCENDING);
        plot1.setRowRenderingOrder(SortOrder.DESCENDING);
        plot2.setRowRenderingOrder(SortOrder.DESCENDING);
        plot1.setDomainGridlinesVisible(true);
        plot2.setDomainGridlinesVisible(true);
        plot1.setDomainGridlinePosition(CategoryAnchor.END);
        plot2.setDomainGridlinePosition(CategoryAnchor.END);
        Stroke stroke = new BasicStroke(2.0f);
        plot1.setDomainGridlineStroke(stroke);
        plot2.setDomainGridlineStroke(stroke);
        plot1.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        plot2.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        plot1.setRangeGridlinesVisible(false);
        plot2.setRangeGridlinesVisible(false);
        plot1.setRangeGridlineStroke(stroke);
        plot2.setRangeGridlineStroke(stroke);
        plot1.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        plot2.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        plot1.setAnchorValue(100.0);
        plot2.setAnchorValue(100.0);
        plot1.setRangeCrosshairVisible(true);
        plot2.setRangeCrosshairVisible(true);
        plot1.setRangeCrosshairValue(100.0);
        plot2.setRangeCrosshairValue(100.0);
        plot1.setRangeCrosshairStroke(stroke);
        plot2.setRangeCrosshairStroke(stroke);
        plot1.setRangeCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow));
        plot2.setRangeCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow));
        plot1.setRangeCrosshairLockedOnData(false);
        plot2.setRangeCrosshairLockedOnData(false);
        plot1.addDomainMarker(new CategoryMarker("C1"), Layer.FOREGROUND);
        plot2.addDomainMarker(new CategoryMarker("C1"), Layer.FOREGROUND);
        plot1.addDomainMarker(new CategoryMarker("C2"), Layer.BACKGROUND);
        plot2.addDomainMarker(new CategoryMarker("C2"), Layer.BACKGROUND);
        plot1.addRangeMarker(new ValueMarker(4.0), Layer.FOREGROUND);
        plot2.addRangeMarker(new ValueMarker(4.0), Layer.FOREGROUND);
        plot1.addRangeMarker(new ValueMarker(5.0), Layer.BACKGROUND);
        plot2.addRangeMarker(new ValueMarker(5.0), Layer.BACKGROUND);
        plot1.addRangeMarker(1, new ValueMarker(4.0), Layer.FOREGROUND);
        plot2.addRangeMarker(1, new ValueMarker(4.0), Layer.FOREGROUND);
        plot1.addRangeMarker(1, new ValueMarker(5.0), Layer.BACKGROUND);
        plot2.addRangeMarker(1, new ValueMarker(5.0), Layer.BACKGROUND);
        plot1.addAnnotation(new CategoryTextAnnotation("Text", "Category", 43.0));
        plot2.addAnnotation(new CategoryTextAnnotation("Text", "Category", 43.0));
        plot1.setWeight(3);
        plot2.setWeight(3);
        plot1.setFixedDomainAxisSpace(new AxisSpace());
        plot2.setFixedDomainAxisSpace(new AxisSpace());
        plot1.setFixedRangeAxisSpace(new AxisSpace());
        plot2.setFixedRangeAxisSpace(new AxisSpace());
        plot1.setFixedLegendItems(new LegendItemCollection());
        plot2.setFixedLegendItems(new LegendItemCollection());
        plot1.setCrosshairDatasetIndex(99);
        plot2.setCrosshairDatasetIndex(99);
        plot1.setDomainCrosshairColumnKey("A");
        plot2.setDomainCrosshairColumnKey("A");
        plot1.setDomainCrosshairRowKey("B");
        plot2.setDomainCrosshairRowKey("B");
        plot1.setDomainCrosshairVisible(true);
        plot2.setDomainCrosshairVisible(true);
        plot1.setDomainCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setDomainCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setDomainCrosshairStroke(new BasicStroke(1.23f));
        plot2.setDomainCrosshairStroke(new BasicStroke(1.23f));
        plot1.setRangeMinorGridlinesVisible(true);
        plot2.setRangeMinorGridlinesVisible(true);
        plot1.setRangeMinorGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setRangeMinorGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setRangeMinorGridlineStroke(new BasicStroke(1.23f));
        plot2.setRangeMinorGridlineStroke(new BasicStroke(1.23f));
        plot1.setRangeZeroBaselineVisible(!plot1.isRangeZeroBaselineVisible());
        plot2.setRangeZeroBaselineVisible(!plot2.isRangeZeroBaselineVisible());
        plot1.setRangeZeroBaselinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setRangeZeroBaselinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setRangeZeroBaselineStroke(new BasicStroke(1.23f));
        plot2.setRangeZeroBaselineStroke(new BasicStroke(1.23f));
        plot1.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot2.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot1.setShadowGenerator(null);
        plot2.setShadowGenerator(null);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setDomainAxis(new CategoryAxis("A"));
        CategoryPlot p2 = new CategoryPlot();
        p2.setDomainAxis(new CategoryAxis("A"));
        p2.setDomainAxis(1, new CategoryAxis("B"));
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList2() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        CategoryPlot p2 = new CategoryPlot();
        p2.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        p2.setDomainAxisLocation(1, AxisLocation.TOP_OR_LEFT);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList3() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setRangeAxis(new NumberAxis("A"));
        CategoryPlot p2 = new CategoryPlot();
        p2.setRangeAxis(new NumberAxis("A"));
        p2.setRangeAxis(1, new NumberAxis("B"));
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList4() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        CategoryPlot p2 = new CategoryPlot();
        p2.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        p2.setRangeAxisLocation(1, AxisLocation.TOP_OR_LEFT);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList5() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setRenderer(new BarRenderer());
        CategoryPlot p2 = new CategoryPlot();
        p2.setRenderer(new BarRenderer());
        p2.setRenderer(1, new LineAndShapeRenderer());
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        CategoryPlot p1 = new CategoryPlot();
        p1.setRangeCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow));
        p1.setRangeMinorGridlinePaint(new GradientPaint(2.0f, 3.0f, Color.white, 4.0f, 5.0f, Color.red));
        p1.setRangeZeroBaselinePaint(new GradientPaint(3.0f, 4.0f, Color.red, 5.0f, 6.0f, Color.white));
        CategoryPlot p2;
        try {
            p2 = (CategoryPlot) p1.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed.");
            return;
        }
        p1.addAnnotation(new CategoryLineAnnotation("C1", 1.0, "C2", 2.0, Color.red, new BasicStroke(1.0f)));
        p2.addAnnotation(new CategoryLineAnnotation("C1", 1.0, "C2", 2.0, Color.red, new BasicStroke(1.0f)));
        p1.addDomainMarker(new CategoryMarker("C1"), Layer.FOREGROUND);
        p2.addDomainMarker(new CategoryMarker("C1"), Layer.FOREGROUND);
        p1.addDomainMarker(new CategoryMarker("C2"), Layer.BACKGROUND);
        p2.addDomainMarker(new CategoryMarker("C2"), Layer.BACKGROUND);
        p1.addRangeMarker(new ValueMarker(1.0), Layer.FOREGROUND);
        p2.addRangeMarker(new ValueMarker(1.0), Layer.FOREGROUND);
        p1.addRangeMarker(new ValueMarker(2.0), Layer.BACKGROUND);
        p2.addRangeMarker(new ValueMarker(2.0), Layer.BACKGROUND);
    }

    /**
     * Some more cloning checks.
     */
    public void testCloning2() {
        AxisSpace da1 = new AxisSpace();
        AxisSpace ra1 = new AxisSpace();
        CategoryPlot p1 = new CategoryPlot();
        p1.setFixedDomainAxisSpace(da1);
        p1.setFixedRangeAxisSpace(ra1);
        CategoryPlot p2;
        try {
            p2 = (CategoryPlot) p1.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed.");
            return;
        }
        da1.setBottom(99.0);
        p2.getFixedDomainAxisSpace().setBottom(99.0);
        ra1.setBottom(11.0);
        p2.getFixedRangeAxisSpace().setBottom(11.0);
    }

    /**
     * Some more cloning checks.
     */
    public void testCloning3() {
        LegendItemCollection c1 = new LegendItemCollection();
        CategoryPlot p1 = new CategoryPlot();
        p1.setFixedLegendItems(c1);
        CategoryPlot p2 = null;
        try {
            p2 = (CategoryPlot) p1.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed.");
            return;
        }
        c1.add(new LegendItem("X", "XX", "tt", "url", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.yellow, new BasicStroke(1.0f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.0f), Color.green));
        p2.getFixedLegendItems().add(new LegendItem("X", "XX", "tt", "url", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.yellow, new BasicStroke(1.0f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.0f), Color.green));
    }

    /**
     * Renderers that belong to the plot are being cloned but they are
     * retaining a reference to the original plot.
     */
    public void testBug2817504() {
        CategoryPlot p1 = new CategoryPlot();
        LineAndShapeRenderer r1 = new LineAndShapeRenderer();
        p1.setRenderer(r1);
        CategoryPlot p2;
        try {
            p2 = (CategoryPlot) p1.clone();
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed.");
            return;
        }
        LineAndShapeRenderer r2 = (LineAndShapeRenderer) p2.getRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis domainAxis = new CategoryAxis("Domain");
        NumberAxis rangeAxis = new NumberAxis("Range");
        BarRenderer renderer = new BarRenderer();
        CategoryPlot p1 = new CategoryPlot(dataset, domainAxis, rangeAxis, renderer);
        p1.setOrientation(PlotOrientation.HORIZONTAL);
        CategoryPlot p2 = (CategoryPlot) TestUtilities.serialised(p1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        CategoryAxis domainAxis = new CategoryAxis("Domain");
        NumberAxis rangeAxis = new NumberAxis("Range");
        BarRenderer renderer = new BarRenderer();
        CategoryPlot p1 = new CategoryPlot(data, domainAxis, rangeAxis, renderer);
        p1.setOrientation(PlotOrientation.VERTICAL);
        CategoryPlot p2 = (CategoryPlot) TestUtilities.serialised(p1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization3() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart("Test Chart", "Category Axis", "Value Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        JFreeChart chart2 = (JFreeChart) TestUtilities.serialised(chart);
        try {
            chart2.createBufferedImage(300, 200);
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * This test ensures that a plot with markers is serialized correctly.
     */
    public void testSerialization4() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart("Test Chart", "Category Axis", "Value Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.addRangeMarker(new ValueMarker(1.1), Layer.FOREGROUND);
        plot.addRangeMarker(new IntervalMarker(2.2, 3.3), Layer.BACKGROUND);
        JFreeChart chart2 = (JFreeChart) TestUtilities.serialised(chart);
        try {
            chart2.createBufferedImage(300, 200);
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * Tests a bug where the plot is no longer registered as a listener
     * with the dataset(s) and axes after deserialization.  See patch 1209475
     * at SourceForge.
     */
    public void testSerialization5() {
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        CategoryAxis domainAxis1 = new CategoryAxis("Domain 1");
        NumberAxis rangeAxis1 = new NumberAxis("Range 1");
        BarRenderer renderer1 = new BarRenderer();
        CategoryPlot p1 = new CategoryPlot(dataset1, domainAxis1, rangeAxis1, renderer1);
        CategoryAxis domainAxis2 = new CategoryAxis("Domain 2");
        NumberAxis rangeAxis2 = new NumberAxis("Range 2");
        BarRenderer renderer2 = new BarRenderer();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        p1.setDataset(1, dataset2);
        p1.setDomainAxis(1, domainAxis2);
        p1.setRangeAxis(1, rangeAxis2);
        p1.setRenderer(1, renderer2);
        CategoryPlot p2 = (CategoryPlot) TestUtilities.serialised(p1);
        CategoryAxis domainAxisA = p2.getDomainAxis(0);
        NumberAxis rangeAxisA = (NumberAxis) p2.getRangeAxis(0);
        DefaultCategoryDataset datasetA = (DefaultCategoryDataset) p2.getDataset(0);
        BarRenderer rendererA = (BarRenderer) p2.getRenderer(0);
        CategoryAxis domainAxisB = p2.getDomainAxis(1);
        NumberAxis rangeAxisB = (NumberAxis) p2.getRangeAxis(1);
        DefaultCategoryDataset datasetB = (DefaultCategoryDataset) p2.getDataset(1);
        BarRenderer rendererB = (BarRenderer) p2.getRenderer(1);
    }

    /**
     * A test for a bug where setting the renderer doesn't register the plot
     * as a RendererChangeListener.
     */
    public void testSetRenderer() {
        CategoryPlot plot = new CategoryPlot();
        CategoryItemRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);
        MyPlotChangeListener listener = new MyPlotChangeListener();
        plot.addChangeListener(listener);
        renderer.setSeriesPaint(0, Color.black);
    }

    /**
     * A test for bug report 1169972.
     */
    public void test1169972() {
        CategoryPlot plot = new CategoryPlot(null, null, null, null);
        plot.setDomainAxis(new CategoryAxis("C"));
        plot.setRangeAxis(new NumberAxis("Y"));
        plot.setRenderer(new BarRenderer());
        plot.setDataset(new DefaultCategoryDataset());
    }

    /**
     * Some tests for the addDomainMarker() method(s).
     */
    public void testAddDomainMarker() {
        CategoryPlot plot = new CategoryPlot();
        CategoryMarker m = new CategoryMarker("C1");
        plot.addDomainMarker(m);
        List listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
        plot.clearDomainMarkers();
        listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
    }

    /**
     * Some tests for the addRangeMarker() method(s).
     */
    public void testAddRangeMarker() {
        CategoryPlot plot = new CategoryPlot();
        Marker m = new ValueMarker(1.0);
        plot.addRangeMarker(m);
        List listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
        plot.clearRangeMarkers();
        listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
    }

    /**
     * A test for bug 1654215 (where a renderer is added to the plot without
     * a corresponding dataset and it throws an exception at drawing time).
     */
    public void test1654215() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRenderer(1, new LineAndShapeRenderer());
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
            g2.dispose();
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * Some checks for the getDomainAxisIndex() method.
     */
    public void testGetDomainAxisIndex() {
        CategoryAxis domainAxis1 = new CategoryAxis("X1");
        CategoryAxis domainAxis2 = new CategoryAxis("X2");
        NumberAxis rangeAxis1 = new NumberAxis("Y1");
        CategoryPlot plot = new CategoryPlot(null, domainAxis1, rangeAxis1, null);
        plot.setDomainAxis(1, domainAxis2);
        boolean pass = false;
        try {
            plot.getDomainAxisIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getRangeAxisIndex() method.
     */
    public void testGetRangeAxisIndex() {
        CategoryAxis domainAxis1 = new CategoryAxis("X1");
        NumberAxis rangeAxis1 = new NumberAxis("Y1");
        NumberAxis rangeAxis2 = new NumberAxis("Y2");
        CategoryPlot plot = new CategoryPlot(null, domainAxis1, rangeAxis1, null);
        plot.setRangeAxis(1, rangeAxis2);
        boolean pass = false;
        try {
            plot.getRangeAxisIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Check that removing a marker that isn't assigned to the plot returns
     * false.
     */
    public void testRemoveDomainMarker() {
        CategoryPlot plot = new CategoryPlot();
    }

    /**
     * Check that removing a marker that isn't assigned to the plot returns
     * false.
     */
    public void testRemoveRangeMarker() {
        CategoryPlot plot = new CategoryPlot();
    }

    /**
     * Some tests for the getDomainAxisForDataset() method.
     */
    public void testGetDomainAxisForDataset() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        boolean pass = false;
        try {
            plot.getDomainAxisForDataset(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        CategoryAxis xAxis2 = new CategoryAxis("X2");
        plot.setDomainAxis(1, xAxis2);
        plot.mapDatasetToDomainAxis(0, 1);
        List axisIndices = Arrays.asList(new Integer[] { new Integer(0), new Integer(1) });
        plot.mapDatasetToDomainAxes(0, axisIndices);
        axisIndices = Arrays.asList(new Integer[] { new Integer(1), new Integer(2) });
        plot.mapDatasetToDomainAxes(0, axisIndices);
    }

    /**
     * Some tests for the getRangeAxisForDataset() method.
     */
    public void testGetRangeAxisForDataset() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new DefaultCategoryItemRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        boolean pass = false;
        try {
            plot.getRangeAxisForDataset(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(1, yAxis2);
        plot.mapDatasetToRangeAxis(0, 1);
        List axisIndices = Arrays.asList(new Integer[] { new Integer(0), new Integer(1) });
        plot.mapDatasetToRangeAxes(0, axisIndices);
        axisIndices = Arrays.asList(new Integer[] { new Integer(1), new Integer(2) });
        plot.mapDatasetToRangeAxes(0, axisIndices);
    }

    /**
     * Datasets are now stored in a Map, and it should be possible to assign
     * them an arbitrary key (index).
     */
    public void testDatasetIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset2);
    }

    public void testAxisIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        CategoryAxis xAxis2 = new CategoryAxis("X2");
        plot.setDomainAxis(99, xAxis2);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(99, yAxis2);
    }

    public void testAxisLocationIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        CategoryAxis xAxis2 = new CategoryAxis("X2");
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setDomainAxis(99, xAxis2);
        plot.setRangeAxis(99, yAxis2);
        plot.setDomainAxisLocation(99, AxisLocation.BOTTOM_OR_RIGHT);
        plot.setRangeAxisLocation(99, AxisLocation.BOTTOM_OR_LEFT);
    }

    public void testRendererIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(20, renderer2);
    }

    public void testGetRendererForDataset2() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset2);
        CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(99, renderer2);
    }

    public void testMapDatasetToDomainAxis() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        CategoryAxis xAxis2 = new CategoryAxis("X2");
        plot.setDomainAxis(11, xAxis2);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset);
        plot.mapDatasetToDomainAxis(99, 11);
    }

    public void testMapDatasetToRangeAxis() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(22, yAxis2);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset);
        plot.mapDatasetToRangeAxis(99, 22);
    }

    public void testDomainMarkerIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset);
        CategoryAxis xAxis2 = new CategoryAxis("X2");
        plot.setDomainAxis(1, xAxis2);
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(99, renderer2);
        plot.mapDatasetToDomainAxis(99, 1);
        CategoryMarker xMarker1 = new CategoryMarker(123);
        plot.addDomainMarker(99, xMarker1, Layer.FOREGROUND);
    }

    public void testRangeMarkerIndices() {
        CategoryDataset dataset = new DefaultCategoryDataset();
        CategoryAxis xAxis = new CategoryAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        CategoryItemRenderer renderer = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(1, "R1", "C1");
        plot.setDataset(99, dataset);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(1, yAxis2);
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(99, renderer2);
        plot.mapDatasetToRangeAxis(99, 1);
        ValueMarker yMarker1 = new ValueMarker(123);
        plot.addRangeMarker(99, yMarker1, Layer.FOREGROUND);
    }
}
