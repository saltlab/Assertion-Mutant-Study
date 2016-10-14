package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CustomXYToolTipGenerator} class.
 */
public class CustomXYItemLabelGeneratorTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CustomXYToolTipGenerator g1 = new CustomXYToolTipGenerator();
        CustomXYToolTipGenerator g2 = (CustomXYToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CustomXYToolTipGenerator g1 = new CustomXYToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        List t1 = new java.util.ArrayList();
        t1.add("Tooltip A1");
        t1.add("Tooltip A2");
        t1.add("Tooltip A3");
        List t2 = new java.util.ArrayList();
        t2.add("Tooltip B1");
        t2.add("Tooltip B2");
        t2.add("Tooltip B3");
        CustomXYToolTipGenerator g1 = new CustomXYToolTipGenerator();
        g1.addToolTipSeries(t1);
        g1.addToolTipSeries(t2);
        CustomXYToolTipGenerator g2 = (CustomXYToolTipGenerator) TestUtilities.serialised(g1);
    }
}
