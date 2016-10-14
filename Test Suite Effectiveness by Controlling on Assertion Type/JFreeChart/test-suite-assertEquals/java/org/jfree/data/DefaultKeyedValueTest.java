package org.jfree.data;

import org.jfree.chart.TestUtilities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Tests for the {@link DefaultKeyedValue} class.
 */
public class DefaultKeyedValueTest {

    /**
     * Simple checks for the constructor.
     */
    @Test
    public void testConstructor() {
        DefaultKeyedValue v = new DefaultKeyedValue("A", new Integer(1));
        assertEquals("A", v.getKey());
        boolean pass = false;
        try {
            new DefaultKeyedValue(null, new Integer(1));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        v = new DefaultKeyedValue("A", null);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultKeyedValue v1 = new DefaultKeyedValue("Test", new Double(45.5));
        DefaultKeyedValue v2 = new DefaultKeyedValue("Test", new Double(45.5));
        v1 = new DefaultKeyedValue("Test 1", new Double(45.5));
        v2 = new DefaultKeyedValue("Test 2", new Double(45.5));
        v1 = new DefaultKeyedValue("Test", new Double(45.5));
        v2 = new DefaultKeyedValue("Test", new Double(45.6));
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValue v1 = new DefaultKeyedValue("Test", new Double(45.5));
        DefaultKeyedValue v2 = (DefaultKeyedValue) v1.clone();
        v2.setValue(new Double(12.3));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValue v1 = new DefaultKeyedValue("Test", new Double(25.3));
        DefaultKeyedValue v2 = (DefaultKeyedValue) TestUtilities.serialised(v1);
    }
}
