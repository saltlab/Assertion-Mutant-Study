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
 * Tests for the {@link Hour} class.
 */
public class HourTest {

    /**
     * Check that an Hour instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Hour hour = new Hour();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Hour hour1 = new Hour(15, new Day(29, MonthConstants.MARCH, 2002));
        Hour hour2 = new Hour(15, new Day(29, MonthConstants.MARCH, 2002));
    }

    /**
     * In GMT, the 4pm on 21 Mar 2002 is java.util.Date(1,014,307,200,000L).
     * Use this to check the hour constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.getDefault();
        Hour h1 = new Hour(new Date(1014307199999L), zone, locale);
        Hour h2 = new Hour(new Date(1014307200000L), zone, locale);
    }

    /**
     * In Sydney, the 4pm on 21 Mar 2002 is java.util.Date(1,014,267,600,000L).
     * Use this to check the hour constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("Australia/Sydney");
        Locale locale = Locale.getDefault();
        Hour h1 = new Hour(new Date(1014267599999L), zone, locale);
        Hour h2 = new Hour(new Date(1014267600000L), zone, locale);
    }

    /**
     * Set up an hour equal to hour zero, 1 January 1900.  Request the
     * previous hour, it should be null.
     */
    public void testFirstHourPrevious() {
        Hour first = new Hour(0, new Day(1, MonthConstants.JANUARY, 1900));
        Hour previous = (Hour) first.previous();
    }

    /**
     * Set up an hour equal to hour zero, 1 January 1900.  Request the next
     * hour, it should be null.
     */
    public void testFirstHourNext() {
        Hour first = new Hour(0, new Day(1, MonthConstants.JANUARY, 1900));
        Hour next = (Hour) first.next();
    }

    /**
     * Set up an hour equal to hour zero, 1 January 1900.  Request the previous
     * hour, it should be null.
     */
    public void testLastHourPrevious() {
        Hour last = new Hour(23, new Day(31, MonthConstants.DECEMBER, 9999));
        Hour previous = (Hour) last.previous();
    }

    /**
     * Set up an hour equal to hour zero, 1 January 1900.  Request the next
     * hour, it should be null.
     */
    public void testLastHourNext() {
        Hour last = new Hour(23, new Day(31, MonthConstants.DECEMBER, 9999));
        Hour next = (Hour) last.next();
    }

    /**
     * Problem for date parsing.
     */
    public void testParseHour() {
        Hour h = Hour.parseHour("2002-01-29 13");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Hour h1 = new Hour();
        Hour h2 = (Hour) TestUtilities.serialised(h1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Hour h1 = new Hour(7, 9, 10, 1999);
        Hour h2 = new Hour(7, 9, 10, 1999);
        int hash1 = h1.hashCode();
        int hash2 = h2.hashCode();
    }

    /**
     * The {@link Hour} class is immutable, so should not be {@link Cloneable}.
     */
    public void testNotCloneable() {
        Hour h = new Hour(7, 9, 10, 1999);
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Hour h = new Hour(15, 1, 4, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Hour h = new Hour(15, 1, 4, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            h.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Hour h = new Hour(2, 15, 4, 2000);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            h.getFirstMillisecond((Calendar) null);
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
        Hour h = new Hour(1, 1, 1, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Hour h = new Hour(2, 7, 7, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            h.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Hour h = new Hour(21, 21, 4, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            h.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Hour h = new Hour(1, 1, 1, 2000);
        h = new Hour(1, 1, 1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    @Test
    public void testNext() {
        Hour h = new Hour(1, 12, 12, 2000);
        h = (Hour) h.next();
        assertEquals(2, h.getHour());
        h = new Hour(23, 31, 12, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Hour h = new Hour(3, 16, 1, 2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 8, 1, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Hour h = new Hour(1, 8, 1, 2006);
        Locale.setDefault(saved);
    }
}
