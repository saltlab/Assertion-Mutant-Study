package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.jfree.date.MonthConstants;
import org.junit.Test;

/**
 * Tests for the {@link Minute} class.
 */
public class MinuteTest {

    /**
     * Check that a Minute instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Minute minute = new Minute();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Day day1 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour1 = new Hour(15, day1);
        Minute minute1 = new Minute(15, hour1);
        Day day2 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour2 = new Hour(15, day2);
        Minute minute2 = new Minute(15, hour2);
    }

    /**
     * In GMT, the 4.55pm on 21 Mar 2002 is java.util.Date(1016729700000L).
     * Use this to check the Minute constructor.
     */
    @Test
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.getDefault();
        Minute m1 = new Minute(new Date(1016729699999L), zone, locale);
        Minute m2 = new Minute(new Date(1016729700000L), zone, locale);
        assertEquals(55, m2.getMinute());
    }

    /**
     * In Singapore, the 4.55pm on 21 Mar 2002 is
     * java.util.Date(1,014,281,700,000L). Use this to check the Minute
     * constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("Asia/Singapore");
        Locale locale = Locale.getDefault();
        Minute m1 = new Minute(new Date(1016700899999L), zone, locale);
        Minute m2 = new Minute(new Date(1016700900000L), zone, locale);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Minute m1 = new Minute();
        Minute m2 = (Minute) TestUtilities.serialised(m1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Minute m1 = new Minute(45, 5, 1, 2, 2003);
        Minute m2 = new Minute(45, 5, 1, 2, 2003);
        int h1 = m1.hashCode();
        int h2 = m2.hashCode();
    }

    /**
     * The {@link Minute} class is immutable, so should not be
     * {@link Cloneable}.
     */
    public void testNotCloneable() {
        Minute m = new Minute(45, 5, 1, 2, 2003);
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Minute m = new Minute(43, 15, 1, 4, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Minute m = new Minute(59, 15, 1, 4, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            m.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Minute m = new Minute(40, 2, 15, 4, 2000);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            m.getFirstMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond() method.
     */
    public void testGetLastMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Minute m = new Minute(1, 1, 1, 1, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Minute m = new Minute(1, 2, 7, 7, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            m.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Minute m = new Minute(45, 21, 21, 4, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            m.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Minute m = new Minute(1, 1, 1, 1, 2000);
        m = new Minute(1, 1, 1, 1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    @Test
    public void testNext() {
        Minute m = new Minute(30, 1, 12, 12, 2000);
        m = (Minute) m.next();
        assertEquals(2000, m.getHour().getYear());
        m = new Minute(59, 23, 31, 12, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Rome"));
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 47, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Minute m = new Minute(47, 3, 16, 1, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Rome"));
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 47, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Minute m = new Minute(47, 3, 16, 1, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Test for bug 1611872 - previous() fails for first minute in hour.
     */
    public void test1611872() {
        Minute m1 = new Minute(0, 10, 15, 4, 2000);
        Minute m2 = (Minute) m1.previous();
    }
}
