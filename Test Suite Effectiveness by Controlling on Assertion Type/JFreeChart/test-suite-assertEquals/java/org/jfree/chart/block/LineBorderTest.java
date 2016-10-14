package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link LineBorder} class.
 */
public class LineBorderTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        LineBorder b1 = new LineBorder(Color.red, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        LineBorder b2 = new LineBorder(Color.red, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        b1 = new LineBorder(Color.blue, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        b2 = new LineBorder(Color.blue, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        b1 = new LineBorder(Color.blue, new BasicStroke(1.1f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        b2 = new LineBorder(Color.blue, new BasicStroke(1.1f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        b1 = new LineBorder(Color.blue, new BasicStroke(1.1f), new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        b2 = new LineBorder(Color.blue, new BasicStroke(1.1f), new RectangleInsets(1.0, 2.0, 3.0, 4.0));
    }

    /**
     * Immutable - cloning not necessary.
     */
    public void testCloning() {
        LineBorder b1 = new LineBorder();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LineBorder b1 = new LineBorder(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow), new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        LineBorder b2 = (LineBorder) TestUtilities.serialised(b1);
    }
}
