package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link IntervalCategoryToolTipGenerator} class.
 */
public class IntervalCategoryToolTipGeneratorTest {

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator();
        IntervalCategoryToolTipGenerator g2 = new IntervalCategoryToolTipGenerator();
        g1 = new IntervalCategoryToolTipGenerator("{3} - {4}", new DecimalFormat("0.000"));
        g2 = new IntervalCategoryToolTipGenerator("{3} - {4}", new DecimalFormat("0.000"));
        g1 = new IntervalCategoryToolTipGenerator("{3} - {4}", new SimpleDateFormat("d-MMM"));
        g2 = new IntervalCategoryToolTipGenerator("{3} - {4}", new SimpleDateFormat("d-MMM"));
    }

    /**
     * Check that the subclass is not equal to an instance of the superclass.
     */
    public void testEquals2() {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator();
        StandardCategoryToolTipGenerator g2 = new StandardCategoryToolTipGenerator(IntervalCategoryToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT_STRING, NumberFormat.getInstance());
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator();
        IntervalCategoryToolTipGenerator g2 = new IntervalCategoryToolTipGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator();
        IntervalCategoryToolTipGenerator g2 = (IntervalCategoryToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        IntervalCategoryToolTipGenerator g1 = new IntervalCategoryToolTipGenerator("{3} - {4}", DateFormat.getInstance());
        IntervalCategoryToolTipGenerator g2 = (IntervalCategoryToolTipGenerator) TestUtilities.serialised(g1);
    }
}
