package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardCategoryItemLabelGenerator} class.
 */
public class StandardCategoryItemLabelGeneratorTest {

    /**
     * Some checks for the generalLabel() method.
     */
    public void testGenerateLabel() {
        StandardCategoryItemLabelGenerator g = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.000"));
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R0", "C0");
        dataset.addValue(2.0, "R0", "C1");
        dataset.addValue(3.0, "R1", "C0");
        dataset.addValue(null, "R1", "C1");
        String s = g.generateLabel(dataset, 0, 0);
        s = g.generateLabel(dataset, 1, 1);
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator();
        StandardCategoryItemLabelGenerator g2 = new StandardCategoryItemLabelGenerator();
        g1 = new StandardCategoryItemLabelGenerator("{0}", new DecimalFormat("0.000"));
        g2 = new StandardCategoryItemLabelGenerator("{0}", new DecimalFormat("0.000"));
        g1 = new StandardCategoryItemLabelGenerator("{1}", new DecimalFormat("0.000"));
        g2 = new StandardCategoryItemLabelGenerator("{1}", new DecimalFormat("0.000"));
        g1 = new StandardCategoryItemLabelGenerator("{2}", new SimpleDateFormat("d-MMM"));
        g2 = new StandardCategoryItemLabelGenerator("{2}", new SimpleDateFormat("d-MMM"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator();
        StandardCategoryItemLabelGenerator g2 = new StandardCategoryItemLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator();
        StandardCategoryItemLabelGenerator g2 = (StandardCategoryItemLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator("{2}", DateFormat.getInstance());
        StandardCategoryItemLabelGenerator g2 = (StandardCategoryItemLabelGenerator) TestUtilities.serialised(g1);
    }

    /**
     * A test for bug 1481087.
     */
    public void testEquals1481087() {
        StandardCategoryItemLabelGenerator g1 = new StandardCategoryItemLabelGenerator("{0}", new DecimalFormat("0.00"));
        StandardCategoryToolTipGenerator g2 = new StandardCategoryToolTipGenerator("{0}", new DecimalFormat("0.00"));
    }
}
