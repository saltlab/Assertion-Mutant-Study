package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link ValueAxis} class.
 */
public class ValueAxisTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ValueAxis a1 = new NumberAxis("Test");
        ValueAxis a2 = (NumberAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        NumberAxis a1 = new NumberAxis("Test");
        NumberAxis a2 = new NumberAxis("Test");
        a1.setAxisLineVisible(false);
        a2.setAxisLineVisible(false);
        a1.setPositiveArrowVisible(true);
        a2.setPositiveArrowVisible(true);
        a1.setNegativeArrowVisible(true);
        a2.setNegativeArrowVisible(true);
        a1.setAxisLinePaint(Color.blue);
        a2.setAxisLinePaint(Color.blue);
        Stroke stroke = new BasicStroke(2.0f);
        a1.setAxisLineStroke(stroke);
        a2.setAxisLineStroke(stroke);
        a1.setInverted(true);
        a2.setInverted(true);
        a1.setRange(new Range(50.0, 75.0));
        a2.setRange(new Range(50.0, 75.0));
        a1.setAutoRange(true);
        a2.setAutoRange(true);
        a1.setAutoRangeMinimumSize(3.33);
        a2.setAutoRangeMinimumSize(3.33);
        a1.setDefaultAutoRange(new Range(1.2, 3.4));
        a2.setDefaultAutoRange(new Range(1.2, 3.4));
        a1.setUpperMargin(0.09);
        a2.setUpperMargin(0.09);
        a1.setLowerMargin(0.09);
        a2.setLowerMargin(0.09);
        a1.setFixedAutoRange(50.0);
        a2.setFixedAutoRange(50.0);
        a1.setAutoTickUnitSelection(false);
        a2.setAutoTickUnitSelection(false);
        a1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        a2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        a1.setVerticalTickLabels(true);
        a2.setVerticalTickLabels(true);
    }

    /**
     * Tests the the lower and upper margin settings produce the expected
     * results.
     */
    public void testAxisMargins() {
        XYSeries series = new XYSeries("S1");
        series.add(100.0, 1.1);
        series.add(200.0, 2.2);
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        dataset.setIntervalWidth(0.0);
        JFreeChart chart = ChartFactory.createScatterPlot("Title", "X", "Y", dataset);
        ValueAxis domainAxis = ((XYPlot) chart.getPlot()).getDomainAxis();
        Range r = domainAxis.getRange();
        domainAxis.setLowerMargin(0.10);
        domainAxis.setUpperMargin(0.10);
        r = domainAxis.getRange();
    }

    /**
     * A test for bug 3555275 (where the fixed axis space is calculated 
     * incorrectly).
     */
    public void test3555275() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setInsets(RectangleInsets.ZERO_INSETS);
        plot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setFixedDimension(100.0);
        BufferedImage image = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        ChartRenderingInfo info = new ChartRenderingInfo();
        chart.draw(g2, new Rectangle2D.Double(0, 0, 500, 300), info);
        g2.dispose();
        Rectangle2D rect = info.getPlotInfo().getDataArea();
        double x = rect.getMinX();
    }
}
