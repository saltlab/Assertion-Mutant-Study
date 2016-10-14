package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.junit.Test;

/**
 * Tests for the {@link ModuloAxis} class.
 */
public class ModuloAxisTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ModuloAxis a1 = new ModuloAxis("Test", new Range(0.0, 1.0));
        ModuloAxis a2 = (ModuloAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ModuloAxis a1 = new ModuloAxis("Test", new Range(0.0, 1.0));
        ModuloAxis a2 = new ModuloAxis("Test", new Range(0.0, 1.0));
        a1.setDisplayRange(0.1, 1.1);
        a2.setDisplayRange(0.1, 1.1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        ModuloAxis a1 = new ModuloAxis("Test", new Range(0.0, 1.0));
        ModuloAxis a2 = new ModuloAxis("Test", new Range(0.0, 1.0));
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ModuloAxis a1 = new ModuloAxis("Test", new Range(0.0, 1.0));
        ModuloAxis a2 = (ModuloAxis) TestUtilities.serialised(a1);
    }
}
