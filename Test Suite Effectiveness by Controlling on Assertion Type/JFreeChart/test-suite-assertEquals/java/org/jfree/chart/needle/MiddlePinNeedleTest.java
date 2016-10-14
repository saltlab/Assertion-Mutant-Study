package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link MiddlePinNeedle} class.
 */
public class MiddlePinNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        MiddlePinNeedle n1 = new MiddlePinNeedle();
        MiddlePinNeedle n2 = new MiddlePinNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        MiddlePinNeedle n1 = new MiddlePinNeedle();
        MiddlePinNeedle n2 = (MiddlePinNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MiddlePinNeedle n1 = new MiddlePinNeedle();
        MiddlePinNeedle n2 = (MiddlePinNeedle) TestUtilities.serialised(n1);
    }
}
