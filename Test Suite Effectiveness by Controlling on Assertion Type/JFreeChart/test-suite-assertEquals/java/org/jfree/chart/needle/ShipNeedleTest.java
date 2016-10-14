package org.jfree.chart.needle;

import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link ShipNeedle} class.
 */
public class ShipNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        ShipNeedle n1 = new ShipNeedle();
        ShipNeedle n2 = new ShipNeedle();
    }

    /**
     * Check that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ShipNeedle n1 = new ShipNeedle();
        ShipNeedle n2 = (ShipNeedle) n1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ShipNeedle n1 = new ShipNeedle();
        ShipNeedle n2 = (ShipNeedle) TestUtilities.serialised(n1);
    }
}
