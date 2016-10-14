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
import org.junit.Test;

/**
 * Tests for the {@link Year} class.
 */
public class YearTest {

    /**
     * Check that a Year instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Year year = new Year();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Year year1 = new Year(2002);
        Year year2 = new Year(2002);
        year1 = new Year(1999);
        year2 = new Year(1999);
    }

    /**
     * In GMT, the end of 2001 is java.util.Date(1009843199999L).  Use this to
     * check the year constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Date d1 = new Date(1009843199999L);
        Date d2 = new Date(1009843200000L);
        Year y1 = new Year(d1, zone);
        Year y2 = new Year(d2, zone);
    }

    /**
     * In Los Angeles, the end of 2001 is java.util.Date(1009871999999L).  Use
     * this to check the year constructor.
     */
    @Test
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        Year y1 = new Year(new Date(1009871999999L), zone);
        Year y2 = new Year(new Date(1009872000000L), zone);
        assertEquals(1009872000000L, y2.getFirstMillisecond(zone));
    }

    /**
     * Set up a year equal to 1900.  Request the previous year, it should be
     * null.
     */
    public void testMinuss9999Previous() {
        Year current = new Year(-9999);
        Year previous = (Year) current.previous();
    }

    /**
     * Set up a year equal to 1900.  Request the next year, it should be 1901.
     */
    public void test1900Next() {
        Year current = new Year(1900);
        Year next = (Year) current.next();
    }

    /**
     * Set up a year equal to 9999.  Request the previous year, it should be
     * 9998.
     */
    public void test9999Previous() {
        Year current = new Year(9999);
        Year previous = (Year) current.previous();
    }

    /**
     * Set up a year equal to 9999.  Request the next year, it should be null.
     */
    public void test9999Next() {
        Year current = new Year(9999);
        Year next = (Year) current.next();
    }

    /**
     * Tests the year string parser.
     */
    @Test
    public void testParseYear() {
        Year year = null;
        try {
            year = Year.parseYear("2000");
        } catch (TimePeriodFormatException e) {
            year = new Year(1900);
        }
        try {
            year = Year.parseYear(" 2001 ");
        } catch (TimePeriodFormatException e) {
            year = new Year(1900);
        }
        try {
            year = Year.parseYear("99");
        } catch (TimePeriodFormatException e) {
            year = new Year(1900);
        }
        assertEquals(99, year.getYear());
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Year y1 = new Year(1999);
        Year y2 = (Year) TestUtilities.serialised(y1);
    }

    /**
     * The {@link Year} class is immutable, so should not be {@link Cloneable}.
     */
    public void testNotCloneable() {
        Year y = new Year(1999);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Year y1 = new Year(1988);
        Year y2 = new Year(1988);
        int h1 = y1.hashCode();
        int h2 = y2.hashCode();
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Year y = new Year(1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Year y = new Year(1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            y.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Year y = new Year(2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            y.getFirstMillisecond((Calendar) null);
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
        Year y = new Year(1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Year y = new Year(1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            y.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Year y = new Year(2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            y.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Year y = new Year(2000);
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Year y = new Year(2000);
        y = (Year) y.next();
        y = new Year(9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Year y = new Year(2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.DECEMBER, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Year y = new Year(2006);
        Locale.setDefault(saved);
    }
}
