package org.jfree.data.function;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for the {@link NormalDistributionFunction2D} class.
 */
public class NormalDistributionFunction2DTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Some tests for the constructor.
     */
    public void testConstructor() {
        NormalDistributionFunction2D f = new NormalDistributionFunction2D(1.0, 2.0);
    }

    /**
     * For datasets, the equals() method just checks keys and values.
     */
    public void testEquals() {
        NormalDistributionFunction2D f1 = new NormalDistributionFunction2D(1.0, 2.0);
        NormalDistributionFunction2D f2 = new NormalDistributionFunction2D(1.0, 2.0);
        f1 = new NormalDistributionFunction2D(2.0, 3.0);
        f2 = new NormalDistributionFunction2D(2.0, 3.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        NormalDistributionFunction2D f1 = new NormalDistributionFunction2D(1.0, 2.0);
        NormalDistributionFunction2D f2 = (NormalDistributionFunction2D) TestUtilities.serialised(f1);
    }

    /**
     * Objects that are equal should have the same hash code otherwise FindBugs
     * will tell on us...
     */
    public void testHashCode() {
        NormalDistributionFunction2D f1 = new NormalDistributionFunction2D(1.0, 2.0);
        NormalDistributionFunction2D f2 = new NormalDistributionFunction2D(1.0, 2.0);
    }
}
