package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link LineNeedle} class.
 */
public class LineNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        LineNeedle n1 = new LineNeedle();
        LineNeedle n2 = new LineNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LineNeedle n1 = new LineNeedle();
        LineNeedle n2 = (LineNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LineNeedle n1 = new LineNeedle();
        LineNeedle n2 = (LineNeedle) TestUtilities.serialised(n1);
    }
}
