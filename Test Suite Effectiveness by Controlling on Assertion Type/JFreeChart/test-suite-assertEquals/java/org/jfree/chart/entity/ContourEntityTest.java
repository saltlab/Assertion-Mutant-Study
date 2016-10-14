package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@code ContourEntity} class.
 */
public class ContourEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ContourEntity e1 = new ContourEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        ContourEntity e2 = new ContourEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
        e1.setIndex(99);
        e2.setIndex(99);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ContourEntity e1 = new ContourEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        ContourEntity e2 = (ContourEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ContourEntity e1 = new ContourEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        ContourEntity e2 = (ContourEntity) TestUtilities.serialised(e1);
    }
}
