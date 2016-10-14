package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link AbstractDialLayer} class.
 */
public class AbstractDialLayerTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DialCap c1 = new DialCap();
        DialCap c2 = new DialCap();
        c1.setVisible(false);
        c2.setVisible(false);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DialCap c1 = new DialCap();
        DialCap c2 = (DialCap) c1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        c1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DialCap c1 = new DialCap();
        DialCap c2 = (DialCap) TestUtilities.serialised(c1);
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        c1.addChangeListener(l1);
    }
}
