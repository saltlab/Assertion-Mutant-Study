package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link TimeSeriesURLGenerator} class.
 */
public class TimeSeriesURLGeneratorTest {

    /**
     * A basic check for the generateURL() method.
     */
    public void testGenerateURL() {
        TimeSeriesURLGenerator g = new TimeSeriesURLGenerator();
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Series '1'", new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } });
        String s = g.generateURL(dataset, 0, 0);
    }

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        TimeSeriesURLGenerator g1 = new TimeSeriesURLGenerator();
        TimeSeriesURLGenerator g2 = new TimeSeriesURLGenerator();
        g1 = new TimeSeriesURLGenerator(new SimpleDateFormat("yyyy"), "prefix", "series", "item");
        g2 = new TimeSeriesURLGenerator(new SimpleDateFormat("yyyy"), "prefix", "series", "item");
        g1 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix", "series", "item");
        g2 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix", "series", "item");
        g1 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series", "item");
        g2 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series", "item");
        g1 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series1", "item");
        g2 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series1", "item");
        g1 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series1", "item1");
        g2 = new TimeSeriesURLGenerator(new SimpleDateFormat("yy"), "prefix1", "series1", "item1");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimeSeriesURLGenerator g1 = new TimeSeriesURLGenerator();
        TimeSeriesURLGenerator g2 = (TimeSeriesURLGenerator) TestUtilities.serialised(g1);
    }

    /**
     * Checks that the class does not implement PublicCloneable (the generator
     * is immutable).
     */
    public void testPublicCloneable() {
        TimeSeriesURLGenerator g1 = new TimeSeriesURLGenerator();
    }
}
