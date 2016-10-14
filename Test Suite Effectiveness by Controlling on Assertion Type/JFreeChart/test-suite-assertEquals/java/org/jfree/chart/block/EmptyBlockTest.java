package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link EmptyBlock} class.
 */
public class EmptyBlockTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = new EmptyBlock(1.0, 2.0);
        b1 = new EmptyBlock(1.1, 2.0);
        b2 = new EmptyBlock(1.1, 2.0);
        b1 = new EmptyBlock(1.1, 2.2);
        b2 = new EmptyBlock(1.1, 2.2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = null;
        try {
            b2 = (EmptyBlock) b1.clone();
        } catch (CloneNotSupportedException e) {
            fail(e.toString());
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = (EmptyBlock) TestUtilities.serialised(b1);
    }
}
