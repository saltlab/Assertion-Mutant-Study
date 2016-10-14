package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TestUtilities;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYBoxAndWhiskerRenderer} class.
 */
public class XYBoxAndWhiskerRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer();
        XYBoxAndWhiskerRenderer r2 = new XYBoxAndWhiskerRenderer();
        r1.setPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red));
        r2.setPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red));
        r1.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        r2.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        r1.setBoxWidth(0.55);
        r2.setBoxWidth(0.55);
        r1.setFillBox(!r1.getFillBox());
        r2.setFillBox(!r2.getFillBox());
        r1.setBoxPaint(Color.yellow);
        r2.setBoxPaint(Color.yellow);
        r1.setBoxPaint(null);
        r2.setBoxPaint(null);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer();
        XYBoxAndWhiskerRenderer r2 = new XYBoxAndWhiskerRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer();
        XYBoxAndWhiskerRenderer r2 = (XYBoxAndWhiskerRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer();
        XYBoxAndWhiskerRenderer r2 = (XYBoxAndWhiskerRenderer) TestUtilities.serialised(r1);
    }

    /**
     * A test for bug report 2909215.
     */
    public void test2909215() {
        DefaultBoxAndWhiskerXYDataset d1 = new DefaultBoxAndWhiskerXYDataset("Series");
        d1.add(new Date(1L), new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), null, null, null));
        JFreeChart chart = ChartFactory.createBoxAndWhiskerChart("Title", "X", "Y", d1, true);
        try {
            BufferedImage image = new BufferedImage(400, 200, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 400, 200), null, null);
            g2.dispose();
        } catch (Exception e) {
            fail("No exception should be thrown.");
        }
    }
}
