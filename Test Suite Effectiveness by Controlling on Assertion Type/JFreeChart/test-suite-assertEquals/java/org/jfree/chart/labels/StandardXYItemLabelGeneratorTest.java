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
 * Tests for the {@link StandardXYItemLabelGenerator} class.
 */
public class StandardXYItemLabelGeneratorTest {

    /**
     * A series of tests for the equals() method.
     */
    public void testEquals() {
        String f1 = "{1}";
        String f2 = "{2}";
        NumberFormat xnf1 = new DecimalFormat("0.00");
        NumberFormat xnf2 = new DecimalFormat("0.000");
        NumberFormat ynf1 = new DecimalFormat("0.00");
        NumberFormat ynf2 = new DecimalFormat("0.000");
        StandardXYItemLabelGenerator g1 = null;
        StandardXYItemLabelGenerator g2 = null;
        g1 = new StandardXYItemLabelGenerator(f1, xnf1, ynf1);
        g2 = new StandardXYItemLabelGenerator(f1, xnf1, ynf1);
        g1 = new StandardXYItemLabelGenerator(f2, xnf1, ynf1);
        g2 = new StandardXYItemLabelGenerator(f2, xnf1, ynf1);
        g1 = new StandardXYItemLabelGenerator(f2, xnf2, ynf1);
        g2 = new StandardXYItemLabelGenerator(f2, xnf2, ynf1);
        g1 = new StandardXYItemLabelGenerator(f2, xnf2, ynf2);
        g2 = new StandardXYItemLabelGenerator(f2, xnf2, ynf2);
        DateFormat xdf1 = new SimpleDateFormat("d-MMM");
        DateFormat xdf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat ydf1 = new SimpleDateFormat("d-MMM");
        DateFormat ydf2 = new SimpleDateFormat("d-MMM-yyyy");
        g1 = new StandardXYItemLabelGenerator(f1, xdf1, ydf1);
        g2 = new StandardXYItemLabelGenerator(f1, xdf1, ydf1);
        g1 = new StandardXYItemLabelGenerator(f1, xdf2, ydf1);
        g2 = new StandardXYItemLabelGenerator(f1, xdf2, ydf1);
        g1 = new StandardXYItemLabelGenerator(f1, xdf2, ydf2);
        g2 = new StandardXYItemLabelGenerator(f1, xdf2, ydf2);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator();
        StandardXYItemLabelGenerator g2 = new StandardXYItemLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator();
        StandardXYItemLabelGenerator g2 = (StandardXYItemLabelGenerator) g1.clone();
        g1.getXFormat().setMinimumIntegerDigits(2);
        g2.getXFormat().setMinimumIntegerDigits(2);
        g1.getYFormat().setMinimumIntegerDigits(2);
        g2.getYFormat().setMinimumIntegerDigits(2);
        g1 = new StandardXYItemLabelGenerator("{0} {1} {2}", DateFormat.getInstance(), DateFormat.getInstance());
        g2 = (StandardXYItemLabelGenerator) g1.clone();
        g1.getXDateFormat().setNumberFormat(new DecimalFormat("0.000"));
        g2.getXDateFormat().setNumberFormat(new DecimalFormat("0.000"));
        g1.getYDateFormat().setNumberFormat(new DecimalFormat("0.000"));
        g2.getYDateFormat().setNumberFormat(new DecimalFormat("0.000"));
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator();
        StandardXYItemLabelGenerator g2 = (StandardXYItemLabelGenerator) TestUtilities.serialised(g1);
    }
}
