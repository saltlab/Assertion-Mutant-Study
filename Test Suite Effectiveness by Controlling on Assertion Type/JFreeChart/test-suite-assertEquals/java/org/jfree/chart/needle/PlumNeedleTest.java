package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PlumNeedle} class.
 */
public class PlumNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        PlumNeedle n1 = new PlumNeedle();
        PlumNeedle n2 = new PlumNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PlumNeedle n1 = new PlumNeedle();
        PlumNeedle n2 = (PlumNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PlumNeedle n1 = new PlumNeedle();
        PlumNeedle n2 = (PlumNeedle) TestUtilities.serialised(n1);
    }
}
