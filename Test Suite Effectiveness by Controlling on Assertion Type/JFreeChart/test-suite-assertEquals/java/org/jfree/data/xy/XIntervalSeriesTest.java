package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.junit.Test;

/**
 * Tests for the {@link XIntervalSeries} class.
 */
public class XIntervalSeriesTest implements SeriesChangeListener {

    SeriesChangeEvent lastEvent;

    /**
     * Records the last event.
     *
     * @param event  the event.
     */
    public void seriesChanged(SeriesChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XIntervalSeries s1 = new XIntervalSeries("s1");
        XIntervalSeries s2 = new XIntervalSeries("s1");
        s1 = new XIntervalSeries("s2");
        s2 = new XIntervalSeries("s2");
        s1 = new XIntervalSeries("s2", false, true);
        s2 = new XIntervalSeries("s2", false, true);
        s1 = new XIntervalSeries("s2", false, false);
        s2 = new XIntervalSeries("s2", false, false);
        s1.add(1.0, 0.5, 1.5, 2.0);
        s2.add(1.0, 0.5, 1.5, 2.0);
        s1.add(2.0, 0.5, 1.5, 2.0);
        s2.add(2.0, 0.5, 1.5, 2.0);
        s1.remove(new Double(1.0));
        s2.remove(new Double(1.0));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XIntervalSeries s1 = new XIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        XIntervalSeries s2 = (XIntervalSeries) s1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XIntervalSeries s1 = new XIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        XIntervalSeries s2 = (XIntervalSeries) TestUtilities.serialised(s1);
    }

    /**
     * Simple test for the indexOf() method.
     */
    public void testIndexOf() {
        XIntervalSeries s1 = new XIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(2.0, 2.0, 2.0, 3.0);
        s1.add(3.0, 3.0, 3.0, 4.0);
    }

    /**
     * A check for the indexOf() method for an unsorted series.
     */
    public void testIndexOf2() {
        XIntervalSeries s1 = new XIntervalSeries("Series 1", false, true);
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(3.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
    }

    /**
     * Simple test for the remove() method.
     */
    public void testRemove() {
        XIntervalSeries s1 = new XIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        s1.add(3.0, 3.0, 3.0, 3.0);
        s1.remove(new Double(2.0));
        s1.remove(new Double(1.0));
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * When items are added with duplicate x-values, we expect them to remain
     * in the order they were added.
     */
    public void testAdditionOfDuplicateXValues() {
        XIntervalSeries s1 = new XIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 1.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        s1.add(2.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 4.0, 4.0, 4.0);
        s1.add(3.0, 5.0, 5.0, 5.0);
    }

    /**
     * Some checks for the add() method for an UNSORTED series.
     */
    @Test
    public void testAdd() {
        XIntervalSeries series = new XIntervalSeries("Series", false, true);
        series.add(5.0, 5.50, 5.50, 5.50);
        series.add(5.1, 5.51, 5.51, 5.51);
        series.add(6.0, 6.6, 6.6, 6.6);
        series.add(3.0, 3.3, 3.3, 3.3);
        series.add(4.0, 4.4, 4.4, 4.4);
        series.add(2.0, 2.2, 2.2, 2.2);
        series.add(1.0, 1.1, 1.1, 1.1);
        assertEquals(3.3, series.getYValue(3), EPSILON);
    }

    /**
     * A simple check that the maximumItemCount attribute is working.
     */
    public void testSetMaximumItemCount() {
        XIntervalSeries s1 = new XIntervalSeries("S1");
        s1.setMaximumItemCount(2);
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
    }

    /**
     * Check that the maximum item count can be applied retrospectively.
     */
    public void testSetMaximumItemCount2() {
        XIntervalSeries s1 = new XIntervalSeries("S1");
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        s1.setMaximumItemCount(2);
    }

    /**
     * Some checks for the clear() method.
     */
    public void testClear() {
        XIntervalSeries s1 = new XIntervalSeries("S1");
        s1.addChangeListener(this);
        s1.clear();
        s1.add(1.0, 2.0, 3.0, 4.0);
        s1.clear();
    }

    /**
     * A simple check for getXLowValue().
     */
    public void testGetXLowValue() {
        XIntervalSeries s1 = new XIntervalSeries("S1");
        s1.add(1.0, 2.0, 3.0, 4.0);
        s1.add(2.0, 1.0, 4.0, 2.5);
    }

    /**
     * A simple check for getXHighValue().
     */
    public void testGetXHighValue() {
        XIntervalSeries s1 = new XIntervalSeries("S1");
        s1.add(1.0, 2.0, 3.0, 4.0);
        s1.add(2.0, 1.0, 4.0, 2.5);
    }
}
