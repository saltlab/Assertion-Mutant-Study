package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.font.TextAttribute;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

/**
 * Tests for the {@link LegendItem} class.
 */
public class LegendItemTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        LegendItem item1 = new LegendItem("Label", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        LegendItem item2 = new LegendItem("Label", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", true, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), true, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.red, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, true, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.blue, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(1.2f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), true, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.1f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.1f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(3.3f), Color.green);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(3.3f), Color.green);
        item1 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(3.3f), Color.white);
        item2 = new LegendItem("Label2", "Description2", "ToolTip", "URL", false, new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), false, Color.black, false, Color.yellow, new BasicStroke(2.1f), false, new Line2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(3.3f), Color.white);
        item1.setFillPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        item2.setFillPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        item1.setLabelFont(new Font("Dialog", Font.PLAIN, 13));
        item2.setLabelFont(new Font("Dialog", Font.PLAIN, 13));
        item1.setLabelPaint(Color.red);
        item2.setLabelPaint(Color.red);
        item1.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.blue));
        item2.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.blue));
        item1.setOutlinePaint(new GradientPaint(1.1f, 2.2f, Color.green, 3.3f, 4.4f, Color.blue));
        item2.setOutlinePaint(new GradientPaint(1.1f, 2.2f, Color.green, 3.3f, 4.4f, Color.blue));
        item1.setLinePaint(new GradientPaint(0.1f, 0.2f, Color.green, 0.3f, 0.4f, Color.blue));
        item2.setLinePaint(new GradientPaint(0.1f, 0.2f, Color.green, 0.3f, 0.4f, Color.blue));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LegendItem item1 = new LegendItem("Item", "Description", "ToolTip", "URL", new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new GradientPaint(5.0f, 6.0f, Color.blue, 7.0f, 8.0f, Color.gray));
        item1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        item1.setOutlinePaint(new GradientPaint(4.0f, 3.0f, Color.green, 2.0f, 1.0f, Color.red));
        item1.setLinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.red));
        LegendItem item2;
        item2 = (LegendItem) TestUtilities.serialised(item1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        AttributedString as = new AttributedString("Test String");
        as.addAttribute(TextAttribute.FONT, new Font("Dialog", Font.PLAIN, 12));
        LegendItem item1 = new LegendItem(as, "Description", "ToolTip", "URL", new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.red);
        LegendItem item2 = (LegendItem) TestUtilities.serialised(item1);
    }

    /**
     * Basic checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        LegendItem item1 = new LegendItem("Item");
        LegendItem item2 = (LegendItem) item1.clone();
    }
}
