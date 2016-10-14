package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.junit.Test;

/**
 * Tests for the {@link LegendGraphic} class.
 */
public class LegendGraphicTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        LegendGraphic g1 = new LegendGraphic(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.black);
        LegendGraphic g2 = new LegendGraphic(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.black);
        g1.setShapeVisible(!g1.isShapeVisible());
        g2.setShapeVisible(!g2.isShapeVisible());
        g1.setShape(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        g2.setShape(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0));
        g1.setShapeFilled(!g1.isShapeFilled());
        g2.setShapeFilled(!g2.isShapeFilled());
        g1.setFillPaint(Color.green);
        g2.setFillPaint(Color.green);
        g1.setShapeOutlineVisible(!g1.isShapeOutlineVisible());
        g2.setShapeOutlineVisible(!g2.isShapeOutlineVisible());
        g1.setOutlinePaint(Color.green);
        g2.setOutlinePaint(Color.green);
        g1.setOutlineStroke(new BasicStroke(1.23f));
        g2.setOutlineStroke(new BasicStroke(1.23f));
        g1.setShapeAnchor(RectangleAnchor.BOTTOM_RIGHT);
        g2.setShapeAnchor(RectangleAnchor.BOTTOM_RIGHT);
        g1.setShapeLocation(RectangleAnchor.BOTTOM_RIGHT);
        g2.setShapeLocation(RectangleAnchor.BOTTOM_RIGHT);
        g1.setLineVisible(!g1.isLineVisible());
        g2.setLineVisible(!g2.isLineVisible());
        g1.setLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        g2.setLine(new Line2D.Double(1.0, 2.0, 3.0, 4.0));
        g1.setLinePaint(Color.green);
        g2.setLinePaint(Color.green);
        g1.setLineStroke(new BasicStroke(1.23f));
        g2.setLineStroke(new BasicStroke(1.23f));
        g1.setFillPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        g2.setFillPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        LegendGraphic g1 = new LegendGraphic(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.black);
        LegendGraphic g2 = new LegendGraphic(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.black);
        int h1 = g1.hashCode();
        int h2 = g2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Rectangle r = new Rectangle(1, 2, 3, 4);
        LegendGraphic g1 = new LegendGraphic(r, Color.black);
        LegendGraphic g2 = (LegendGraphic) g1.clone();
        r.setBounds(4, 3, 2, 1);
    }

    /**
     * A test for cloning - checks that the line shape is cloned correctly.
     */
    public void testCloning2() throws CloneNotSupportedException {
        Rectangle r = new Rectangle(1, 2, 3, 4);
        LegendGraphic g1 = new LegendGraphic(r, Color.black);
        Line2D l = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        g1.setLine(l);
        LegendGraphic g2 = (LegendGraphic) g1.clone();
        l.setLine(4.0, 3.0, 2.0, 1.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Stroke s = new BasicStroke(1.23f);
        LegendGraphic g1 = new LegendGraphic(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), Color.black);
        g1.setOutlineStroke(s);
        LegendGraphic g2 = (LegendGraphic) TestUtilities.serialised(g1);
    }
}
