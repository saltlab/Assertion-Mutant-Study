package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link Axis} class.
 */
public class AxisTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryAxis a1 = new CategoryAxis("Test");
        a1.setAxisLinePaint(Color.red);
        CategoryAxis a2 = (CategoryAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        Axis a1 = new CategoryAxis("Test");
        Axis a2 = new CategoryAxis("Test");
        a1.setVisible(false);
        a2.setVisible(false);
        a1.setLabel("New Label");
        a2.setLabel("New Label");
        a1.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        a2.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        a1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.black));
        a2.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.black));
        a1.setAttributedLabel(new AttributedString("Hello World!"));
        a2.setAttributedLabel(new AttributedString("Hello World!"));
        AttributedString l1 = a1.getAttributedLabel();
        l1.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 2);
        a1.setAttributedLabel(l1);
        assertNotEquals(a1, a2);
        AttributedString l2 = a2.getAttributedLabel();
        l2.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 2);
        a2.setAttributedLabel(l2);
        a1.setLabelInsets(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        a2.setLabelInsets(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        a1.setLabelAngle(1.23);
        a2.setLabelAngle(1.23);
        a1.setLabelLocation(AxisLabelLocation.HIGH_END);
        a2.setLabelLocation(AxisLabelLocation.HIGH_END);
        a1.setAxisLineVisible(false);
        assertNotEquals(a1, a2);
        a2.setAxisLineVisible(false);
        BasicStroke s = new BasicStroke(1.1f);
        a1.setAxisLineStroke(s);
        a2.setAxisLineStroke(s);
        a1.setAxisLinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        a2.setAxisLinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        a1.setTickLabelsVisible(false);
        a2.setTickLabelsVisible(false);
        a1.setTickLabelFont(new Font("Dialog", Font.PLAIN, 12));
        a2.setTickLabelFont(new Font("Dialog", Font.PLAIN, 12));
        a1.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.black));
        a2.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.black));
        a1.setTickLabelInsets(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        a2.setTickLabelInsets(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        a1.setTickMarksVisible(false);
        a2.setTickMarksVisible(false);
        a1.setTickMarkInsideLength(1.23f);
        a2.setTickMarkInsideLength(1.23f);
        a1.setTickMarkOutsideLength(1.23f);
        a2.setTickMarkOutsideLength(1.23f);
        a1.setTickMarkStroke(new BasicStroke(2.0f));
        a2.setTickMarkStroke(new BasicStroke(2.0f));
        a1.setTickMarkPaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.black));
        a2.setTickMarkPaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.black));
        a1.setFixedDimension(3.21f);
        a2.setFixedDimension(3.21f);
        a1.setMinorTickMarksVisible(true);
        a2.setMinorTickMarksVisible(true);
        a1.setMinorTickMarkInsideLength(1.23f);
        a2.setMinorTickMarkInsideLength(1.23f);
        a1.setMinorTickMarkOutsideLength(3.21f);
        a2.setMinorTickMarkOutsideLength(3.21f);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Axis a1 = new CategoryAxis("Test");
        Axis a2 = new CategoryAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Checks that serialization works, particularly with the attributed label.
     */
    public void testSerialization() {
        Axis a1 = new CategoryAxis("Test");
        AttributedString label = new AttributedString("Axis Label");
        label.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 4);
        a1.setAttributedLabel(label);
        Axis a2 = (Axis) TestUtilities.serialised(a1);
    }
}
