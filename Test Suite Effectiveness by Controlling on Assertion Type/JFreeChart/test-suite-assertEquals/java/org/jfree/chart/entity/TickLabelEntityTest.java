package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link TickLabelEntity} class.
 */
public class TickLabelEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        TickLabelEntity e1 = new TickLabelEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        TickLabelEntity e2 = new TickLabelEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        TickLabelEntity e1 = new TickLabelEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        TickLabelEntity e2 = (TickLabelEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TickLabelEntity e1 = new TickLabelEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL");
        TickLabelEntity e2 = (TickLabelEntity) TestUtilities.serialised(e1);
    }
}
