package org.jfree.chart.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.Test;

/**
 * Tests for the {@link XYItemEntity} class.
 */
public class XYItemEntityTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYItemEntity e1 = new XYItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new TimeSeriesCollection(), 1, 9, "ToolTip", "URL");
        XYItemEntity e2 = new XYItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new TimeSeriesCollection(), 1, 9, "ToolTip", "URL");
        e1.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e2.setArea(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        e1.setToolTipText("New ToolTip");
        e2.setToolTipText("New ToolTip");
        e1.setURLText("New URL");
        e2.setURLText("New URL");
        e1.setSeriesIndex(88);
        e2.setSeriesIndex(88);
        e1.setItem(88);
        e2.setItem(88);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYItemEntity e1 = new XYItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new TimeSeriesCollection(), 1, 9, "ToolTip", "URL");
        XYItemEntity e2 = (XYItemEntity) e1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYItemEntity e1 = new XYItemEntity(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new TimeSeriesCollection(), 1, 9, "ToolTip", "URL");
        XYItemEntity e2 = (XYItemEntity) TestUtilities.serialised(e1);
    }
}
