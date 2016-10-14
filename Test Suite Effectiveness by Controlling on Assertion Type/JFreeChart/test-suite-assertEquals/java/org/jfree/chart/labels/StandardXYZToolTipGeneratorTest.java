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
 * Tests for the {@link StandardXYZToolTipGenerator} class.
 */
public class StandardXYZToolTipGeneratorTest {

    /**
     * Tests that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        String f1 = "{1}";
        String f2 = "{2}";
        NumberFormat xnf1 = new DecimalFormat("0.00");
        NumberFormat xnf2 = new DecimalFormat("0.000");
        NumberFormat ynf1 = new DecimalFormat("0.00");
        NumberFormat ynf2 = new DecimalFormat("0.000");
        NumberFormat znf1 = new DecimalFormat("0.00");
        NumberFormat znf2 = new DecimalFormat("0.000");
        DateFormat xdf1 = new SimpleDateFormat("d-MMM");
        DateFormat xdf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat ydf1 = new SimpleDateFormat("d-MMM");
        DateFormat ydf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat zdf1 = new SimpleDateFormat("d-MMM");
        DateFormat zdf2 = new SimpleDateFormat("d-MMM-yyyy");
        StandardXYZToolTipGenerator g1 = null;
        StandardXYZToolTipGenerator g2 = null;
        g1 = new StandardXYZToolTipGenerator(f1, xnf1, ynf1, znf1);
        g2 = new StandardXYZToolTipGenerator(f1, xnf1, ynf1, znf1);
        g1 = new StandardXYZToolTipGenerator(f2, xnf1, ynf1, znf1);
        g2 = new StandardXYZToolTipGenerator(f2, xnf1, ynf1, znf1);
        g1 = new StandardXYZToolTipGenerator(f2, xnf2, ynf1, znf1);
        g2 = new StandardXYZToolTipGenerator(f2, xnf2, ynf1, znf1);
        g1 = new StandardXYZToolTipGenerator(f2, xnf2, ynf2, znf1);
        g2 = new StandardXYZToolTipGenerator(f2, xnf2, ynf2, znf1);
        g1 = new StandardXYZToolTipGenerator(f2, xnf2, ynf2, znf2);
        g2 = new StandardXYZToolTipGenerator(f2, xnf2, ynf2, znf2);
        g1 = new StandardXYZToolTipGenerator(f2, xdf1, ydf1, zdf1);
        g2 = new StandardXYZToolTipGenerator(f2, xdf1, ydf1, zdf1);
        g1 = new StandardXYZToolTipGenerator(f2, xdf2, ydf1, zdf1);
        g2 = new StandardXYZToolTipGenerator(f2, xdf2, ydf1, zdf1);
        g1 = new StandardXYZToolTipGenerator(f2, xdf2, ydf2, zdf1);
        g2 = new StandardXYZToolTipGenerator(f2, xdf2, ydf2, zdf1);
        g1 = new StandardXYZToolTipGenerator(f2, xdf2, ydf2, zdf2);
        g2 = new StandardXYZToolTipGenerator(f2, xdf2, ydf2, zdf2);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardXYZToolTipGenerator g1 = new StandardXYZToolTipGenerator();
        StandardXYZToolTipGenerator g2 = new StandardXYZToolTipGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardXYZToolTipGenerator g1 = new StandardXYZToolTipGenerator();
        StandardXYZToolTipGenerator g2 = (StandardXYZToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardXYZToolTipGenerator g1 = new StandardXYZToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardXYZToolTipGenerator g1 = new StandardXYZToolTipGenerator();
        StandardXYZToolTipGenerator g2 = (StandardXYZToolTipGenerator) TestUtilities.serialised(g1);
    }
}
