package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.Rotation;
import org.jfree.util.TableOrder;
import org.junit.Test;

/**
 * Tests for the {@link SpiderWebPlot} class.
 */
public class SpiderWebPlotTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        SpiderWebPlot p1 = new SpiderWebPlot(new DefaultCategoryDataset());
        SpiderWebPlot p2 = new SpiderWebPlot(new DefaultCategoryDataset());
        p1.setDataExtractOrder(TableOrder.BY_COLUMN);
        p2.setDataExtractOrder(TableOrder.BY_COLUMN);
        p1.setHeadPercent(0.321);
        p2.setHeadPercent(0.321);
        p1.setInteriorGap(0.123);
        p2.setInteriorGap(0.123);
        p1.setStartAngle(0.456);
        p2.setStartAngle(0.456);
        p1.setDirection(Rotation.ANTICLOCKWISE);
        p2.setDirection(Rotation.ANTICLOCKWISE);
        p1.setMaxValue(123.4);
        p2.setMaxValue(123.4);
        p1.setLegendItemShape(new Rectangle(1, 2, 3, 4));
        p2.setLegendItemShape(new Rectangle(1, 2, 3, 4));
        p1.setSeriesPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        p2.setSeriesPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        p1.setSeriesPaint(1, new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white));
        p2.setSeriesPaint(1, new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white));
        p1.setBaseSeriesPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        p2.setBaseSeriesPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        p1.setSeriesOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.black));
        p2.setSeriesOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.black));
        p1.setSeriesOutlinePaint(1, new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        p2.setSeriesOutlinePaint(1, new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        p1.setBaseSeriesOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.green));
        p2.setBaseSeriesOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.green));
        BasicStroke s = new BasicStroke(1.23f);
        p1.setSeriesOutlineStroke(s);
        p2.setSeriesOutlineStroke(s);
        p1.setSeriesOutlineStroke(1, s);
        p2.setSeriesOutlineStroke(1, s);
        p1.setBaseSeriesOutlineStroke(s);
        p2.setBaseSeriesOutlineStroke(s);
        p1.setWebFilled(false);
        p2.setWebFilled(false);
        p1.setAxisLabelGap(0.11);
        p2.setAxisLabelGap(0.11);
        p1.setLabelFont(new Font("Serif", Font.PLAIN, 9));
        p2.setLabelFont(new Font("Serif", Font.PLAIN, 9));
        p1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p2.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setLabelGenerator(new StandardCategoryItemLabelGenerator("XYZ: {0}", new DecimalFormat("0.000")));
        p2.setLabelGenerator(new StandardCategoryItemLabelGenerator("XYZ: {0}", new DecimalFormat("0.000")));
        p1.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        p2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        p1.setURLGenerator(new StandardCategoryURLGenerator());
        p2.setURLGenerator(new StandardCategoryURLGenerator());
        p1.setAxisLinePaint(Color.red);
        p2.setAxisLinePaint(Color.red);
        p1.setAxisLineStroke(new BasicStroke(1.1f));
        p2.setAxisLineStroke(new BasicStroke(1.1f));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        SpiderWebPlot p1 = new SpiderWebPlot(new DefaultCategoryDataset());
        Rectangle2D legendShape = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        p1.setLegendItemShape(legendShape);
        SpiderWebPlot p2 = (SpiderWebPlot) p1.clone();
        legendShape.setRect(4.0, 3.0, 2.0, 1.0);
        p2.setLegendItemShape(legendShape);
        p1.setSeriesPaint(1, Color.black);
        p2.setSeriesPaint(1, Color.black);
        p1.setSeriesOutlinePaint(0, Color.red);
        p2.setSeriesOutlinePaint(0, Color.red);
        p1.setSeriesOutlineStroke(0, new BasicStroke(1.1f));
        p2.setSeriesOutlineStroke(0, new BasicStroke(1.1f));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        SpiderWebPlot p1 = new SpiderWebPlot(new DefaultCategoryDataset());
        SpiderWebPlot p2 = (SpiderWebPlot) TestUtilities.serialised(p1);
    }

    /**
     * Draws the chart with a null info object to make sure that no exceptions
     * are thrown.
     */
    public void testDrawWithNullInfo() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(35.0, "S1", "C1");
        dataset.addValue(45.0, "S1", "C2");
        dataset.addValue(55.0, "S1", "C3");
        dataset.addValue(15.0, "S1", "C4");
        dataset.addValue(25.0, "S1", "C5");
        SpiderWebPlot plot = new SpiderWebPlot(dataset);
        JFreeChart chart = new JFreeChart(plot);
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
            g2.dispose();
        } catch (Exception e) {
            fail("There should be no exception.");
        }
    }

    /**
     * Fetches the legend items and checks the values.
     */
    public void testGetLegendItems() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(35.0, "S1", "C1");
        dataset.addValue(45.0, "S1", "C2");
        dataset.addValue(55.0, "S2", "C1");
        dataset.addValue(15.0, "S2", "C2");
        SpiderWebPlot plot = new SpiderWebPlot(dataset);
        JFreeChart chart = new JFreeChart(plot);
        LegendItemCollection legendItems = plot.getLegendItems();
        LegendItem item1 = legendItems.get(0);
        LegendItem item2 = legendItems.get(1);
    }
}
