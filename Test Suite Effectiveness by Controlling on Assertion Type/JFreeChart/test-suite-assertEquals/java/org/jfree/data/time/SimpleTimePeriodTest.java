package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link SimpleTimePeriod} class.
 */
public class SimpleTimePeriodTest {

    /**
     * Check that an instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        SimpleTimePeriod p = new SimpleTimePeriod(new Date(1000L), new Date(1001L));
    }

    /**
     * Test the equals() method.
     */
    public void testEquals() {
        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(1000L), new Date(1004L));
        SimpleTimePeriod p2 = new SimpleTimePeriod(new Date(1000L), new Date(1004L));
        p1 = new SimpleTimePeriod(new Date(1002L), new Date(1004L));
        p2 = new SimpleTimePeriod(new Date(1002L), new Date(1004L));
        p1 = new SimpleTimePeriod(new Date(1002L), new Date(1003L));
        p2 = new SimpleTimePeriod(new Date(1002L), new Date(1003L));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(1000L), new Date(1001L));
        SimpleTimePeriod p2 = (SimpleTimePeriod) TestUtilities.serialised(p1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        SimpleTimePeriod s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        int h1 = s1.hashCode();
        int h2 = s2.hashCode();
    }

    /**
     * This class is immutable, so it should not implement Cloneable.
     */
    public void testClone() {
        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L), new Date(20));
    }

    /**
     * Some simple checks for immutability.
     */
    public void testImmutable() {
        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        SimpleTimePeriod p2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        p1.getStart().setTime(11L);
        Date d1 = new Date(10L);
        Date d2 = new Date(20L);
        p1 = new SimpleTimePeriod(d1, d2);
        d1.setTime(11L);
    }

    /**
     * Some checks for the compareTo() method.
     */
    public void testCompareTo() {
        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        SimpleTimePeriod s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(9L), new Date(21L));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(11L), new Date(19L));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(9L), new Date(19L));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(11L), new Date(21));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(10L), new Date(18));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
        s1 = new SimpleTimePeriod(new Date(10L), new Date(22));
        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
    }
}
