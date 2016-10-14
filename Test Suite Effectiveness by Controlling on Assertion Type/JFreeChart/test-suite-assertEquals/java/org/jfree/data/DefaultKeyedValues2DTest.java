package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DefaultKeyedValues2D} class.
 */
public class DefaultKeyedValues2DTest {

    /**
     * Some checks for the getValue() method.
     */
    public void testGetValue() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Double(1.0), "R1", "C1");
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
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValues2D v1 = new DefaultKeyedValues2D();
        v1.setValue(new Integer(1), "V1", "C1");
        v1.setValue(null, "V2", "C1");
        v1.setValue(new Integer(3), "V3", "C2");
        DefaultKeyedValues2D v2 = (DefaultKeyedValues2D) v1.clone();
        v2.setValue(new Integer(2), "V2", "C1");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValues2D kv2D1 = new DefaultKeyedValues2D();
        kv2D1.addValue(new Double(234.2), "Row1", "Col1");
        kv2D1.addValue(null, "Row1", "Col2");
        kv2D1.addValue(new Double(345.9), "Row2", "Col1");
        kv2D1.addValue(new Double(452.7), "Row2", "Col2");
        DefaultKeyedValues2D kv2D2 = (DefaultKeyedValues2D) TestUtilities.serialised(kv2D1);
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        DefaultKeyedValues2D d1 = new DefaultKeyedValues2D();
        DefaultKeyedValues2D d2 = new DefaultKeyedValues2D();
        d1.addValue(new Double(1.0), new Double(2.0), "S1");
        d2.addValue(new Double(1.0), new Double(2.0), "S1");
    }

    /**
     * Populates a data structure with sparse entries, then checks that
     * the unspecified entries return null.
     */
    public void testSparsePopulation() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Integer(11), "R1", "C1");
        d.addValue(new Integer(22), "R2", "C2");
    }

    /**
     * Some basic checks for the getRowCount() method.
     */
    public void testRowCount() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R2", "C1");
    }

    /**
     * Some basic checks for the getColumnCount() method.
     */
    public void testColumnCount() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R1", "C2");
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some basic checks for the getValue(int, int) method.
     */
    public void testGetValue2() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        boolean pass = false;
        try {
            d.getValue(0, 0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R2", "C2");
        pass = false;
        try {
            d.getValue(2, 0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some basic checks for the getRowKey() method.
     */
    public void testGetRowKey() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        boolean pass = false;
        try {
            d.getRowKey(0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(1.0), "R2", "C1");
        d = new DefaultKeyedValues2D(true);
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(0.0), "R0", "C1");
    }

    /**
     * Some basic checks for the getColumnKey() method.
     */
    public void testGetColumnKey() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        boolean pass = false;
        try {
            d.getColumnKey(0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(1.0), "R1", "C2");
    }

    /**
     * Some basic checks for the removeValue() method.
     */
    public void testRemoveValue() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.removeValue("R1", "C1");
        d.addValue(new Double(1.0), "R1", "C1");
        d.removeValue("R1", "C1");
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R2", "C1");
        d.removeValue("R1", "C1");
    }

    /**
     * A test for bug 1690654.
     */
    public void testRemoveValueBug1690654() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R2", "C2");
        d.removeValue("R2", "C2");
    }

    /**
     * Some basic checks for the removeRow() method.
     */
    public void testRemoveRow() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        boolean pass = false;
        try {
            d.removeRow(0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some basic checks for the removeColumn(Comparable) method.
     */
    public void testRemoveColumnByKey() {
        DefaultKeyedValues2D d = new DefaultKeyedValues2D();
        d.addValue(new Double(1.0), "R1", "C1");
        d.addValue(new Double(2.0), "R2", "C2");
        d.removeColumn("C2");
        d.addValue(new Double(3.0), "R2", "C2");
        boolean pass = false;
        try {
            d.removeColumn("XXX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }
}
