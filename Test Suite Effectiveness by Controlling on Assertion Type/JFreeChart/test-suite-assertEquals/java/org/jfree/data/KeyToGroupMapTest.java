package org.jfree.data;

import org.jfree.chart.TestUtilities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests for the {@link KeyToGroupMap} class.
 */
public class KeyToGroupMapTest {

    /**
     * Tests the mapKeyToGroup() method.
     */
    public void testMapKeyToGroup() {
        KeyToGroupMap m1 = new KeyToGroupMap("G1");
        m1.mapKeyToGroup("K1", "G1");
        m1.mapKeyToGroup("K2", "G2");
        m1.mapKeyToGroup("K2", null);
        boolean pass = false;
        try {
            m1.mapKeyToGroup(null, "G1");
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Tests that the getGroupCount() method returns the correct values under
     * various circumstances.
     */
    public void testGroupCount() {
        KeyToGroupMap m1 = new KeyToGroupMap("Default Group");
        m1.mapKeyToGroup("C1", "G1");
        m1.mapKeyToGroup("C2", "Default Group");
        m1.mapKeyToGroup("C3", "Default Group");
        m1.mapKeyToGroup("C4", "G2");
        m1.mapKeyToGroup("C5", "G2");
        m1.mapKeyToGroup("C6", "Default Group");
        m1.mapKeyToGroup("C4", "G1");
        m1.mapKeyToGroup("C5", "G1");
    }

    /**
     * Tests that the getKeyCount() method returns the correct values under
     * various circumstances.
     */
    public void testKeyCount() {
        KeyToGroupMap m1 = new KeyToGroupMap("Default Group");
        m1.mapKeyToGroup("K1", "G1");
        m1.mapKeyToGroup("K1", null);
        m1.mapKeyToGroup("K2", "Default Group");
        m1.mapKeyToGroup("K3", "Default Group");
        m1.mapKeyToGroup("K4", "G2");
        m1.mapKeyToGroup("K5", "G2");
        m1.mapKeyToGroup("K6", "Default Group");
        m1.mapKeyToGroup("K4", "G1");
        m1.mapKeyToGroup("K5", "G1");
    }

    /**
     * Tests the getGroupIndex() method.
     */
    public void testGetGroupIndex() {
        KeyToGroupMap m1 = new KeyToGroupMap("Default Group");
        m1.mapKeyToGroup("K3", "G3");
        m1.mapKeyToGroup("K1", "G1");
        m1.mapKeyToGroup("K2", "G2");
    }

    /**
     * Tests the getGroup() method.
     */
    public void testGetGroup() {
        KeyToGroupMap m1 = new KeyToGroupMap("Default Group");
        m1.mapKeyToGroup("K1", "G1");
        m1.mapKeyToGroup("K1", "G2");
        m1.mapKeyToGroup("K1", null);
        boolean pass = false;
        try {
            Comparable g = m1.getGroup(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        KeyToGroupMap m1 = new KeyToGroupMap("Default Group");
        KeyToGroupMap m2 = new KeyToGroupMap("Default Group");
        m1.mapKeyToGroup("K1", "G1");
        m2.mapKeyToGroup("K1", "G1");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        KeyToGroupMap m1 = new KeyToGroupMap("Test");
        m1.mapKeyToGroup("K1", "G1");
        KeyToGroupMap m2 = (KeyToGroupMap) m1.clone();
        m1.mapKeyToGroup("K1", "G2");
        m2.mapKeyToGroup("K1", "G2");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        KeyToGroupMap m1 = new KeyToGroupMap("Test");
        KeyToGroupMap m2 = (KeyToGroupMap) TestUtilities.serialised(m1);
    }
}
