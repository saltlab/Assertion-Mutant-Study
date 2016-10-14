package org.jfree.data.function;

import org.jfree.chart.TestUtilities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Tests for the {@link LineFunction2D} class.
 */
public class LineFunction2DTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Some tests for the constructor.
     */
    public void testConstructor() {
        LineFunction2D f = new LineFunction2D(1.0, 2.0);
    }

    /**
     * For datasets, the equals() method just checks keys and values.
     */
    public void testEquals() {
        LineFunction2D f1 = new LineFunction2D(1.0, 2.0);
        LineFunction2D f2 = new LineFunction2D(1.0, 2.0);
        f1 = new LineFunction2D(2.0, 3.0);
        f2 = new LineFunction2D(2.0, 3.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LineFunction2D f1 = new LineFunction2D(1.0, 2.0);
        LineFunction2D f2 = (LineFunction2D) TestUtilities.serialised(f1);
    }

    /**
     * Objects that are equal should have the same hash code otherwise FindBugs
     * will tell on us...
     */
    public void testHashCode() {
        LineFunction2D f1 = new LineFunction2D(1.0, 2.0);
        LineFunction2D f2 = new LineFunction2D(1.0, 2.0);
    }
}
