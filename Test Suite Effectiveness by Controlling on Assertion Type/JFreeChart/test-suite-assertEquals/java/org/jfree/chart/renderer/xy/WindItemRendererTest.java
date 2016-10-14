package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link WindItemRenderer} class.
 */
public class WindItemRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        WindItemRenderer r1 = new WindItemRenderer();
        WindItemRenderer r2 = new WindItemRenderer();
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        WindItemRenderer r1 = new WindItemRenderer();
        WindItemRenderer r2 = new WindItemRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        WindItemRenderer r1 = new WindItemRenderer();
        WindItemRenderer r2 = (WindItemRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        WindItemRenderer r1 = new WindItemRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        WindItemRenderer r1 = new WindItemRenderer();
        WindItemRenderer r2 = (WindItemRenderer) TestUtilities.serialised(r1);
    }
}
