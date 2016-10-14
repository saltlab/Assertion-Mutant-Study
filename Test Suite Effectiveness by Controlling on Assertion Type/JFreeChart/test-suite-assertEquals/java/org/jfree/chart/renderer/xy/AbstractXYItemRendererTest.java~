package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Tests for the {@link AbstractXYItemRenderer} class.
 */
public class AbstractXYItemRendererTest {

    /**
     * Creates a test dataset.
     *
     * @return A test dataset.
     */
    private XYDataset createDataset1() {
        XYSeries series = new XYSeries("Series");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the findDomainBounds() method.
     */
    public void testFindDomainBounds() {
        AbstractXYItemRenderer renderer = new StandardXYItemRenderer();
        XYDataset dataset = createDataset1();
        Range r = renderer.findDomainBounds(dataset);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        AbstractXYItemRenderer renderer = new StandardXYItemRenderer();
    }

    /**
     * Check that the legendItemLabelGenerator is cloned.
     */
    public void testCloning_LegendItemLabelGenerator() throws CloneNotSupportedException {
        StandardXYSeriesLabelGenerator generator = new StandardXYSeriesLabelGenerator("Series {0}");
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setLegendItemLabelGenerator(generator);
        XYBarRenderer r2 = (XYBarRenderer) r1.clone();
    }

    /**
     * Check that the legendItemToolTipGenerator is cloned.
     */
    public void testCloning_LegendItemToolTipGenerator() throws CloneNotSupportedException {
        StandardXYSeriesLabelGenerator generator = new StandardXYSeriesLabelGenerator("Series {0}");
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setLegendItemToolTipGenerator(generator);
        XYBarRenderer r2 = (XYBarRenderer) r1.clone();
    }

    /**
     * Check that the legendItemURLGenerator is cloned.
     */
    public void testCloning_LegendItemURLGenerator() throws CloneNotSupportedException {
        StandardXYSeriesLabelGenerator generator = new StandardXYSeriesLabelGenerator("Series {0}");
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setLegendItemURLGenerator(generator);
        XYBarRenderer r2 = (XYBarRenderer) r1.clone();
    }

    public void testEquals_ObjectList() {
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        XYBarRenderer r2 = new XYBarRenderer();
        r2.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        r2.setSeriesItemLabelGenerator(1, new StandardXYItemLabelGenerator("X"));
    }

    public void testEquals_ObjectList2() {
        XYBarRenderer r1 = new XYBarRenderer();
        r1.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        XYBarRenderer r2 = new XYBarRenderer();
        r2.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        r2.setSeriesToolTipGenerator(1, new StandardXYToolTipGenerator());
    }
}
