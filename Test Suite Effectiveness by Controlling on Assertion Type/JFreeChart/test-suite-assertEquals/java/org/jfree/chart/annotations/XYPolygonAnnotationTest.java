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
 * Tests for the {@link XYPolygonAnnotation} class.
 */
public class XYPolygonAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Stroke stroke1 = new BasicStroke(2.0f);
        Stroke stroke2 = new BasicStroke(2.5f);
        XYPolygonAnnotation a1 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        XYPolygonAnnotation a2 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        a1 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        a2 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        a1 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, Color.red, Color.blue);
        a2 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, Color.red, Color.blue);
        GradientPaint gp1 = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white);
        GradientPaint gp2 = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.white);
        a1 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, gp1, Color.blue);
        a2 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, gp2, Color.blue);
        GradientPaint gp3 = new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.white);
        GradientPaint gp4 = new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.white);
        a1 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, gp1, gp3);
        a2 = new XYPolygonAnnotation(new double[] { 99.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke2, gp2, gp4);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Stroke stroke = new BasicStroke(2.0f);
        XYPolygonAnnotation a1 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke, Color.red, Color.blue);
        XYPolygonAnnotation a2 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke, Color.red, Color.blue);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Stroke stroke1 = new BasicStroke(2.0f);
        XYPolygonAnnotation a1 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        XYPolygonAnnotation a2 = (XYPolygonAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        Stroke stroke1 = new BasicStroke(2.0f);
        XYPolygonAnnotation a1 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Stroke stroke1 = new BasicStroke(2.0f);
        XYPolygonAnnotation a1 = new XYPolygonAnnotation(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, stroke1, Color.red, Color.blue);
        XYPolygonAnnotation a2 = (XYPolygonAnnotation) TestUtilities.serialised(a1);
    }
}
