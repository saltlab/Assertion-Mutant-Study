package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link MatrixSeries} class.
 */
public class MatrixSeriesTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MatrixSeries m1 = new MatrixSeries("Test", 8, 3);
        m1.update(0, 0, 11.0);
        m1.update(7, 2, 22.0);
        MatrixSeries m2 = new MatrixSeries("Test", 8, 3);
        m2.update(0, 0, 11.0);
        m2.update(7, 2, 22.0);
        m1 = new MatrixSeries("Test 2", 8, 3);
        m2 = new MatrixSeries("Test 2", 8, 3);
        m1 = new MatrixSeries("Test 2", 10, 3);
        m2 = new MatrixSeries("Test 2", 10, 3);
        m1 = new MatrixSeries("Test 2", 10, 5);
        m2 = new MatrixSeries("Test 2", 10, 5);
        m1.update(0, 0, 99);
        m2.update(0, 0, 99);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        MatrixSeries m1 = new MatrixSeries("Test", 8, 3);
        m1.update(0, 0, 11.0);
        m1.update(7, 2, 22.0);
        MatrixSeries m2 = (MatrixSeries) m1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MatrixSeries m1 = new MatrixSeries("Test", 8, 3);
        m1.update(0, 0, 11.0);
        m1.update(7, 2, 22.0);
        MatrixSeries m2 = (MatrixSeries) TestUtilities.serialised(m1);
    }

    /**
     * Tests the getItemColumn() method.
     */
    public void testGetItemColumn() {
        MatrixSeries m = new MatrixSeries("Test", 3, 2);
    }

    /**
     * Tests the getItemRow() method.
     */
    public void testGetItemRow() {
        MatrixSeries m = new MatrixSeries("Test", 3, 2);
    }

    /**
     * Tests the getItem() method.
     */
    public void testGetItem() {
        MatrixSeries m = new MatrixSeries("Test", 3, 2);
        m.update(0, 0, 0.0);
        m.update(0, 1, 1.0);
        m.update(1, 0, 2.0);
        m.update(1, 1, 3.0);
        m.update(2, 0, 4.0);
        m.update(2, 1, 5.0);
    }
}
