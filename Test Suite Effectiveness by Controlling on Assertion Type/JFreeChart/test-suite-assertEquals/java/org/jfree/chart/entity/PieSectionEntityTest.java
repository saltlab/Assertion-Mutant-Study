package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

/**
 * Tests for the {@link PieSectionEntity} class.
 */
public class PieSectionEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 1, 2, "Key", "ToolTip", "URL");
        PieSectionEntity e2 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 1, 2, "Key", "ToolTip", "URL");
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
        e1.setDataset(null);
        e2.setDataset(null);
        e1.setPieIndex(99);
        e2.setPieIndex(99);
        e1.setSectionIndex(66);
        e2.setSectionIndex(66);
        e1.setSectionKey("ABC");
        e2.setSectionKey("ABC");
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 1, 2, "Key", "ToolTip", "URL");
        PieSectionEntity e2 = (PieSectionEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 1, 2, "Key", "ToolTip", "URL");
        PieSectionEntity e2 = (PieSectionEntity) TestUtilities.serialised(e1);
    }
}
