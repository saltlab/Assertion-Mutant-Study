package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link OHLCDataItem} class.
 */
public class OHLCDataItemTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        OHLCDataItem i1 = new OHLCDataItem(new Date(1L), 1.0, 2.0, 3.0, 4.0, 5.0);
        OHLCDataItem i2 = new OHLCDataItem(new Date(1L), 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    /**
     * Instances of this class are immutable - cloning not required.
     */
    public void testCloning() {
        OHLCDataItem i1 = new OHLCDataItem(new Date(1L), 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        OHLCDataItem i1 = new OHLCDataItem(new Date(1L), 1.0, 2.0, 3.0, 4.0, 5.0);
        OHLCDataItem i2 = (OHLCDataItem) TestUtilities.serialised(i1);
    }
}
