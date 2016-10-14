package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link DefaultTableXYDataset} class.
 */
public class DefaultTableXYDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        XYSeries s1 = new XYSeries("Series 1", true, false);
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        d1.addSeries(s1);
        DefaultTableXYDataset d2 = new DefaultTableXYDataset();
        XYSeries s2 = new XYSeries("Series 1", true, false);
        s2.add(1.0, 1.1);
        s2.add(2.0, 2.2);
        d2.addSeries(s2);
        s1.add(3.0, 3.3);
        s2.add(3.0, 3.3);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        XYSeries s1 = new XYSeries("Series 1", true, false);
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        d1.addSeries(s1);
        DefaultTableXYDataset d2 = (DefaultTableXYDataset) d1.clone();
        s1.add(3.0, 3.3);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        XYSeries s1 = new XYSeries("Series 1", true, false);
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        d1.addSeries(s1);
        DefaultTableXYDataset d2 = (DefaultTableXYDataset) TestUtilities.serialised(d1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * This is a test for bug 1312066 - adding a new series should trigger a
     * recalculation of the interval width, if it is being automatically
     * calculated.
     */
    public void testAddSeries() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        d1.setAutoWidth(true);
        XYSeries s1 = new XYSeries("Series 1", true, false);
        s1.add(3.0, 1.1);
        s1.add(7.0, 2.2);
        d1.addSeries(s1);
        XYSeries s2 = new XYSeries("Series 2", true, false);
        s2.add(7.5, 1.1);
        s2.add(9.0, 2.2);
        d1.addSeries(s2);
    }

    /**
     * Some basic checks for the getSeries() method.
     */
    public void testGetSeries() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        XYSeries s1 = new XYSeries("Series 1", true, false);
        d1.addSeries(s1);
        boolean pass = false;
        try {
            d1.getSeries(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            d1.getSeries(1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }
}
