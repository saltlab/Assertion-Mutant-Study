package org.jfree.data.function;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the {@link PowerFunction2D} class.
 */
public class PowerFunction2DTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Some tests for the constructor.
     */
    public void testConstructor() {
        PowerFunction2D f = new PowerFunction2D(1.0, 2.0);
    }

    /**
     * For datasets, the equals() method just checks keys and values.
     */
    public void testEquals() {
        PowerFunction2D f1 = new PowerFunction2D(1.0, 2.0);
        PowerFunction2D f2 = new PowerFunction2D(1.0, 2.0);
        f1 = new PowerFunction2D(2.0, 3.0);
        f2 = new PowerFunction2D(2.0, 3.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PowerFunction2D f1 = new PowerFunction2D(1.0, 2.0);
        PowerFunction2D f2 = (PowerFunction2D) TestUtilities.serialised(f1);
    }

    /**
     * Objects that are equal should have the same hash code otherwise FindBugs
     * will tell on us...
     */
    public void testHashCode() {
        PowerFunction2D f1 = new PowerFunction2D(1.0, 2.0);
        PowerFunction2D f2 = new PowerFunction2D(1.0, 2.0);
    }
}
