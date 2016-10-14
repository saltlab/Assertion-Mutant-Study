package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

/**
 * Tests for the {@link KeyedObjects} class.
 */
public class KeyedObjectsTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("V1", new Integer(1));
        ko1.addObject("V2", null);
        ko1.addObject("V3", new Integer(3));
        KeyedObjects ko2 = (KeyedObjects) ko1.clone();
    }

    /**
     * Confirm special features of cloning.
     */
    public void testCloning2() throws CloneNotSupportedException {
        Object obj1 = new ArrayList();
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("K1", obj1);
        KeyedObjects ko2 = (KeyedObjects) ko1.clone();
        obj1 = new DefaultPieDataset();
        ko1 = new KeyedObjects();
        ko1.addObject("K1", obj1);
        ko2 = (KeyedObjects) ko1.clone();
    }

    /**
     * Check that inserting and retrieving values works as expected.
     */
    public void testInsertAndRetrieve() {
        KeyedObjects data = new KeyedObjects();
        data.addObject("A", new Double(1.0));
        data.addObject("B", new Double(2.0));
        data.addObject("C", new Double(3.0));
        data.addObject("D", null);
        boolean pass = false;
        try {
            data.getObject("Not a key");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("Key 1", "Object 1");
        ko1.addObject("Key 2", null);
        ko1.addObject("Key 3", "Object 2");
        KeyedObjects ko2 = (KeyedObjects) TestUtilities.serialised(ko1);
    }

    /**
     * Simple checks for the getObject(int) method.
     */
    public void testGetObject() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("Key 1", "Object 1");
        ko1.addObject("Key 2", null);
        ko1.addObject("Key 3", "Object 2");
        boolean pass = false;
        try {
            ko1.getObject(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            ko1.getObject(3);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Simple checks for the getKey(int) method.
     */
    public void testGetKey() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("Key 1", "Object 1");
        ko1.addObject("Key 2", null);
        ko1.addObject("Key 3", "Object 2");
        boolean pass = false;
        try {
            ko1.getKey(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            ko1.getKey(3);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }

    /**
     * Simple checks for the getIndex(Comparable) method.
     */
    public void testGetIndex() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.addObject("Key 1", "Object 1");
        ko1.addObject("Key 2", null);
        ko1.addObject("Key 3", "Object 2");
        boolean pass = false;
        try {
            ko1.getIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the setObject(Comparable, Object) method.
     */
    public void testSetObject() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.setObject("Key 1", "Object 1");
        ko1.setObject("Key 2", null);
        ko1.setObject("Key 3", "Object 2");
        ko1.setObject("Key 2", "AAA");
        ko1.setObject("Key 3", "BBB");
        boolean pass = false;
        try {
            ko1.setObject(null, "XX");
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeValue() methods.
     */
    public void testRemoveValue() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.setObject("Key 1", "Object 1");
        ko1.setObject("Key 2", null);
        ko1.setObject("Key 3", "Object 2");
        ko1.removeValue(1);
        ko1.removeValue("Key 1");
        boolean pass = false;
        try {
            ko1.removeValue("UNKNOWN");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            ko1.removeValue(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the removeValue(int) method.
     */
    public void testRemoveValueInt() {
        KeyedObjects ko1 = new KeyedObjects();
        ko1.setObject("Key 1", "Object 1");
        ko1.setObject("Key 2", null);
        ko1.setObject("Key 3", "Object 2");
        ko1.removeValue(1);
        boolean pass = false;
        try {
            ko1.removeValue(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        pass = false;
        try {
            ko1.removeValue(2);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
    }
}
