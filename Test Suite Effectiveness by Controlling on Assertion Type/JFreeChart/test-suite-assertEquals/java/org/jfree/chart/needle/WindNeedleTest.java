package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link WindNeedle} class.
 */
public class WindNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        WindNeedle n1 = new WindNeedle();
        WindNeedle n2 = new WindNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        WindNeedle n1 = new WindNeedle();
        WindNeedle n2 = (WindNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        WindNeedle n1 = new WindNeedle();
        WindNeedle n2 = (WindNeedle) TestUtilities.serialised(n1);
    }
}
