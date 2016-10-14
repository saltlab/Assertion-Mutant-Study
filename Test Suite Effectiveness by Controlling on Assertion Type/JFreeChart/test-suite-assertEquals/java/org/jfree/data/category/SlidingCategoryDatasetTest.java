package org.jfree.data.category;

import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.data.UnknownKeyException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests for the {@link SlidingCategoryDataset} class.
 */
public class SlidingCategoryDatasetTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        DefaultCategoryDataset u1 = new DefaultCategoryDataset();
        u1.addValue(1.0, "R1", "C1");
        u1.addValue(2.0, "R1", "C2");
        SlidingCategoryDataset d1 = new SlidingCategoryDataset(u1, 0, 5);
        DefaultCategoryDataset u2 = new DefaultCategoryDataset();
        u2.addValue(1.0, "R1", "C1");
        u2.addValue(2.0, "R1", "C2");
        SlidingCategoryDataset d2 = new SlidingCategoryDataset(u2, 0, 5);
        d1.setFirstCategoryIndex(1);
        d2.setFirstCategoryIndex(1);
        d1.setMaximumCategoryCount(99);
        d2.setMaximumCategoryCount(99);
        u1.addValue(3.0, "R1", "C3");
        u2.addValue(3.0, "R1", "C3");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultCategoryDataset u1 = new DefaultCategoryDataset();
        u1.addValue(1.0, "R1", "C1");
        u1.addValue(2.0, "R1", "C2");
        SlidingCategoryDataset d1 = new SlidingCategoryDataset(u1, 0, 5);
        SlidingCategoryDataset d2;
        d2 = (SlidingCategoryDataset) d1.clone();
        u1.addValue(3.0, "R1", "C3");
        DefaultCategoryDataset u2 = (DefaultCategoryDataset) d2.getUnderlyingDataset();
        u2.addValue(3.0, "R1", "C3");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultCategoryDataset u1 = new DefaultCategoryDataset();
        u1.addValue(1.0, "R1", "C1");
        u1.addValue(2.0, "R1", "C2");
        SlidingCategoryDataset d1 = new SlidingCategoryDataset(u1, 0, 5);
        SlidingCategoryDataset d2 = (SlidingCategoryDataset) TestUtilities.serialised(d1);
        u1.addValue(3.0, "R1", "C3");
        DefaultCategoryDataset u2 = (DefaultCategoryDataset) d2.getUnderlyingDataset();
        u2.addValue(3.0, "R1", "C3");
    }

    /**
     * Some checks for the getColumnCount() method.
     */
    public void testGetColumnCount() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 10, 2);
        underlying.addValue(1.0, "R1", "C1");
        underlying.addValue(1.0, "R1", "C2");
        dataset.setFirstCategoryIndex(0);
        underlying.addValue(1.0, "R1", "C3");
        dataset.setFirstCategoryIndex(2);
        underlying.clear();
    }

    /**
     * Some checks for the getRowCount() method.
     */
    public void testGetRowCount() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 10, 5);
        underlying.addValue(1.0, "R1", "C1");
        underlying.clear();
    }

    /**
     * Some checks for the getColumnIndex() method.
     */
    public void testGetColumnIndex() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.0, "R1", "C1");
        underlying.addValue(2.0, "R1", "C2");
        underlying.addValue(3.0, "R1", "C3");
        underlying.addValue(4.0, "R1", "C4");
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 1, 2);
    }

    /**
     * Some checks for the getRowIndex() method.
     */
    @Test
    public void testGetRowIndex() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.0, "R1", "C1");
        underlying.addValue(2.0, "R2", "C1");
        underlying.addValue(3.0, "R3", "C1");
        underlying.addValue(4.0, "R4", "C1");
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 1, 2);
        assertEquals(2, dataset.getRowIndex("R3"));
    }

    /**
     * Some checks for the getValue() method.
     */
    public void testGetValue() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.0, "R1", "C1");
        underlying.addValue(2.0, "R1", "C2");
        underlying.addValue(3.0, "R1", "C3");
        underlying.addValue(4.0, "R1", "C4");
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 1, 2);
        boolean pass = false;
        try {
            dataset.getValue("R1", "C1");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            dataset.getValue("R1", "C4");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getColumnKeys() method.
     */
    public void testGetColumnKeys() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.0, "R1", "C1");
        underlying.addValue(2.0, "R1", "C2");
        underlying.addValue(3.0, "R1", "C3");
        underlying.addValue(4.0, "R1", "C4");
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(underlying, 1, 2);
        List keys = dataset.getColumnKeys();
        dataset.setFirstCategoryIndex(3);
        keys = dataset.getColumnKeys();
    }
}
