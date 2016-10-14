package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

/**
 * Tests for the {@link LegendItemEntity} class.
 */
public class LegendItemEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        LegendItemEntity e1 = new LegendItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        LegendItemEntity e2 = new LegendItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
        e1.setDataset(new DefaultCategoryDataset());
        e2.setDataset(new DefaultCategoryDataset());
        e1.setSeriesKey("A");
        e2.setSeriesKey("A");
        e1.setSeriesIndex(7);
        e2.setSeriesIndex(7);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LegendItemEntity e1 = new LegendItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        LegendItemEntity e2 = (LegendItemEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LegendItemEntity e1 = new LegendItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        LegendItemEntity e2 = (LegendItemEntity) TestUtilities.serialised(e1);
    }
}
