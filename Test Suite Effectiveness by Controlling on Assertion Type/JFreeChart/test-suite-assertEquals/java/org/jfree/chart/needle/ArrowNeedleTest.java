package org.jfree.chart.needle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link ArrowNeedle} class.
 */
public class ArrowNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        ArrowNeedle n1 = new ArrowNeedle(false);
        ArrowNeedle n2 = new ArrowNeedle(false);
        n1 = new ArrowNeedle(true);
        n2 = new ArrowNeedle(true);
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ArrowNeedle n1 = new ArrowNeedle(false);
        ArrowNeedle n2 = (ArrowNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ArrowNeedle n1 = new ArrowNeedle(false);
        ArrowNeedle n2 = (ArrowNeedle) TestUtilities.serialised(n1);
    }
}
