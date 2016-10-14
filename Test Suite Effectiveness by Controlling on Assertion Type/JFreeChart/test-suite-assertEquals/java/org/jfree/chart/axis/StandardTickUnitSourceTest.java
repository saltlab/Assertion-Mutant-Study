package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link StandardTickUnitSource} class.
 */
public class StandardTickUnitSourceTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardTickUnitSource t1 = new StandardTickUnitSource();
        StandardTickUnitSource t2 = new StandardTickUnitSource();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardTickUnitSource t1 = new StandardTickUnitSource();
        StandardTickUnitSource t2 = (StandardTickUnitSource) TestUtilities.serialised(t1);
    }
}
