package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

/**
 * Tests for the {@link CategoryItemEntity} class.
 */
public class CategoryItemEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(1.0, "R1", "C1");
        d.addValue(2.0, "R1", "C2");
        d.addValue(3.0, "R2", "C1");
        d.addValue(4.0, "R2", "C2");
        CategoryItemEntity e1 = new CategoryItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL", d, 1, "C2", 1);
        CategoryItemEntity e2 = new CategoryItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL", d, 1, "C2", 1);
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
        e1.setCategory("C1");
        e2.setCategory("C1");
        e1.setCategoryIndex(0);
        e2.setCategoryIndex(0);
        e1.setSeries(0);
        e2.setSeries(0);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(1.0, "R1", "C1");
        d.addValue(2.0, "R1", "C2");
        d.addValue(3.0, "R2", "C1");
        d.addValue(4.0, "R2", "C2");
        CategoryItemEntity e1 = new CategoryItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL", d, 1, "C2", 1);
        CategoryItemEntity e2 = (CategoryItemEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(1.0, "R1", "C1");
        d.addValue(2.0, "R1", "C2");
        d.addValue(3.0, "R2", "C1");
        d.addValue(4.0, "R2", "C2");
        CategoryItemEntity e1 = new CategoryItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), "ToolTip", "URL", d, 1, "C2", 1);
        CategoryItemEntity e2 = (CategoryItemEntity) TestUtilities.serialised(e1);
    }
}
