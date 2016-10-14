package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

/**
 * Tests for the {@link LegendItemCollection} class.
 */
public class LegendItemCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        LegendItemCollection c1 = new LegendItemCollection();
        LegendItemCollection c2 = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Label", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        LegendItem item2 = new LegendItem("Label", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        c1.add(item1);
        c2.add(item2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LegendItemCollection c1 = new LegendItemCollection();
        c1.add(new LegendItem("Item", "Description", "ToolTip", "URL", new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.red));
        LegendItemCollection c2 = (LegendItemCollection) TestUtilities.serialised(c1);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LegendItemCollection c1 = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Item 1");
        c1.add(item1);
        LegendItemCollection c2 = (LegendItemCollection) c1.clone();
        Rectangle2D item1Shape = (Rectangle2D) item1.getShape();
        item1Shape.setRect(1.0, 2.0, 3.0, 4.0);
    }
}
