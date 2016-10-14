package org.jfree.data;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

/**
 * Tests for the {@link DomainOrder} class.
 */
public class DomainOrderTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DomainOrder d1 = DomainOrder.ASCENDING;
        DomainOrder d2 = DomainOrder.ASCENDING;
        int h1 = d1.hashCode();
        int h2 = d2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DomainOrder d1 = DomainOrder.ASCENDING;
        DomainOrder d2 = (DomainOrder) TestUtilities.serialised(d1);
    }
}
