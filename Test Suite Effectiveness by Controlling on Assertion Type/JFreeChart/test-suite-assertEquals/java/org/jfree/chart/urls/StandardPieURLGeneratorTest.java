package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardPieURLGenerator} class.
 */
public class StandardPieURLGeneratorTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        StandardPieURLGenerator g1 = new StandardPieURLGenerator();
        StandardPieURLGenerator g2 = new StandardPieURLGenerator();
        g1 = new StandardPieURLGenerator("prefix", "category", "index");
        g2 = new StandardPieURLGenerator("prefix", "category", "index");
        g1 = new StandardPieURLGenerator("prefix2", "category", "index");
        g2 = new StandardPieURLGenerator("prefix2", "category", "index");
        g1 = new StandardPieURLGenerator("prefix2", "category2", "index");
        g2 = new StandardPieURLGenerator("prefix2", "category2", "index");
        g1 = new StandardPieURLGenerator("prefix2", "category2", "index2");
        g2 = new StandardPieURLGenerator("prefix2", "category2", "index2");
        g1 = new StandardPieURLGenerator("prefix2", "category2", null);
        g2 = new StandardPieURLGenerator("prefix2", "category2", null);
    }

    /**
     * Checks that the class does not implement PublicCloneable (the generator
     * is immutable).
     */
    public void testPublicCloneable() {
        StandardPieURLGenerator g1 = new StandardPieURLGenerator("index.html?", "cat");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardPieURLGenerator g1 = new StandardPieURLGenerator("index.html?", "cat");
        StandardPieURLGenerator g2 = (StandardPieURLGenerator) TestUtilities.serialised(g1);
    }

    /**
     * Test that the generated URL is as expected.
     */
    public void testURL() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Alpha '1'", new Double(5.0));
        dataset.setValue("Beta", new Double(5.5));
        StandardPieURLGenerator g1 = new StandardPieURLGenerator("chart.jsp", "category");
        String url = g1.generateURL(dataset, "Beta", 0);
        url = g1.generateURL(dataset, "Alpha '1'", 0);
    }
}
