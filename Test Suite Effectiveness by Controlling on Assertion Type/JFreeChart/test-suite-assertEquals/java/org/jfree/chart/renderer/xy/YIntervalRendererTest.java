package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.IntervalXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.Layer;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link YIntervalRenderer} class.
 */
public class YIntervalRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        YIntervalRenderer r1 = new YIntervalRenderer();
        YIntervalRenderer r2 = new YIntervalRenderer();
        r1.setItemLabelGenerator(new StandardXYItemLabelGenerator());
        r2.setItemLabelGenerator(new StandardXYItemLabelGenerator());
        r1.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        r2.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        r1.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        r2.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        r1.setToolTipGenerator(new StandardXYToolTipGenerator());
        r2.setToolTipGenerator(new StandardXYToolTipGenerator());
        r1.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        r2.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        r1.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        r2.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        r1.setURLGenerator(new StandardXYURLGenerator());
        r2.setURLGenerator(new StandardXYURLGenerator());
        r1.addAnnotation(new XYTextAnnotation("X", 1.0, 2.0), Layer.FOREGROUND);
        r2.addAnnotation(new XYTextAnnotation("X", 1.0, 2.0), Layer.FOREGROUND);
        r1.addAnnotation(new XYTextAnnotation("X", 1.0, 2.0), Layer.BACKGROUND);
        r2.addAnnotation(new XYTextAnnotation("X", 1.0, 2.0), Layer.BACKGROUND);
        r1.setDefaultEntityRadius(99);
        r2.setDefaultEntityRadius(99);
        r1.setLegendItemLabelGenerator(new StandardXYSeriesLabelGenerator("{0} {1}"));
        r2.setLegendItemLabelGenerator(new StandardXYSeriesLabelGenerator("{0} {1}"));
        r1.setLegendItemToolTipGenerator(new StandardXYSeriesLabelGenerator());
        r2.setLegendItemToolTipGenerator(new StandardXYSeriesLabelGenerator());
        r1.setLegendItemURLGenerator(new StandardXYSeriesLabelGenerator());
        r2.setLegendItemURLGenerator(new StandardXYSeriesLabelGenerator());
        r1.setAdditionalItemLabelGenerator(new IntervalXYItemLabelGenerator());
        r2.setAdditionalItemLabelGenerator(new IntervalXYItemLabelGenerator());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        YIntervalRenderer r1 = new YIntervalRenderer();
        YIntervalRenderer r2 = new YIntervalRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        YIntervalRenderer r1 = new YIntervalRenderer();
        YIntervalRenderer r2 = (YIntervalRenderer) r1.clone();
        r1.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        r2.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        r1.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        r2.setSeriesToolTipGenerator(0, new StandardXYToolTipGenerator());
        r1.addAnnotation(new XYTextAnnotation("ABC", 1.0, 2.0), Layer.FOREGROUND);
        r2.addAnnotation(new XYTextAnnotation("ABC", 1.0, 2.0), Layer.FOREGROUND);
        r1.addAnnotation(new XYTextAnnotation("ABC", 1.0, 2.0), Layer.BACKGROUND);
        r2.addAnnotation(new XYTextAnnotation("ABC", 1.0, 2.0), Layer.BACKGROUND);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        YIntervalRenderer r1 = new YIntervalRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        YIntervalRenderer r1 = new YIntervalRenderer();
        YIntervalRenderer r2 = (YIntervalRenderer) TestUtilities.serialised(r1);
    }

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    public void testGetLegendItemSeriesIndex() {
        YIntervalSeriesCollection d1 = new YIntervalSeriesCollection();
        YIntervalSeries s1 = new YIntervalSeries("S1");
        s1.add(1.0, 1.1, 1.2, 1.3);
        YIntervalSeries s2 = new YIntervalSeries("S2");
        s2.add(1.0, 1.1, 1.2, 1.3);
        d1.addSeries(s1);
        d1.addSeries(s2);
        YIntervalSeriesCollection d2 = new YIntervalSeriesCollection();
        YIntervalSeries s3 = new YIntervalSeries("S3");
        s3.add(1.0, 1.1, 1.2, 1.3);
        YIntervalSeries s4 = new YIntervalSeries("S4");
        s4.add(1.0, 1.1, 1.2, 1.3);
        YIntervalSeries s5 = new YIntervalSeries("S5");
        s5.add(1.0, 1.1, 1.2, 1.3);
        d2.addSeries(s3);
        d2.addSeries(s4);
        d2.addSeries(s5);
        YIntervalRenderer r = new YIntervalRenderer();
        XYPlot plot = new XYPlot(d1, new NumberAxis("x"), new NumberAxis("y"), r);
        plot.setDataset(1, d2);
        new JFreeChart(plot);
        LegendItem li = r.getLegendItem(1, 2);
    }
}
