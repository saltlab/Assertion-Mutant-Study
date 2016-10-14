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
 * Tests for the {@link StandardXYToolTipGenerator} class.
 */
public class StandardXYToolTipGeneratorTest {

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        String f1 = "{1}";
        String f2 = "{2}";
        NumberFormat xnf1 = new DecimalFormat("0.00");
        NumberFormat xnf2 = new DecimalFormat("0.000");
        NumberFormat ynf1 = new DecimalFormat("0.00");
        NumberFormat ynf2 = new DecimalFormat("0.000");
        StandardXYToolTipGenerator g1 = null;
        StandardXYToolTipGenerator g2 = null;
        g1 = new StandardXYToolTipGenerator(f1, xnf1, ynf1);
        g2 = new StandardXYToolTipGenerator(f1, xnf1, ynf1);
        g1 = new StandardXYToolTipGenerator(f2, xnf1, ynf1);
        g2 = new StandardXYToolTipGenerator(f2, xnf1, ynf1);
        g1 = new StandardXYToolTipGenerator(f2, xnf2, ynf1);
        g2 = new StandardXYToolTipGenerator(f2, xnf2, ynf1);
        g1 = new StandardXYToolTipGenerator(f2, xnf2, ynf2);
        g2 = new StandardXYToolTipGenerator(f2, xnf2, ynf2);
        DateFormat xdf1 = new SimpleDateFormat("d-MMM");
        DateFormat xdf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat ydf1 = new SimpleDateFormat("d-MMM");
        DateFormat ydf2 = new SimpleDateFormat("d-MMM-yyyy");
        g1 = new StandardXYToolTipGenerator(f1, xdf1, ydf1);
        g2 = new StandardXYToolTipGenerator(f1, xdf1, ydf1);
        g1 = new StandardXYToolTipGenerator(f1, xdf2, ydf1);
        g2 = new StandardXYToolTipGenerator(f1, xdf2, ydf1);
        g1 = new StandardXYToolTipGenerator(f1, xdf2, ydf2);
        g2 = new StandardXYToolTipGenerator(f1, xdf2, ydf2);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardXYToolTipGenerator g1 = new StandardXYToolTipGenerator();
        StandardXYToolTipGenerator g2 = new StandardXYToolTipGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardXYToolTipGenerator g1 = new StandardXYToolTipGenerator();
        StandardXYToolTipGenerator g2 = (StandardXYToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardXYToolTipGenerator g1 = new StandardXYToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardXYToolTipGenerator g1 = new StandardXYToolTipGenerator();
        StandardXYToolTipGenerator g2 = (StandardXYToolTipGenerator) TestUtilities.serialised(g1);
    }
}
