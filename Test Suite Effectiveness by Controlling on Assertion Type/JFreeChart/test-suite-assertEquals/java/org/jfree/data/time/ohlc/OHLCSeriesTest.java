package org.jfree.data.time.ohlc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Year;
import org.junit.Test;

/**
 * Tests for the {@link OHLCSeries} class.
 */
public class OHLCSeriesTest implements SeriesChangeListener {

    SeriesChangeEvent lastEvent;

    /**
     * Records a change event.
     *
     * @param event  the event.
     */
    @Override
    public void seriesChanged(SeriesChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        OHLCSeries s1 = new OHLCSeries("s1");
        OHLCSeries s2 = new OHLCSeries("s1");
        s1 = new OHLCSeries("s2");
        s2 = new OHLCSeries("s2");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        s2.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        s1.add(new Year(2008), 2.0, 4.0, 1.0, 3.0);
        s2.add(new Year(2008), 2.0, 4.0, 1.0, 3.0);
        s1.remove(new Year(2008));
        s2.remove(new Year(2008));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        OHLCSeries s1 = new OHLCSeries("Test");
        s1.add(new Year(2009), 1.0, 3.0, 2.0, 1.4);
        OHLCSeries s2 = new OHLCSeries("Test");
        s2.add(new Year(2009), 1.0, 3.0, 2.0, 1.4);
        int h1 = s1.hashCode();
        int h2 = s2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        OHLCSeries s2 = (OHLCSeries) s1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        OHLCSeries s2 = (OHLCSeries) TestUtilities.serialised(s1);
    }

    /**
     * Simple test for the indexOf() method.
     */
    public void testIndexOf() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        s1.add(new Year(2011), 2.0, 4.0, 1.0, 3.0);
        s1.add(new Year(2010), 2.0, 4.0, 1.0, 3.0);
    }

    /**
     * Simple test for the remove() method.
     */
    public void testRemove() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        s1.add(new Year(2011), 2.1, 4.1, 1.1, 3.1);
        s1.add(new Year(2010), 2.2, 4.2, 1.2, 3.2);
        s1.remove(new Year(2010));
        s1.remove(new Year(2006));
    }

    /**
     * A check for the remove(int) method.
     */
    public void testRemove_int() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 2.0, 4.0, 1.0, 3.0);
        s1.add(new Year(2011), 2.1, 4.1, 1.1, 3.1);
        s1.add(new Year(2010), 2.2, 4.2, 1.2, 3.2);
        s1.remove(s1.getItemCount() - 1);
    }

    /**
     * If you add a duplicate period, an exception should be thrown.
     */
    public void testAdditionOfDuplicatePeriod() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 1.0, 1.0, 1.0, 1.0);
        boolean pass = false;
        try {
            s1.add(new Year(2006), 1.0, 1.0, 1.0, 1.0);
        } catch (SeriesException e) {
            pass = true;
        }
    }

    /**
     * A simple check that the maximumItemCount attribute is working.
     */
    public void testSetMaximumItemCount() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.setMaximumItemCount(2);
        s1.add(new Year(2006), 1.0, 1.1, 1.1, 1.1);
        s1.add(new Year(2007), 2.0, 2.2, 2.2, 2.2);
        s1.add(new Year(2008), 3.0, 3.3, 3.3, 3.3);
    }

    /**
     * Check that the maximum item count can be applied retrospectively.
     */
    public void testSetMaximumItemCount2() {
        OHLCSeries s1 = new OHLCSeries("s1");
        s1.add(new Year(2006), 1.0, 1.1, 1.1, 1.1);
        s1.add(new Year(2007), 2.0, 2.2, 2.2, 2.2);
        s1.add(new Year(2008), 3.0, 3.3, 3.3, 3.3);
        s1.setMaximumItemCount(2);
    }

    /**
     * Some checks for the clear() method.
     */
    public void testClear() {
        OHLCSeries s1 = new OHLCSeries("S1");
        s1.addChangeListener(this);
        s1.clear();
        s1.add(new Year(2006), 1.0, 1.1, 1.1, 1.1);
        s1.clear();
    }
}
