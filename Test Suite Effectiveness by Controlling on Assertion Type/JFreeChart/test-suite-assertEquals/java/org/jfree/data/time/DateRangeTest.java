package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Some tests for the {@link DateRange} class.
 */
public class DateRangeTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DateRange r1 = new DateRange(new Date(1000L), new Date(2000L));
        DateRange r2 = new DateRange(new Date(1000L), new Date(2000L));
        r1 = new DateRange(new Date(1111L), new Date(2000L));
        r2 = new DateRange(new Date(1111L), new Date(2000L));
        r1 = new DateRange(new Date(1111L), new Date(2222L));
        r2 = new DateRange(new Date(1111L), new Date(2222L));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateRange r1 = new DateRange(new Date(1000L), new Date(2000L));
        DateRange r2 = (DateRange) TestUtilities.serialised(r1);
    }

    /**
     * The {@link DateRange} class is immutable, so it doesn't need to
     * be cloneable.
     */
    public void testClone() {
        DateRange r1 = new DateRange(new Date(1000L), new Date(2000L));
    }

    /**
     * Confirm that a DateRange is immutable.
     */
    public void testImmutable() {
        Date d1 = new Date(10L);
        Date d2 = new Date(20L);
        DateRange r = new DateRange(d1, d2);
        d1.setTime(11L);
        r.getUpperDate().setTime(22L);
    }
}
