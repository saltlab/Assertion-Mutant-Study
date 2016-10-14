package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link VectorDataItem} class.
 */
public class VectorDataItemTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        VectorDataItem v1 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        VectorDataItem v2 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        v1 = new VectorDataItem(1.1, 2.0, 3.0, 4.0);
        v2 = new VectorDataItem(1.1, 2.0, 3.0, 4.0);
        v1 = new VectorDataItem(1.1, 2.2, 3.0, 4.0);
        v2 = new VectorDataItem(1.1, 2.2, 3.0, 4.0);
        v1 = new VectorDataItem(1.1, 2.2, 3.3, 4.0);
        v2 = new VectorDataItem(1.1, 2.2, 3.3, 4.0);
        v1 = new VectorDataItem(1.1, 2.2, 3.3, 4.4);
        v2 = new VectorDataItem(1.1, 2.2, 3.3, 4.4);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        VectorDataItem v1 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        VectorDataItem v2 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        int h1 = v1.hashCode();
        int h2 = v2.hashCode();
    }

    /**
     * Check cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        VectorDataItem v1 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        VectorDataItem v2 = (VectorDataItem) v1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        VectorDataItem v1 = new VectorDataItem(1.0, 2.0, 3.0, 4.0);
        VectorDataItem v2 = (VectorDataItem) TestUtilities.serialised(v1);
    }
}
