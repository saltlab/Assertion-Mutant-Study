package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYAreaRenderer} class.
 */
public class XYAreaRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYAreaRenderer r1 = new XYAreaRenderer();
        XYAreaRenderer r2 = new XYAreaRenderer();
        r1 = new XYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES);
        r2 = new XYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES);
        r1 = new XYAreaRenderer(XYAreaRenderer.AREA);
        r2 = new XYAreaRenderer(XYAreaRenderer.AREA);
        r1 = new XYAreaRenderer(XYAreaRenderer.LINES);
        r2 = new XYAreaRenderer(XYAreaRenderer.LINES);
        r1 = new XYAreaRenderer(XYAreaRenderer.SHAPES);
        r2 = new XYAreaRenderer(XYAreaRenderer.SHAPES);
        r1 = new XYAreaRenderer(XYAreaRenderer.SHAPES_AND_LINES);
        r2 = new XYAreaRenderer(XYAreaRenderer.SHAPES_AND_LINES);
        r1.setOutline(true);
        r2.setOutline(true);
        r1.setLegendArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        r2.setLegendArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        r1.setUseFillPaint(true);
        r2.setUseFillPaint(true);
        r1.setGradientTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        r2.setGradientTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYAreaRenderer r1 = new XYAreaRenderer();
        XYAreaRenderer r2 = new XYAreaRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
        r2.setUseFillPaint(true);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYAreaRenderer r1 = new XYAreaRenderer();
        Rectangle2D rect1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        r1.setLegendArea(rect1);
        XYAreaRenderer r2 = (XYAreaRenderer) r1.clone();
        rect1.setRect(4.0, 3.0, 2.0, 1.0);
        r2.setLegendArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYAreaRenderer r1 = new XYAreaRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYAreaRenderer r1 = new XYAreaRenderer();
        XYAreaRenderer r2 = (XYAreaRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Draws the chart with a {@code null} info object to make sure that
     * no exceptions are thrown (particularly by code in the renderer).
     */
    public void testDrawWithNullInfo() {
        try {
            DefaultTableXYDataset dataset = new DefaultTableXYDataset();
            XYSeries s1 = new XYSeries("Series 1", true, false);
            s1.add(5.0, 5.0);
            s1.add(10.0, 15.5);
            s1.add(15.0, 9.5);
            s1.add(20.0, 7.5);
            dataset.addSeries(s1);
            XYSeries s2 = new XYSeries("Series 2", true, false);
            s2.add(5.0, 5.0);
            s2.add(10.0, 15.5);
            s2.add(15.0, 9.5);
            s2.add(20.0, 3.5);
            dataset.addSeries(s2);
            XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new XYAreaRenderer());
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, null);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
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
        XYAreaRenderer r = new XYAreaRenderer();
        XYPlot plot = new XYPlot(d1, new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, d2);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
