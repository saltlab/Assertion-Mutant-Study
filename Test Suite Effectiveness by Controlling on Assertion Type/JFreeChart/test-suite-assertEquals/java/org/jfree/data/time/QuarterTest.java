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
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the {link Quarter} class.
 */
public class QuarterTest {

    /** A quarter. */
    private Quarter q1Y1900;

    /** A quarter. */
    private Quarter q2Y1900;

    /** A quarter. */
    private Quarter q3Y9999;

    /** A quarter. */
    private Quarter q4Y9999;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.q1Y1900 = new Quarter(1, 1900);
        this.q2Y1900 = new Quarter(2, 1900);
        this.q3Y9999 = new Quarter(3, 9999);
        this.q4Y9999 = new Quarter(4, 9999);
    }

    /**
     * Check that a Quarter instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
    public void testEqualsSelf() {
        Quarter quarter = new Quarter();
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Quarter q1 = new Quarter(2, 2002);
        Quarter q2 = new Quarter(2, 2002);
    }

    /**
     * In GMT, the end of Q1 2002 is java.util.Date(1017619199999L).  Use this
     * to check the quarter constructor.
     */
    public void testDateConstructor1() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        Quarter q1 = new Quarter(new Date(1017619199999L), zone);
        Quarter q2 = new Quarter(new Date(1017619200000L), zone);
    }

    /**
     * In Istanbul, the end of Q1 2002 is java.util.Date(1017608399999L).  Use
     * this to check the quarter constructor.
     */
    public void testDateConstructor2() {
        TimeZone zone = TimeZone.getTimeZone("Europe/Istanbul");
        Quarter q1 = new Quarter(new Date(1017608399999L), zone);
        Quarter q2 = new Quarter(new Date(1017608400000L), zone);
    }

    /**
     * Set up a quarter equal to Q1 1900.  Request the previous quarter, it
     * should be null.
     */
    public void testQ1Y1900Previous() {
        Quarter previous = (Quarter) this.q1Y1900.previous();
    }

    /**
     * Set up a quarter equal to Q1 1900.  Request the next quarter, it should
     * be Q2 1900.
     */
    public void testQ1Y1900Next() {
        Quarter next = (Quarter) this.q1Y1900.next();
    }

    /**
     * Set up a quarter equal to Q4 9999.  Request the previous quarter, it
     * should be Q3 9999.
     */
    public void testQ4Y9999Previous() {
        Quarter previous = (Quarter) this.q4Y9999.previous();
    }

    /**
     * Set up a quarter equal to Q4 9999.  Request the next quarter, it should
     * be null.
     */
    public void testQ4Y9999Next() {
        Quarter next = (Quarter) this.q4Y9999.next();
    }

    /**
     * Test the string parsing code...
     */
    @Test
    public void testParseQuarter() {
        Quarter quarter = null;
        try {
            quarter = Quarter.parseQuarter("Q1-2000");
        } catch (TimePeriodFormatException e) {
            quarter = new Quarter(1, 1900);
        }
        try {
            quarter = Quarter.parseQuarter("2001-Q2");
        } catch (TimePeriodFormatException e) {
            quarter = new Quarter(1, 1900);
        }
        try {
            quarter = Quarter.parseQuarter("Q3, 2002");
        } catch (TimePeriodFormatException e) {
            quarter = new Quarter(1, 1900);
        }
        assertEquals(3, quarter.getQuarter());
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Quarter q1 = new Quarter(4, 1999);
        Quarter q2 = (Quarter) TestUtilities.serialised(q1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Quarter q1 = new Quarter(2, 2003);
        Quarter q2 = new Quarter(2, 2003);
        int h1 = q1.hashCode();
        int h2 = q2.hashCode();
    }

    /**
     * The {@link Quarter} class is immutable, so should not be
     * {@link Cloneable}.
     */
    public void testNotCloneable() {
        Quarter q = new Quarter(2, 2003);
    }

    /**
     * Some tests for the constructor with (int, int) arguments.  Covers bug
     * report 1377239.
     */
    public void testConstructor() {
        boolean pass = false;
        try {
            new Quarter(0, 2005);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            new Quarter(5, 2005);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond() method.
     */
    public void testGetFirstMillisecond() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        TimeZone savedZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Quarter q = new Quarter(3, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Quarter q = new Quarter(2, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            q.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Quarter q = new Quarter(1, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            q.getFirstMillisecond((Calendar) null);
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
        Quarter q = new Quarter(3, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Quarter q = new Quarter(2, 1950);
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        boolean pass = false;
        try {
            q.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Quarter q = new Quarter(3, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            q.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Quarter q = new Quarter(1, 2000);
        q = new Quarter(1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Quarter q = new Quarter(1, 2000);
        q = (Quarter) q.next();
        q = new Quarter(4, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JULY, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Quarter q = new Quarter(3, 2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.MARCH, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Quarter q = new Quarter(1, 2006);
        Locale.setDefault(saved);
    }
}
