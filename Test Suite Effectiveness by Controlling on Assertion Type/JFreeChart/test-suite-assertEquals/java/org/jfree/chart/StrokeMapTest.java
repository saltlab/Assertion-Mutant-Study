package org.jfree.chart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import org.junit.Test;

/**
 * Some tests for the {@link StrokeMap} class.
 */
public class StrokeMapTest {

    /**
     * Some checks for the getStroke() method.
     */
    public void testGetStroke() {
        StrokeMap m1 = new StrokeMap();
        m1.put("A", new BasicStroke(1.1f));
        m1.put("A", null);
        boolean pass = false;
        try {
            m1.getStroke(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the put() method.
     */
    public void testPut() {
        StrokeMap m1 = new StrokeMap();
        m1.put("A", new BasicStroke(1.1f));
        boolean pass = false;
        try {
            m1.put(null, new BasicStroke(1.1f));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        StrokeMap m1 = new StrokeMap();
        StrokeMap m2 = new StrokeMap();
        m1.put("K1", new BasicStroke(1.1f));
        m2.put("K1", new BasicStroke(1.1f));
        m1.put("K2", new BasicStroke(2.2f));
        m2.put("K2", new BasicStroke(2.2f));
        m1.put("K2", null);
        m2.put("K2", null);
    }

    /**
     * Some checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        StrokeMap m1 = new StrokeMap();
        StrokeMap m2 = (StrokeMap) m1.clone();
        m1.put("K1", new BasicStroke(1.1f));
        m1.put("K2", new BasicStroke(2.2f));
        m2 = (StrokeMap) m1.clone();
    }

    /**
     * A check for serialization.
     */
    public void testSerialization1() {
        StrokeMap m1 = new StrokeMap();
        StrokeMap m2 = (StrokeMap) TestUtilities.serialised(m1);
    }

    /**
     * A check for serialization.
     */
    public void testSerialization2() {
        StrokeMap m1 = new StrokeMap();
        m1.put("K1", new BasicStroke(1.1f));
        m1.put("K2", new BasicStroke(2.2f));
        StrokeMap m2 = (StrokeMap) TestUtilities.serialised(m1);
    }
}
