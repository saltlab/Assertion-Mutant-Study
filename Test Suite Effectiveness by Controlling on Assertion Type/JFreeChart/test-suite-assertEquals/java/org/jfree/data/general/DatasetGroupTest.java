package org.jfree.data.general;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link DatasetGroup} class.
 */
public class DatasetGroupTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DatasetGroup g1 = new DatasetGroup();
        DatasetGroup g2 = (DatasetGroup) TestUtilities.serialised(g1);
    }
}
