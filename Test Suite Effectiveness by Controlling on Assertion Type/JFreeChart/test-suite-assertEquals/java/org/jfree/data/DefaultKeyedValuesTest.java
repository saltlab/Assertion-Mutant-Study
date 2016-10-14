package org.jfree.data;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.jfree.chart.TestUtilities;
import org.jfree.util.SortOrder;
import org.junit.Test;

/**
 * Tests for the {@link DefaultKeyedValues} class.
 */
public class DefaultKeyedValuesTest {

    /**
     * Checks that a new instance is empty.
     */
    public void testConstructor() {
        DefaultKeyedValues d = new DefaultKeyedValues();
    }

    /**
     * Some checks for the getItemCount() method.
     */
    public void testGetItemCount() {
        DefaultKeyedValues d = new DefaultKeyedValues();
        d.addValue("A", 1.0);
        d.addValue("B", 2.0);
        d.clear();
    }

    /**
     * Some checks for the getKeys() method.
     */
    public void testGetKeys() {
        DefaultKeyedValues d = new DefaultKeyedValues();
        List keys = d.getKeys();
        d.addValue("A", 1.0);
        keys = d.getKeys();
        d.addValue("B", 2.0);
        keys = d.getKeys();
        d.clear();
        keys = d.getKeys();
    }

    /**
     * A simple test for the clear() method.
     */
    public void testClear() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        v1.addValue("A", 1.0);
        v1.addValue("B", 2.0);
        v1.clear();
    }

    /**
     * Some checks for the getValue() methods.
     */
    public void testGetValue() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        try {
            v1.getValue(-1);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            v1.getValue(0);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        DefaultKeyedValues v2 = new DefaultKeyedValues();
        v2.addValue("K1", new Integer(1));
        v2.addValue("K2", new Integer(2));
        v2.addValue("K3", new Integer(3));
        boolean pass = false;
        try {
            v2.getValue("KK");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getKey() methods.
     */
    public void testGetKey() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        try {
            v1.getKey(-1);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            v1.getKey(0);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        DefaultKeyedValues v2 = new DefaultKeyedValues();
        v2.addValue("K1", new Integer(1));
        v2.addValue("K2", new Integer(2));
        v2.addValue("K3", new Integer(3));
    }

    /**
     * Some checks for the getIndex() methods.
     */
    public void testGetIndex() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        DefaultKeyedValues v2 = new DefaultKeyedValues();
        v2.addValue("K1", new Integer(1));
        v2.addValue("K2", new Integer(2));
        v2.addValue("K3", new Integer(3));
        boolean pass = false;
        try {
            v2.getIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Another check for the getIndex(Comparable) method.
     */
    public void testGetIndex2() {
        DefaultKeyedValues v = new DefaultKeyedValues();
        v.addValue("K1", 1.0);
        v.removeValue("K1");
    }

    /**
     * Some checks for the addValue() method.
     */
    public void testAddValue() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        v1.addValue("A", 1.0);
        v1.addValue("B", 2.0);
        v1.addValue("B", 3.0);
        v1.addValue("A", null);
        boolean pass = false;
        try {
            v1.addValue(null, 99.9);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the insertValue() method.
     */
    public void testInsertValue() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        v1.insertValue(0, "A", 1.0);
        v1.insertValue(0, "B", 2.0);
        v1.insertValue(2, "C", 3.0);
        v1.insertValue(2, "B", 4.0);
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        v1.addValue("V1", new Integer(1));
        v1.addValue("V2", null);
        v1.addValue("V3", new Integer(3));
        DefaultKeyedValues v2 = (DefaultKeyedValues) v1.clone();
        v2.setValue("V1", new Integer(44));
    }

    /**
     * Check that inserting and retrieving values works as expected.
     */
    public void testInsertAndRetrieve() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", new Double(1.0));
        data.addValue("B", new Double(2.0));
        data.addValue("C", new Double(3.0));
        data.addValue("D", null);
    }

    /**
     * Some tests for the removeValue() method.
     */
    public void testRemoveValue() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", new Double(1.0));
        data.addValue("B", null);
        data.addValue("C", new Double(3.0));
        data.addValue("D", new Double(2.0));
        data.removeValue("B");
        boolean pass = false;
        try {
            data.removeValue("XXX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Tests sorting of data by key (ascending).
     */
    public void testSortByKeyAscending() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("C", new Double(1.0));
        data.addValue("B", null);
        data.addValue("D", new Double(3.0));
        data.addValue("A", new Double(2.0));
        data.sortByKeys(SortOrder.ASCENDING);
    }

    /**
     * Tests sorting of data by key (descending).
     */
    public void testSortByKeyDescending() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("C", new Double(1.0));
        data.addValue("B", null);
        data.addValue("D", new Double(3.0));
        data.addValue("A", new Double(2.0));
        data.sortByKeys(SortOrder.DESCENDING);
    }

    /**
     * Tests sorting of data by value (ascending).
     */
    public void testSortByValueAscending() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("C", new Double(1.0));
        data.addValue("B", null);
        data.addValue("D", new Double(3.0));
        data.addValue("A", new Double(2.0));
        data.sortByValues(SortOrder.ASCENDING);
    }

    /**
     * Tests sorting of data by key (descending).
     */
    public void testSortByValueDescending() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("C", new Double(1.0));
        data.addValue("B", null);
        data.addValue("D", new Double(3.0));
        data.addValue("A", new Double(2.0));
        data.sortByValues(SortOrder.DESCENDING);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValues v1 = new DefaultKeyedValues();
        v1.addValue("Key 1", new Double(23));
        v1.addValue("Key 2", null);
        v1.addValue("Key 3", new Double(42));
        DefaultKeyedValues v2 = (DefaultKeyedValues) TestUtilities.serialised(v1);
    }
}
