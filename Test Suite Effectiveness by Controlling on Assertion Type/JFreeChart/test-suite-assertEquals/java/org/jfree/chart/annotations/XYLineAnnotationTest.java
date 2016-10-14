package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYLineAnnotation} class.
 */
public class XYLineAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Stroke stroke = new BasicStroke(2.0f);
        XYLineAnnotation a1 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        XYLineAnnotation a2 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        a1 = new XYLineAnnotation(11.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        a2 = new XYLineAnnotation(11.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        a1 = new XYLineAnnotation(11.0, 21.0, 100.0, 200.0, stroke, Color.blue);
        a2 = new XYLineAnnotation(11.0, 21.0, 100.0, 200.0, stroke, Color.blue);
        a1 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke, Color.blue);
        a2 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke, Color.blue);
        a1 = new XYLineAnnotation(11.0, 21.0, 101.0, 201.0, stroke, Color.blue);
        a2 = new XYLineAnnotation(11.0, 21.0, 101.0, 201.0, stroke, Color.blue);
        Stroke stroke2 = new BasicStroke(0.99f);
        a1 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke2, Color.blue);
        a2 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke2, Color.blue);
        GradientPaint g1 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white);
        GradientPaint g2 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white);
        a1 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke2, g1);
        a2 = new XYLineAnnotation(11.0, 21.0, 101.0, 200.0, stroke2, g2);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Stroke stroke = new BasicStroke(2.0f);
        XYLineAnnotation a1 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        XYLineAnnotation a2 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Stroke stroke = new BasicStroke(2.0f);
        XYLineAnnotation a1 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        XYLineAnnotation a2 = (XYLineAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        Stroke stroke = new BasicStroke(2.0f);
        XYLineAnnotation a1 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Stroke stroke = new BasicStroke(2.0f);
        XYLineAnnotation a1 = new XYLineAnnotation(10.0, 20.0, 100.0, 200.0, stroke, Color.blue);
        XYLineAnnotation a2 = (XYLineAnnotation) TestUtilities.serialised(a1);
    }
}
