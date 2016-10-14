package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link QuarterDateFormat} class.
 */
public class QuarterDateFormatTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        QuarterDateFormat qf2 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "1", "2", "3", "4" });
        qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "1", "2", "3", "4" });
        qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" });
        qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" });
        qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }, true);
        qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }, true);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        QuarterDateFormat qf2 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        int h1 = qf1.hashCode();
        int h2 = qf2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        QuarterDateFormat qf2 = null;
        qf2 = (QuarterDateFormat) qf1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" });
        QuarterDateFormat qf2 = (QuarterDateFormat) TestUtilities.serialised(qf1);
    }
}
