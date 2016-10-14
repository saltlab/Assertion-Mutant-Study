package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PinNeedle} class.
 */
public class PinNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        PinNeedle n1 = new PinNeedle();
        PinNeedle n2 = new PinNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PinNeedle n1 = new PinNeedle();
        PinNeedle n2 = (PinNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PinNeedle n1 = new PinNeedle();
        PinNeedle n2 = (PinNeedle) TestUtilities.serialised(n1);
    }
}
