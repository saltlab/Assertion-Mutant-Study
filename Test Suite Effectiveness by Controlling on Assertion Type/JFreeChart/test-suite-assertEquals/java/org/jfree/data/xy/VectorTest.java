package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link Vector} class.
 */
public class VectorTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        Vector v1 = new Vector(1.0, 2.0);
        Vector v2 = new Vector(1.0, 2.0);
        v1 = new Vector(1.1, 2.0);
        v2 = new Vector(1.1, 2.0);
        v1 = new Vector(1.1, 2.2);
        v2 = new Vector(1.1, 2.2);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Vector v1 = new Vector(1.0, 2.0);
        Vector v2 = new Vector(1.0, 2.0);
        int h1 = v1.hashCode();
        int h2 = v2.hashCode();
    }

    /**
     * Immutable class is not cloneable.
     */
    public void testCloning() {
        Vector v1 = new Vector(1.0, 2.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Vector v1 = new Vector(1.0, 2.0);
        Vector v2 = (Vector) TestUtilities.serialised(v1);
    }
}
