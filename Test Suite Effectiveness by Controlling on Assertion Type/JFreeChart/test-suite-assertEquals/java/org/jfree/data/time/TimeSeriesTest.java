package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.general.SeriesException;
import org.jfree.date.MonthConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * A collection of test cases for the {@link TimeSeries} class.
 */
public class TimeSeriesTest implements SeriesChangeListener {

    /** A time series. */
    private TimeSeries seriesA;

    /** A time series. */
    private TimeSeries seriesB;

    /** A time series. */
    private TimeSeries seriesC;

    /** A flag that indicates whether or not a change event was fired. */
    private boolean gotSeriesChangeEvent = false;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.seriesA = new TimeSeries("Series A");
        this.seriesA.add(new Year(2000), new Integer(102000));
        this.seriesA.add(new Year(2001), new Integer(102001));
        this.seriesA.add(new Year(2002), new Integer(102002));
        this.seriesA.add(new Year(2003), new Integer(102003));
        this.seriesA.add(new Year(2004), new Integer(102004));
        this.seriesA.add(new Year(2005), new Integer(102005));
        this.seriesB = new TimeSeries("Series B");
        this.seriesB.add(new Year(2006), new Integer(202006));
        this.seriesB.add(new Year(2007), new Integer(202007));
        this.seriesB.add(new Year(2008), new Integer(202008));
        this.seriesC = new TimeSeries("Series C");
        this.seriesC.add(new Year(1999), new Integer(301999));
        this.seriesC.add(new Year(2000), new Integer(302000));
        this.seriesC.add(new Year(2002), new Integer(302002));
    }

    /**
     * Sets the flag to indicate that a {@link SeriesChangeEvent} has been
     * received.
     *
     * @param event  the event.
     */
    @Override
    public void seriesChanged(SeriesChangeEvent event) {
        this.gotSeriesChangeEvent = true;
    }

    /**
     * Check that cloning works.
     */
    public void testClone() throws CloneNotSupportedException {
        TimeSeries series = new TimeSeries("Test Series");
        RegularTimePeriod jan1st2002 = new Day(1, MonthConstants.JANUARY, 2002);
        series.add(jan1st2002, new Integer(42));
        TimeSeries clone;
        clone = (TimeSeries) series.clone();
        clone.setKey("Clone Series");
        clone.update(jan1st2002, new Integer(10));
        int seriesValue = series.getValue(jan1st2002).intValue();
        int cloneValue = clone.getValue(jan1st2002).intValue();
    }

    /**
     * Another test of the clone() method.
     */
    public void testClone2() throws CloneNotSupportedException {
        TimeSeries s1 = new TimeSeries("S1", Year.class);
        s1.add(new Year(2007), 100.0);
        s1.add(new Year(2008), null);
        s1.add(new Year(2009), 200.0);
        TimeSeries s2 = (TimeSeries) s1.clone();
        s2.addOrUpdate(new Year(2009), 300.0);
        s1.addOrUpdate(new Year(2009), 300.0);
    }

    /**
     * Add a value to series A for 1999.  It should be added at index 0.
     */
    public void testAddValue() {
        this.seriesA.add(new Year(1999), new Integer(1));
        int value = this.seriesA.getValue(0).intValue();
    }

    /**
     * Tests the retrieval of values.
     */
    public void testGetValue() {
        Number value1 = this.seriesA.getValue(new Year(1999));
        int value2 = this.seriesA.getValue(new Year(2000)).intValue();
    }

    /**
     * Tests the deletion of values.
     */
    public void testDelete() {
        this.seriesA.delete(0, 0);
        Number value = this.seriesA.getValue(new Year(2000));
    }

    /**
     * Basic tests for the delete() method.
     */
    public void testDelete2() {
        TimeSeries s1 = new TimeSeries("Series", Year.class);
        s1.add(new Year(2000), 13.75);
        s1.add(new Year(2001), 11.90);
        s1.add(new Year(2002), null);
        s1.addChangeListener(this);
        this.gotSeriesChangeEvent = false;
        s1.delete(new Year(2001));
        this.gotSeriesChangeEvent = false;
        s1.delete(new Year(2006));
        try {
            s1.delete(null);
            fail("Expected IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Some checks for the delete(int, int) method.
     */
    public void testDelete3() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2011), 1.1);
        s1.add(new Year(2012), 2.2);
        s1.add(new Year(2013), 3.3);
        s1.add(new Year(2014), 4.4);
        s1.add(new Year(2015), 5.5);
        s1.add(new Year(2016), 6.6);
        s1.delete(2, 5);
    }

    /**
     * Check that the item bounds are determined correctly when there is a
     * maximum item count and a new value is added.
     */
    public void testDelete_RegularTimePeriod() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2010), 1.1);
        s1.add(new Year(2011), 2.2);
        s1.add(new Year(2012), 3.3);
        s1.add(new Year(2013), 4.4);
        s1.delete(new Year(2010));
        s1.delete(new Year(2013));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimeSeries s1 = new TimeSeries("A test");
        s1.add(new Year(2000), 13.75);
        s1.add(new Year(2001), 11.90);
        s1.add(new Year(2002), null);
        s1.add(new Year(2005), 19.32);
        s1.add(new Year(2007), 16.89);
        TimeSeries s2 = (TimeSeries) TestUtilities.serialised(s1);
    }

    /**
     * Tests the equals method.
     */
    public void testEquals() {
        TimeSeries s1 = new TimeSeries("Time Series 1");
        TimeSeries s2 = new TimeSeries("Time Series 2");
        boolean b1 = s1.equals(s2);
        s2.setKey("Time Series 1");
        boolean b2 = s1.equals(s2);
        RegularTimePeriod p1 = new Day();
        RegularTimePeriod p2 = p1.next();
        s1.add(p1, 100.0);
        s1.add(p2, 200.0);
        boolean b3 = s1.equals(s2);
        s2.add(p1, 100.0);
        s2.add(p2, 200.0);
        boolean b4 = s1.equals(s2);
        s1.setMaximumItemCount(100);
        boolean b5 = s1.equals(s2);
        s2.setMaximumItemCount(100);
        boolean b6 = s1.equals(s2);
        s1.setMaximumItemAge(100);
        boolean b7 = s1.equals(s2);
        s2.setMaximumItemAge(100);
        boolean b8 = s1.equals(s2);
    }

    /**
     * Tests a specific bug report where null arguments in the constructor
     * cause the equals() method to fail.  Fixed for 0.9.21.
     */
    public void testEquals2() {
        TimeSeries s1 = new TimeSeries("Series", null, null, Day.class);
        TimeSeries s2 = new TimeSeries("Series", null, null, Day.class);
    }

    /**
     * Two classes with different period classes are NOT the same.
     */
    public void testEquals3() {
        TimeSeries s1 = new TimeSeries("Series", Day.class);
        TimeSeries s2 = new TimeSeries("Series", Month.class);
    }

    /**
     * Some tests to ensure that the createCopy(RegularTimePeriod,
     * RegularTimePeriod) method is functioning correctly.
     */
    public void testCreateCopy1() {
        TimeSeries series = new TimeSeries("Series", Month.class);
        series.add(new Month(MonthConstants.JANUARY, 2003), 45.0);
        series.add(new Month(MonthConstants.FEBRUARY, 2003), 55.0);
        series.add(new Month(MonthConstants.JUNE, 2003), 35.0);
        series.add(new Month(MonthConstants.NOVEMBER, 2003), 85.0);
        series.add(new Month(MonthConstants.DECEMBER, 2003), 75.0);
        try {
            TimeSeries result1 = series.createCopy(new Month(MonthConstants.NOVEMBER, 2002), new Month(MonthConstants.DECEMBER, 2002));
            assertEquals(0, result1.getItemCount());
            TimeSeries result2 = series.createCopy(new Month(MonthConstants.NOVEMBER, 2002), new Month(MonthConstants.JANUARY, 2003));
            assertEquals(1, result2.getItemCount());
            TimeSeries result3 = series.createCopy(new Month(MonthConstants.NOVEMBER, 2002), new Month(MonthConstants.APRIL, 2003));
            assertEquals(2, result3.getItemCount());
            TimeSeries result4 = series.createCopy(new Month(MonthConstants.NOVEMBER, 2002), new Month(MonthConstants.DECEMBER, 2003));
            assertEquals(5, result4.getItemCount());
            TimeSeries result5 = series.createCopy(new Month(MonthConstants.NOVEMBER, 2002), new Month(MonthConstants.MARCH, 2004));
            assertEquals(5, result5.getItemCount());
            TimeSeries result6 = series.createCopy(new Month(MonthConstants.JANUARY, 2003), new Month(MonthConstants.JANUARY, 2003));
            assertEquals(1, result6.getItemCount());
            TimeSeries result7 = series.createCopy(new Month(MonthConstants.JANUARY, 2003), new Month(MonthConstants.APRIL, 2003));
            assertEquals(2, result7.getItemCount());
            TimeSeries result8 = series.createCopy(new Month(MonthConstants.JANUARY, 2003), new Month(MonthConstants.DECEMBER, 2003));
            assertEquals(5, result8.getItemCount());
            TimeSeries result9 = series.createCopy(new Month(MonthConstants.JANUARY, 2003), new Month(MonthConstants.MARCH, 2004));
            assertEquals(5, result9.getItemCount());
            TimeSeries result10 = series.createCopy(new Month(MonthConstants.MAY, 2003), new Month(MonthConstants.DECEMBER, 2003));
            assertEquals(3, result10.getItemCount());
            TimeSeries result11 = series.createCopy(new Month(MonthConstants.MAY, 2003), new Month(MonthConstants.MARCH, 2004));
            assertEquals(3, result11.getItemCount());
            TimeSeries result12 = series.createCopy(new Month(MonthConstants.DECEMBER, 2003), new Month(MonthConstants.DECEMBER, 2003));
            assertEquals(1, result12.getItemCount());
            TimeSeries result13 = series.createCopy(new Month(MonthConstants.DECEMBER, 2003), new Month(MonthConstants.MARCH, 2004));
            assertEquals(1, result13.getItemCount());
            TimeSeries result14 = series.createCopy(new Month(MonthConstants.JANUARY, 2004), new Month(MonthConstants.MARCH, 2004));
            assertEquals(0, result14.getItemCount());
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
    }

    /**
     * Some tests to ensure that the createCopy(int, int) method is
     * functioning correctly.
     */
    public void testCreateCopy2() {
        TimeSeries series = new TimeSeries("Series", Month.class);
        series.add(new Month(MonthConstants.JANUARY, 2003), 45.0);
        series.add(new Month(MonthConstants.FEBRUARY, 2003), 55.0);
        series.add(new Month(MonthConstants.JUNE, 2003), 35.0);
        series.add(new Month(MonthConstants.NOVEMBER, 2003), 85.0);
        series.add(new Month(MonthConstants.DECEMBER, 2003), 75.0);
        try {
            TimeSeries result1 = series.createCopy(0, 0);
            assertEquals(new Month(1, 2003), result1.getTimePeriod(0));
            result1 = series.createCopy(0, 1);
            assertEquals(new Month(2, 2003), result1.getTimePeriod(1));
            result1 = series.createCopy(1, 3);
            assertEquals(new Month(2, 2003), result1.getTimePeriod(0));
            assertEquals(new Month(11, 2003), result1.getTimePeriod(2));
            result1 = series.createCopy(3, 4);
            assertEquals(new Month(11, 2003), result1.getTimePeriod(0));
            assertEquals(new Month(12, 2003), result1.getTimePeriod(1));
            result1 = series.createCopy(4, 4);
            assertEquals(new Month(12, 2003), result1.getTimePeriod(0));
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
        boolean pass = false;
        try {
            series.createCopy(-1, 1);
        } catch (IllegalArgumentException e) {
            pass = true;
        } catch (CloneNotSupportedException e) {
            pass = false;
        }
        pass = false;
        try {
            series.createCopy(1, 0);
        } catch (IllegalArgumentException e) {
            pass = true;
        } catch (CloneNotSupportedException e) {
            pass = false;
        }
        TimeSeries series2 = new TimeSeries("Series 2");
        try {
            TimeSeries series3 = series2.createCopy(99, 999);
            assertEquals(0, series3.getItemCount());
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
    }

    /**
     * Checks that the min and max y values are updated correctly when copying
     * a subset.
     *
     * @throws java.lang.CloneNotSupportedException
     */
    public void testCreateCopy3() throws CloneNotSupportedException {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2009), 100.0);
        s1.add(new Year(2010), 101.0);
        s1.add(new Year(2011), 102.0);
        TimeSeries s2 = s1.createCopy(0, 1);
        TimeSeries s3 = s1.createCopy(1, 2);
    }

    /**
     * Test the setMaximumItemCount() method to ensure that it removes items
     * from the series if necessary.
     */
    public void testSetMaximumItemCount() {
        TimeSeries s1 = new TimeSeries("S1", Year.class);
        s1.add(new Year(2000), 13.75);
        s1.add(new Year(2001), 11.90);
        s1.add(new Year(2002), null);
        s1.add(new Year(2005), 19.32);
        s1.add(new Year(2007), 16.89);
        s1.setMaximumItemCount(3);
        TimeSeriesDataItem item = s1.getDataItem(0);
    }

    /**
     * Some checks for the addOrUpdate() method.
     */
    public void testAddOrUpdate() {
        TimeSeries s1 = new TimeSeries("S1", Year.class);
        s1.setMaximumItemCount(2);
        s1.addOrUpdate(new Year(2000), 100.0);
        s1.addOrUpdate(new Year(2001), 101.0);
        s1.addOrUpdate(new Year(2001), 102.0);
        s1.addOrUpdate(new Year(2002), 103.0);
    }

    /**
     * Test the add branch of the addOrUpdate() method.
     */
    public void testAddOrUpdate2() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.setMaximumItemCount(2);
        s1.addOrUpdate(new Year(2010), 1.1);
        s1.addOrUpdate(new Year(2011), 2.2);
        s1.addOrUpdate(new Year(2012), 3.3);
    }

    /**
     * Test that the addOrUpdate() method won't allow multiple time period
     * classes.
     */
    public void testAddOrUpdate3() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.addOrUpdate(new Year(2010), 1.1);
        boolean pass = false;
        try {
            s1.addOrUpdate(new Month(1, 2009), 0.0);
        } catch (SeriesException e) {
            pass = true;
        }
    }

    /**
     * Some more checks for the addOrUpdate() method.
     */
    public void testAddOrUpdate4() {
        TimeSeries ts = new TimeSeries("S");
        TimeSeriesDataItem overwritten = ts.addOrUpdate(new Year(2009), 20.09);
        overwritten = ts.addOrUpdate(new Year(2009), 1.0);
        overwritten.setValue(null);
        TimeSeriesDataItem item = new TimeSeriesDataItem(new Year(2010), 20.10);
        overwritten = ts.addOrUpdate(item);
        item.setValue(null);
    }

    /**
     * A test for the bug report 1075255.
     */
    public void testBug1075255() {
        TimeSeries ts = new TimeSeries("dummy");
        ts.add(new FixedMillisecond(0L), 0.0);
        TimeSeries ts2 = new TimeSeries("dummy2");
        ts2.add(new FixedMillisecond(0L), 1.0);
        try {
            ts.addAndOrUpdate(ts2);
        } catch (Exception e) {
            fail("No exceptions should be thrown.");
        }
    }

    /**
     * A test for bug 1832432.
     */
    public void testBug1832432() throws CloneNotSupportedException {
        TimeSeries s1 = new TimeSeries("Series");
        TimeSeries s2 = (TimeSeries) s1.clone();
        s1.add(new Day(1, 1, 2007), 100.0);
    }

    /**
     * Some checks for the getIndex() method.
     */
    public void testGetIndex() {
        TimeSeries series = new TimeSeries("Series", Month.class);
        series.add(new Month(1, 2003), 45.0);
        series.add(new Month(3, 2003), 55.0);
    }

    /**
     * Some checks for the getDataItem(int) method.
     */
    public void testGetDataItem1() {
        TimeSeries series = new TimeSeries("S", Year.class);
        boolean pass = false;
        try {
            series.getDataItem(0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        series.add(new Year(2006), 100.0);
        TimeSeriesDataItem item = series.getDataItem(0);
        pass = false;
        try {
            series.getDataItem(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            series.getDataItem(1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getDataItem(RegularTimePeriod) method.
     */
    public void testGetDataItem2() {
        TimeSeries series = new TimeSeries("S", Year.class);
        boolean pass = false;
        try {
            series.getDataItem(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeAgedItems() method.
     */
    public void testRemoveAgedItems() {
        TimeSeries series = new TimeSeries("Test Series", Year.class);
        series.addChangeListener(this);
        this.gotSeriesChangeEvent = false;
        series.removeAgedItems(true);
        series.add(new Year(1999), 1.0);
        series.setMaximumItemAge(0);
        this.gotSeriesChangeEvent = false;
        series.removeAgedItems(true);
        series.setMaximumItemAge(10);
        series.add(new Year(2001), 2.0);
        this.gotSeriesChangeEvent = false;
        series.setMaximumItemAge(2);
        series.setMaximumItemAge(1);
    }

    /**
     * Some checks for the removeAgedItems(long, boolean) method.
     */
    public void testRemoveAgedItems2() {
        long y2006 = 1157087372534L;
        TimeSeries series = new TimeSeries("Test Series", Year.class);
        series.addChangeListener(this);
        this.gotSeriesChangeEvent = false;
        series.removeAgedItems(y2006, true);
        series.add(new Year(2004), 1.0);
        series.setMaximumItemAge(1);
        this.gotSeriesChangeEvent = false;
        series.removeAgedItems(new Year(2005).getMiddleMillisecond(), true);
        series.removeAgedItems(y2006, true);
        series.setMaximumItemAge(2);
        series.add(new Year(2003), 1.0);
        series.add(new Year(2005), 2.0);
        this.gotSeriesChangeEvent = false;
        series.removeAgedItems(new Year(2005).getMiddleMillisecond(), true);
        series.removeAgedItems(y2006, true);
    }

    /**
     * Calling removeAgedItems() on an empty series should not throw any
     * exception.
     */
    public void testRemoveAgedItems3() {
        TimeSeries s = new TimeSeries("Test");
        boolean pass = true;
        try {
            s.removeAgedItems(0L, true);
        } catch (Exception e) {
            pass = false;
        }
    }

    /**
     * Check that the item bounds are determined correctly when there is a
     * maximum item count.
     */
    public void testRemoveAgedItems4() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.setMaximumItemAge(2);
        s1.add(new Year(2010), 1.1);
        s1.add(new Year(2011), 2.2);
        s1.add(new Year(2012), 3.3);
        s1.add(new Year(2013), 2.5);
    }

    /**
     * Check that the item bounds are determined correctly after a call to
     * removeAgedItems().
     */
    public void testRemoveAgedItems5() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.setMaximumItemAge(4);
        s1.add(new Year(2010), 1.1);
        s1.add(new Year(2011), 2.2);
        s1.add(new Year(2012), 3.3);
        s1.add(new Year(2013), 2.5);
        s1.removeAgedItems(new Year(2015).getMiddleMillisecond(), true);
    }

    /**
     * Some simple checks for the hashCode() method.
     */
    public void testHashCode() {
        TimeSeries s1 = new TimeSeries("Test");
        TimeSeries s2 = new TimeSeries("Test");
        s1.add(new Day(1, 1, 2007), 500.0);
        s2.add(new Day(1, 1, 2007), 500.0);
        s1.add(new Day(2, 1, 2007), null);
        s2.add(new Day(2, 1, 2007), null);
        s1.add(new Day(5, 1, 2007), 111.0);
        s2.add(new Day(5, 1, 2007), 111.0);
        s1.add(new Day(9, 1, 2007), 1.0);
        s2.add(new Day(9, 1, 2007), 1.0);
    }

    /**
     * Test for bug report 1864222.
     */
    public void testBug1864222() {
        TimeSeries s = new TimeSeries("S");
        s.add(new Day(19, 8, 2005), 1);
        s.add(new Day(31, 1, 2006), 1);
        boolean pass = true;
        try {
            s.createCopy(new Day(1, 12, 2005), new Day(18, 1, 2006));
        } catch (CloneNotSupportedException e) {
            pass = false;
        }
    }

    /**
     * Test for bug report 3446965.
     */
    public void testBug3446965() {
        TimeSeries s = new TimeSeries("s");
        s.addOrUpdate(new Year(2011), 100.0);
        s.addOrUpdate(new Year(2012), 150.0);
        s.addOrUpdate(new Year(2013), 200.0);
        s.addOrUpdate(new Year(2012), 250.0);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the getMinY() method.
     */
    public void testGetMinY() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2008), 1.1);
        s1.add(new Year(2009), 2.2);
        s1.add(new Year(2000), 99.9);
        s1.add(new Year(2002), -1.1);
        s1.add(new Year(2003), null);
        s1.addOrUpdate(new Year(2002), null);
    }

    public void testGetMinY2() {
        TimeSeries ts = new TimeSeries("Time Series");
        ts.add(new Year(2014), 1.0);
        ts.addOrUpdate(new Year(2014), null);
        ts.addOrUpdate(new Year(2014), 1.0);
        ts.clear();
    }

    /**
     * Some checks for the getMaxY() method.
     */
    public void testGetMaxY() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2008), 1.1);
        s1.add(new Year(2009), 2.2);
        s1.add(new Year(2000), 99.9);
        s1.add(new Year(2002), -1.1);
        s1.add(new Year(2003), null);
        s1.addOrUpdate(new Year(2000), null);
    }

    public void testGetMaxY2() {
        TimeSeries ts = new TimeSeries("Time Series");
        ts.add(new Year(2014), 1.0);
        ts.addOrUpdate(new Year(2014), null);
        ts.addOrUpdate(new Year(2014), 1.0);
        ts.clear();
    }

    /**
     * A test for the clear method.
     */
    public void testClear() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2009), 1.1);
        s1.add(new Year(2010), 2.2);
        s1.clear();
    }

    /**
     * Check that the item bounds are determined correctly when there is a
     * maximum item count and a new value is added.
     */
    public void testAdd() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.setMaximumItemCount(2);
        s1.add(new Year(2010), 1.1);
        s1.add(new Year(2011), 2.2);
        s1.add(new Year(2012), 3.3);
    }

    /**
     * Some checks for the update(RegularTimePeriod...method).
     */
    public void testUpdate_RegularTimePeriod() {
        TimeSeries s1 = new TimeSeries("S1");
        s1.add(new Year(2010), 1.1);
        s1.add(new Year(2011), 2.2);
        s1.add(new Year(2012), 3.3);
        s1.update(new Year(2012), 4.4);
        s1.update(new Year(2010), 0.5);
        s1.update(new Year(2012), null);
        s1.update(new Year(2010), null);
    }

    /**
     * Create a TimeSeriesDataItem, add it to a TimeSeries.  Now, modifying
     * the original TimeSeriesDataItem should NOT affect the TimeSeries.
     */
    public void testAdd_TimeSeriesDataItem() {
        TimeSeriesDataItem item = new TimeSeriesDataItem(new Year(2009), 1.0);
        TimeSeries series = new TimeSeries("S1");
        series.add(item);
        item.setValue(new Double(99.9));
    }

    public void testSetKey() {
        TimeSeries s1 = new TimeSeries("S");
        s1.setKey("S1");
        TimeSeriesCollection c = new TimeSeriesCollection();
        c.addSeries(s1);
        TimeSeries s2 = new TimeSeries("S2");
        c.addSeries(s2);
        s1.setKey("OK");
        try {
            s1.setKey("S2");
            fail("Expect an exception here.");
        } catch (IllegalArgumentException e) {
        }
        c.removeSeries(s1);
        s1.setKey("S2");
        s1.setKey("S1");
        c.addSeries(s1);
        c.removeSeries(1);
        s1.setKey("S2");
    }

    public void testFindValueRange() {
        TimeSeries ts = new TimeSeries("Time Series");
        ts.add(new Year(2014), 1.0);
        ts.add(new Year(2015), 2.0);
        ts.add(new Year(2016), null);
        ts.add(new Year(2017), Double.NaN);
        ts.clear();
        ts.add(new Year(2014), null);
    }

    /**
     * Tests for:
     * public Range findValueRange(Range, TimePeriodAnchor, TimeZone)
     */
    public void testFindValueRange2() {
        TimeZone tzone = TimeZone.getTimeZone("Europe/London");
        Calendar calendar = new GregorianCalendar(tzone, Locale.UK);
        calendar.clear();
        calendar.set(2014, Calendar.FEBRUARY, 23, 6, 0);
        long start = calendar.getTimeInMillis();
        calendar.clear();
        calendar.set(2014, Calendar.FEBRUARY, 24, 18, 0);
        long end = calendar.getTimeInMillis();
        Range range = new Range(start, end);
        TimeSeries ts = new TimeSeries("Time Series");
        ts.add(new Day(23, 2, 2014), 5.0);
        ts.add(new Day(24, 2, 2014), 6.0);
        ts.clear();
        ts.add(new Day(24, 2, 2014), null);
    }

    /**
     * Test findValueRange() method when there are Double.NaN values present.
     */
    public void testFindValueRange3() {
        TimeZone tzone = TimeZone.getTimeZone("Europe/London");
        Calendar calendar = new GregorianCalendar(tzone, Locale.UK);
        calendar.clear();
        calendar.set(2015, Calendar.SEPTEMBER, 1, 6, 0);
        long start = calendar.getTimeInMillis();
        calendar.clear();
        calendar.set(2015, Calendar.SEPTEMBER, 30, 18, 0);
        long end = calendar.getTimeInMillis();
        Range range = new Range(start, end);
        TimeSeries ts = new TimeSeries("Time Series");
        ts.add(new Day(1, 9, 2015), 1.0);
        ts.add(new Day(2, 9, 2015), 99.0);
        ts.add(new Day(30, 9, 2015), 2.0);
        ts.add(new Day(10, 9, 2015), Double.NaN);
    }
}
