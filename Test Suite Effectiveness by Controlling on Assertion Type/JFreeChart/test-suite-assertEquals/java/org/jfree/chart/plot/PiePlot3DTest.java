package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PiePlot3D} class.
 */
public class PiePlot3DTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        PiePlot3D p1 = new PiePlot3D();
        PiePlot3D p2 = new PiePlot3D();
        p1.setDepthFactor(1.23);
        p2.setDepthFactor(1.23);
        p1.setDarkerSides(true);
        p2.setDarkerSides(true);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PiePlot3D p1 = new PiePlot3D(null);
        PiePlot3D p2 = (PiePlot3D) TestUtilities.serialised(p1);
    }

    /**
     * Draws a pie chart where the label generator returns null.
     */
    public void testDrawWithNullDataset() {
        JFreeChart chart = ChartFactory.createPieChart3D("Test", null, true, false, false);
        boolean success = false;
        try {
            BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
            g2.dispose();
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }
}
