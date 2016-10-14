package org.jfree.data.category;

import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.TableOrder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Tests for the {@link CategoryToPieDataset} class.
 */
public class CategoryToPieDatasetTest {

    /**
     * Some tests for the constructor.
     */
    public void testConstructor() {
        CategoryToPieDataset p1 = new CategoryToPieDataset(null, TableOrder.BY_COLUMN, 0);
    }

    /**
     * Some checks for the getValue() method.
     */
    public void testGetValue() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.1, "R1", "C1");
        underlying.addValue(2.2, "R1", "C2");
        CategoryToPieDataset d1 = new CategoryToPieDataset(underlying, TableOrder.BY_ROW, 0);
        try {
            d1.getValue(-1);
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            d1.getValue(d1.getItemCount());
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
        CategoryToPieDataset p1 = new CategoryToPieDataset(null, TableOrder.BY_COLUMN, 0);
        try {
            p1.getValue(0);
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Some checks for the getKey(int) method.
     */
    public void testGetKey() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.1, "R1", "C1");
        underlying.addValue(2.2, "R1", "C2");
        CategoryToPieDataset d1 = new CategoryToPieDataset(underlying, TableOrder.BY_ROW, 0);
        try {
            d1.getKey(-1);
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            d1.getKey(d1.getItemCount());
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
        CategoryToPieDataset p1 = new CategoryToPieDataset(null, TableOrder.BY_COLUMN, 0);
        try {
            p1.getKey(0);
            fail("Expected IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Some checks for the getIndex() method.
     */
    public void testGetIndex() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.1, "R1", "C1");
        underlying.addValue(2.2, "R1", "C2");
        CategoryToPieDataset d1 = new CategoryToPieDataset(underlying, TableOrder.BY_ROW, 0);
        boolean pass = false;
        try {
            d1.getIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * For datasets, the equals() method just checks keys and values.
     */
    public void testEquals() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.1, "R1", "C1");
        underlying.addValue(2.2, "R1", "C2");
        CategoryToPieDataset d1 = new CategoryToPieDataset(underlying, TableOrder.BY_COLUMN, 1);
        DefaultPieDataset d2 = new DefaultPieDataset();
        d2.setValue("R1", 2.2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultCategoryDataset underlying = new DefaultCategoryDataset();
        underlying.addValue(1.1, "R1", "C1");
        underlying.addValue(2.2, "R1", "C2");
        CategoryToPieDataset d1 = new CategoryToPieDataset(underlying, TableOrder.BY_COLUMN, 1);
        CategoryToPieDataset d2 = (CategoryToPieDataset) TestUtilities.serialised(d1);
    }
}
