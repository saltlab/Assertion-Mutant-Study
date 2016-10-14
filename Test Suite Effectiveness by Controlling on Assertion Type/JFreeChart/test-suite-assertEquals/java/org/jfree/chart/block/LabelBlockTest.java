package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.junit.Test;

/**
 * Some tests for the {@link LabelBlock} class.
 */
public class LabelBlockTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        LabelBlock b1 = new LabelBlock("ABC", new Font("Dialog", Font.PLAIN, 12), Color.red);
        LabelBlock b2 = new LabelBlock("ABC", new Font("Dialog", Font.PLAIN, 12), Color.red);
        b1 = new LabelBlock("XYZ", new Font("Dialog", Font.PLAIN, 12), Color.red);
        b2 = new LabelBlock("XYZ", new Font("Dialog", Font.PLAIN, 12), Color.red);
        b1 = new LabelBlock("XYZ", new Font("Dialog", Font.BOLD, 12), Color.red);
        b2 = new LabelBlock("XYZ", new Font("Dialog", Font.BOLD, 12), Color.red);
        b1 = new LabelBlock("XYZ", new Font("Dialog", Font.BOLD, 12), Color.blue);
        b2 = new LabelBlock("XYZ", new Font("Dialog", Font.BOLD, 12), Color.blue);
        b1.setToolTipText("Tooltip");
        b2.setToolTipText("Tooltip");
        b1.setURLText("URL");
        b2.setURLText("URL");
        b1.setContentAlignmentPoint(TextBlockAnchor.CENTER_RIGHT);
        b2.setContentAlignmentPoint(TextBlockAnchor.CENTER_RIGHT);
        b1.setTextAnchor(RectangleAnchor.BOTTOM_RIGHT);
        b2.setTextAnchor(RectangleAnchor.BOTTOM_RIGHT);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LabelBlock b1 = new LabelBlock("ABC", new Font("Dialog", Font.PLAIN, 12), Color.red);
        LabelBlock b2 = (LabelBlock) b1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        LabelBlock b1 = new LabelBlock("ABC", new Font("Dialog", Font.PLAIN, 12), gp);
        LabelBlock b2 = (LabelBlock) TestUtilities.serialised(b1);
    }
}
