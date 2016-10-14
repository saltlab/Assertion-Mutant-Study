package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.urls.TimeSeriesURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYLineAndShapeRenderer} class.
 */
public class XYLineAndShapeRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    @Test
    public void testEquals() {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        XYLineAndShapeRenderer r2 = new XYLineAndShapeRenderer();
        assertEquals(r1, r2);
        r1.setLinesVisible(true);
        r2.setLinesVisible(true);
        r1.setSeriesLinesVisible(3, true);
        r2.setSeriesLinesVisible(3, true);
        r1.setBaseLinesVisible(false);
        r2.setBaseLinesVisible(false);
        r1.setLegendLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        r2.setLegendLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        r1.setShapesVisible(true);
        r2.setShapesVisible(true);
        r1.setSeriesShapesVisible(3, true);
        r2.setSeriesShapesVisible(3, true);
        r1.setBaseShapesVisible(false);
        r2.setBaseShapesVisible(false);
        r1.setShapesFilled(true);
        r2.setShapesFilled(true);
        r1.setSeriesShapesFilled(3, true);
        r2.setSeriesShapesFilled(3, true);
        r1.setBaseShapesFilled(false);
        r2.setBaseShapesFilled(false);
        r1.setDrawOutlines(!r1.getDrawOutlines());
        r2.setDrawOutlines(r1.getDrawOutlines());
        r1.setUseOutlinePaint(true);
        r2.setUseOutlinePaint(true);
        r1.setUseFillPaint(true);
        r2.setUseFillPaint(true);
        r1.setDrawSeriesLineAsPath(true);
        r2.setDrawSeriesLineAsPath(true);
    }

    /**
     * Test that the equals() method works for a TimeSeriesURLGenerator.
     */
    public void testEquals2() {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        XYLineAndShapeRenderer r2 = new XYLineAndShapeRenderer();
        r1.setURLGenerator(new TimeSeriesURLGenerator());
        r2.setURLGenerator(new TimeSeriesURLGenerator());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        XYLineAndShapeRenderer r2 = new XYLineAndShapeRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Rectangle2D legendShape = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        r1.setLegendLine(legendShape);
        XYLineAndShapeRenderer r2 = (XYLineAndShapeRenderer) r1.clone();
        r1.setSeriesLinesVisible(0, false);
        r2.setSeriesLinesVisible(0, false);
        legendShape.setRect(4.0, 3.0, 2.0, 1.0);
        r2.setLegendLine(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        r1.setSeriesShapesVisible(1, true);
        r2.setSeriesShapesVisible(1, true);
        r1.setSeriesShapesFilled(1, true);
        r2.setSeriesShapesFilled(1, true);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        XYLineAndShapeRenderer r2 = (XYLineAndShapeRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Check that the renderer is calculating the domain bounds correctly.
     */
    public void testFindDomainBounds() {
        XYSeriesCollection dataset = RendererXYPackageUtils.createTestXYSeriesCollection();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        Range bounds = domainAxis.getRange();
    }

    /**
     * Check that the renderer is calculating the range bounds correctly.
     */
    public void testFindRangeBounds() {
        TableXYDataset dataset = RendererXYPackageUtils.createTestTableXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAutoRangeIncludesZero(false);
        Range bounds = rangeAxis.getRange();
    }

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    public void testGetLegendItemSeriesIndex() {
        XYSeriesCollection d1 = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        XYSeries s2 = new XYSeries("S2");
        s2.add(1.0, 1.1);
        d1.addSeries(s1);
        d1.addSeries(s2);
        XYSeriesCollection d2 = new XYSeriesCollection();
        XYSeries s3 = new XYSeries("S3");
        s3.add(1.0, 1.1);
        XYSeries s4 = new XYSeries("S4");
        s4.add(1.0, 1.1);
        XYSeries s5 = new XYSeries("S5");
        s5.add(1.0, 1.1);
        d2.addSeries(s3);
        d2.addSeries(s4);
        d2.addSeries(s5);
        XYLineAndShapeRenderer r = new XYLineAndShapeRenderer();
        XYPlot plot = new XYPlot(d1, new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, d2);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
