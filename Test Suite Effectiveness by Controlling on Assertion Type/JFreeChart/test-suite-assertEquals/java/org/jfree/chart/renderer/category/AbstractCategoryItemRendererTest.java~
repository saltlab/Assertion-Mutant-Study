package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Tests for the {@link AbstractCategoryItemRenderer} class.
 */
public class AbstractCategoryItemRendererTest {

    /**
     * Checks that all fields are distinguished.
     */
    public void testEquals() {
        BarRenderer r1 = new BarRenderer();
        BarRenderer r2 = new BarRenderer();
        r1.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        r2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        r1.setSeriesToolTipGenerator(1, new StandardCategoryToolTipGenerator());
        r2.setSeriesToolTipGenerator(1, new StandardCategoryToolTipGenerator());
        r1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{2}", NumberFormat.getInstance()));
        r2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{2}", NumberFormat.getInstance()));
        r1.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        r2.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        r1.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator());
        r2.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator());
        r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance()));
        r2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance()));
        r1.setItemURLGenerator(new StandardCategoryURLGenerator());
        r2.setItemURLGenerator(new StandardCategoryURLGenerator());
        r1.setSeriesItemURLGenerator(1, new StandardCategoryURLGenerator());
        r2.setSeriesItemURLGenerator(1, new StandardCategoryURLGenerator());
        r1.setBaseItemURLGenerator(new StandardCategoryURLGenerator("abc.html"));
        r2.setBaseItemURLGenerator(new StandardCategoryURLGenerator("abc.html"));
        r1.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("XYZ"));
        r2.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("XYZ"));
        r1.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("ToolTip"));
        r2.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("ToolTip"));
        r1.setLegendItemURLGenerator(new StandardCategorySeriesLabelGenerator("URL"));
        r2.setLegendItemURLGenerator(new StandardCategorySeriesLabelGenerator("URL"));
    }

    public void testEquals_ObjectList() {
        BarRenderer r1 = new BarRenderer();
        r1.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        BarRenderer r2 = new BarRenderer();
        r2.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        r2.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator("X", new DecimalFormat("0.0")));
    }

    public void testEquals_ObjectList2() {
        BarRenderer r1 = new BarRenderer();
        r1.setSeriesToolTipGenerator(0, new StandardCategoryToolTipGenerator());
        BarRenderer r2 = new BarRenderer();
        r2.setSeriesToolTipGenerator(0, new StandardCategoryToolTipGenerator());
        r2.setSeriesToolTipGenerator(1, new StandardCategoryToolTipGenerator("X", new DecimalFormat("0.0")));
    }

    public void testEquals_ObjectList3() {
        BarRenderer r1 = new BarRenderer();
        r1.setSeriesItemURLGenerator(0, new StandardCategoryURLGenerator());
        BarRenderer r2 = new BarRenderer();
        r2.setSeriesItemURLGenerator(0, new StandardCategoryURLGenerator());
        r2.setSeriesItemURLGenerator(1, new StandardCategoryURLGenerator());
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning1() throws CloneNotSupportedException {
        AbstractCategoryItemRenderer r1 = new BarRenderer();
        r1.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        AbstractCategoryItemRenderer r2 = (BarRenderer) r1.clone();
        r1 = new BarRenderer();
        r1.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        r2 = (BarRenderer) r1.clone();
        r1 = new BarRenderer();
        r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        r2 = (BarRenderer) r1.clone();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning2() throws CloneNotSupportedException {
        BarRenderer r1 = new BarRenderer();
        r1.setBaseItemLabelGenerator(new IntervalCategoryItemLabelGenerator());
        BarRenderer r2 = (BarRenderer) r1.clone();
        r1 = new BarRenderer();
        r1.setSeriesItemLabelGenerator(0, new IntervalCategoryItemLabelGenerator());
        r2 = (BarRenderer) r1.clone();
        r1 = new BarRenderer();
        r1.setBaseItemLabelGenerator(new IntervalCategoryItemLabelGenerator());
        r2 = (BarRenderer) r1.clone();
    }

    /**
     * Check that the legendItemLabelGenerator is cloned.
     */
    public void testCloning_LegendItemLabelGenerator() throws CloneNotSupportedException {
        StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}");
        BarRenderer r1 = new BarRenderer();
        r1.setLegendItemLabelGenerator(generator);
        BarRenderer r2 = (BarRenderer) r1.clone();
    }

    /**
     * Check that the legendItemToolTipGenerator is cloned.
     */
    public void testCloning_LegendItemToolTipGenerator() throws CloneNotSupportedException {
        StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}");
        BarRenderer r1 = new BarRenderer();
        r1.setLegendItemToolTipGenerator(generator);
        BarRenderer r2 = (BarRenderer) r1.clone();
    }

    /**
     * Check that the legendItemURLGenerator is cloned.
     */
    public void testCloning_LegendItemURLGenerator() throws CloneNotSupportedException {
        StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}");
        BarRenderer r1 = new BarRenderer();
        r1.setLegendItemURLGenerator(generator);
        BarRenderer r2 = (BarRenderer) r1.clone();
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        AbstractCategoryItemRenderer r = new LineAndShapeRenderer();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R1", "C1");
        dataset.addValue(-2.0, "R1", "C2");
        dataset.addValue(null, "R1", "C3");
    }

    /**
     * A test that reproduces the problem reported in bug 2947660.
     */
    public void test2947660() {
        AbstractCategoryItemRenderer r = new LineAndShapeRenderer();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CategoryPlot plot = new CategoryPlot();
        plot.setDataset(dataset);
        plot.setRenderer(r);
        dataset.addValue(1.0, "S1", "C1");
        LegendItemCollection lic = r.getLegendItems();
    }
}
