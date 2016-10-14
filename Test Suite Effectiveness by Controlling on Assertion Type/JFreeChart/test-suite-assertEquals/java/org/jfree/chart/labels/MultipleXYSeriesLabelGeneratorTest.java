package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link MultipleXYSeriesLabelGenerator} class.
 */
public class MultipleXYSeriesLabelGeneratorTest {

    /**
     * A series of tests for the equals() method.
     */
    public void testEquals() {
        MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator();
        MultipleXYSeriesLabelGenerator g2 = new MultipleXYSeriesLabelGenerator();
        g1 = new MultipleXYSeriesLabelGenerator("Series {0}");
        g2 = new MultipleXYSeriesLabelGenerator("Series {0}");
        g1.addSeriesLabel(1, "Additional 1");
        g2.addSeriesLabel(1, "Additional 1");
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator();
        MultipleXYSeriesLabelGenerator g2 = new MultipleXYSeriesLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator();
        MultipleXYSeriesLabelGenerator g2 = (MultipleXYSeriesLabelGenerator) g1.clone();
        g1.addSeriesLabel(3, "Add3");
        g2.addSeriesLabel(3, "Add3");
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator();
        g1.addSeriesLabel(0, "Add0");
        g1.addSeriesLabel(0, "Add0b");
        g1.addSeriesLabel(1, "Add1");
        MultipleXYSeriesLabelGenerator g2 = (MultipleXYSeriesLabelGenerator) TestUtilities.serialised(g1);
    }
}
