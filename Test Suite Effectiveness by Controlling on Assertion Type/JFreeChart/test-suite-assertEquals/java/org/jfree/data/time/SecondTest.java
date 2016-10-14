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
 * Tests for the {@link Second} class.
 */
public class SecondTest {

    /**
     * Test that a Second instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Second second = new Second();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Day day1 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour1 = new Hour(15, day1);
        Minute minute1 = new Minute(15, hour1);
        Second second1 = new Second(34, minute1);
        Day day2 = new Day(29, MonthConstants.MARCH, 2002);
        Hour hour2 = new Hour(15, day2);
        Minute minute2 = new Minute(15, hour2);
        Second second2 = new Second(34, minute2);
    }

    /**
     * In GMT, the 4.55:59pm on 21 Mar 2002 is java.util.Date(1016729759000L).
     * Use this to check the Second constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.getDefault();
        Second s1 = new Second(new Date(1016729758999L), zone, locale);
        Second s2 = new Second(new Date(1016729759000L), zone, locale);
    }

    /**
     * In Chicago, the 4.55:59pm on 21 Mar 2002 is
     * java.util.Date(1016751359000L). Use this to check the Second constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("America/Chicago");
        Locale locale = Locale.getDefault();
        Second s1 = new Second(new Date(1016751358999L), zone, locale);
        Second s2 = new Second(new Date(1016751359000L), zone, locale);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Second s1 = new Second();
        Second s2 = (Second) TestUtilities.serialised(s1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Second s1 = new Second(13, 45, 5, 1, 2, 2003);
        Second s2 = new Second(13, 45, 5, 1, 2, 2003);
        int h1 = s1.hashCode();
        int h2 = s2.hashCode();
    }

    /**
     * The {@link Second} class is immutable, so should not be
     * {@link Cloneable}.
     */
    public void testNotCloneable() {
        Second s = new Second(13, 45, 5, 1, 2, 2003);
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Second s = new Second(15, 43, 15, 1, 4, 2006);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Second s = new Second(50, 59, 15, 1, 4, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            s.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Second s = new Second(55, 40, 2, 15, 4, 2000);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            s.getFirstMillisecond((Calendar) null);
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
        Second s = new Second(1, 1, 1, 1, 1, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Second s = new Second(55, 1, 2, 7, 7, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            s.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Second s = new Second(50, 45, 21, 21, 4, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            s.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Second s = new Second(1, 1, 1, 1, 1, 2000);
        s = new Second(1, 1, 1, 1, 1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Second s = new Second(55, 30, 1, 12, 12, 2000);
        s = (Second) s.next();
        s = new Second(59, 59, 23, 31, 12, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 3, 47, 55);
        cal.set(Calendar.MILLISECOND, 0);
        Second s = new Second(55, 47, 3, 16, 1, 2006);
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
        cal.set(Calendar.MILLISECOND, 999);
        Second s = new Second(55, 47, 3, 16, 1, 2006);
        Locale.setDefault(saved);
    }
}
