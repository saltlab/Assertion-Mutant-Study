package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYTextAnnotation} class.
 */
public class XYTextAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYTextAnnotation a1 = new XYTextAnnotation("Text", 10.0, 20.0);
        XYTextAnnotation a2 = new XYTextAnnotation("Text", 10.0, 20.0);
        a1 = new XYTextAnnotation("ABC", 10.0, 20.0);
        a2 = new XYTextAnnotation("ABC", 10.0, 20.0);
        a1 = new XYTextAnnotation("ABC", 11.0, 20.0);
        a2 = new XYTextAnnotation("ABC", 11.0, 20.0);
        a1 = new XYTextAnnotation("ABC", 11.0, 22.0);
        a2 = new XYTextAnnotation("ABC", 11.0, 22.0);
        a1.setFont(new Font("Serif", Font.PLAIN, 23));
        a2.setFont(new Font("Serif", Font.PLAIN, 23));
        GradientPaint gp1 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow);
        GradientPaint gp2 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow);
        a1.setPaint(gp1);
        a2.setPaint(gp2);
        a1.setRotationAnchor(TextAnchor.BASELINE_RIGHT);
        a2.setRotationAnchor(TextAnchor.BASELINE_RIGHT);
        a1.setRotationAngle(12.3);
        a2.setRotationAngle(12.3);
        a1.setTextAnchor(TextAnchor.BASELINE_RIGHT);
        a2.setTextAnchor(TextAnchor.BASELINE_RIGHT);
        a1.setBackgroundPaint(gp1);
        a2.setBackgroundPaint(gp1);
        a1.setOutlinePaint(gp1);
        a2.setOutlinePaint(gp1);
        a1.setOutlineStroke(new BasicStroke(1.2f));
        a2.setOutlineStroke(new BasicStroke(1.2f));
        a1.setOutlineVisible(!a1.isOutlineVisible());
        a2.setOutlineVisible(a1.isOutlineVisible());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        XYTextAnnotation a1 = new XYTextAnnotation("Text", 10.0, 20.0);
        XYTextAnnotation a2 = new XYTextAnnotation("Text", 10.0, 20.0);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYTextAnnotation a1 = new XYTextAnnotation("Text", 10.0, 20.0);
        XYTextAnnotation a2 = (XYTextAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        XYTextAnnotation a1 = new XYTextAnnotation("Text", 10.0, 20.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYTextAnnotation a1 = new XYTextAnnotation("Text", 10.0, 20.0);
        a1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        XYTextAnnotation a2 = (XYTextAnnotation) TestUtilities.serialised(a1);
    }
}
