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
 * Tests for the {@link Millisecond} class.
 */
public class MillisecondTest {

    /**
     * Check that a {@link Millisecond} instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Millisecond millisecond = new Millisecond();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Day day1 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour1 = new Hour(15, day1);
        Minute minute1 = new Minute(15, hour1);
        Second second1 = new Second(34, minute1);
        Millisecond milli1 = new Millisecond(999, second1);
        Day day2 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour2 = new Hour(15, day2);
        Minute minute2 = new Minute(15, hour2);
        Second second2 = new Second(34, minute2);
        Millisecond milli2 = new Millisecond(999, second2);
    }

    /**
     * In GMT, the 4.55:59.123pm on 21 Mar 2002 is
     * java.util.Date(1016729759123L).  Use this to check the Millisecond
     * constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.getDefault();
        Millisecond m1 = new Millisecond(new Date(1016729759122L), zone, locale);
        Millisecond m2 = new Millisecond(new Date(1016729759123L), zone, locale);
    }

    /**
     * In Tallinn, the 4.55:59.123pm on 21 Mar 2002 is
     * java.util.Date(1016722559123L).  Use this to check the Millisecond
     * constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("Europe/Tallinn");
        Locale locale = Locale.getDefault();
        Millisecond m1 = new Millisecond(new Date(1016722559122L), zone, locale);
        Millisecond m2 = new Millisecond(new Date(1016722559123L), zone, locale);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Millisecond m1 = new Millisecond();
        Millisecond m2 = (Millisecond) TestUtilities.serialised(m1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Millisecond m1 = new Millisecond(599, 23, 45, 7, 9, 10, 2007);
        Millisecond m2 = new Millisecond(599, 23, 45, 7, 9, 10, 2007);
        int hash1 = m1.hashCode();
        int hash2 = m2.hashCode();
    }

    /**
     * A test for bug report 943985 - the calculation for the middle
     * millisecond is incorrect for odd milliseconds.
     */
    public void test943985() {
        Millisecond ms = new Millisecond(new java.util.Date(4));
        ms = new Millisecond(new java.util.Date(5));
    }

    /**
     * The {@link Millisecond} class is immutable, so should not be
     * {@link Cloneable}.
     */
    public void testNotCloneable() {
        Millisecond m = new Millisecond(599, 23, 45, 7, 9, 10, 2007);
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Millisecond m = new Millisecond(500, 15, 43, 15, 1, 4, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Millisecond m = new Millisecond(500, 50, 59, 15, 1, 4, 1950);
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
        Millisecond m = new Millisecond(500, 55, 40, 2, 15, 4, 2000);
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
        Millisecond m = new Millisecond(750, 1, 1, 1, 1, 1, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Millisecond m = new Millisecond(750, 55, 1, 2, 7, 7, 1950);
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
        Millisecond m = new Millisecond(250, 50, 45, 21, 21, 4, 2001);
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
    @Test
    public void testGetSerialIndex() {
        Millisecond m = new Millisecond(500, 1, 1, 1, 1, 1, 2000);
        m = new Millisecond(500, 1, 1, 1, 1, 1, 1900);
        assertEquals(176461500L, m.getSerialIndex());
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Millisecond m = new Millisecond(555, 55, 30, 1, 12, 12, 2000);
        m = (Millisecond) m.next();
        m = new Millisecond(999, 59, 59, 23, 31, 12, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 47, 55);
        cal.set(Calendar.MILLISECOND, 555);
        Millisecond m = new Millisecond(555, 55, 47, 3, 16, 1, 2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 47, 55);
        cal.set(Calendar.MILLISECOND, 555);
        Millisecond m = new Millisecond(555, 55, 47, 3, 16, 1, 2006);
        Locale.setDefault(saved);
    }
}
