package org.jfree.chart;

import org.junit.Test;
import java.awt.Color;
import java.awt.GradientPaint;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Some tests for the {@link PaintMap} class.
 */
public class PaintMapTest {

    /**
     * Some checks for the getPaint() method.
     */
    public void testGetPaint() {
        PaintMap m1 = new PaintMap();
        m1.put("A", Color.red);
        m1.put("A", null);
        try {
            m1.getPaint(null);
            fail("IllegalArgumentException should have been thrown on passing null value");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'key' argument.", e.getMessage());
        }
    }

    /**
     * Some checks for the put() method.
     */
    public void testPut() {
        PaintMap m1 = new PaintMap();
        m1.put("A", Color.red);
        try {
            m1.put(null, Color.blue);
            fail("IllegalArgumentException should have been thrown on null key");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'key' argument.", e.getMessage());
        }
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        PaintMap m1 = new PaintMap();
        PaintMap m2 = new PaintMap();
        m1.put("K1", Color.red);
        m2.put("K1", Color.red);
        m1.put("K2", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        m2.put("K2", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        m1.put("K2", null);
        m2.put("K2", null);
    }

    /**
     * Some checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        PaintMap m1 = new PaintMap();
        PaintMap m2 = (PaintMap) m1.clone();
        m1.put("K1", Color.red);
        m1.put("K2", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        m2 = (PaintMap) m1.clone();
    }

    /**
     * A check for serialization.
     */
    public void testSerialization1() {
        PaintMap m1 = new PaintMap();
        PaintMap m2 = (PaintMap) TestUtilities.serialised(m1);
    }

    /**
     * A check for serialization.
     */
    public void testSerialization2() {
        PaintMap m1 = new PaintMap();
        m1.put("K1", Color.red);
        m1.put("K2", new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        PaintMap m2 = (PaintMap) TestUtilities.serialised(m1);
    }

    /**
     * This test covers a bug reported in the forum:
     *
     * http://www.jfree.org/phpBB2/viewtopic.php?t=19980
     */
    public void testKeysOfDifferentClasses() {
        PaintMap m = new PaintMap();
        m.put("ABC", Color.red);
        m.put(new Integer(99), Color.blue);
    }
}
