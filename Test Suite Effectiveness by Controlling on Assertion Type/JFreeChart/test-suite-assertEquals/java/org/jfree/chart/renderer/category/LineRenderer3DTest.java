package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link LineRenderer3D} class.
 */
public class LineRenderer3DTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        LineRenderer3D r1 = new LineRenderer3D();
        LineRenderer3D r2 = new LineRenderer3D();
        r1.setXOffset(99.9);
        r2.setXOffset(99.9);
        r1.setYOffset(111.1);
        r2.setYOffset(111.1);
        r1.setWallPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r2.setWallPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        LineRenderer3D r1 = new LineRenderer3D();
        LineRenderer3D r2 = new LineRenderer3D();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LineRenderer3D r1 = new LineRenderer3D();
        LineRenderer3D r2 = (LineRenderer3D) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        LineRenderer3D r1 = new LineRenderer3D();
    }

    /**
     * Checks that the two renderers are equal but independent of one another.
     *
     * @param r1  renderer 1.
     * @param r2  renderer 2.
     *
     * @return A boolean.
     */
    private boolean checkIndependence(LineRenderer3D r1, LineRenderer3D r2) {
        boolean b0 = r1.equals(r2);
        r1.setBaseLinesVisible(!r1.getBaseLinesVisible());
        if (r1.equals(r2)) {
            return false;
        }
        r2.setBaseLinesVisible(r1.getBaseLinesVisible());
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setSeriesLinesVisible(1, true);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setSeriesLinesVisible(1, true);
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setLinesVisible(false);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setLinesVisible(false);
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setBaseShapesVisible(!r1.getBaseShapesVisible());
        if (r1.equals(r2)) {
            return false;
        }
        r2.setBaseShapesVisible(r1.getBaseShapesVisible());
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setSeriesShapesVisible(1, true);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setSeriesShapesVisible(1, true);
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setShapesVisible(false);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setShapesVisible(false);
        if (!r1.equals(r2)) {
            return false;
        }
        boolean flag = true;
        Boolean existing = r1.getShapesFilled();
        if (existing != null) {
            flag = !existing.booleanValue();
        }
        r1.setShapesFilled(flag);
        boolean b5 = !r1.equals(r2);
        r2.setShapesFilled(flag);
        boolean b6 = r1.equals(r2);
        r1.setShapesFilled(false);
        r2.setShapesFilled(false);
        r1.setSeriesShapesFilled(0, false);
        r2.setSeriesShapesFilled(0, true);
        boolean b7 = !r1.equals(r2);
        r2.setSeriesShapesFilled(0, false);
        boolean b8 = (r1.equals(r2));
        r1.setBaseShapesFilled(false);
        r2.setBaseShapesFilled(true);
        boolean b9 = !r1.equals(r2);
        r2.setBaseShapesFilled(false);
        boolean b10 = (r1.equals(r2));
        return b0 && b5 && b6 && b7 && b8 && b9 && b10;
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LineRenderer3D r1 = new LineRenderer3D();
        LineRenderer3D r2 = (LineRenderer3D) TestUtilities.serialised(r1);
    }
}
