package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link BlockContainer} class.
 */
public class BlockContainerTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        BlockContainer c1 = new BlockContainer(new FlowArrangement());
        BlockContainer c2 = new BlockContainer(new FlowArrangement());
        c1.setArrangement(new ColumnArrangement());
        c2.setArrangement(new ColumnArrangement());
        c1.add(new EmptyBlock(1.2, 3.4));
        c2.add(new EmptyBlock(1.2, 3.4));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BlockContainer c1 = new BlockContainer(new FlowArrangement());
        c1.add(new EmptyBlock(1.2, 3.4));
        BlockContainer c2 = (BlockContainer) c1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BlockContainer c1 = new BlockContainer();
        c1.add(new EmptyBlock(1.2, 3.4));
        BlockContainer c2 = (BlockContainer) TestUtilities.serialised(c1);
    }
}
