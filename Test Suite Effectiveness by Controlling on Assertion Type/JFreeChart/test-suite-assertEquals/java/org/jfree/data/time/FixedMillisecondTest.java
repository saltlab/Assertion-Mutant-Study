package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link FixedMillisecond} class.
 */
public class FixedMillisecondTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        FixedMillisecond m1 = new FixedMillisecond();
        FixedMillisecond m2 = (FixedMillisecond) TestUtilities.serialised(m1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        FixedMillisecond m1 = new FixedMillisecond(500000L);
        FixedMillisecond m2 = new FixedMillisecond(500000L);
        int h1 = m1.hashCode();
        int h2 = m2.hashCode();
    }

    /**
     * The {@link FixedMillisecond} class is immutable, so should not be
     * {@link Cloneable}.
     */
    public void testNotCloneable() {
        FixedMillisecond m = new FixedMillisecond(500000L);
    }

    /**
     * A check for immutability.
     */
    public void testImmutability() {
        Date d = new Date(20L);
        FixedMillisecond fm = new FixedMillisecond(d);
        d.setTime(22L);
    }
}
