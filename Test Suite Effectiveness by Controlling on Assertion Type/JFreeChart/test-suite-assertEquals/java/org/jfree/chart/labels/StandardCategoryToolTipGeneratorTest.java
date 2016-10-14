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
 * Tests for the {@link StandardCategoryToolTipGenerator} class.
 */
public class StandardCategoryToolTipGeneratorTest {

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator();
        StandardCategoryToolTipGenerator g2 = new StandardCategoryToolTipGenerator();
        g1 = new StandardCategoryToolTipGenerator("{0}", new DecimalFormat("0.000"));
        g2 = new StandardCategoryToolTipGenerator("{0}", new DecimalFormat("0.000"));
        g1 = new StandardCategoryToolTipGenerator("{1}", new DecimalFormat("0.000"));
        g2 = new StandardCategoryToolTipGenerator("{1}", new DecimalFormat("0.000"));
        g1 = new StandardCategoryToolTipGenerator("{2}", new SimpleDateFormat("d-MMM"));
        g2 = new StandardCategoryToolTipGenerator("{2}", new SimpleDateFormat("d-MMM"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator();
        StandardCategoryToolTipGenerator g2 = new StandardCategoryToolTipGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator();
        StandardCategoryToolTipGenerator g2 = (StandardCategoryToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator("{2}", DateFormat.getInstance());
        StandardCategoryToolTipGenerator g2 = (StandardCategoryToolTipGenerator) TestUtilities.serialised(g1);
    }

    /**
     * A test for bug 1481087.
     */
    public void testEquals1481087() {
        StandardCategoryToolTipGenerator g1 = new StandardCategoryToolTipGenerator("{0}", new DecimalFormat("0.00"));
        StandardCategoryItemLabelGenerator g2 = new StandardCategoryItemLabelGenerator("{0}", new DecimalFormat("0.00"));
    }
}
