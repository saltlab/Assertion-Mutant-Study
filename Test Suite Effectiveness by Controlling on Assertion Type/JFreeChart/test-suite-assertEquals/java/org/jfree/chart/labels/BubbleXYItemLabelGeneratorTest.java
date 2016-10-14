package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link BubbleXYItemLabelGenerator} class.
 */
public class BubbleXYItemLabelGeneratorTest {

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
        NumberFormat znf1 = new DecimalFormat("0.00");
        NumberFormat znf2 = new DecimalFormat("0.000");
        BubbleXYItemLabelGenerator g1 = null;
        BubbleXYItemLabelGenerator g2 = null;
        g1 = new BubbleXYItemLabelGenerator(f1, xnf1, ynf1, znf1);
        g2 = new BubbleXYItemLabelGenerator(f1, xnf1, ynf1, znf1);
        g1 = new BubbleXYItemLabelGenerator(f2, xnf1, ynf1, znf1);
        g2 = new BubbleXYItemLabelGenerator(f2, xnf1, ynf1, znf1);
        g1 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf1, znf1);
        g2 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf1, znf1);
        g1 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf2, znf1);
        g2 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf2, znf1);
        g1 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf2, znf2);
        g2 = new BubbleXYItemLabelGenerator(f2, xnf2, ynf2, znf2);
        DateFormat xdf1 = new SimpleDateFormat("d-MMM");
        DateFormat xdf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat ydf1 = new SimpleDateFormat("d-MMM");
        DateFormat ydf2 = new SimpleDateFormat("d-MMM-yyyy");
        DateFormat zdf1 = new SimpleDateFormat("d-MMM");
        DateFormat zdf2 = new SimpleDateFormat("d-MMM-yyyy");
        g1 = new BubbleXYItemLabelGenerator(f1, xdf1, ydf1, zdf1);
        g2 = new BubbleXYItemLabelGenerator(f1, xdf1, ydf1, zdf1);
        g1 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf1, zdf1);
        g2 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf1, zdf1);
        g1 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf2, zdf1);
        g2 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf2, zdf1);
        g1 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf2, zdf2);
        g2 = new BubbleXYItemLabelGenerator(f1, xdf2, ydf2, zdf2);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        BubbleXYItemLabelGenerator g1 = new BubbleXYItemLabelGenerator();
        BubbleXYItemLabelGenerator g2 = new BubbleXYItemLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BubbleXYItemLabelGenerator g1 = new BubbleXYItemLabelGenerator();
        BubbleXYItemLabelGenerator g2 = (BubbleXYItemLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        BubbleXYItemLabelGenerator g1 = new BubbleXYItemLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BubbleXYItemLabelGenerator g1 = new BubbleXYItemLabelGenerator();
        BubbleXYItemLabelGenerator g2 = (BubbleXYItemLabelGenerator) TestUtilities.serialised(g1);
    }

    /**
     * Some checks for the testGenerateLabel() method.
     */
    public void testGenerateLabel() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 2.0);
        s1.add(2.2, 3.3);
        XYSeriesCollection dataset = new XYSeriesCollection(s1);
        BubbleXYItemLabelGenerator g = new BubbleXYItemLabelGenerator();
    }
}
