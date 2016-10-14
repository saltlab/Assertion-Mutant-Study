package org.jfree.chart.panel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.plot.Crosshair;
import org.junit.Test;

/**
 * Tests for the {@link CrosshairOverlay} class.
 */
public class CrosshairOverlayTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CrosshairOverlay o1 = new CrosshairOverlay();
        CrosshairOverlay o2 = new CrosshairOverlay();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CrosshairOverlay o1 = new CrosshairOverlay();
        o1.addDomainCrosshair(new Crosshair(99.9));
        o1.addRangeCrosshair(new Crosshair(1.23, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue), new BasicStroke(1.1f)));
        CrosshairOverlay o2 = (CrosshairOverlay) TestUtilities.serialised(o1);
    }

    /**
     * Basic checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        CrosshairOverlay o1 = new CrosshairOverlay();
        o1.addDomainCrosshair(new Crosshair(99.9));
        o1.addRangeCrosshair(new Crosshair(1.23, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue), new BasicStroke(1.1f)));
        CrosshairOverlay o2 = (CrosshairOverlay) o1.clone();
        o1.addDomainCrosshair(new Crosshair(3.21));
        o1.addRangeCrosshair(new Crosshair(4.32));
    }
}
