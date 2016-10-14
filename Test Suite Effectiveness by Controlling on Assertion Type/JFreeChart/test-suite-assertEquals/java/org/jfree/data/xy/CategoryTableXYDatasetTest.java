package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CategoryTableXYDataset} class.
 */
public class CategoryTableXYDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
        d1.add(1.0, 1.1, "Series 1");
        d1.add(2.0, 2.2, "Series 1");
        CategoryTableXYDataset d2 = new CategoryTableXYDataset();
        d2.add(1.0, 1.1, "Series 1");
        d2.add(2.0, 2.2, "Series 1");
        d1.add(3.0, 3.3, "Series 1");
        d2.add(3.0, 3.3, "Series 1");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
        d1.add(1.0, 1.1, "Series 1");
        d1.add(2.0, 2.2, "Series 1");
        CategoryTableXYDataset d2 = (CategoryTableXYDataset) d1.clone();
        d1.add(3.0, 3.3, "Series 1");
        d2.add(3.0, 3.3, "Series 1");
        d1.setIntervalPositionFactor(0.33);
        d2.setIntervalPositionFactor(0.33);
    }

    /**
     * Another check for cloning - making sure it works for a customised
     * interval delegate.
     */
    public void testCloning2() throws CloneNotSupportedException {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
        d1.add(1.0, 1.1, "Series 1");
        d1.add(2.0, 2.2, "Series 1");
        d1.setIntervalWidth(1.23);
        CategoryTableXYDataset d2 = (CategoryTableXYDataset) d1.clone();
        d1.add(3.0, 3.3, "Series 1");
        d2.add(3.0, 3.3, "Series 1");
        d1.setIntervalPositionFactor(0.33);
        d2.setIntervalPositionFactor(0.33);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
        d1.add(1.0, 1.1, "Series 1");
        d1.add(2.0, 2.2, "Series 1");
        CategoryTableXYDataset d2 = (CategoryTableXYDataset) TestUtilities.serialised(d1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * This is a test for bug 1312066 - adding a new series should trigger a
     * recalculation of the interval width, if it is being automatically
     * calculated.
     */
    public void testAddSeries() {
        CategoryTableXYDataset d1 = new CategoryTableXYDataset();
        d1.setAutoWidth(true);
        d1.add(3.0, 1.1, "Series 1");
        d1.add(7.0, 2.2, "Series 1");
        d1.add(7.5, 1.1, "Series 2");
        d1.add(9.0, 2.2, "Series 2");
    }
}
