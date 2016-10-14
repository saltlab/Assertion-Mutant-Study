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
 * Tests for the {@link Week} class.
 */
public class WeekTest {

    /** A week. */
    private Week w1Y1900;

    /** A week. */
    private Week w2Y1900;

    /** A week. */
    private Week w51Y9999;

    /** A week. */
    private Week w52Y9999;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.w1Y1900 = new Week(1, 1900);
        this.w2Y1900 = new Week(2, 1900);
        this.w51Y9999 = new Week(51, 9999);
        this.w52Y9999 = new Week(52, 9999);
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Week w1 = new Week(1, 2002);
        Week w2 = new Week(1, 2002);
        w1 = new Week(2, 2002);
        w2 = new Week(2, 2002);
        w1 = new Week(2, 2003);
        w2 = new Week(2, 2003);
    }

    /**
     * Request the week before week 1, 1900: it should be {@code null}.
     */
    public void testW1Y1900Previous() {
        Week previous = (Week) this.w1Y1900.previous();
    }

    /**
     * Request the week after week 1, 1900: it should be week 2, 1900.
     */
    public void testW1Y1900Next() {
        Week next = (Week) this.w1Y1900.next();
    }

    /**
     * Request the week before w52, 9999: it should be week 51, 9999.
     */
    public void testW52Y9999Previous() {
        Week previous = (Week) this.w52Y9999.previous();
    }

    /**
     * Request the week after w52, 9999: it should be {@code null}.
     */
    public void testW52Y9999Next() {
        Week next = (Week) this.w52Y9999.next();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Week w1 = new Week(24, 1999);
        Week w2 = (Week) TestUtilities.serialised(w1);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        Week w1 = new Week(2, 2003);
        Week w2 = new Week(2, 2003);
        int h1 = w1.hashCode();
        int h2 = w2.hashCode();
    }

    /**
     * The {@link Week} class is immutable, so should not be {@link Cloneable}.
     */
    public void testNotCloneable() {
        Week w = new Week(1, 1999);
    }

    /**
     * The first week in 2005 should span the range:
     *
     * TimeZone         | Start Millis  | End Millis    | Start Date  | End Date
     * -----------------+---------------+---------------+-------------+------------
     * Europe/London    | 1104710400000 | 1105315199999 |  3-Jan-2005 | 9-Jan-2005
     * Europe/Paris     | 1104706800000 | 1105311599999 |  3-Jan-2005 | 2-Jan-2005
     * America/New_York | 1104037200000 | 1104641999999 | 26-Dec-2004 | 1-Jan-2005
     *
     * In London and Paris, Monday is the first day of the week, while in the
     * US it is Sunday.
     *
     * Previously, we were using these values, but see Java Bug ID 4960215:
     *
     * TimeZone         | Start Millis  | End Millis    | Start Date  | End Date
     * -----------------+---------------+---------------+-------------+------------
     * Europe/London    | 1104105600000 | 1104710399999 | 27-Dec-2004 | 2-Jan-2005
     * Europe/Paris     | 1104102000000 | 1104706799999 | 27-Dec-2004 | 2-Jan-2005
     * America/New_York | 1104037200000 | 1104641999999 | 26-Dec-2004 | 1-Jan-2005
     */
    public void testWeek12005() {
        Week w1 = new Week(1, 2005);
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK);
        c1.setMinimalDaysInFirstWeek(4);
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"), Locale.FRANCE);
        c2.setMinimalDaysInFirstWeek(4);
        Calendar c3 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"), Locale.US);
    }

    /**
     * The 53rd week in 2004 in London and Paris should span the range:
     *
     * TimeZone         | Start Millis  | End Millis    | Start Date  | End Date
     * -----------------+---------------+---------------+-------------+------------
     * Europe/London    | 1104105600000 | 1104710399999 | 27-Dec-2004 | 02-Jan-2005
     * Europe/Paris     | 1104102000000 | 1104706799999 | 27-Dec-2004 | 02-Jan-2005
     *
     * The 53rd week in 2005 in New York should span the range:
     *
     * TimeZone         | Start Millis  | End Millis    | Start Date  | End Date
     * -----------------+---------------+---------------+-------------+------------
     * America/New_York | 1135486800000 | 1136091599999 | 25-Dec-2005 | 31-Dec-2005
     *
     * In London and Paris, Monday is the first day of the week, while in the
     * US it is Sunday.
     */
    @Test
    public void testWeek532005() {
        Week w1 = new Week(53, 2004);
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK);
        c1.setMinimalDaysInFirstWeek(4);
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"), Locale.FRANCE);
        c2.setMinimalDaysInFirstWeek(4);
        w1 = new Week(53, 2005);
        Calendar c3 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"), Locale.US);
        assertEquals(1135486800000L, w1.getFirstMillisecond(c3));
    }

    /**
     * A test case for bug 1448828.
     */
    public void testBug1448828() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        try {
            Week w = new Week(new Date(1136109830000l), TimeZone.getTimeZone("GMT"));
            assertEquals(2005, w.getYearValue());
            assertEquals(52, w.getWeek());
        } finally {
            Locale.setDefault(saved);
        }
    }

    /**
     * A test case for bug 1498805.
     */
    public void testBug1498805() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        try {
            TimeZone zone = TimeZone.getTimeZone("GMT");
            GregorianCalendar gc = new GregorianCalendar(zone);
            gc.set(2005, Calendar.JANUARY, 1, 12, 0, 0);
            Week w = new Week(gc.getTime(), zone);
            assertEquals(53, w.getWeek());
            assertEquals(new Year(2004), w.getYear());
        } finally {
            Locale.setDefault(saved);
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
        Week w = new Week(3, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithTimeZone() {
        Week w = new Week(47, 1950);
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.US);
        try {
            TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
            assertEquals(-603302400000L, w.getFirstMillisecond(zone));
        } finally {
            Locale.setDefault(saved);
        }
        boolean pass = false;
        try {
            w.getFirstMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getFirstMillisecond(TimeZone) method.
     */
    public void testGetFirstMillisecondWithCalendar() {
        Week w = new Week(1, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            w.getFirstMillisecond((Calendar) null);
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
        Week w = new Week(31, 1970);
        Locale.setDefault(saved);
        TimeZone.setDefault(savedZone);
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithTimeZone() {
        Week w = new Week(2, 1950);
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.US);
        try {
            TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
            assertEquals(-629913600001L, w.getLastMillisecond(zone));
        } finally {
            Locale.setDefault(saved);
        }
        boolean pass = false;
        try {
            w.getLastMillisecond((TimeZone) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getLastMillisecond(TimeZone) method.
     */
    public void testGetLastMillisecondWithCalendar() {
        Week w = new Week(52, 2001);
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt"));
        boolean pass = false;
        try {
            w.getLastMillisecond((Calendar) null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSerialIndex() method.
     */
    public void testGetSerialIndex() {
        Week w = new Week(1, 2000);
        w = new Week(1, 1900);
    }

    /**
     * Some checks for the testNext() method.
     */
    public void testNext() {
        Week w = new Week(12, 2000);
        w = (Week) w.next();
        w = new Week(53, 9999);
    }

    /**
     * Some checks for the getStart() method.
     */
    public void testGetStart() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 16, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Week w = new Week(3, 2006);
        Locale.setDefault(saved);
    }

    /**
     * Some checks for the getEnd() method.
     */
    public void testGetEnd() {
        Locale saved = Locale.getDefault();
        Locale.setDefault(Locale.ITALY);
        Calendar cal = Calendar.getInstance(Locale.ITALY);
        cal.set(2006, Calendar.JANUARY, 8, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Week w = new Week(1, 2006);
        Locale.setDefault(saved);
    }

    /**
     * A test for a problem in constructing a new Week instance.
     */
    public void testConstructor() {
        Locale savedLocale = Locale.getDefault();
        TimeZone savedZone = TimeZone.getDefault();
        Locale.setDefault(new Locale("da", "DK"));
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Copenhagen"));
        GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        cal.set(2007, Calendar.AUGUST, 26, 1, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date t = cal.getTime();
        Week w = new Week(t, TimeZone.getTimeZone("Europe/Copenhagen"));
        Locale.setDefault(Locale.US);
        TimeZone.setDefault(TimeZone.getTimeZone("US/Detroit"));
        cal = (GregorianCalendar) Calendar.getInstance(TimeZone.getDefault());
        cal.set(2007, Calendar.AUGUST, 26, 1, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        t = cal.getTime();
        w = new Week(t, TimeZone.getTimeZone("Europe/Copenhagen"));
        w = new Week(t, TimeZone.getTimeZone("Europe/Copenhagen"), new Locale("da", "DK"));
        Locale.setDefault(savedLocale);
        TimeZone.setDefault(savedZone);
    }
}
