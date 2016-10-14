package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.DateRange;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Month;
import org.jfree.data.time.Second;
import org.jfree.data.time.Year;
import org.jfree.ui.RectangleEdge;

/**
 * Tests for the {@link DateAxis} class.
 */
public class DateAxisTest {

    static class MyDateAxis extends DateAxis {

        /**
         * Creates a new instance.
         *
         * @param label  the label.
         */
        public MyDateAxis(String label) {
            super(label);
        }

        @Override
        public Date previousStandardDate(Date d, DateTickUnit unit) {
            return super.previousStandardDate(d, unit);
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DateAxis a1 = new DateAxis("Test");
        DateAxis a2 = new DateAxis("Test");
        a1 = new DateAxis("Test", TimeZone.getTimeZone("PST"), Locale.US);
        a2 = new DateAxis("Test", TimeZone.getTimeZone("PST"), Locale.US);
        a1 = new DateAxis("Test", TimeZone.getTimeZone("PST"), Locale.FRANCE);
        a2 = new DateAxis("Test", TimeZone.getTimeZone("PST"), Locale.FRANCE);
        a1.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 7));
        a2.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 7));
        a1.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        a2.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        a1.setTickMarkPosition(DateTickMarkPosition.END);
        a2.setTickMarkPosition(DateTickMarkPosition.END);
        a1.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
        a2.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
    }

    /**
     * A test for bug report 1472942.  The DateFormat.equals() method is not
     * checking the range attribute.
     */
    public void test1472942() {
        DateAxis a1 = new DateAxis("Test");
        DateAxis a2 = new DateAxis("Test");
        a1.setRange(new Date(1L), new Date(2L));
        a2.setRange(new Date(1L), new Date(2L));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DateAxis a1 = new DateAxis("Test");
        DateAxis a2 = new DateAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DateAxis a1 = new DateAxis("Test");
        DateAxis a2 = (DateAxis) a1.clone();
    }

    /**
     * Test that the setRange() method works.
     */
    public void testSetRange() {
        DateAxis axis = new DateAxis("Test Axis");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.JANUARY, 3);
        Date d1 = calendar.getTime();
        calendar.set(1999, Calendar.JANUARY, 31);
        Date d2 = calendar.getTime();
        axis.setRange(d1, d2);
        DateRange range = (DateRange) axis.getRange();
    }

    /**
     * Test that the setMaximumDate() method works.
     */
    public void testSetMaximumDate() {
        DateAxis axis = new DateAxis("Test Axis");
        Date date = new Date();
        axis.setMaximumDate(date);
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 1);
        Date d0 = new Date(d1.getTime() - 1);
        axis.setMaximumDate(d2);
        axis.setMinimumDate(d1);
        axis.setMaximumDate(d1);
    }

    /**
     * Test that the setMinimumDate() method works.
     */
    public void testSetMinimumDate() {
        DateAxis axis = new DateAxis("Test Axis");
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 1);
        axis.setMaximumDate(d2);
        axis.setMinimumDate(d1);
        Date d3 = new Date(d2.getTime() + 1);
        axis.setMinimumDate(d2);
    }

    /**
     * Tests two doubles for 'near enough' equality.
     *
     * @param d1  number 1.
     * @param d2  number 2.
     * @param tolerance  maximum tolerance.
     *
     * @return A boolean.
     */
    private boolean same(double d1, double d2, double tolerance) {
        return (Math.abs(d1 - d2) < tolerance);
    }

    /**
     * Test the translation of Java2D values to data values.
     */
    public void testJava2DToValue() {
        DateAxis axis = new DateAxis();
        axis.setRange(50.0, 100.0);
        Rectangle2D dataArea = new Rectangle2D.Double(10.0, 50.0, 400.0, 300.0);
        double y1 = axis.java2DToValue(75.0, dataArea, RectangleEdge.LEFT);
        double y2 = axis.java2DToValue(75.0, dataArea, RectangleEdge.RIGHT);
        double x1 = axis.java2DToValue(75.0, dataArea, RectangleEdge.TOP);
        double x2 = axis.java2DToValue(75.0, dataArea, RectangleEdge.BOTTOM);
        axis.setInverted(true);
        double y3 = axis.java2DToValue(75.0, dataArea, RectangleEdge.LEFT);
        double y4 = axis.java2DToValue(75.0, dataArea, RectangleEdge.RIGHT);
        double x3 = axis.java2DToValue(75.0, dataArea, RectangleEdge.TOP);
        double x4 = axis.java2DToValue(75.0, dataArea, RectangleEdge.BOTTOM);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateAxis a1 = new DateAxis("Test Axis");
        DateAxis a2 = (DateAxis) TestUtilities.serialised(a1);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 year.
     */
    public void testPreviousStandardDateYearA() {
        MyDateAxis axis = new MyDateAxis("Year");
        Year y2006 = new Year(2006);
        Year y2007 = new Year(2007);
        Date d0 = new Date(y2006.getFirstMillisecond());
        Date d1 = new Date(y2006.getFirstMillisecond() + 500L);
        Date d2 = new Date(y2006.getMiddleMillisecond());
        Date d3 = new Date(y2006.getMiddleMillisecond() + 500L);
        Date d4 = new Date(y2006.getLastMillisecond());
        Date end = new Date(y2007.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.YEAR, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 10 years (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateYearB() {
        MyDateAxis axis = new MyDateAxis("Year");
        Year y2006 = new Year(2006);
        Year y2007 = new Year(2007);
        Date d0 = new Date(y2006.getFirstMillisecond());
        Date d1 = new Date(y2006.getFirstMillisecond() + 500L);
        Date d2 = new Date(y2006.getMiddleMillisecond());
        Date d3 = new Date(y2006.getMiddleMillisecond() + 500L);
        Date d4 = new Date(y2006.getLastMillisecond());
        Date end = new Date(y2007.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.YEAR, 10);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 month.
     */
    public void testPreviousStandardDateMonthA() {
        MyDateAxis axis = new MyDateAxis("Month");
        Month nov2006 = new Month(11, 2006);
        Month dec2006 = new Month(12, 2006);
        Date d0 = new Date(nov2006.getFirstMillisecond());
        Date d1 = new Date(nov2006.getFirstMillisecond() + 500L);
        Date d2 = new Date(nov2006.getMiddleMillisecond());
        Date d3 = new Date(nov2006.getMiddleMillisecond() + 500L);
        Date d4 = new Date(nov2006.getLastMillisecond());
        Date end = new Date(dec2006.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.MONTH, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 3 months (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateMonthB() {
        MyDateAxis axis = new MyDateAxis("Month");
        Month nov2006 = new Month(11, 2006);
        Month dec2006 = new Month(12, 2006);
        Date d0 = new Date(nov2006.getFirstMillisecond());
        Date d1 = new Date(nov2006.getFirstMillisecond() + 500L);
        Date d2 = new Date(nov2006.getMiddleMillisecond());
        Date d3 = new Date(nov2006.getMiddleMillisecond() + 500L);
        Date d4 = new Date(nov2006.getLastMillisecond());
        Date end = new Date(dec2006.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.MONTH, 3);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 day.
     */
    public void testPreviousStandardDateDayA() {
        MyDateAxis axis = new MyDateAxis("Day");
        Day apr12007 = new Day(1, 4, 2007);
        Day apr22007 = new Day(2, 4, 2007);
        Date d0 = new Date(apr12007.getFirstMillisecond());
        Date d1 = new Date(apr12007.getFirstMillisecond() + 500L);
        Date d2 = new Date(apr12007.getMiddleMillisecond());
        Date d3 = new Date(apr12007.getMiddleMillisecond() + 500L);
        Date d4 = new Date(apr12007.getLastMillisecond());
        Date end = new Date(apr22007.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.DAY, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 7 days (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateDayB() {
        MyDateAxis axis = new MyDateAxis("Day");
        Day apr12007 = new Day(1, 4, 2007);
        Day apr22007 = new Day(2, 4, 2007);
        Date d0 = new Date(apr12007.getFirstMillisecond());
        Date d1 = new Date(apr12007.getFirstMillisecond() + 500L);
        Date d2 = new Date(apr12007.getMiddleMillisecond());
        Date d3 = new Date(apr12007.getMiddleMillisecond() + 500L);
        Date d4 = new Date(apr12007.getLastMillisecond());
        Date end = new Date(apr22007.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.DAY, 7);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 hour.
     */
    public void testPreviousStandardDateHourA() {
        MyDateAxis axis = new MyDateAxis("Hour");
        Hour h0 = new Hour(12, 1, 4, 2007);
        Hour h1 = new Hour(13, 1, 4, 2007);
        Date d0 = new Date(h0.getFirstMillisecond());
        Date d1 = new Date(h0.getFirstMillisecond() + 500L);
        Date d2 = new Date(h0.getMiddleMillisecond());
        Date d3 = new Date(h0.getMiddleMillisecond() + 500L);
        Date d4 = new Date(h0.getLastMillisecond());
        Date end = new Date(h1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.HOUR, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 6 hours (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateHourB() {
        MyDateAxis axis = new MyDateAxis("Hour");
        Hour h0 = new Hour(12, 1, 4, 2007);
        Hour h1 = new Hour(13, 1, 4, 2007);
        Date d0 = new Date(h0.getFirstMillisecond());
        Date d1 = new Date(h0.getFirstMillisecond() + 500L);
        Date d2 = new Date(h0.getMiddleMillisecond());
        Date d3 = new Date(h0.getMiddleMillisecond() + 500L);
        Date d4 = new Date(h0.getLastMillisecond());
        Date end = new Date(h1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.HOUR, 6);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 second.
     */
    public void testPreviousStandardDateSecondA() {
        MyDateAxis axis = new MyDateAxis("Second");
        Second s0 = new Second(58, 31, 12, 1, 4, 2007);
        Second s1 = new Second(59, 31, 12, 1, 4, 2007);
        Date d0 = new Date(s0.getFirstMillisecond());
        Date d1 = new Date(s0.getFirstMillisecond() + 50L);
        Date d2 = new Date(s0.getMiddleMillisecond());
        Date d3 = new Date(s0.getMiddleMillisecond() + 50L);
        Date d4 = new Date(s0.getLastMillisecond());
        Date end = new Date(s1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.SECOND, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 5 seconds (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateSecondB() {
        MyDateAxis axis = new MyDateAxis("Second");
        Second s0 = new Second(58, 31, 12, 1, 4, 2007);
        Second s1 = new Second(59, 31, 12, 1, 4, 2007);
        Date d0 = new Date(s0.getFirstMillisecond());
        Date d1 = new Date(s0.getFirstMillisecond() + 50L);
        Date d2 = new Date(s0.getMiddleMillisecond());
        Date d3 = new Date(s0.getMiddleMillisecond() + 50L);
        Date d4 = new Date(s0.getLastMillisecond());
        Date end = new Date(s1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.SECOND, 5);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d1, end);
        psd = axis.previousStandardDate(d1, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d2, end);
        psd = axis.previousStandardDate(d2, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d3, end);
        psd = axis.previousStandardDate(d3, unit);
        nsd = unit.addToDate(psd);
        axis.setRange(d4, end);
        psd = axis.previousStandardDate(d4, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 1 millisecond.
     */
    public void testPreviousStandardDateMillisecondA() {
        MyDateAxis axis = new MyDateAxis("Millisecond");
        Millisecond m0 = new Millisecond(458, 58, 31, 12, 1, 4, 2007);
        Millisecond m1 = new Millisecond(459, 58, 31, 12, 1, 4, 2007);
        Date d0 = new Date(m0.getFirstMillisecond());
        Date end = new Date(m1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.MILLISECOND, 1);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d0, end);
        psd = axis.previousStandardDate(d0, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d0, end);
        psd = axis.previousStandardDate(d0, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A basic check for the testPreviousStandardDate() method when the
     * tick unit is 10 milliseconds (just for the sake of having a multiple).
     */
    public void testPreviousStandardDateMillisecondB() {
        MyDateAxis axis = new MyDateAxis("Millisecond");
        Millisecond m0 = new Millisecond(458, 58, 31, 12, 1, 4, 2007);
        Millisecond m1 = new Millisecond(459, 58, 31, 12, 1, 4, 2007);
        Date d0 = new Date(m0.getFirstMillisecond());
        Date end = new Date(m1.getLastMillisecond());
        DateTickUnit unit = new DateTickUnit(DateTickUnit.MILLISECOND, 10);
        axis.setTickUnit(unit);
        axis.setTickMarkPosition(DateTickMarkPosition.START);
        axis.setRange(d0, end);
        Date psd = axis.previousStandardDate(d0, unit);
        Date nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setRange(d0, end);
        psd = axis.previousStandardDate(d0, unit);
        nsd = unit.addToDate(psd);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        axis.setRange(d0, end);
        psd = axis.previousStandardDate(d0, unit);
        nsd = unit.addToDate(psd);
    }

    /**
     * A test to reproduce bug 2201869.
     */
    public void testBug2201869() {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        GregorianCalendar c = new GregorianCalendar(tz, Locale.UK);
        DateAxis axis = new DateAxis("Date", tz, Locale.UK);
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy", Locale.UK);
        sdf.setCalendar(c);
        axis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH, 1, sdf));
        Day d1 = new Day(1, 3, 2008);
        d1.peg(c);
        Day d2 = new Day(30, 6, 2008);
        d2.peg(c);
        axis.setRange(d1.getStart(), d2.getEnd());
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D area = new Rectangle2D.Double(0.0, 0.0, 200, 100);
        axis.setTickMarkPosition(DateTickMarkPosition.END);
        List ticks = axis.refreshTicks(g2, new AxisState(), area, RectangleEdge.BOTTOM);
        DateTick t1 = (DateTick) ticks.get(0);
        DateTick t2 = (DateTick) ticks.get(1);
        DateTick t3 = (DateTick) ticks.get(2);
        ticks = axis.refreshTicks(g2, new AxisState(), area, RectangleEdge.LEFT);
        t1 = (DateTick) ticks.get(0);
        t2 = (DateTick) ticks.get(1);
        t3 = (DateTick) ticks.get(2);
    }

    public void testBug3484403() {
        final long[] dates = { 1304892000000L, 1304632800000L, 1304546400000L, 1304460000000L, 1304373600000L, 1304287200000L, 1320015600000L, 1309384800000L, 1319752800000L, 1319666400000L, 1319580000000L, 1319493600000L };
        Arrays.sort(dates);
        DateAxis axis = new DateAxis("Date");
        Date start = new Date(dates[0]);
        Date end = new Date(dates[dates.length - 1]);
        axis.setMinimumDate(start);
        axis.setMaximumDate(end);
        SegmentedTimeline timeline = SegmentedTimeline.newMondayThroughFridayTimeline();
        timeline.setStartTime(start.getTime());
        axis.setTimeline(timeline);
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D area = new Rectangle2D.Double(0.0, 0.0, 500, 200);
        axis.refreshTicks(g2, new AxisState(), area, RectangleEdge.BOTTOM);
    }
}
