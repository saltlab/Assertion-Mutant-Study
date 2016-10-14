package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link YIntervalSeriesCollection} class.
 */
public class YIntervalSeriesCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        YIntervalSeriesCollection c1 = new YIntervalSeriesCollection();
        YIntervalSeriesCollection c2 = new YIntervalSeriesCollection();
        YIntervalSeries s1 = new YIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        YIntervalSeries s2 = new YIntervalSeries("Series");
        s2.add(1.0, 1.1, 1.2, 1.3);
        c2.addSeries(s2);
        c1.addSeries(new YIntervalSeries("Empty Series"));
        c2.addSeries(new YIntervalSeries("Empty Series"));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        YIntervalSeriesCollection c1 = new YIntervalSeriesCollection();
        YIntervalSeries s1 = new YIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        YIntervalSeriesCollection c2 = (YIntervalSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        YIntervalSeriesCollection c1 = new YIntervalSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        YIntervalSeriesCollection c1 = new YIntervalSeriesCollection();
        YIntervalSeries s1 = new YIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        YIntervalSeriesCollection c2 = (YIntervalSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * Some basic checks for the removeSeries() method.
     */
    public void testRemoveSeries() {
        YIntervalSeriesCollection c = new YIntervalSeriesCollection();
        YIntervalSeries s1 = new YIntervalSeries("s1");
        c.addSeries(s1);
        c.removeSeries(0);
        c.addSeries(s1);
        boolean pass = false;
        try {
            c.removeSeries(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            c.removeSeries(1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * A test for bug report 1170825 (originally affected XYSeriesCollection,
     * this test is just copied over).
     */
    public void test1170825() {
        YIntervalSeries s1 = new YIntervalSeries("Series1");
        YIntervalSeriesCollection dataset = new YIntervalSeriesCollection();
        dataset.addSeries(s1);
        try {
            dataset.getSeries(1);
        } catch (IllegalArgumentException e) {
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }
}
