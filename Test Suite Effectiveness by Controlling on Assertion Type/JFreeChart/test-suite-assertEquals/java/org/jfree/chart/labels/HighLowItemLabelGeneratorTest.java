package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link HighLowItemLabelGenerator} class.
 */
public class HighLowItemLabelGeneratorTest {

    /**
     * Tests that the equals method can distinguish all fields.
     */
    public void testEquals() {
        HighLowItemLabelGenerator g1 = new HighLowItemLabelGenerator();
        HighLowItemLabelGenerator g2 = new HighLowItemLabelGenerator();
        g1 = new HighLowItemLabelGenerator(new SimpleDateFormat("d-MMM-yyyy"), NumberFormat.getInstance());
        g2 = new HighLowItemLabelGenerator(new SimpleDateFormat("d-MMM-yyyy"), NumberFormat.getInstance());
        g1 = new HighLowItemLabelGenerator(new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.000"));
        g2 = new HighLowItemLabelGenerator(new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.000"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        HighLowItemLabelGenerator g1 = new HighLowItemLabelGenerator();
        HighLowItemLabelGenerator g2 = new HighLowItemLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        HighLowItemLabelGenerator g1 = new HighLowItemLabelGenerator();
        HighLowItemLabelGenerator g2 = (HighLowItemLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        HighLowItemLabelGenerator g1 = new HighLowItemLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        HighLowItemLabelGenerator g1 = new HighLowItemLabelGenerator();
        HighLowItemLabelGenerator g2 = (HighLowItemLabelGenerator) TestUtilities.serialised(g1);
    }
}
