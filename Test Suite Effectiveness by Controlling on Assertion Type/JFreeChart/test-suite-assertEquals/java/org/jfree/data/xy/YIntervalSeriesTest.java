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
 * Tests for the {@link YIntervalSeries} class.
 */
public class YIntervalSeriesTest implements SeriesChangeListener {

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
        YIntervalSeries s1 = new YIntervalSeries("s1");
        YIntervalSeries s2 = new YIntervalSeries("s1");
        s1 = new YIntervalSeries("s2");
        s2 = new YIntervalSeries("s2");
        s1 = new YIntervalSeries("s2", false, true);
        s2 = new YIntervalSeries("s2", false, true);
        s1 = new YIntervalSeries("s2", false, false);
        s2 = new YIntervalSeries("s2", false, false);
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
        YIntervalSeries s1 = new YIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        YIntervalSeries s2 = (YIntervalSeries) s1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        YIntervalSeries s1 = new YIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        YIntervalSeries s2 = (YIntervalSeries) TestUtilities.serialised(s1);
    }

    /**
     * Simple test for the indexOf() method.
     */
    public void testIndexOf() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(2.0, 2.0, 2.0, 3.0);
        s1.add(3.0, 3.0, 3.0, 4.0);
    }

    /**
     * A check for the indexOf() method for an unsorted series.
     */
    public void testIndexOf2() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1", false, true);
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(3.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
    }

    /**
     * Simple test for the remove() method.
     */
    public void testRemove() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1");
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
        YIntervalSeries s1 = new YIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 1.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        s1.add(2.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 4.0, 4.0, 4.0);
        s1.add(3.0, 5.0, 5.0, 5.0);
    }

    /**
     * Some checks for the add() method for an UNSORTED series.
     */
    public void testAdd() {
        YIntervalSeries series = new YIntervalSeries("Series", false, true);
        series.add(5.0, 5.50, 5.50, 5.50);
        series.add(5.1, 5.51, 5.51, 5.51);
        series.add(6.0, 6.6, 6.6, 6.6);
        series.add(3.0, 3.3, 3.3, 3.3);
        series.add(4.0, 4.4, 4.4, 4.4);
        series.add(2.0, 2.2, 2.2, 2.2);
        series.add(1.0, 1.1, 1.1, 1.1);
    }

    /**
     * A simple check that the maximumItemCount attribute is working.
     */
    public void testSetMaximumItemCount() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        s1.setMaximumItemCount(2);
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
    }

    /**
     * Check that the maximum item count can be applied retrospectively.
     */
    public void testSetMaximumItemCount2() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        s1.setMaximumItemCount(2);
    }

    /**
     * Some checks for the clear() method.
     */
    public void testClear() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        s1.addChangeListener(this);
        s1.clear();
        s1.add(1.0, 2.0, 3.0, 4.0);
        s1.clear();
    }
}
