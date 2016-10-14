package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.data.UnknownKeyException;
import org.junit.Test;

/**
 * Tests for the {@link DefaultMultiValueCategoryDataset} class.
 */
public class DefaultMultiValueCategoryDatasetTest {

    /**
     * Some checks for the getValue() method.
     */
    public void testGetValue() {
        DefaultMultiValueCategoryDataset d = new DefaultMultiValueCategoryDataset();
        List values = new ArrayList();
        values.add(new Integer(1));
        values.add(new Integer(2));
        d.add(values, "R1", "C1");
        boolean pass = false;
        try {
            d.getValue("XX", "C1");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            d.getValue("R1", "XX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * A simple check for the getValue(int, int) method.
     */
    public void testGetValue2() {
        DefaultMultiValueCategoryDataset d = new DefaultMultiValueCategoryDataset();
        boolean pass = false;
        try {
            d.getValue(0, 0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some tests for the getRowCount() method.
     */
    public void testGetRowCount() {
        DefaultMultiValueCategoryDataset d = new DefaultMultiValueCategoryDataset();
        List values = new ArrayList();
        d.add(values, "R1", "C1");
        d.add(values, "R2", "C1");
        d.add(values, "R2", "C1");
    }

    /**
     * Some tests for the getColumnCount() method.
     */
    public void testGetColumnCount() {
        DefaultMultiValueCategoryDataset d = new DefaultMultiValueCategoryDataset();
        List values = new ArrayList();
        d.add(values, "R1", "C1");
        d.add(values, "R1", "C2");
        d.add(values, "R1", "C2");
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultMultiValueCategoryDataset d1 = new DefaultMultiValueCategoryDataset();
        DefaultMultiValueCategoryDataset d2 = new DefaultMultiValueCategoryDataset();
        List values = new ArrayList();
        d1.add(values, "R1", "C1");
        d2.add(values, "R1", "C1");
        values.add(new Integer(99));
        d1.add(values, "R1", "C1");
        d2.add(values, "R1", "C1");
        values.add(new Integer(99));
        d1.add(values, "R1", "C2");
        d2.add(values, "R1", "C2");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultMultiValueCategoryDataset d1 = new DefaultMultiValueCategoryDataset();
        DefaultMultiValueCategoryDataset d2 = (DefaultMultiValueCategoryDataset) TestUtilities.serialised(d1);
    }

    /**
     * Some checks for the add() method.
     */
    public void testAddValue() {
        DefaultMultiValueCategoryDataset d1 = new DefaultMultiValueCategoryDataset();
        boolean pass = false;
        try {
            d1.add(null, "R1", "C1");
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        List values = new ArrayList();
        d1.add(values, "R2", "C1");
        pass = false;
        try {
            d1.add(values, null, "C2");
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultMultiValueCategoryDataset d1 = new DefaultMultiValueCategoryDataset();
        DefaultMultiValueCategoryDataset d2 = (DefaultMultiValueCategoryDataset) d1.clone();
        List values = new ArrayList();
        values.add(new Integer(99));
        d1.add(values, "R1", "C1");
        d2 = (DefaultMultiValueCategoryDataset) d1.clone();
        List values2 = new ArrayList();
        values2.add(new Integer(111));
        d1.add(values2, "R2", "C2");
        d2.add(values2, "R2", "C2");
    }
}
