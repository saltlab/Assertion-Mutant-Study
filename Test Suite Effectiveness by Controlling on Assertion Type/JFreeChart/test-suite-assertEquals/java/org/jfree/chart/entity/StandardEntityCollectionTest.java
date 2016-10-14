package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

/**
 * Tests for the {@link StandardEntityCollection} class.
 */
public class StandardEntityCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardEntityCollection c1 = new StandardEntityCollection();
        StandardEntityCollection c2 = new StandardEntityCollection();
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 0, 1, "Key", "ToolTip", "URL");
        c1.add(e1);
        PieSectionEntity e2 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 0, 1, "Key", "ToolTip", "URL");
        c2.add(e2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 0, 1, "Key", "ToolTip", "URL");
        StandardEntityCollection c1 = new StandardEntityCollection();
        c1.add(e1);
        StandardEntityCollection c2 = (StandardEntityCollection) c1.clone();
        c1.clear();
        c2.clear();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PieSectionEntity e1 = new PieSectionEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new DefaultPieDataset(), 0, 1, "Key", "ToolTip", "URL");
        StandardEntityCollection c1 = new StandardEntityCollection();
        c1.add(e1);
        StandardEntityCollection c2 = (StandardEntityCollection) TestUtilities.serialised(c1);
    }
}
