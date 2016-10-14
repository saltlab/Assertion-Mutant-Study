package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.junit.Test;

/**
 * Tests for the {@link DefaultStatisticalCategoryDataset} class.
 */
public class DefaultStatisticalCategoryDatasetTest {

    /**
     * Some checks for the getRangeBounds() method.
     */
    public void testGetRangeBounds() {
        DefaultStatisticalCategoryDataset d = new DefaultStatisticalCategoryDataset();
        d.add(4.5, 1.0, "R1", "C1");
        d.add(0.5, 2.0, "R1", "C2");
        d.add(Double.NaN, 0.0, "R1", "C3");
        d.add(Double.NEGATIVE_INFINITY, 0.0, "R1", "C3");
        d.add(Double.POSITIVE_INFINITY, 0.0, "R1", "C3");
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        DefaultStatisticalCategoryDataset d2 = new DefaultStatisticalCategoryDataset();
    }

    /**
     * Some checks for cloning.
     */
    public void testCloning() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.1, 2.2, "R1", "C1");
        d1.add(3.3, 4.4, "R1", "C2");
        d1.add(null, new Double(5.5), "R1", "C3");
        d1.add(new Double(6.6), null, "R2", "C3");
        DefaultStatisticalCategoryDataset d2 = null;
        try {
            d2 = (DefaultStatisticalCategoryDataset) d1.clone();
        } catch (CloneNotSupportedException e) {
            fail(e.toString());
        }
        d1.add(1.1, 2.2, "R3", "C1");
    }

    /**
     * Check serialization of a default instance.
     */
    public void testSerialization1() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.1, 2.2, "R1", "C1");
        d1.add(3.3, 4.4, "R1", "C2");
        d1.add(null, new Double(5.5), "R1", "C3");
        d1.add(new Double(6.6), null, "R2", "C3");
        DefaultStatisticalCategoryDataset d2 = (DefaultStatisticalCategoryDataset) TestUtilities.serialised(d1);
    }

    /**
     * Check serialization of a more complex instance.
     */
    public void testSerialization2() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.2, 3.4, "Row 1", "Column 1");
        DefaultStatisticalCategoryDataset d2 = (DefaultStatisticalCategoryDataset) TestUtilities.serialised(d1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the add() method.
     */
    public void testAdd() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.0, 2.0, "R1", "C1");
        d1.add(10.0, 20.0, "R1", "C1");
    }

    /**
     * Some checks for the getRangeLowerBound() method.
     */
    public void testGetRangeLowerBound() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.0, 2.0, "R1", "C1");
    }

    /**
     * Some checks for the getRangeUpperBound() method.
     */
    public void testGetRangeUpperBound() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.0, 2.0, "R1", "C1");
    }

    /**
     * Some checks for the getRangeBounds() method.
     */
    @Test
    public void testGetRangeBounds2() {
        DefaultStatisticalCategoryDataset d1 = new DefaultStatisticalCategoryDataset();
        d1.add(1.0, 2.0, "R1", "C1");
        d1.add(10.0, 20.0, "R1", "C1");
        assertEquals(new Range(10.0, 10.0), d1.getRangeBounds(false));
    }

    /**
     * Some checks for the remove method.
     */
    public void testRemove() {
        DefaultStatisticalCategoryDataset data = new DefaultStatisticalCategoryDataset();
        boolean pass = false;
        try {
            data.remove("R1", "R2");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        data.add(1.0, 0.5, "R1", "C1");
        data.add(1.4, 0.2, "R2", "C1");
        data.remove("R1", "C1");
    }

    /**
     * A test for bug 3072674.
     */
    public void test3072674() {
        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
        dataset.add(1.0, Double.NaN, "R1", "C1");
        Range r = dataset.getRangeBounds(true);
    }
}
