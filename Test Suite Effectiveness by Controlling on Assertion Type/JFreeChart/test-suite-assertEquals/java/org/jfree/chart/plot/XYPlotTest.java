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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.date.MonthConstants;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleInsets;

/**
 * Tests for the {@link XYPlot} class.
 */
public class XYPlotTest {

    /**
     * Added this test in response to a bug report.
     */
    public void testGetDatasetCount() {
        XYPlot plot = new XYPlot();
        assertEquals(0, plot.getDatasetCount());
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        XYPlot plot1 = new XYPlot();
        XYPlot plot2 = new XYPlot();
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
        plot2.setOrientation(PlotOrientation.HORIZONTAL);
        plot1.setAxisOffset(new RectangleInsets(0.05, 0.05, 0.05, 0.05));
        plot2.setAxisOffset(new RectangleInsets(0.05, 0.05, 0.05, 0.05));
        plot1.setDomainAxis(new NumberAxis("Domain Axis"));
        plot2.setDomainAxis(new NumberAxis("Domain Axis"));
        plot1.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot2.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot1.setDomainAxis(11, new NumberAxis("Secondary Domain Axis"));
        plot2.setDomainAxis(11, new NumberAxis("Secondary Domain Axis"));
        plot1.setDomainAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot2.setDomainAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot1.setRangeAxis(new NumberAxis("Range Axis"));
        plot2.setRangeAxis(new NumberAxis("Range Axis"));
        plot1.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot2.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot1.setRangeAxis(11, new NumberAxis("Secondary Range Axis"));
        plot2.setRangeAxis(11, new NumberAxis("Secondary Range Axis"));
        plot1.setRangeAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot2.setRangeAxisLocation(11, AxisLocation.TOP_OR_RIGHT);
        plot1.mapDatasetToDomainAxis(11, 11);
        plot2.mapDatasetToDomainAxis(11, 11);
        plot1.mapDatasetToRangeAxis(11, 11);
        plot2.mapDatasetToRangeAxis(11, 11);
        plot1.setRenderer(new DefaultXYItemRenderer());
        plot2.setRenderer(new DefaultXYItemRenderer());
        plot1.setRenderer(11, new DefaultXYItemRenderer());
        plot2.setRenderer(11, new DefaultXYItemRenderer());
        plot1.setDomainGridlinesVisible(false);
        plot2.setDomainGridlinesVisible(false);
        Stroke stroke = new BasicStroke(2.0f);
        plot1.setDomainGridlineStroke(stroke);
        plot2.setDomainGridlineStroke(stroke);
        plot1.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red));
        plot2.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red));
        plot1.setRangeGridlinesVisible(false);
        plot2.setRangeGridlinesVisible(false);
        plot1.setRangeGridlineStroke(stroke);
        plot2.setRangeGridlineStroke(stroke);
        plot1.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        plot2.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        plot1.setRangeZeroBaselineVisible(true);
        plot2.setRangeZeroBaselineVisible(true);
        plot1.setRangeZeroBaselineStroke(stroke);
        plot2.setRangeZeroBaselineStroke(stroke);
        plot1.setRangeZeroBaselinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.red));
        plot2.setRangeZeroBaselinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.red));
        plot1.setRangeCrosshairVisible(true);
        plot2.setRangeCrosshairVisible(true);
        plot1.setRangeCrosshairValue(100.0);
        plot2.setRangeCrosshairValue(100.0);
        plot1.setRangeCrosshairStroke(stroke);
        plot2.setRangeCrosshairStroke(stroke);
        plot1.setRangeCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.pink, 3.0f, 4.0f, Color.red));
        plot2.setRangeCrosshairPaint(new GradientPaint(1.0f, 2.0f, Color.pink, 3.0f, 4.0f, Color.red));
        plot1.setRangeCrosshairLockedOnData(false);
        plot2.setRangeCrosshairLockedOnData(false);
        plot1.addRangeMarker(new ValueMarker(4.0));
        plot2.addRangeMarker(new ValueMarker(4.0));
        plot1.addRangeMarker(1, new ValueMarker(4.0), Layer.FOREGROUND);
        plot2.addRangeMarker(1, new ValueMarker(4.0), Layer.FOREGROUND);
        plot1.addRangeMarker(1, new ValueMarker(99.0), Layer.BACKGROUND);
        plot2.addRangeMarker(1, new ValueMarker(99.0), Layer.BACKGROUND);
        plot1.setFixedLegendItems(new LegendItemCollection());
        plot2.setFixedLegendItems(new LegendItemCollection());
        plot1.setWeight(3);
        plot2.setWeight(3);
        plot1.setQuadrantOrigin(new Point2D.Double(12.3, 45.6));
        plot2.setQuadrantOrigin(new Point2D.Double(12.3, 45.6));
        plot1.setQuadrantPaint(0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setQuadrantPaint(0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setQuadrantPaint(1, new GradientPaint(2.0f, 3.0f, Color.red, 4.0f, 5.0f, Color.blue));
        plot2.setQuadrantPaint(1, new GradientPaint(2.0f, 3.0f, Color.red, 4.0f, 5.0f, Color.blue));
        plot1.setQuadrantPaint(2, new GradientPaint(3.0f, 4.0f, Color.red, 5.0f, 6.0f, Color.blue));
        plot2.setQuadrantPaint(2, new GradientPaint(3.0f, 4.0f, Color.red, 5.0f, 6.0f, Color.blue));
        plot1.setQuadrantPaint(3, new GradientPaint(4.0f, 5.0f, Color.red, 6.0f, 7.0f, Color.blue));
        plot2.setQuadrantPaint(3, new GradientPaint(4.0f, 5.0f, Color.red, 6.0f, 7.0f, Color.blue));
        plot1.setDomainTickBandPaint(Color.red);
        plot2.setDomainTickBandPaint(Color.red);
        plot1.setRangeTickBandPaint(Color.blue);
        plot2.setRangeTickBandPaint(Color.blue);
        plot1.setDomainMinorGridlinesVisible(true);
        plot2.setDomainMinorGridlinesVisible(true);
        plot1.setDomainMinorGridlinePaint(Color.red);
        plot2.setDomainMinorGridlinePaint(Color.red);
        plot1.setDomainGridlineStroke(new BasicStroke(1.1f));
        plot2.setDomainGridlineStroke(new BasicStroke(1.1f));
        plot1.setRangeMinorGridlinesVisible(true);
        plot2.setRangeMinorGridlinesVisible(true);
        plot1.setRangeMinorGridlinePaint(Color.blue);
        plot2.setRangeMinorGridlinePaint(Color.blue);
        plot1.setRangeMinorGridlineStroke(new BasicStroke(1.23f));
        plot2.setRangeMinorGridlineStroke(new BasicStroke(1.23f));
        List axisIndices = Arrays.asList(new Integer[] { new Integer(0), new Integer(1) });
        plot1.mapDatasetToDomainAxes(0, axisIndices);
        plot2.mapDatasetToDomainAxes(0, axisIndices);
        plot1.mapDatasetToRangeAxes(0, axisIndices);
        plot2.mapDatasetToRangeAxes(0, axisIndices);
        plot1.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot2.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot1.setShadowGenerator(null);
        plot2.setShadowGenerator(null);
        LegendItemCollection lic1 = new LegendItemCollection();
        lic1.add(new LegendItem("XYZ", Color.red));
        plot1.setFixedLegendItems(lic1);
        LegendItemCollection lic2 = new LegendItemCollection();
        lic2.add(new LegendItem("XYZ", Color.red));
        plot2.setFixedLegendItems(lic2);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList() {
        XYPlot p1 = new XYPlot();
        p1.setDomainAxis(new NumberAxis("A"));
        XYPlot p2 = new XYPlot();
        p2.setDomainAxis(new NumberAxis("A"));
        p2.setDomainAxis(1, new NumberAxis("B"));
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList2() {
        XYPlot p1 = new XYPlot();
        p1.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        XYPlot p2 = new XYPlot();
        p2.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        p2.setDomainAxisLocation(1, AxisLocation.TOP_OR_LEFT);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList3() {
        XYPlot p1 = new XYPlot();
        p1.setRangeAxis(new NumberAxis("A"));
        XYPlot p2 = new XYPlot();
        p2.setRangeAxis(new NumberAxis("A"));
        p2.setRangeAxis(1, new NumberAxis("B"));
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList4() {
        XYPlot p1 = new XYPlot();
        p1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        XYPlot p2 = new XYPlot();
        p2.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        p2.setRangeAxisLocation(1, AxisLocation.TOP_OR_LEFT);
    }

    /**
     * This test covers a flaw in the ObjectList equals() method.
     */
    public void testEquals_ObjectList5() {
        XYPlot p1 = new XYPlot();
        p1.setRenderer(new XYBarRenderer());
        XYPlot p2 = new XYPlot();
        p2.setRenderer(new XYBarRenderer());
        p2.setRenderer(1, new XYLineAndShapeRenderer());
    }

    /**
     * Confirm that basic cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot();
        XYPlot p2 = (XYPlot) p1.clone();
    }

    /**
     * Tests cloning for a more complex plot.
     */
    public void testCloning2() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot(null, new NumberAxis("Domain Axis"), new NumberAxis("Range Axis"), new StandardXYItemRenderer());
        p1.setRangeAxis(1, new NumberAxis("Range Axis 2"));
        List axisIndices = Arrays.asList(new Integer[] { new Integer(0), new Integer(1) });
        p1.mapDatasetToDomainAxes(0, axisIndices);
        p1.mapDatasetToRangeAxes(0, axisIndices);
        p1.setRenderer(1, new XYBarRenderer());
        XYPlot p2 = (XYPlot) p1.clone();
    }

    /**
     * Tests cloning for a plot where the fixed legend items have been
     * specified.
     */
    public void testCloning3() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot(null, new NumberAxis("Domain Axis"), new NumberAxis("Range Axis"), new StandardXYItemRenderer());
        LegendItemCollection c1 = new LegendItemCollection();
        p1.setFixedLegendItems(c1);
        XYPlot p2 = (XYPlot) p1.clone();
        c1.add(new LegendItem("X"));
    }

    /**
     * Tests cloning to ensure that the cloned plot is registered as a listener
     * on the cloned renderer.
     */
    public void testCloning4() throws CloneNotSupportedException {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        XYPlot p1 = new XYPlot(null, new NumberAxis("Domain Axis"), new NumberAxis("Range Axis"), r1);
        XYPlot p2 = (XYPlot) p1.clone();
        XYLineAndShapeRenderer r2 = (XYLineAndShapeRenderer) p2.getRenderer();
    }

    /**
     * Confirm that cloning captures the quadrantOrigin field.
     */
    public void testCloning_QuadrantOrigin() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot();
        Point2D p = new Point2D.Double(1.2, 3.4);
        p1.setQuadrantOrigin(p);
        XYPlot p2 = (XYPlot) p1.clone();
    }

    /**
     * Confirm that cloning captures the quadrantOrigin field.
     */
    public void testCloning_QuadrantPaint() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot();
        p1.setQuadrantPaint(3, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        XYPlot p2 = (XYPlot) p1.clone();
        p1.setQuadrantPaint(1, Color.red);
        p2.setQuadrantPaint(1, Color.red);
    }

    /**
     * Renderers that belong to the plot are being cloned but they are
     * retaining a reference to the original plot.
     */
    public void testBug2817504() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot();
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        p1.setRenderer(r1);
        XYPlot p2 = (XYPlot) p1.clone();
        XYLineAndShapeRenderer r2 = (XYLineAndShapeRenderer) p2.getRenderer();
    }

    /**
     * Tests the independence of the clones.
     */
    public void testCloneIndependence() throws CloneNotSupportedException {
        XYPlot p1 = new XYPlot(null, new NumberAxis("Domain Axis"), new NumberAxis("Range Axis"), new StandardXYItemRenderer());
        p1.setDomainAxis(1, new NumberAxis("Domain Axis 2"));
        p1.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
        p1.setRangeAxis(1, new NumberAxis("Range Axis 2"));
        p1.setRangeAxisLocation(1, AxisLocation.TOP_OR_RIGHT);
        p1.setRenderer(1, new XYBarRenderer());
        XYPlot p2 = (XYPlot) p1.clone();
        p1.getDomainAxis().setLabel("Label");
        p2.getDomainAxis().setLabel("Label");
        p1.getDomainAxis(1).setLabel("S1");
        p2.getDomainAxis(1).setLabel("S1");
        p1.setDomainAxisLocation(1, AxisLocation.TOP_OR_RIGHT);
        p2.setDomainAxisLocation(1, AxisLocation.TOP_OR_RIGHT);
        p1.mapDatasetToDomainAxis(2, 1);
        p2.mapDatasetToDomainAxis(2, 1);
        p1.getRangeAxis().setLabel("Label");
        p2.getRangeAxis().setLabel("Label");
        p1.getRangeAxis(1).setLabel("S1");
        p2.getRangeAxis(1).setLabel("S1");
        p1.setRangeAxisLocation(1, AxisLocation.TOP_OR_LEFT);
        p2.setRangeAxisLocation(1, AxisLocation.TOP_OR_LEFT);
        p1.mapDatasetToRangeAxis(2, 1);
        p2.mapDatasetToRangeAxis(2, 1);
        p1.getRenderer().setOutlinePaint(Color.cyan);
        p2.getRenderer().setOutlinePaint(Color.cyan);
        p1.getRenderer(1).setOutlinePaint(Color.red);
        p2.getRenderer(1).setOutlinePaint(Color.red);
    }

    /**
     * Setting a null renderer should be allowed, but is generating a null
     * pointer exception in 0.9.7.
     */
    public void testSetNullRenderer() {
        boolean failed = false;
        try {
            XYPlot plot = new XYPlot(null, new NumberAxis("X"), new NumberAxis("Y"), null);
            plot.setRenderer(null);
        } catch (Exception e) {
            failed = true;
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization1() {
        XYDataset data = new XYSeriesCollection();
        NumberAxis domainAxis = new NumberAxis("Domain");
        NumberAxis rangeAxis = new NumberAxis("Range");
        StandardXYItemRenderer renderer = new StandardXYItemRenderer();
        XYPlot p1 = new XYPlot(data, domainAxis, rangeAxis, renderer);
        XYPlot p2 = (XYPlot) TestUtilities.serialised(p1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.  This test
     * uses a {@link DateAxis} and a {@link StandardXYToolTipGenerator}.
     */
    public void testSerialization2() {
        IntervalXYDataset data1 = createDataset1();
        XYItemRenderer renderer1 = new XYBarRenderer(0.20);
        renderer1.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        XYPlot p1 = new XYPlot(data1, new DateAxis("Date"), null, renderer1);
        XYPlot p2 = (XYPlot) TestUtilities.serialised(p1);
    }

    /**
     * Problem to reproduce a bug in serialization.  The bug (first reported
     * against the {@link org.jfree.chart.plot.CategoryPlot} class) is a null
     * pointer exception that occurs when drawing a plot after deserialization.
     * It is caused by four temporary storage structures (axesAtTop,
     * axesAtBottom, axesAtLeft and axesAtRight - all initialized as empty
     * lists in the constructor) not being initialized by the readObject()
     * method following deserialization.  This test has been written to
     * reproduce the bug (now fixed).
     */
    public void testSerialization3() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "Domain Axis", "Range Axis", dataset);
        JFreeChart chart2 = (JFreeChart) TestUtilities.serialised(chart);
        try {
            chart2.createBufferedImage(300, 200);
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * A test to reproduce a bug in serialization: the domain and/or range
     * markers for a plot are not being serialized.
     */
    public void testSerialization4() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "Domain Axis", "Range Axis", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.addDomainMarker(new ValueMarker(1.0), Layer.FOREGROUND);
        plot.addDomainMarker(new IntervalMarker(2.0, 3.0), Layer.BACKGROUND);
        plot.addRangeMarker(new ValueMarker(4.0), Layer.FOREGROUND);
        plot.addRangeMarker(new IntervalMarker(5.0, 6.0), Layer.BACKGROUND);
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
        XYSeriesCollection dataset1 = new XYSeriesCollection();
        NumberAxis domainAxis1 = new NumberAxis("Domain 1");
        NumberAxis rangeAxis1 = new NumberAxis("Range 1");
        StandardXYItemRenderer renderer1 = new StandardXYItemRenderer();
        XYPlot p1 = new XYPlot(dataset1, domainAxis1, rangeAxis1, renderer1);
        NumberAxis domainAxis2 = new NumberAxis("Domain 2");
        NumberAxis rangeAxis2 = new NumberAxis("Range 2");
        StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        p1.setDataset(1, dataset2);
        p1.setDomainAxis(1, domainAxis2);
        p1.setRangeAxis(1, rangeAxis2);
        p1.setRenderer(1, renderer2);
        XYPlot p2 = (XYPlot) TestUtilities.serialised(p1);
        NumberAxis domainAxisA = (NumberAxis) p2.getDomainAxis(0);
        NumberAxis rangeAxisA = (NumberAxis) p2.getRangeAxis(0);
        XYSeriesCollection datasetA = (XYSeriesCollection) p2.getDataset(0);
        StandardXYItemRenderer rendererA = (StandardXYItemRenderer) p2.getRenderer(0);
        NumberAxis domainAxisB = (NumberAxis) p2.getDomainAxis(1);
        NumberAxis rangeAxisB = (NumberAxis) p2.getRangeAxis(1);
        XYSeriesCollection datasetB = (XYSeriesCollection) p2.getDataset(1);
        StandardXYItemRenderer rendererB = (StandardXYItemRenderer) p2.getRenderer(1);
    }

    /**
     * Some checks for the getRendererForDataset() method.
     */
    public void testGetRendererForDataset() {
        XYDataset d0 = new XYSeriesCollection();
        XYDataset d1 = new XYSeriesCollection();
        XYDataset d2 = new XYSeriesCollection();
        XYDataset d3 = new XYSeriesCollection();
        XYItemRenderer r0 = new XYLineAndShapeRenderer();
        XYItemRenderer r2 = new XYLineAndShapeRenderer();
        XYPlot plot = new XYPlot();
        plot.setDataset(0, d0);
        plot.setDataset(1, d1);
        plot.setDataset(2, d2);
        plot.setRenderer(0, r0);
        plot.setRenderer(2, r2);
    }

    /**
     * Some checks for the getLegendItems() method.
     */
    public void testGetLegendItems() {
        XYDataset d0 = createDataset1();
        XYDataset d1 = createDataset2();
        XYItemRenderer r0 = new XYLineAndShapeRenderer();
        XYPlot plot = new XYPlot();
        plot.setDataset(0, d0);
        plot.setDataset(1, d1);
        plot.setRenderer(0, r0);
        LegendItemCollection items = plot.getLegendItems();
    }

    /**
     * Creates a sample dataset.
     *
     * @return Series 1.
     */
    private IntervalXYDataset createDataset1() {
        TimeSeries series1 = new TimeSeries("Series 1", Day.class);
        series1.add(new Day(1, MonthConstants.MARCH, 2002), 12353.3);
        series1.add(new Day(2, MonthConstants.MARCH, 2002), 13734.4);
        series1.add(new Day(3, MonthConstants.MARCH, 2002), 14525.3);
        series1.add(new Day(4, MonthConstants.MARCH, 2002), 13984.3);
        series1.add(new Day(5, MonthConstants.MARCH, 2002), 12999.4);
        series1.add(new Day(6, MonthConstants.MARCH, 2002), 14274.3);
        series1.add(new Day(7, MonthConstants.MARCH, 2002), 15943.5);
        series1.add(new Day(8, MonthConstants.MARCH, 2002), 14845.3);
        series1.add(new Day(9, MonthConstants.MARCH, 2002), 14645.4);
        series1.add(new Day(10, MonthConstants.MARCH, 2002), 16234.6);
        series1.add(new Day(11, MonthConstants.MARCH, 2002), 17232.3);
        series1.add(new Day(12, MonthConstants.MARCH, 2002), 14232.2);
        series1.add(new Day(13, MonthConstants.MARCH, 2002), 13102.2);
        series1.add(new Day(14, MonthConstants.MARCH, 2002), 14230.2);
        series1.add(new Day(15, MonthConstants.MARCH, 2002), 11235.2);
        TimeSeriesCollection collection = new TimeSeriesCollection(series1);
        return collection;
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    private XYDataset createDataset2() {
        XYSeries series = new XYSeries("Series 2");
        XYSeriesCollection collection = new XYSeriesCollection(series);
        return collection;
    }

    /**
     * A test for a bug where setting the renderer doesn't register the plot
     * as a RendererChangeListener.
     */
    public void testSetRenderer() {
        XYPlot plot = new XYPlot();
        XYItemRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);
        MyPlotChangeListener listener = new MyPlotChangeListener();
        plot.addChangeListener(listener);
        renderer.setSeriesPaint(0, Color.black);
    }

    /**
     * Some checks for the removeAnnotation() method.
     */
    public void testRemoveAnnotation() {
        XYPlot plot = new XYPlot();
        XYTextAnnotation a1 = new XYTextAnnotation("X", 1.0, 2.0);
        XYTextAnnotation a2 = new XYTextAnnotation("X", 3.0, 4.0);
        XYTextAnnotation a3 = new XYTextAnnotation("X", 1.0, 2.0);
        plot.addAnnotation(a1);
        plot.addAnnotation(a2);
        plot.addAnnotation(a3);
        plot.removeAnnotation(a2);
        XYTextAnnotation x = (XYTextAnnotation) plot.getAnnotations().get(0);
        plot.removeAnnotation(a3);
        x = (XYTextAnnotation) plot.getAnnotations().get(0);
    }

    /**
     * Some tests for the addDomainMarker() method(s).
     */
    public void testAddDomainMarker() {
        XYPlot plot = new XYPlot();
        Marker m = new ValueMarker(1.0);
        plot.addDomainMarker(m);
        List listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
        plot.clearDomainMarkers();
        listeners = Arrays.asList(m.getListeners(MarkerChangeListener.class));
    }

    /**
     * Some tests for the addRangeMarker() method(s).
     */
    public void testAddRangeMarker() {
        XYPlot plot = new XYPlot();
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
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRenderer(1, new XYLineAndShapeRenderer());
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
     * A test for drawing range grid lines when there is no primary renderer.
     * In 1.0.4, this is throwing a NullPointerException.
     */
    public void testDrawRangeGridlines() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRenderer(null);
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
     * A test for drawing a plot where a series has zero items.  With
     * JFreeChart 1.0.5+cvs this was throwing an exception at one point.
     */
    public void testDrawSeriesWithZeroItems() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Series 1", new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } });
        dataset.addSeries("Series 2", new double[][] { {}, {} });
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
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
     * Check that removing a marker that isn't assigned to the plot returns
     * false.
     */
    public void testRemoveDomainMarker() {
        XYPlot plot = new XYPlot();
    }

    /**
     * Check that removing a marker that isn't assigned to the plot returns
     * false.
     */
    public void testRemoveRangeMarker() {
        XYPlot plot = new XYPlot();
    }

    /**
     * Some tests for the getDomainAxisForDataset() method.
     */
    public void testGetDomainAxisForDataset() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        boolean pass = false;
        try {
            plot.getDomainAxisForDataset(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        NumberAxis xAxis2 = new NumberAxis("X2");
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
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
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
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset2);
    }

    public void testAxisIndices() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        NumberAxis xAxis2 = new NumberAxis("X2");
        plot.setDomainAxis(99, xAxis2);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(99, yAxis2);
    }

    public void testAxisLocationIndices() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        NumberAxis xAxis2 = new NumberAxis("X2");
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setDomainAxis(99, xAxis2);
        plot.setRangeAxis(99, yAxis2);
        plot.setDomainAxisLocation(99, AxisLocation.BOTTOM_OR_RIGHT);
        plot.setRangeAxisLocation(99, AxisLocation.BOTTOM_OR_LEFT);
    }

    public void testRendererIndices() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        plot.setRenderer(20, renderer2);
    }

    public void testGetRendererForDataset2() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset2);
        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        plot.setRenderer(99, renderer);
    }

    public void testMapDatasetToDomainAxis() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        NumberAxis xAxis2 = new NumberAxis("X2");
        plot.setDomainAxis(11, xAxis2);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset);
        plot.mapDatasetToDomainAxis(99, 11);
    }

    public void testMapDatasetToRangeAxis() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(22, yAxis2);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset);
        plot.mapDatasetToRangeAxis(99, 22);
    }

    public void testDomainMarkerIndices() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset);
        NumberAxis xAxis2 = new NumberAxis("X2");
        plot.setDomainAxis(1, xAxis2);
        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        plot.setRenderer(99, renderer2);
        plot.mapDatasetToDomainAxis(99, 1);
        ValueMarker xMarker1 = new ValueMarker(123);
        plot.addDomainMarker(99, xMarker1, Layer.FOREGROUND);
    }

    public void testRangeMarkerIndices() {
        XYDataset dataset = new XYSeriesCollection();
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");
        XYItemRenderer renderer = new DefaultXYItemRenderer();
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(new XYSeries("Series in dataset 2"));
        plot.setDataset(99, dataset);
        NumberAxis yAxis2 = new NumberAxis("Y2");
        plot.setRangeAxis(1, yAxis2);
        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        plot.setRenderer(99, renderer2);
        plot.mapDatasetToRangeAxis(99, 1);
        ValueMarker yMarker1 = new ValueMarker(123);
        plot.addRangeMarker(99, yMarker1, Layer.FOREGROUND);
    }
}
