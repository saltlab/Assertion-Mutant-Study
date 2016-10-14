package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link LongNeedle} class.
 */
public class LongNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        LongNeedle n1 = new LongNeedle();
        LongNeedle n2 = new LongNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LongNeedle n1 = new LongNeedle();
        LongNeedle n2 = (LongNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LongNeedle n1 = new LongNeedle();
        LongNeedle n2 = (LongNeedle) TestUtilities.serialised(n1);
    }
}
