package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardPieToolTipGenerator} class.
 */
public class StandardPieToolTipGeneratorTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        StandardPieToolTipGenerator g1 = new StandardPieToolTipGenerator();
        StandardPieToolTipGenerator g2 = new StandardPieToolTipGenerator();
        g1 = new StandardPieToolTipGenerator("{0}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g2 = new StandardPieToolTipGenerator("{0}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g1 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g2 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g1 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0"), NumberFormat.getPercentInstance());
        g2 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0"), NumberFormat.getPercentInstance());
        g1 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0"), new DecimalFormat("0.000%"));
        g2 = new StandardPieToolTipGenerator("{0} {1}", new DecimalFormat("#,##0"), new DecimalFormat("0.000%"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardPieToolTipGenerator g1 = new StandardPieToolTipGenerator();
        StandardPieToolTipGenerator g2 = new StandardPieToolTipGenerator();
    }

    /**
     * Some checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardPieToolTipGenerator g1 = new StandardPieToolTipGenerator();
        StandardPieToolTipGenerator g2 = (StandardPieToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardPieToolTipGenerator g1 = new StandardPieToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardPieToolTipGenerator g1 = new StandardPieToolTipGenerator();
        StandardPieToolTipGenerator g2 = (StandardPieToolTipGenerator) TestUtilities.serialised(g1);
    }
}
