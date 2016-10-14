package org.jfree.data.statistics;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link BoxAndWhiskerItem} class.
 */
public class BoxAndWhiskerItemTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        BoxAndWhiskerItem i1 = new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList());
        BoxAndWhiskerItem i2 = new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList());
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BoxAndWhiskerItem i1 = new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList());
        BoxAndWhiskerItem i2 = (BoxAndWhiskerItem) TestUtilities.serialised(i1);
    }
}
