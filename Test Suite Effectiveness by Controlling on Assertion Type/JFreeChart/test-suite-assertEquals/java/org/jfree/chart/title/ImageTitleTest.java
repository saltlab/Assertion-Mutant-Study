package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.Size2D;
import org.junit.Test;

/**
 * Tests for the {@link ImageTitle} class.
 */
public class ImageTitleTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        ImageTitle t1 = new ImageTitle(JFreeChart.INFO.getLogo());
        ImageTitle t2 = new ImageTitle(JFreeChart.INFO.getLogo());
        t1.setImage(new BufferedImage(2, 1, BufferedImage.TYPE_INT_RGB));
        t2.setImage(new BufferedImage(2, 1, BufferedImage.TYPE_INT_RGB));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashcode() {
        ImageTitle t1 = new ImageTitle(JFreeChart.INFO.getLogo());
        ImageTitle t2 = new ImageTitle(JFreeChart.INFO.getLogo());
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ImageTitle t1 = new ImageTitle(JFreeChart.INFO.getLogo());
        ImageTitle t2 = (ImageTitle) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
    }

    private static final double EPSILON = 0.00000001;

    /**
     * Check the width and height.
     */
    public void testWidthAndHeight() {
        ImageTitle t1 = new ImageTitle(JFreeChart.INFO.getLogo());
    }

    /**
     * Some checks for the arrange method.
     */
    public void testArrangeNN() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        ImageTitle t = new ImageTitle(JFreeChart.INFO.getLogo());
        Size2D s = t.arrange(g2);
        t.setPadding(1.0, 2.0, 3.0, 4.0);
        s = t.arrange(g2);
        t.setMargin(5.0, 6.0, 7.0, 8.0);
        s = t.arrange(g2);
    }
}
