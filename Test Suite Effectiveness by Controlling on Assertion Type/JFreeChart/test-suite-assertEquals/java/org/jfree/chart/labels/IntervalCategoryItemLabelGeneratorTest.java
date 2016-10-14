package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link IntervalCategoryItemLabelGenerator} class.
 */
public class IntervalCategoryItemLabelGeneratorTest {

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator();
        IntervalCategoryItemLabelGenerator g2 = new IntervalCategoryItemLabelGenerator();
        g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new DecimalFormat("0.000"));
        g2 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new DecimalFormat("0.000"));
        g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new SimpleDateFormat("d-MMM"));
        g2 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new SimpleDateFormat("d-MMM"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator();
        IntervalCategoryItemLabelGenerator g2 = new IntervalCategoryItemLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator();
        IntervalCategoryItemLabelGenerator g2 = (IntervalCategoryItemLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", DateFormat.getInstance());
        IntervalCategoryItemLabelGenerator g2 = (IntervalCategoryItemLabelGenerator) TestUtilities.serialised(g1);
    }
}
