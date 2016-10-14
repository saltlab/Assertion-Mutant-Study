package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;
import org.jfree.data.time.Day;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.Second;
import org.jfree.data.time.Year;
import org.junit.Test;

/**
 * Tests for the {@link PeriodAxis} class.
 */
public class PeriodAxisTest implements AxisChangeListener {

    /** The last event received. */
    private AxisChangeEvent lastEvent;

    /**
     * Receives and records an {@link AxisChangeEvent}.
     *
     * @param event  the event.
     */
    @Override
    public void axisChanged(AxisChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        PeriodAxis a1 = new PeriodAxis("Test");
        PeriodAxis a2 = new PeriodAxis("Test");
        a1.setFirst(new Year(2000));
        a2.setFirst(new Year(2000));
        a1.setLast(new Year(2004));
        a2.setLast(new Year(2004));
        a1.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        a2.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        a1.setAutoRangeTimePeriodClass(Quarter.class);
        a2.setAutoRangeTimePeriodClass(Quarter.class);
        PeriodAxisLabelInfo info[] = new PeriodAxisLabelInfo[1];
        info[0] = new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"));
        a1.setLabelInfo(info);
        a2.setLabelInfo(info);
        a1.setMajorTickTimePeriodClass(Minute.class);
        a2.setMajorTickTimePeriodClass(Minute.class);
        a1.setMinorTickMarksVisible(!a1.isMinorTickMarksVisible());
        a2.setMinorTickMarksVisible(a1.isMinorTickMarksVisible());
        a1.setMinorTickTimePeriodClass(Minute.class);
        a2.setMinorTickTimePeriodClass(Minute.class);
        Stroke s = new BasicStroke(1.23f);
        a1.setMinorTickMarkStroke(s);
        a2.setMinorTickMarkStroke(s);
        a1.setMinorTickMarkPaint(Color.blue);
        a2.setMinorTickMarkPaint(Color.blue);
    }

    /**
     * Confirm that the equals() method can distinguish the locale field (which
     * is new in version 1.0.13).
     */
    public void testEqualsWithLocale() {
        PeriodAxis a1 = new PeriodAxis("Test", new Year(2000), new Year(2009), TimeZone.getDefault(), Locale.JAPAN);
        PeriodAxis a2 = new PeriodAxis("Test", new Year(2000), new Year(2009), TimeZone.getDefault(), Locale.JAPAN);
        a1 = new PeriodAxis("Test", new Year(2000), new Year(2009), TimeZone.getDefault(), Locale.UK);
        a2 = new PeriodAxis("Test", new Year(2000), new Year(2009), TimeZone.getDefault(), Locale.UK);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        PeriodAxis a1 = new PeriodAxis("Test");
        PeriodAxis a2 = new PeriodAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PeriodAxis a1 = new PeriodAxis("Test");
        PeriodAxis a2 = (PeriodAxis) a1.clone();
        a1.setLabel("New Label");
        a2.setLabel("New Label");
        a1.setFirst(new Year(1920));
        a2.setFirst(new Year(1920));
        a1.setLast(new Year(2020));
        a2.setLast(new Year(2020));
        PeriodAxisLabelInfo[] info = new PeriodAxisLabelInfo[2];
        info[0] = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        info[1] = new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy"));
        a1.setLabelInfo(info);
        a2.setLabelInfo(info);
        a1.setAutoRangeTimePeriodClass(Second.class);
        a2.setAutoRangeTimePeriodClass(Second.class);
        a1.setTimeZone(new SimpleTimeZone(123, "Bogus"));
        a2.setTimeZone(new SimpleTimeZone(123, "Bogus"));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PeriodAxis a1 = new PeriodAxis("Test Axis");
        PeriodAxis a2 = (PeriodAxis) TestUtilities.serialised(a1);
        boolean b = a1.equals(a2);
    }

    /**
     * A test for bug 1932146.
     */
    public void test1932146() {
        PeriodAxis axis = new PeriodAxis("TestAxis");
        axis.addChangeListener(this);
        this.lastEvent = null;
        axis.setRange(new DateRange(0L, 1000L));
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * A test for the setRange() method (because the axis shows whole time
     * periods, the range set for the axis will most likely be wider than the
     * one specified).
     */
    public void test2490803() {
        Locale savedLocale = Locale.getDefault();
        TimeZone savedTimeZone = TimeZone.getDefault();
        try {
            Locale.setDefault(Locale.FRANCE);
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
            GregorianCalendar c0 = new GregorianCalendar();
            c0.clear();
            PeriodAxis axis = new PeriodAxis("TestAxis");
            axis.setRange(new Range(1232105696000L, 1232192096000L), false, false);
            Range r = axis.getRange();
            Day d0 = new Day(16, 1, 2009);
            Day d1 = new Day(17, 1, 2009);
            assertEquals(d0.getFirstMillisecond(), r.getLowerBound(), EPSILON);
            assertEquals(d1.getLastMillisecond() + 1.0, r.getUpperBound(), EPSILON);
        } finally {
            TimeZone.setDefault(savedTimeZone);
            Locale.setDefault(savedLocale);
        }
    }
}
