package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link DialValueIndicator} class.
 */
public class DialValueIndicatorTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DialValueIndicator i1 = new DialValueIndicator(0);
        DialValueIndicator i2 = new DialValueIndicator(0);
        i1.setDatasetIndex(99);
        i2.setDatasetIndex(99);
        i1.setAngle(43);
        i2.setAngle(43);
        i1.setRadius(0.77);
        i2.setRadius(0.77);
        i1.setFrameAnchor(RectangleAnchor.TOP_LEFT);
        i2.setFrameAnchor(RectangleAnchor.TOP_LEFT);
        i1.setTemplateValue(new Double(1.23));
        i2.setTemplateValue(new Double(1.23));
        i1.setFont(new Font("Dialog", Font.PLAIN, 7));
        i2.setFont(new Font("Dialog", Font.PLAIN, 7));
        i1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i1.setOutlineStroke(new BasicStroke(1.1f));
        i2.setOutlineStroke(new BasicStroke(1.1f));
        i1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i2.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        i1.setInsets(new RectangleInsets(1, 2, 3, 4));
        i2.setInsets(new RectangleInsets(1, 2, 3, 4));
        i1.setValueAnchor(RectangleAnchor.BOTTOM_LEFT);
        i2.setValueAnchor(RectangleAnchor.BOTTOM_LEFT);
        i1.setTextAnchor(TextAnchor.TOP_LEFT);
        i2.setTextAnchor(TextAnchor.TOP_LEFT);
        i1.setVisible(false);
        i2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DialValueIndicator i1 = new DialValueIndicator(0);
        DialValueIndicator i2 = new DialValueIndicator(0);
        int h1 = i1.hashCode();
        int h2 = i2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DialValueIndicator i1 = new DialValueIndicator(0);
        DialValueIndicator i2 = (DialValueIndicator) i1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        i1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DialValueIndicator i1 = new DialValueIndicator(0);
        DialValueIndicator i2 = (DialValueIndicator) TestUtilities.serialised(i1);
    }
}
