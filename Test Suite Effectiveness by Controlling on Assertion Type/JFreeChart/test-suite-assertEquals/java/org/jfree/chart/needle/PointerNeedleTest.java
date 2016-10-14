package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PointerNeedle} class.
 */
public class PointerNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        PointerNeedle n1 = new PointerNeedle();
        PointerNeedle n2 = new PointerNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PointerNeedle n1 = new PointerNeedle();
        PointerNeedle n2 = (PointerNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PointerNeedle n1 = new PointerNeedle();
        PointerNeedle n2 = (PointerNeedle) TestUtilities.serialised(n1);
    }
}
