package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardCategoryURLGenerator} class.
 */
public class StandardCategoryURLGeneratorTest {

    /**
     * Some tests for the generateURL() method.
     */
    public void testGenerateURL() {
        StandardCategoryURLGenerator g1 = new StandardCategoryURLGenerator();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R1", "C1");
        dataset.addValue(2.0, "R2", "C2");
        dataset.addValue(3.0, "R&", "C&");
    }

    /**
     * Checks that the class does not implement PublicCloneable (the generator
     * is immutable, so cloning is not necessary).
     */
    public void testPublicCloneable() {
        StandardCategoryURLGenerator g1 = new StandardCategoryURLGenerator();
    }

    /**
     * Some tests for the equals() method.
     */
    public void testEquals() {
        StandardCategoryURLGenerator g1 = new StandardCategoryURLGenerator();
        StandardCategoryURLGenerator g2 = new StandardCategoryURLGenerator();
        g1 = new StandardCategoryURLGenerator("index2.html?");
        g2 = new StandardCategoryURLGenerator("index2.html?");
        g1 = new StandardCategoryURLGenerator("index2.html?", "A", "B");
        g2 = new StandardCategoryURLGenerator("index2.html?", "A", "B");
        g1 = new StandardCategoryURLGenerator("index2.html?", "A", "C");
        g2 = new StandardCategoryURLGenerator("index2.html?", "A", "C");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardCategoryURLGenerator g1 = new StandardCategoryURLGenerator("index.html?");
        StandardCategoryURLGenerator g2 = (StandardCategoryURLGenerator) TestUtilities.serialised(g1);
    }
}
