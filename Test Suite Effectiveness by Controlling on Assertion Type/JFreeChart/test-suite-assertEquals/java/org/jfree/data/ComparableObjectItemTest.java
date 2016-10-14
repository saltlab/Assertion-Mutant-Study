package org.jfree.data;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

/**
 * Tests for the {@link ComparableObjectItem} class.
 */
public class ComparableObjectItemTest {

    /**
     * Some checks for the constructor.
     */
    public void testConstructor() {
        try {
            new ComparableObjectItem(null, "XYZ");
            fail("There should be an exception.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ");
        ComparableObjectItem item2 = new ComparableObjectItem(new Integer(1), "XYZ");
        item1 = new ComparableObjectItem(new Integer(2), "XYZ");
        assertNotEquals(item1, item2);
        item2 = new ComparableObjectItem(new Integer(2), "XYZ");
        item1 = new ComparableObjectItem(new Integer(2), null);
        item2 = new ComparableObjectItem(new Integer(2), null);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ");
        ComparableObjectItem item2 = (ComparableObjectItem) item1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ");
        ComparableObjectItem item2 = (ComparableObjectItem) TestUtilities.serialised(item1);
    }

    /**
     * Some checks for the compareTo() method.
     */
    public void testCompareTo() {
        ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ");
        ComparableObjectItem item2 = new ComparableObjectItem(new Integer(2), "XYZ");
        ComparableObjectItem item3 = new ComparableObjectItem(new Integer(3), "XYZ");
        ComparableObjectItem item4 = new ComparableObjectItem(new Integer(1), "XYZ");
    }
}
