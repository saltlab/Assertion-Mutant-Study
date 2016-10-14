package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XIntervalSeriesCollection} class.
 */
public class XIntervalSeriesCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XIntervalSeriesCollection c1 = new XIntervalSeriesCollection();
        XIntervalSeriesCollection c2 = new XIntervalSeriesCollection();
        XIntervalSeries s1 = new XIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        XIntervalSeries s2 = new XIntervalSeries("Series");
        s2.add(1.0, 1.1, 1.2, 1.3);
        c2.addSeries(s2);
        c1.addSeries(new XIntervalSeries("Empty Series"));
        c2.addSeries(new XIntervalSeries("Empty Series"));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XIntervalSeriesCollection c1 = new XIntervalSeriesCollection();
        XIntervalSeries s1 = new XIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        XIntervalSeriesCollection c2 = (XIntervalSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XIntervalSeriesCollection c1 = new XIntervalSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XIntervalSeriesCollection c1 = new XIntervalSeriesCollection();
        XIntervalSeries s1 = new XIntervalSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        XIntervalSeriesCollection c2 = (XIntervalSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * Some basic checks for the removeSeries() method.
     */
    public void testRemoveSeries() {
        XIntervalSeriesCollection c = new XIntervalSeriesCollection();
        XIntervalSeries s1 = new XIntervalSeries("s1");
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
        XIntervalSeries s1 = new XIntervalSeries("Series1");
        XIntervalSeriesCollection dataset = new XIntervalSeriesCollection();
        dataset.addSeries(s1);
        try {
            dataset.getSeries(1);
        } catch (IllegalArgumentException e) {
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }
}
