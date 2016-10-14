package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.urls.CustomPieURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Some tests for the {@link PiePlot} class.
 */
public class PiePlotTest {

    /**
     * Test the equals() method.
     */
    public void testEquals() {
        PiePlot plot1 = new PiePlot();
        PiePlot plot2 = new PiePlot();
        plot1.setPieIndex(99);
        plot2.setPieIndex(99);
        plot1.setInteriorGap(0.15);
        plot2.setInteriorGap(0.15);
        plot1.setCircular(!plot1.isCircular());
        plot2.setCircular(false);
        plot1.setStartAngle(Math.PI);
        plot2.setStartAngle(Math.PI);
        plot1.setDirection(Rotation.ANTICLOCKWISE);
        plot2.setDirection(Rotation.ANTICLOCKWISE);
        plot1.setIgnoreZeroValues(true);
        plot2.setIgnoreZeroValues(false);
        plot2.setIgnoreZeroValues(true);
        plot1.setIgnoreNullValues(true);
        plot2.setIgnoreNullValues(false);
        plot2.setIgnoreNullValues(true);
        plot1.setSectionPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        plot2.setSectionPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        plot1.setSectionPaint("A", new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.white));
        plot2.setSectionPaint("A", new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.white));
        plot1.setBaseSectionPaint(new GradientPaint(1.0f, 2.0f, Color.black, 3.0f, 4.0f, Color.white));
        plot2.setBaseSectionPaint(new GradientPaint(1.0f, 2.0f, Color.black, 3.0f, 4.0f, Color.white));
        plot1.setSectionOutlinesVisible(false);
        plot2.setSectionOutlinesVisible(false);
        plot1.setSectionOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.white));
        plot2.setSectionOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.white));
        plot1.setSectionOutlinePaint("A", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.white));
        plot2.setSectionOutlinePaint("A", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.white));
        plot1.setBaseSectionOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.gray, 3.0f, 4.0f, Color.white));
        plot2.setBaseSectionOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.gray, 3.0f, 4.0f, Color.white));
        plot1.setSectionOutlineStroke(new BasicStroke(1.0f));
        plot2.setSectionOutlineStroke(new BasicStroke(1.0f));
        plot1.setSectionOutlineStroke("A", new BasicStroke(1.0f));
        plot2.setSectionOutlineStroke("A", new BasicStroke(1.0f));
        plot1.setBaseSectionOutlineStroke(new BasicStroke(1.0f));
        plot2.setBaseSectionOutlineStroke(new BasicStroke(1.0f));
        plot1.setShadowPaint(new GradientPaint(1.0f, 2.0f, Color.orange, 3.0f, 4.0f, Color.white));
        plot2.setShadowPaint(new GradientPaint(1.0f, 2.0f, Color.orange, 3.0f, 4.0f, Color.white));
        plot1.setShadowXOffset(4.4);
        plot2.setShadowXOffset(4.4);
        plot1.setShadowYOffset(4.4);
        plot2.setShadowYOffset(4.4);
        plot1.setLabelFont(new Font("Serif", Font.PLAIN, 18));
        plot2.setLabelFont(new Font("Serif", Font.PLAIN, 18));
        plot1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.darkGray, 3.0f, 4.0f, Color.white));
        plot2.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.darkGray, 3.0f, 4.0f, Color.white));
        plot1.setLabelBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        plot2.setLabelBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        plot1.setLabelOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.white));
        plot2.setLabelOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.white));
        Stroke s = new BasicStroke(1.1f);
        plot1.setLabelOutlineStroke(s);
        plot2.setLabelOutlineStroke(s);
        plot1.setLabelShadowPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white));
        plot2.setLabelShadowPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white));
        plot1.setExplodePercent("A", 0.33);
        plot2.setExplodePercent("A", 0.33);
        plot1.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}{1}{0}"));
        plot2.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}{1}{0}"));
        Font f = new Font("SansSerif", Font.PLAIN, 20);
        plot1.setLabelFont(f);
        plot2.setLabelFont(f);
        plot1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.magenta, 3.0f, 4.0f, Color.white));
        plot2.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.magenta, 3.0f, 4.0f, Color.white));
        plot1.setMaximumLabelWidth(0.33);
        plot2.setMaximumLabelWidth(0.33);
        plot1.setLabelGap(0.11);
        plot2.setLabelGap(0.11);
        plot1.setLabelLinksVisible(false);
        plot2.setLabelLinksVisible(false);
        plot1.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
        plot2.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
        plot1.setLabelLinkMargin(0.11);
        plot2.setLabelLinkMargin(0.11);
        plot1.setLabelLinkPaint(new GradientPaint(1.0f, 2.0f, Color.magenta, 3.0f, 4.0f, Color.white));
        plot2.setLabelLinkPaint(new GradientPaint(1.0f, 2.0f, Color.magenta, 3.0f, 4.0f, Color.white));
        plot1.setLabelLinkStroke(new BasicStroke(1.0f));
        plot2.setLabelLinkStroke(new BasicStroke(1.0f));
        plot1.setToolTipGenerator(new StandardPieToolTipGenerator("{2}{1}{0}"));
        plot2.setToolTipGenerator(new StandardPieToolTipGenerator("{2}{1}{0}"));
        plot1.setURLGenerator(new StandardPieURLGenerator("xx"));
        plot2.setURLGenerator(new StandardPieURLGenerator("xx"));
        plot1.setMinimumArcAngleToDraw(1.0);
        plot2.setMinimumArcAngleToDraw(1.0);
        plot1.setLegendItemShape(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        plot2.setLegendItemShape(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        plot1.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0} --> {1}"));
        plot2.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0} --> {1}"));
        plot1.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("{0} is {1}"));
        plot2.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("{0} is {1}"));
        plot1.setLegendLabelURLGenerator(new StandardPieURLGenerator("index.html"));
        plot2.setLegendLabelURLGenerator(new StandardPieURLGenerator("index.html"));
        plot1.setAutoPopulateSectionPaint(false);
        plot2.setAutoPopulateSectionPaint(false);
        plot1.setAutoPopulateSectionOutlinePaint(true);
        plot2.setAutoPopulateSectionOutlinePaint(true);
        plot1.setAutoPopulateSectionOutlineStroke(true);
        plot2.setAutoPopulateSectionOutlineStroke(true);
        plot1.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot2.setShadowGenerator(new DefaultShadowGenerator(5, Color.gray, 0.6f, 4, -Math.PI / 4));
        plot1.setShadowGenerator(null);
        plot2.setShadowGenerator(null);
    }

    /**
     * Some basic checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        PiePlot p1 = new PiePlot();
        PiePlot p2 = (PiePlot) p1.clone();
    }

    /**
     * Check cloning of the urlGenerator field.
     */
    public void testCloning_URLGenerator() throws CloneNotSupportedException {
        CustomPieURLGenerator generator = new CustomPieURLGenerator();
        PiePlot p1 = new PiePlot();
        p1.setURLGenerator(generator);
        PiePlot p2 = (PiePlot) p1.clone();
    }

    /**
     * Check cloning of the legendItemShape field.
     */
    public void testCloning_LegendItemShape() throws CloneNotSupportedException {
        Rectangle shape = new Rectangle(-4, -4, 8, 8);
        PiePlot p1 = new PiePlot();
        p1.setLegendItemShape(shape);
        PiePlot p2 = (PiePlot) p1.clone();
        shape.setRect(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * Check cloning of the legendLabelGenerator field.
     */
    public void testCloning_LegendLabelGenerator() throws CloneNotSupportedException {
        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator();
        PiePlot p1 = new PiePlot();
        p1.setLegendLabelGenerator(generator);
        PiePlot p2 = (PiePlot) p1.clone();
        generator.getNumberFormat().setMinimumFractionDigits(2);
    }

    /**
     * Check cloning of the legendLabelToolTipGenerator field.
     */
    public void testCloning_LegendLabelToolTipGenerator() throws CloneNotSupportedException {
        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator();
        PiePlot p1 = new PiePlot();
        p1.setLegendLabelToolTipGenerator(generator);
        PiePlot p2 = (PiePlot) p1.clone();
        generator.getNumberFormat().setMinimumFractionDigits(2);
    }

    /**
     * Check cloning of the legendLabelURLGenerator field.
     */
    public void testCloning_LegendLabelURLGenerator() throws CloneNotSupportedException {
        CustomPieURLGenerator generator = new CustomPieURLGenerator();
        PiePlot p1 = new PiePlot();
        p1.setLegendLabelURLGenerator(generator);
        PiePlot p2 = (PiePlot) p1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PiePlot p1 = new PiePlot(null);
        PiePlot p2 = (PiePlot) TestUtilities.serialised(p1);
    }

    /**
     * Some checks for the getLegendItems() method.
     */
    public void testGetLegendItems() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Item 1", 1.0);
        dataset.setValue("Item 2", 2.0);
        dataset.setValue("Item 3", 0.0);
        dataset.setValue("Item 4", null);
        PiePlot plot = new PiePlot(dataset);
        plot.setIgnoreNullValues(false);
        plot.setIgnoreZeroValues(false);
        LegendItemCollection items = plot.getLegendItems();
        plot.setIgnoreNullValues(true);
        items = plot.getLegendItems();
        plot.setIgnoreZeroValues(true);
        items = plot.getLegendItems();
        dataset.setValue("Item 5", -1.0);
        items = plot.getLegendItems();
    }

    /**
     * Check that the default base section paint is not null, and that you
     * can never set it to null.
     */
    public void testGetBaseSectionPaint() {
        PiePlot plot = new PiePlot();
        boolean pass = false;
        try {
            plot.setBaseSectionPaint(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    static class NullLegendLabelGenerator implements PieSectionLabelGenerator {

        @Override
        public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
            return null;
        }

        @Override
        public String generateSectionLabel(PieDataset dataset, Comparable key) {
            return null;
        }
    }

    /**
     * Draws a pie chart where the label generator returns null.
     */
    public void testDrawWithNullLegendLabels() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("L1", 12.0);
        dataset.setValue("L2", 11.0);
        JFreeChart chart = ChartFactory.createPieChart("Test", dataset, true, false, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLegendLabelGenerator(new NullLegendLabelGenerator());
        boolean success = false;
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
            g2.dispose();
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    public void testBug1126() throws CloneNotSupportedException {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        PiePlot plot1 = new PiePlot(dataset1);
        plot1.setSectionPaint("A", Color.RED);
        plot1.setSectionPaint("B", Color.GREEN);
        PiePlot plot2 = (PiePlot) plot1.clone();
        plot2.setSectionPaint("A", Color.BLUE);
        plot2.setSectionPaint("B", Color.YELLOW);
    }

    public void testBug1126_b() throws CloneNotSupportedException {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        PiePlot plot1 = new PiePlot(dataset1);
        plot1.setSectionOutlinePaint("A", Color.RED);
        plot1.setSectionOutlinePaint("B", Color.GREEN);
        PiePlot plot2 = (PiePlot) plot1.clone();
        plot2.setSectionOutlinePaint("A", Color.BLUE);
        plot2.setSectionOutlinePaint("B", Color.YELLOW);
    }

    public void testBug1126_c() throws CloneNotSupportedException {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        PiePlot plot1 = new PiePlot(dataset1);
        plot1.setSectionOutlineStroke("A", new BasicStroke(5.0f));
        plot1.setSectionOutlineStroke("B", new BasicStroke(6.0f));
        PiePlot plot2 = (PiePlot) plot1.clone();
        plot2.setSectionOutlineStroke("A", new BasicStroke(7.0f));
        plot2.setSectionOutlineStroke("B", new BasicStroke(8.0f));
    }

    public void testBug1126_d() throws CloneNotSupportedException {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        PiePlot plot1 = new PiePlot(dataset1);
        plot1.setExplodePercent("A", 0.1);
        plot1.setExplodePercent("B", 0.2);
        PiePlot plot2 = (PiePlot) plot1.clone();
        plot2.setExplodePercent("A", 0.3);
        plot2.setExplodePercent("B", 0.4);
    }

    private static final double EPSILON = 0.000000001;

    public void testBug1126_e() throws CloneNotSupportedException {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        PiePlot plot1 = new PiePlot(dataset1);
        plot1.setLabelGenerator(new StandardPieSectionLabelGenerator());
        PiePlot plot2 = (PiePlot) plot1.clone();
        StandardPieSectionLabelGenerator g2 = (StandardPieSectionLabelGenerator) plot2.getLabelGenerator();
        g2.setAttributedLabel(1, new AttributedString("TESTING"));
    }
}
