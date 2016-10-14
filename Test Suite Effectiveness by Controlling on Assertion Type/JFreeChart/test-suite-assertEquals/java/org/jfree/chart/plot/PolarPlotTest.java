package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

/**
 * Some tests for the {@link PolarPlot} class.
 */
public class PolarPlotTest {

    /**
     * Some checks for the getLegendItems() method.
     */
    public void testGetLegendItems() {
        XYSeriesCollection d = new XYSeriesCollection();
        d.addSeries(new XYSeries("A"));
        d.addSeries(new XYSeries("B"));
        DefaultPolarItemRenderer r = new DefaultPolarItemRenderer();
        PolarPlot plot = new PolarPlot();
        plot.setDataset(d);
        plot.setRenderer(r);
        LegendItemCollection items = plot.getLegendItems();
        LegendItem item1 = items.get(0);
        LegendItem item2 = items.get(1);
    }

    /**
     * Some checks for the getLegendItems() method with multiple datasets.
     */
    public void testGetLegendItems2() {
        XYSeriesCollection d1 = new XYSeriesCollection();
        d1.addSeries(new XYSeries("A"));
        d1.addSeries(new XYSeries("B"));
        XYSeriesCollection d2 = new XYSeriesCollection();
        d2.addSeries(new XYSeries("C"));
        d2.addSeries(new XYSeries("D"));
        DefaultPolarItemRenderer r = new DefaultPolarItemRenderer();
        PolarPlot plot = new PolarPlot();
        plot.setDataset(d1);
        plot.setDataset(1, d2);
        plot.setRenderer(r);
        plot.setRenderer(1, new DefaultPolarItemRenderer());
        LegendItemCollection items = plot.getLegendItems();
        LegendItem item1 = items.get(0);
        LegendItem item2 = items.get(1);
        LegendItem item3 = items.get(2);
        LegendItem item4 = items.get(3);
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        PolarPlot plot1 = new PolarPlot();
        PolarPlot plot2 = new PolarPlot();
        plot1.setAngleGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setAngleGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        Stroke s = new BasicStroke(1.23f);
        plot1.setAngleGridlineStroke(s);
        plot2.setAngleGridlineStroke(s);
        plot1.setAngleTickUnit(new NumberTickUnit(11.0));
        plot2.setAngleTickUnit(new NumberTickUnit(11.0));
        plot1.setAngleGridlinesVisible(false);
        plot2.setAngleGridlinesVisible(false);
        plot1.setAngleLabelFont(new Font("Serif", Font.PLAIN, 9));
        plot2.setAngleLabelFont(new Font("Serif", Font.PLAIN, 9));
        plot1.setAngleLabelPaint(new GradientPaint(9.0f, 8.0f, Color.blue, 7.0f, 6.0f, Color.red));
        plot2.setAngleLabelPaint(new GradientPaint(9.0f, 8.0f, Color.blue, 7.0f, 6.0f, Color.red));
        plot1.setAngleLabelsVisible(false);
        plot2.setAngleLabelsVisible(false);
        plot1.setAxis(new NumberAxis("Test"));
        plot2.setAxis(new NumberAxis("Test"));
        plot1.setRadiusGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.black));
        plot2.setRadiusGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.black));
        plot1.setRadiusGridlineStroke(s);
        plot2.setRadiusGridlineStroke(s);
        plot1.setRadiusGridlinesVisible(false);
        plot2.setRadiusGridlinesVisible(false);
        plot1.setRadiusMinorGridlinesVisible(false);
        plot2.setRadiusMinorGridlinesVisible(false);
        plot1.addCornerTextItem("XYZ");
        plot2.addCornerTextItem("XYZ");
        plot1.setMargin(6);
        plot2.setMargin(6);
        LegendItemCollection lic1 = new LegendItemCollection();
        lic1.add(new LegendItem("XYZ", Color.red));
        plot1.setFixedLegendItems(lic1);
        LegendItemCollection lic2 = new LegendItemCollection();
        lic2.add(new LegendItem("XYZ", Color.red));
        plot2.setFixedLegendItems(lic2);
    }

    /**
     * Some basic checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        PolarPlot p1 = new PolarPlot();
        PolarPlot p2 = (PolarPlot) p1.clone();
        p1.addCornerTextItem("XYZ");
        p2.addCornerTextItem("XYZ");
        p1 = new PolarPlot(new DefaultXYDataset(), new NumberAxis("A1"), new DefaultPolarItemRenderer());
        p2 = (PolarPlot) p1.clone();
        p1.getAxis().setLabel("ABC");
        p2.getAxis().setLabel("ABC");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PolarPlot p1 = new PolarPlot();
        p1.setAngleGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setAngleLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setRadiusGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        PolarPlot p2 = (PolarPlot) TestUtilities.serialised(p1);
    }

    public void testTranslateToJava2D_NumberAxis() {
        Rectangle2D dataArea = new Rectangle2D.Double(0.0, 0.0, 100.0, 100.0);
        ValueAxis axis = new NumberAxis();
        axis.setRange(0.0, 20.0);
        PolarPlot plot = new PolarPlot(null, axis, null);
        plot.setMargin(0);
        plot.setAngleOffset(0.0);
        Point point = plot.translateToJava2D(0.0, 10.0, axis, dataArea);
        point = plot.translateToJava2D(90.0, 5.0, axis, dataArea);
        point = plot.translateToJava2D(45.0, 20.0, axis, dataArea);
        point = plot.translateToJava2D(135.0, 20.0, axis, dataArea);
        point = plot.translateToJava2D(225.0, 15.0, axis, dataArea);
        point = plot.translateToJava2D(315.0, 15.0, axis, dataArea);
        point = plot.translateToJava2D(21.0, 11.5, axis, dataArea);
        point = plot.translateToJava2D(162.0, 7.0, axis, dataArea);
    }

    public void testTranslateToJava2D_NumberAxisAndMargin() {
        Rectangle2D dataArea = new Rectangle2D.Double(10.0, 10.0, 80.0, 80.0);
        ValueAxis axis = new NumberAxis();
        axis.setRange(-2.0, 2.0);
        PolarPlot plot = new PolarPlot(null, axis, null);
        plot.setAngleOffset(0.0);
        Point point = plot.translateToJava2D(0.0, 10.0, axis, dataArea);
        point = plot.translateToJava2D(90.0, 5.0, axis, dataArea);
        point = plot.translateToJava2D(45.0, 20.0, axis, dataArea);
        point = plot.translateToJava2D(135.0, 20.0, axis, dataArea);
        point = plot.translateToJava2D(225.0, 15.0, axis, dataArea);
        point = plot.translateToJava2D(315.0, 15.0, axis, dataArea);
        point = plot.translateToJava2D(21.0, 11.5, axis, dataArea);
        point = plot.translateToJava2D(162.0, 7.0, axis, dataArea);
    }

    public void testTranslateToJava2D_LogAxis() {
        Rectangle2D dataArea = new Rectangle2D.Double(0.0, 0.0, 100.0, 100.0);
        ValueAxis axis = new LogAxis();
        axis.setRange(1.0, 100.0);
        PolarPlot plot = new PolarPlot(null, axis, null);
        plot.setMargin(0);
        plot.setAngleOffset(0.0);
        Point point = plot.translateToJava2D(0.0, 10.0, axis, dataArea);
        point = plot.translateToJava2D(90.0, 5.0, axis, dataArea);
        point = plot.translateToJava2D(45.0, 20.0, axis, dataArea);
    }
}
