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
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the {@link Month} class.
 */
public class MonthTest {

    /** A month. */
    private Month jan1900;

    /** A month. */
    private Month feb1900;

    /** A month. */
    private Month nov9999;

    /** A month. */
    private Month dec9999;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.jan1900 = new Month(MonthConstants.JANUARY, 1900);
        this.feb1900 = new Month(MonthConstants.FEBRUARY, 1900);
        this.nov9999 = new Month(MonthConstants.NOVEMBER, 9999);
        this.dec9999 = new Month(MonthConstants.DECEMBER, 9999);
    }

    /**
     * Check that a Month instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Month month = new Month();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Month m1 = new Month(MonthConstants.MAY, 2002);
        Month m2 = new Month(MonthConstants.MAY, 2002);
    }

    /**
     * In GMT, the end of Feb 2000 is java.util.Date(951,868,799,999L).  Use
     * this to check the Month constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Month m1 = new Month(new Date(951868799999L), zone);
        Month m2 = new Month(new Date(951868800000L), zone);
    }

    /**
     * In Auckland, the end of Feb 2000 is java.util.Date(951,821,999,999L).
     * Use this to check the Month constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("Pacific/Auckland");
        Month m1 = new Month(new Date(951821999999L), zone);
        Month m2 = new Month(new Date(951822000000L), zone);
    }

    /**
     * Set up a month equal to Jan 1900.  Request the previous month, it should
     * be null.
     */
    public void testJan1900Previous() {
        Month previous = (Month) this.jan1900.previous();
    }

    /**
     * Set up a month equal to Jan 1900.  Request the next month, it should be
     * Feb 1900.
     */
    public void testJan1900Next() {
        Month next = (Month) this.jan1900.next();
    }

    /**
     * Set up a month equal to Dec 9999.  Request the previous month, it should
     * be Nov 9999.
     */
    public void testDec9999Previous() {
        Month previous = (Month) this.dec9999.previous();
    }

    /**
     * Set up a month equal to Dec 9999.  Request the next month, it should be
     * null.
     */
    public void testDec9999Next() {
        Month next = (Month) this.dec9999.next();
    }

    /**
     * Tests the string parsing code...
     */
    public void testParseMonth() {
        Month month = null;
        try {
            month = Month.parseMonth("1990-01");
        } catch (TimePeriodFormatException e) {
            month = new Month(1, 1900);
        }
        try {
            month = Month.parseMonth("02-1991");
        } catch (TimePeriodFormatException e) {
            month = new Month(1, 1900);
        }
        try {
            month = Month.parseMonth("March 1993");
        } catch (TimePeriodFormatException e) {
            month = new Month(1, 1900);
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Month m1 = new Month(12, 1999);
        Month m2 = (Month) TestUtilities.serialised(m1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Month m1 = new Month(2, 2003);
        Month m2 = new Month(2, 2003);
        int h1 = m1.hashCode();
        int h2 = m2.hashCode();
    }

    /**
     * The {@link Month} class is immutable, so should not be {@link Cloneable}.
     */
    public void testNotCloneable() {
        Month m = new Month(2, 2003);
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Month m = new Month(3, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Month m = new Month(2, 1950);
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
        Month m = new Month(1, 2001);
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
        Month m = new Month(3, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Month m = new Month(2, 1950);
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
        Month m = new Month(3, 2001);
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
        Month m = new Month(1, 2000);
        m = new Month(1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Month m = new Month(12, 2000);
        m = (Month) m.next();
        m = new Month(12, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.MARCH, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Month m = new Month(3, 2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Month m = new Month(1, 2006);
        Locale.setDefault(saved);
    }
}
