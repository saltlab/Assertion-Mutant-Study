package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardXYURLGenerator} class.
 */
public class StandardXYURLGeneratorTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardXYURLGenerator g1 = new StandardXYURLGenerator("index.html?");
        StandardXYURLGenerator g2 = (StandardXYURLGenerator) TestUtilities.serialised(g1);
    }

    /**
     * Checks that the class does not implement PublicCloneable (the generator
     * is immutable).
     */
    public void testPublicCloneable() {
        StandardXYURLGenerator g1 = new StandardXYURLGenerator("index.html?");
    }
}
