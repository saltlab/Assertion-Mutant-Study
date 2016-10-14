package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Line2D;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYDifferenceRenderer} class.
 */
public class XYDifferenceRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYDifferenceRenderer r1 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        XYDifferenceRenderer r2 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        r1.setPositivePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r2.setPositivePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r1.setNegativePaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.blue));
        r2.setNegativePaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.blue));
        r1 = new XYDifferenceRenderer(Color.green, Color.yellow, true);
        r2 = new XYDifferenceRenderer(Color.green, Color.yellow, true);
        r1.setLegendLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        r2.setLegendLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        r1.setRoundXCoordinates(true);
        r2.setRoundXCoordinates(true);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYDifferenceRenderer r1 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        XYDifferenceRenderer r2 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYDifferenceRenderer r1 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        XYDifferenceRenderer r2 = (XYDifferenceRenderer) r1.clone();
        Shape s = r1.getLegendLine();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYDifferenceRenderer r1 = new XYDifferenceRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYDifferenceRenderer r1 = new XYDifferenceRenderer(Color.red, Color.blue, false);
        XYDifferenceRenderer r2 = (XYDifferenceRenderer) TestUtilities.serialised(r1);
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
        XYDifferenceRenderer r = new XYDifferenceRenderer();
        XYPlot plot = new XYPlot(d1, new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, d2);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
