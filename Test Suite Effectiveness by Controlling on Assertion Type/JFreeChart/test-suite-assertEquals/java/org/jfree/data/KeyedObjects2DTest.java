package org.jfree.data;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

/**
 * Tests for the {@link KeyedObjects2D} class.
 */
public class KeyedObjects2DTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        KeyedObjects2D k1 = new KeyedObjects2D();
        KeyedObjects2D k2 = new KeyedObjects2D();
        k1.addObject(new Integer(99), "R1", "C1");
        k2.addObject(new Integer(99), "R1", "C1");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        KeyedObjects2D o1 = new KeyedObjects2D();
        o1.setObject(new Integer(1), "V1", "C1");
        o1.setObject(null, "V2", "C1");
        o1.setObject(new Integer(3), "V3", "C2");
        KeyedObjects2D o2 = (KeyedObjects2D) o1.clone();
        o1.addObject("XX", "R1", "C1");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        KeyedObjects2D ko2D1 = new KeyedObjects2D();
        ko2D1.addObject(new Double(234.2), "Row1", "Col1");
        ko2D1.addObject(null, "Row1", "Col2");
        ko2D1.addObject(new Double(345.9), "Row2", "Col1");
        ko2D1.addObject(new Double(452.7), "Row2", "Col2");
        KeyedObjects2D ko2D2 = (KeyedObjects2D) TestUtilities.serialised(ko2D1);
    }

    /**
     * Some checks for the getValue(int, int) method.
     */
    public void testGetValueByIndex() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.addObject("Obj1", "R1", "C1");
        data.addObject("Obj2", "R2", "C2");
        boolean pass = false;
        try {
            data.getObject(-1, 0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject(0, -1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject(2, 0);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject(0, 2);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getValue(Comparable, Comparable) method.
     */
    public void testGetValueByKey() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.addObject("Obj1", "R1", "C1");
        data.addObject("Obj2", "R2", "C2");
        boolean pass = false;
        try {
            data.getObject("XX", "C1");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject("R1", "XX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject("XX", "C1");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            data.getObject("R1", "XX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the setObject(Object, Comparable, Comparable) method.
     */
    public void testSetObject() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.setObject("ABC", "R2", "C2");
        boolean pass = false;
        try {
            data.setObject("X", null, "C1");
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            data.setObject("X", "R1", null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeRow(int) method.
     */
    public void testRemoveRowByIndex() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.removeRow(0);
        boolean pass = false;
        try {
            data.removeRow(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            data.removeRow(data.getRowCount());
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeColumn(int) method.
     */
    public void testRemoveColumnByIndex() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.removeColumn(0);
        boolean pass = false;
        try {
            data.removeColumn(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            data.removeColumn(data.getColumnCount());
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeRow(Comparable) method.
     */
    public void testRemoveRowByKey() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.removeRow("R2");
        boolean pass = false;
        try {
            data.removeRow("XXX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            data.removeRow(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeColumn(Comparable) method.
     */
    public void testRemoveColumnByKey() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.removeColumn("C2");
        boolean pass = false;
        try {
            data.removeColumn("XXX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            data.removeColumn(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * A simple check for the removeValue() method.
     */
    public void testRemoveValue() {
        KeyedObjects2D data = new KeyedObjects2D();
        data.setObject("Obj1", "R1", "C1");
        data.setObject("Obj2", "R2", "C2");
        data.removeObject("R2", "C2");
    }
}
