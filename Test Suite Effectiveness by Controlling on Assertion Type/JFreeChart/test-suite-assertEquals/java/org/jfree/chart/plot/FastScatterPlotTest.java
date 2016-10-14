package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.junit.Test;

/**
 * Tests for the {@link FastScatterPlot} class.
 */
public class FastScatterPlotTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        FastScatterPlot plot1 = new FastScatterPlot();
        FastScatterPlot plot2 = new FastScatterPlot();
        plot1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        plot2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        plot1.setDomainGridlinesVisible(false);
        plot2.setDomainGridlinesVisible(false);
        plot1.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        plot2.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        Stroke s = new BasicStroke(1.5f);
        plot1.setDomainGridlineStroke(s);
        plot2.setDomainGridlineStroke(s);
        plot1.setRangeGridlinesVisible(false);
        plot2.setRangeGridlinesVisible(false);
        plot1.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        plot2.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        Stroke s2 = new BasicStroke(1.5f);
        plot1.setRangeGridlineStroke(s2);
        plot2.setRangeGridlineStroke(s2);
        plot1.setDomainPannable(true);
        plot2.setDomainPannable(true);
        plot1.setRangePannable(true);
        plot2.setRangePannable(true);
    }

    /**
     * Some tests for the data array equality in the equals() method.
     */
    public void testEquals2() {
        FastScatterPlot plot1 = new FastScatterPlot();
        FastScatterPlot plot2 = new FastScatterPlot();
        float[][] a = new float[2][];
        float[][] b = new float[2][];
        plot1.setData(a);
        plot2.setData(b);
        a[0] = new float[6];
        b[0] = new float[6];
        a[0][0] = 1.0f;
        b[0][0] = 1.0f;
        a[0][1] = Float.NaN;
        b[0][1] = Float.NaN;
        a[0][2] = Float.POSITIVE_INFINITY;
        b[0][2] = Float.POSITIVE_INFINITY;
        a[0][3] = Float.NEGATIVE_INFINITY;
        b[0][3] = Float.NEGATIVE_INFINITY;
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        FastScatterPlot p1 = new FastScatterPlot();
        FastScatterPlot p2 = (FastScatterPlot) p1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        float[][] data = createData();
        ValueAxis domainAxis = new NumberAxis("X");
        ValueAxis rangeAxis = new NumberAxis("Y");
        FastScatterPlot p1 = new FastScatterPlot(data, domainAxis, rangeAxis);
        FastScatterPlot p2 = (FastScatterPlot) TestUtilities.serialised(p1);
    }

    /**
     * Draws the chart with a {@code null} info object to make sure that
     * no exceptions are thrown.
     */
    public void testDrawWithNullInfo() {
        try {
            float[][] data = createData();
            ValueAxis domainAxis = new NumberAxis("X");
            ValueAxis rangeAxis = new NumberAxis("Y");
            FastScatterPlot plot = new FastScatterPlot(data, domainAxis, rangeAxis);
            JFreeChart chart = new JFreeChart(plot);
            chart.createBufferedImage(300, 200, null);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * Populates the data array with random values.
     *
     * @return Random data.
     */
    private float[][] createData() {
        float[][] result = new float[2][1000];
        for (int i = 0; i < result[0].length; i++) {
            float x = (float) i + 100;
            result[0][i] = x;
            result[1][i] = 100 + (float) Math.random() * 1000;
        }
        return result;
    }
}
