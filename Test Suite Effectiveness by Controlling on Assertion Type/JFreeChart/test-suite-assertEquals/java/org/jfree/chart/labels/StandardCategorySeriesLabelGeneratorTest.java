package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardCategorySeriesLabelGenerator} class.
 */
public class StandardCategorySeriesLabelGeneratorTest {

    /**
     * Some checks for the generalLabel() method.
     */
    public void testGenerateLabel() {
        StandardCategorySeriesLabelGenerator g = new StandardCategorySeriesLabelGenerator("{0}");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R0", "C0");
        dataset.addValue(2.0, "R0", "C1");
        dataset.addValue(3.0, "R1", "C0");
        dataset.addValue(null, "R1", "C1");
        String s = g.generateLabel(dataset, 0);
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        StandardCategorySeriesLabelGenerator g1 = new StandardCategorySeriesLabelGenerator();
        StandardCategorySeriesLabelGenerator g2 = new StandardCategorySeriesLabelGenerator();
        g1 = new StandardCategorySeriesLabelGenerator("{1}");
        g2 = new StandardCategorySeriesLabelGenerator("{1}");
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardCategorySeriesLabelGenerator g1 = new StandardCategorySeriesLabelGenerator();
        StandardCategorySeriesLabelGenerator g2 = new StandardCategorySeriesLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardCategorySeriesLabelGenerator g1 = new StandardCategorySeriesLabelGenerator("{1}");
        StandardCategorySeriesLabelGenerator g2 = (StandardCategorySeriesLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardCategorySeriesLabelGenerator g1 = new StandardCategorySeriesLabelGenerator("{1}");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardCategorySeriesLabelGenerator g1 = new StandardCategorySeriesLabelGenerator("{2}");
        StandardCategorySeriesLabelGenerator g2 = (StandardCategorySeriesLabelGenerator) TestUtilities.serialised(g1);
    }
}
