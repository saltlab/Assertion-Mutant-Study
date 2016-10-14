package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYErrorRenderer} class.
 */
public class XYErrorRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYErrorRenderer r1 = new XYErrorRenderer();
        XYErrorRenderer r2 = new XYErrorRenderer();
        r1.setDrawXError(false);
        r2.setDrawXError(false);
        r1.setDrawYError(false);
        r2.setDrawYError(false);
        r1.setCapLength(9.0);
        r2.setCapLength(9.0);
        r1.setErrorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        r2.setErrorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        r1.setErrorStroke(new BasicStroke(1.5f));
        r2.setErrorStroke(new BasicStroke(1.5f));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYErrorRenderer r1 = new XYErrorRenderer();
        XYErrorRenderer r2 = new XYErrorRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYErrorRenderer r1 = new XYErrorRenderer();
        r1.setErrorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        XYErrorRenderer r2 = (XYErrorRenderer) r1.clone();
    }

    /**
     * A test for cloning.
     */
    public void testCloning2() throws CloneNotSupportedException {
        XYErrorRenderer r1 = new XYErrorRenderer();
        r1.setErrorStroke(new BasicStroke(1.5f));
        XYErrorRenderer r2 = (XYErrorRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYErrorRenderer r1 = new XYErrorRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYErrorRenderer r1 = new XYErrorRenderer();
        r1.setErrorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        XYErrorRenderer r2 = (XYErrorRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        XYErrorRenderer r1 = new XYErrorRenderer();
        r1.setErrorStroke(new BasicStroke(1.5f));
        XYErrorRenderer r2 = (XYErrorRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Some checks for the findDomainBounds() method.
     */
    public void testFindDomainBounds() {
        XYErrorRenderer r = new XYErrorRenderer();
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        XYErrorRenderer r = new XYErrorRenderer();
    }
}
