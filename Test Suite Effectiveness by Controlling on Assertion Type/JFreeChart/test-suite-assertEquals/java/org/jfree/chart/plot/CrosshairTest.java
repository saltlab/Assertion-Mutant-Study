package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.text.NumberFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.labels.StandardCrosshairLabelGenerator;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link Crosshair} class.
 */
public class CrosshairTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        Crosshair c1 = new Crosshair(1.0, Color.blue, new BasicStroke(1.0f));
        Crosshair c2 = new Crosshair(1.0, Color.blue, new BasicStroke(1.0f));
        c1.setVisible(false);
        c2.setVisible(false);
        c1.setValue(2.0);
        c2.setValue(2.0);
        c1.setPaint(Color.red);
        c2.setPaint(Color.red);
        c1.setStroke(new BasicStroke(1.1f));
        c2.setStroke(new BasicStroke(1.1f));
        c1.setLabelVisible(true);
        c2.setLabelVisible(true);
        c1.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        c2.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        c1.setLabelGenerator(new StandardCrosshairLabelGenerator("Value = {0}", NumberFormat.getNumberInstance()));
        c2.setLabelGenerator(new StandardCrosshairLabelGenerator("Value = {0}", NumberFormat.getNumberInstance()));
        c1.setLabelXOffset(11);
        c2.setLabelXOffset(11);
        c1.setLabelYOffset(22);
        c2.setLabelYOffset(22);
        c1.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        c2.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        c1.setLabelPaint(Color.red);
        c2.setLabelPaint(Color.red);
        c1.setLabelBackgroundPaint(Color.yellow);
        c2.setLabelBackgroundPaint(Color.yellow);
        c1.setLabelOutlineVisible(false);
        c2.setLabelOutlineVisible(false);
        c1.setLabelOutlineStroke(new BasicStroke(2.0f));
        c2.setLabelOutlineStroke(new BasicStroke(2.0f));
        c1.setLabelOutlinePaint(Color.darkGray);
        c2.setLabelOutlinePaint(Color.darkGray);
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        Crosshair c1 = new Crosshair(1.0);
        Crosshair c2 = new Crosshair(1.0);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Crosshair c1 = new Crosshair(1.0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.BLUE), new BasicStroke(1.0f));
        Crosshair c2 = (Crosshair) c1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        Crosshair c1 = new Crosshair(1.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Crosshair c1 = new Crosshair(1.0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.BLUE), new BasicStroke(1.0f));
        Crosshair c2 = (Crosshair) TestUtilities.serialised(c1);
    }
}
