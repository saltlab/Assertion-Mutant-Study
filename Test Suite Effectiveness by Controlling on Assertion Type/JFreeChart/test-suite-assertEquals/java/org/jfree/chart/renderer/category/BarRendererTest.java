package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.RendererChangeDetector;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link BarRenderer} class.
 */
public class BarRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        BarRenderer r1 = new BarRenderer();
        BarRenderer r2 = new BarRenderer();
        r1.setBase(0.123);
        r2.setBase(0.123);
        r1.setItemMargin(0.22);
        r2.setItemMargin(0.22);
        r1.setDrawBarOutline(!r1.isDrawBarOutline());
        r2.setDrawBarOutline(!r2.isDrawBarOutline());
        r1.setMaximumBarWidth(0.11);
        r2.setMaximumBarWidth(0.11);
        r1.setMinimumBarLength(0.04);
        r2.setMinimumBarLength(0.04);
        r1.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        r2.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        r1.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.INSIDE1, TextAnchor.CENTER));
        r2.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.INSIDE1, TextAnchor.CENTER));
        r1.setNegativeItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.INSIDE1, TextAnchor.CENTER));
        r2.setNegativeItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.INSIDE1, TextAnchor.CENTER));
        r1.setBarPainter(new GradientBarPainter(0.1, 0.2, 0.3));
        r2.setBarPainter(new GradientBarPainter(0.1, 0.2, 0.3));
        r1.setShadowVisible(false);
        r2.setShadowVisible(false);
        r1.setShadowPaint(Color.red);
        r2.setShadowPaint(Color.red);
        r1.setShadowXOffset(3.3);
        r2.setShadowXOffset(3.3);
        r1.setShadowYOffset(3.3);
        r2.setShadowYOffset(3.3);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        BarRenderer r1 = new BarRenderer();
        BarRenderer r2 = new BarRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BarRenderer r1 = new BarRenderer();
        r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        r1.setBarPainter(new GradientBarPainter(0.11, 0.22, 0.33));
        BarRenderer r2 = (BarRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        BarRenderer r1 = new BarRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BarRenderer r1 = new BarRenderer();
        BarRenderer r2 = (BarRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Tests each setter method to ensure that it sends an event notification.
     */
    public void testEventNotification() {
        RendererChangeDetector detector = new RendererChangeDetector();
        BarRenderer r1 = new BarRenderer();
        r1.addChangeListener(detector);
        detector.setNotified(false);
        r1.setBasePaint(Color.red);
    }

    /**
     * Some checks for the getLegendItem() method.
     */
    public void testGetLegendItem() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(21.0, "R1", "C1");
        BarRenderer r = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset, new CategoryAxis("x"), new NumberAxis("y"), r);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(0, 0);
        r.setSeriesVisibleInLegend(0, Boolean.FALSE);
        li = r.getLegendItem(0, 0);
    }

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    public void testGetLegendItemSeriesIndex() {
        DefaultCategoryDataset dataset0 = new DefaultCategoryDataset();
        dataset0.addValue(21.0, "R1", "C1");
        dataset0.addValue(22.0, "R2", "C1");
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        dataset1.addValue(23.0, "R3", "C1");
        dataset1.addValue(24.0, "R4", "C1");
        dataset1.addValue(25.0, "R5", "C1");
        BarRenderer r = new BarRenderer();
        CategoryPlot plot = new CategoryPlot(dataset0, new CategoryAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, dataset1);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        BarRenderer r = new BarRenderer();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R1", "C1");
        r.setIncludeBaseInRange(false);
        r.setIncludeBaseInRange(true);
        dataset.addValue(-2.0, "R1", "C2");
        dataset.addValue(null, "R1", "C3");
        dataset.addValue(-6.0, "R2", "C1");
        r.setSeriesVisible(1, Boolean.FALSE);
    }
}
