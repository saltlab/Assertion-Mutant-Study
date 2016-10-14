package org.jfree.data;

import java.util.ArrayList;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests for the {@link KeyedObject} class.
 */
public class KeyedObjectTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        KeyedObject ko1 = new KeyedObject("Test", "Object");
        KeyedObject ko2 = new KeyedObject("Test", "Object");
        ko1 = new KeyedObject("Test 1", "Object");
        ko2 = new KeyedObject("Test 2", "Object");
        ko1 = new KeyedObject("Test", "Object 1");
        ko2 = new KeyedObject("Test", "Object 2");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        KeyedObject ko1 = new KeyedObject("Test", "Object");
        KeyedObject ko2 = (KeyedObject) ko1.clone();
    }

    /**
     * Confirm special features of cloning.
     */
    public void testCloning2() throws CloneNotSupportedException {
        Object obj1 = new ArrayList();
        KeyedObject ko1 = new KeyedObject("Test", obj1);
        KeyedObject ko2 = (KeyedObject) ko1.clone();
        obj1 = new DefaultPieDataset();
        ko1 = new KeyedObject("Test", obj1);
        ko2 = (KeyedObject) ko1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        KeyedObject ko1 = new KeyedObject("Test", "Object");
        KeyedObject ko2 = (KeyedObject) TestUtilities.serialised(ko1);
    }
}
