package org.jfree.chart.needle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.junit.Test;

/**
 * Tests for the {@link MeterNeedle} class.
 */
public class MeterNeedleTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        MeterNeedle n1 = new LineNeedle();
        MeterNeedle n2 = new LineNeedle();
        n1.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        n2.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        n1.setOutlinePaint(new GradientPaint(5.0f, 6.0f, Color.red, 7.0f, 8.0f, Color.blue));
        n2.setOutlinePaint(new GradientPaint(5.0f, 6.0f, Color.red, 7.0f, 8.0f, Color.blue));
        n1.setHighlightPaint(new GradientPaint(9.0f, 0.0f, Color.red, 1.0f, 2.0f, Color.blue));
        n2.setHighlightPaint(new GradientPaint(9.0f, 0.0f, Color.red, 1.0f, 2.0f, Color.blue));
        Stroke s = new BasicStroke(1.23f);
        n1.setOutlineStroke(s);
        n2.setOutlineStroke(s);
        n1.setRotateX(1.23);
        n2.setRotateX(1.23);
        n1.setRotateY(4.56);
        n2.setRotateY(4.56);
        n1.setSize(11);
        n2.setSize(11);
    }
}
