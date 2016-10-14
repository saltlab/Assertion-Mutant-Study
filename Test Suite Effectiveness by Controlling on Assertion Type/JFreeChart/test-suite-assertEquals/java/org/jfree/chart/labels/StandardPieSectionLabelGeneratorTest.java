package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardPieSectionLabelGenerator} class.
 */
public class StandardPieSectionLabelGeneratorTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        StandardPieSectionLabelGenerator g1 = new StandardPieSectionLabelGenerator();
        StandardPieSectionLabelGenerator g2 = new StandardPieSectionLabelGenerator();
        g1 = new StandardPieSectionLabelGenerator("{0}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g2 = new StandardPieSectionLabelGenerator("{0}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g1 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g2 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0.00"), NumberFormat.getPercentInstance());
        g1 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0"), NumberFormat.getPercentInstance());
        g2 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0"), NumberFormat.getPercentInstance());
        g1 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0"), new DecimalFormat("0.000%"));
        g2 = new StandardPieSectionLabelGenerator("{0} {1}", new DecimalFormat("#,##0"), new DecimalFormat("0.000%"));
        AttributedString as = new AttributedString("XYZ");
        g1.setAttributedLabel(0, as);
        g2.setAttributedLabel(0, as);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardPieSectionLabelGenerator g1 = new StandardPieSectionLabelGenerator();
        StandardPieSectionLabelGenerator g2 = new StandardPieSectionLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardPieSectionLabelGenerator g1 = new StandardPieSectionLabelGenerator();
        StandardPieSectionLabelGenerator g2 = (StandardPieSectionLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardPieSectionLabelGenerator g1 = new StandardPieSectionLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardPieSectionLabelGenerator g1 = new StandardPieSectionLabelGenerator();
        StandardPieSectionLabelGenerator g2 = (StandardPieSectionLabelGenerator) TestUtilities.serialised(g1);
    }
}
