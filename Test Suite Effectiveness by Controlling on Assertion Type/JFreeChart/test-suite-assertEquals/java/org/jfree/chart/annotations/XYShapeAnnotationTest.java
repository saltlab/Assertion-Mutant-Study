package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Some tests for the {@link XYShapeAnnotation} class.
 */
public class XYShapeAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYShapeAnnotation a1 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        XYShapeAnnotation a2 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        a1 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(1.2f), Color.red, Color.blue);
        a2 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(1.2f), Color.red, Color.blue);
        a1 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), Color.red, Color.blue);
        a2 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), Color.red, Color.blue);
        GradientPaint gp1a = new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red);
        GradientPaint gp1b = new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red);
        GradientPaint gp2a = new GradientPaint(5.0f, 6.0f, Color.pink, 7.0f, 8.0f, Color.white);
        GradientPaint gp2b = new GradientPaint(5.0f, 6.0f, Color.pink, 7.0f, 8.0f, Color.white);
        a1 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), gp1a, Color.blue);
        a2 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), gp1b, Color.blue);
        a1 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), gp1a, gp2a);
        a2 = new XYShapeAnnotation(new Rectangle2D.Double(4.0, 3.0, 2.0, 1.0), new BasicStroke(2.3f), gp1b, gp2b);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        XYShapeAnnotation a1 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        XYShapeAnnotation a2 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYShapeAnnotation a1 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        XYShapeAnnotation a2 = (XYShapeAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        XYShapeAnnotation a1 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYShapeAnnotation a1 = new XYShapeAnnotation(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0), new BasicStroke(1.2f), Color.red, Color.blue);
        XYShapeAnnotation a2 = (XYShapeAnnotation) TestUtilities.serialised(a1);
    }
}
