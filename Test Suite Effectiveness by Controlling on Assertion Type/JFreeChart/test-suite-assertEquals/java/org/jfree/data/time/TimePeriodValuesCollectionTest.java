package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.junit.Test;

/**
 * Some tests for the {@link TimePeriodValuesCollection} class.
 */
public class TimePeriodValuesCollectionTest {

    /**
     * A test for bug report 1161340.  I wasn't able to reproduce the problem
     * with this test.
     */
    public void test1161340() {
        TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        TimePeriodValues v1 = new TimePeriodValues("V1");
        v1.add(new Day(11, 3, 2005), 1.2);
        v1.add(new Day(12, 3, 2005), 3.4);
        dataset.addSeries(v1);
        dataset.removeSeries(v1);
        TimePeriodValues v2 = new TimePeriodValues("V2");
        v1.add(new Day(5, 3, 2005), 1.2);
        v1.add(new Day(6, 3, 2005), 3.4);
        dataset.addSeries(v2);
    }

    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        TimePeriodValuesCollection c1 = new TimePeriodValuesCollection();
        TimePeriodValuesCollection c2 = new TimePeriodValuesCollection();
        c1.setDomainIsPointsInTime(!c1.getDomainIsPointsInTime());
        c2.setDomainIsPointsInTime(c1.getDomainIsPointsInTime());
        c1.setXPosition(TimePeriodAnchor.END);
        c2.setXPosition(TimePeriodAnchor.END);
        TimePeriodValues v1 = new TimePeriodValues("Test");
        TimePeriodValues v2 = new TimePeriodValues("Test");
        c1.addSeries(v1);
        c2.addSeries(v2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimePeriodValuesCollection c1 = new TimePeriodValuesCollection();
        TimePeriodValuesCollection c2 = (TimePeriodValuesCollection) TestUtilities.serialised(c1);
    }

    /**
     * Some basic checks for the getSeries() method.
     */
    public void testGetSeries() {
        TimePeriodValuesCollection c1 = new TimePeriodValuesCollection();
        TimePeriodValues s1 = new TimePeriodValues("Series 1");
        c1.addSeries(s1);
        boolean pass = false;
        try {
            c1.getSeries(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            c1.getSeries(1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the getDomainBounds() method.
     */
    public void testGetDomainBoundsWithoutInterval() {
        TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        dataset.setDomainIsPointsInTime(false);
        Range r = dataset.getDomainBounds(false);
        TimePeriodValues s1 = new TimePeriodValues("S1");
        s1.add(new SimpleTimePeriod(1000L, 2000L), 1.0);
        dataset.addSeries(s1);
        r = dataset.getDomainBounds(false);
        s1.add(new SimpleTimePeriod(1500L, 3000L), 2.0);
        r = dataset.getDomainBounds(false);
    }

    /**
     * Some more checks for the getDomainBounds() method.
     * 
     * @see #testGetDomainBoundsWithoutInterval()
     */
    public void testGetDomainBoundsWithInterval() {
        TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        Range r = dataset.getDomainBounds(true);
        TimePeriodValues s1 = new TimePeriodValues("S1");
        s1.add(new SimpleTimePeriod(1000L, 2000L), 1.0);
        dataset.addSeries(s1);
        r = dataset.getDomainBounds(true);
        s1.add(new SimpleTimePeriod(1500L, 3000L), 2.0);
        r = dataset.getDomainBounds(true);
        s1.add(new SimpleTimePeriod(6000L, 7000L), 1.5);
        r = dataset.getDomainBounds(true);
        s1.add(new SimpleTimePeriod(4000L, 5000L), 1.4);
        r = dataset.getDomainBounds(true);
    }
}
