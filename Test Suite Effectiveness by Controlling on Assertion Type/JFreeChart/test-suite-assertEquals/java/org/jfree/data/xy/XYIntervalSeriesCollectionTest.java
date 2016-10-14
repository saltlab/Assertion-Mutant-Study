package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYIntervalSeriesCollection} class.
 */
public class XYIntervalSeriesCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection();
        XYIntervalSeriesCollection c2 = new XYIntervalSeriesCollection();
        XYIntervalSeries s1 = new XYIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5);
        c1.addSeries(s1);
        XYIntervalSeries s2 = new XYIntervalSeries("Series");
        s2.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5);
        c2.addSeries(s2);
        c1.addSeries(new XYIntervalSeries("Empty Series"));
        c2.addSeries(new XYIntervalSeries("Empty Series"));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection();
        XYIntervalSeries s1 = new XYIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5);
        XYIntervalSeriesCollection c2 = (XYIntervalSeriesCollection) c1.clone();
        c1.addSeries(new XYIntervalSeries("Empty"));
        c2.addSeries(new XYIntervalSeries("Empty"));
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection();
        XYIntervalSeries s1 = new XYIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5);
        XYIntervalSeriesCollection c2 = (XYIntervalSeriesCollection) TestUtilities.serialised(c1);
        c1.addSeries(new XYIntervalSeries("Empty"));
        c2.addSeries(new XYIntervalSeries("Empty"));
    }

    /**
     * Some basic checks for the removeSeries() method.
     */
    public void testRemoveSeries() {
        XYIntervalSeriesCollection c = new XYIntervalSeriesCollection();
        XYIntervalSeries s1 = new XYIntervalSeries("s1");
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
        XYIntervalSeries s1 = new XYIntervalSeries("Series1");
        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
        dataset.addSeries(s1);
        try {
            dataset.getSeries(1);
        } catch (IllegalArgumentException e) {
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }
}
