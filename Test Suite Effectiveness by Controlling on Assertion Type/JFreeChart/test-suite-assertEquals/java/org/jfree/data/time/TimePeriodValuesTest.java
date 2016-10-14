package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.date.MonthConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * A collection of test cases for the {@link TimePeriodValues} class.
 */
public class TimePeriodValuesTest {

    /** Series A. */
    private TimePeriodValues seriesA;

    /** Series B. */
    private TimePeriodValues seriesB;

    /** Series C. */
    private TimePeriodValues seriesC;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.seriesA = new TimePeriodValues("Series A");
        this.seriesA.add(new Year(2000), new Integer(102000));
        this.seriesA.add(new Year(2001), new Integer(102001));
        this.seriesA.add(new Year(2002), new Integer(102002));
        this.seriesA.add(new Year(2003), new Integer(102003));
        this.seriesA.add(new Year(2004), new Integer(102004));
        this.seriesA.add(new Year(2005), new Integer(102005));
        this.seriesB = new TimePeriodValues("Series B");
        this.seriesB.add(new Year(2006), new Integer(202006));
        this.seriesB.add(new Year(2007), new Integer(202007));
        this.seriesB.add(new Year(2008), new Integer(202008));
        this.seriesC = new TimePeriodValues("Series C");
        this.seriesC.add(new Year(1999), new Integer(301999));
        this.seriesC.add(new Year(2000), new Integer(302000));
        this.seriesC.add(new Year(2002), new Integer(302002));
    }

    /**
     * Set up a quarter equal to Q1 1900.  Request the previous quarter, it 
     * should be null.
     */
    public void testClone() throws CloneNotSupportedException {
        TimePeriodValues series = new TimePeriodValues("Test Series");
        RegularTimePeriod jan1st2002 = new Day(1, MonthConstants.JANUARY, 2002);
        series.add(jan1st2002, new Integer(42));
        TimePeriodValues clone = (TimePeriodValues) series.clone();
        clone.setKey("Clone Series");
        clone.update(0, new Integer(10));
        int seriesValue = series.getValue(0).intValue();
        int cloneValue = clone.getValue(0).intValue();
    }

    /**
     * Add a value to series A for 1999.  It should be added at index 0.
     */
    public void testAddValue() {
        TimePeriodValues tpvs = new TimePeriodValues("Test");
        tpvs.add(new Year(1999), new Integer(1));
        int value = tpvs.getValue(0).intValue();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimePeriodValues s1 = new TimePeriodValues("A test");
        s1.add(new Year(2000), 13.75);
        s1.add(new Year(2001), 11.90);
        s1.add(new Year(2002), null);
        s1.add(new Year(2005), 19.32);
        s1.add(new Year(2007), 16.89);
        TimePeriodValues s2 = (TimePeriodValues) TestUtilities.serialised(s1);
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        TimePeriodValues s1 = new TimePeriodValues("Time Series 1");
        TimePeriodValues s2 = new TimePeriodValues("Time Series 2");
        boolean b1 = s1.equals(s2);
        s2.setKey("Time Series 1");
        boolean b2 = s1.equals(s2);
        s1.setDomainDescription("XYZ");
        s2.setDomainDescription("XYZ");
        s1.setDomainDescription(null);
        s2.setDomainDescription(null);
        s1.setRangeDescription("XYZ");
        s2.setRangeDescription("XYZ");
        s1.setRangeDescription(null);
        s2.setRangeDescription(null);
        RegularTimePeriod p1 = new Day();
        RegularTimePeriod p2 = p1.next();
        s1.add(p1, 100.0);
        s1.add(p2, 200.0);
        boolean b3 = s1.equals(s2);
        s2.add(p1, 100.0);
        s2.add(p2, 200.0);
        boolean b4 = s1.equals(s2);
    }

    /**
     * A test for bug report 1161329.
     */
    public void test1161329() {
        TimePeriodValues tpv = new TimePeriodValues("Test");
        RegularTimePeriod t = new Day();
        tpv.add(t, 1.0);
        t = t.next();
        tpv.add(t, 2.0);
        tpv.delete(0, 1);
        tpv.add(t, 2.0);
    }

    static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the add() methods.
     */
    public void testAdd() {
        TimePeriodValues tpv = new TimePeriodValues("Test");
        MySeriesChangeListener listener = new MySeriesChangeListener();
        tpv.addChangeListener(listener);
        tpv.add(new TimePeriodValue(new SimpleTimePeriod(new Date(1L), new Date(3L)), 99.0));
        boolean pass = false;
        try {
            tpv.add((TimePeriodValue) null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some tests for the getMinStartIndex() method.
     */
    public void testGetMinStartIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
    }

    /**
     * Some tests for the getMaxStartIndex() method.
     */
    public void testGetMaxStartIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
    }

    /**
     * Some tests for the getMinMiddleIndex() method.
     */
    public void testGetMinMiddleIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
    }

    /**
     * Some tests for the getMaxMiddleIndex() method.
     */
    public void testGetMaxMiddleIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
        s.add(new SimpleTimePeriod(150L, 200L), 4.0);
    }

    /**
     * Some tests for the getMinEndIndex() method.
     */
    public void getMinEndIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
    }

    /**
     * Some tests for the getMaxEndIndex() method.
     */
    public void getMaxEndIndex() {
        TimePeriodValues s = new TimePeriodValues("Test");
        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
    }

    /**
     * A listener used for detecting series change events.
     */
    static class MySeriesChangeListener implements SeriesChangeListener {

        SeriesChangeEvent lastEvent;

        /**
         * Creates a new listener.
         */
        public MySeriesChangeListener() {
            this.lastEvent = null;
        }

        /**
         * Returns the last event.
         * 
         * @return The last event (possibly {@code null}).
         */
        public SeriesChangeEvent getLastEvent() {
            return this.lastEvent;
        }

        /**
         * Clears the last event (sets it to {@code null}).
         */
        public void clearLastEvent() {
            this.lastEvent = null;
        }

        /**
         * Callback method for series change events.
         * 
         * @param event  the event.
         */
        @Override
        public void seriesChanged(SeriesChangeEvent event) {
            this.lastEvent = event;
        }
    }
}
