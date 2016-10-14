package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYBarRenderer} class.
 */
public class XYBarRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYBarRenderer r1 = new XYBarRenderer();
        XYBarRenderer r2 = new XYBarRenderer();
        r1.setBase(1.0);
        r2.setBase(1.0);
        r1.setUseYInterval(!r1.getUseYInterval());
        r2.setUseYInterval(!r2.getUseYInterval());
        r1.setMargin(0.10);
        r2.setMargin(0.10);
        r1.setDrawBarOutline(!r1.isDrawBarOutline());
        r2.setDrawBarOutline(!r2.isDrawBarOutline());
        r1.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        r2.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        r1.setLegendBar(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        r2.setLegendBar(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        r1.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
        r2.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
        r1.setNegativeItemLabelPositionFallback(new ItemLabelPosition());
        r2.setNegativeItemLabelPositionFallback(new ItemLabelPosition());
        r1.setBarPainter(new GradientXYBarPainter(0.11, 0.22, 0.33));
        r2.setBarPainter(new GradientXYBarPainter(0.11, 0.22, 0.33));
        r1.setShadowVisible(false);
        r2.setShadowVisible(false);
        r1.setShadowXOffset(3.3);
        r2.setShadowXOffset(3.3);
        r1.setShadowYOffset(3.3);
        r2.setShadowYOffset(3.3);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYBarRenderer r1 = new XYBarRenderer();
        XYBarRenderer r2 = new XYBarRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYBarRenderer r1 = new XYBarRenderer();
        Rectangle2D rect = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        r1.setLegendBar(rect);
        XYBarRenderer r2 = (XYBarRenderer) r1.clone();
        rect.setRect(4.0, 3.0, 2.0, 1.0);
        r2.setLegendBar(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYBarRenderer r1 = new XYBarRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYBarRenderer r1 = new XYBarRenderer();
        XYBarRenderer r2 = (XYBarRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
        XYBarRenderer r2 = (XYBarRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Check that the renderer is calculating the domain bounds correctly.
     */
    public void testFindDomainBounds() {
        XYSeriesCollection dataset = RendererXYPackageUtils.createTestXYSeriesCollection();
        JFreeChart chart = ChartFactory.createXYBarChart("Test Chart", "X", false, "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        Range bounds = domainAxis.getRange();
    }

    /**
     * A test for the findDomainBounds method to ensure it correctly accounts 
     * for the series visibility.
     */
    @Test
    public void testFindDomainBounds2() {
        XYIntervalSeries s1 = new XYIntervalSeries("S1");
        s1.add(1.0, 0.5, 1.5, 10.0, 9.5, 10.5);
        s1.add(2.0, 1.9, 2.1, 20.0, 19.8, 20.3);
        XYIntervalSeries s2 = new XYIntervalSeries("S2");
        s2.add(3.0, 2.5, 3.5, 30.0, 29.5, 30.5);
        s2.add(4.0, 3.9, 4.1, 9.0, 9.0, 9.0);
        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        XYBarRenderer renderer = new XYBarRenderer();
        Range r = renderer.findDomainBounds(dataset);
        assertEquals(0.5, r.getLowerBound(), EPSILON);
        renderer.setSeriesVisible(1, Boolean.FALSE);
        r = renderer.findDomainBounds(dataset);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * A simple test for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x = { 1.0, 2.0, 3.0, 4.0 };
        double[] startx = { 0.9, 1.8, 2.7, 3.6 };
        double[] endx = { 1.1, 2.2, 3.3, 4.4 };
        double[] y = { 1.0, 2.0, 3.0, 4.0 };
        double[] starty = { 0.9, 1.8, 2.7, 3.6 };
        double[] endy = { 1.1, 2.2, 3.3, 4.4 };
        double[][] data = new double[][] { x, startx, endx, y, starty, endy };
        dataset.addSeries("Series 1", data);
        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setUseYInterval(true);
        Range r = renderer.findRangeBounds(dataset);
        renderer.setUseYInterval(false);
        r = renderer.findRangeBounds(dataset);
    }

    /**
     * A test for the findRangeBounds method to ensure it correctly accounts 
     * for the series visibility.
     */
    public void testFindRangeBounds2() {
        XYIntervalSeries s1 = new XYIntervalSeries("S1");
        s1.add(1.0, 0.5, 1.5, 10.0, 9.5, 10.5);
        s1.add(2.0, 1.9, 2.1, 20.0, 19.8, 20.3);
        XYIntervalSeries s2 = new XYIntervalSeries("S2");
        s2.add(3.0, 2.5, 3.5, 30.0, 29.5, 30.5);
        s2.add(4.0, 3.9, 4.1, 9.0, 9.0, 9.0);
        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setUseYInterval(false);
        Range r = renderer.findRangeBounds(dataset);
        renderer.setSeriesVisible(1, Boolean.FALSE);
        r = renderer.findRangeBounds(dataset);
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
        XYBarRenderer r = new XYBarRenderer();
        XYPlot plot = new XYPlot(new XYBarDataset(d1, 1.0), new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, new XYBarDataset(d2, 2.0));
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
