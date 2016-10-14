package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link ColorBlock} class.
 */
public class ColorBlockTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        ColorBlock b1 = new ColorBlock(Color.red, 1.0, 2.0);
        ColorBlock b2 = new ColorBlock(Color.red, 1.0, 2.0);
        b1 = new ColorBlock(Color.blue, 1.0, 2.0);
        b2 = new ColorBlock(Color.blue, 1.0, 2.0);
        b1 = new ColorBlock(Color.blue, 1.1, 2.0);
        b2 = new ColorBlock(Color.blue, 1.1, 2.0);
        b1 = new ColorBlock(Color.blue, 1.1, 2.2);
        b2 = new ColorBlock(Color.blue, 1.1, 2.2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        Rectangle2D bounds1 = new Rectangle2D.Double(10.0, 20.0, 30.0, 40.0);
        ColorBlock b1 = new ColorBlock(gp, 1.0, 2.0);
        b1.setBounds(bounds1);
        ColorBlock b2 = null;
        try {
            b2 = (ColorBlock) b1.clone();
        } catch (CloneNotSupportedException e) {
            fail(e.toString());
        }
        bounds1.setRect(1.0, 2.0, 3.0, 4.0);
        b2.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        ColorBlock b1 = new ColorBlock(gp, 1.0, 2.0);
        ColorBlock b2 = (ColorBlock) TestUtilities.serialised(b1);
    }
}
