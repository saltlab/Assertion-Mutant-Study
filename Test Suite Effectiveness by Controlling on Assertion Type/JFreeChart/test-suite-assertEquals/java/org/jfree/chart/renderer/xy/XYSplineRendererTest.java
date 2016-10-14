package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYSplineRenderer} class.
 */
public class XYSplineRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYSplineRenderer r1 = new XYSplineRenderer();
        XYSplineRenderer r2 = new XYSplineRenderer();
        r1.setPrecision(9);
        r2.setPrecision(9);
        r1.setFillType(XYSplineRenderer.FillType.TO_ZERO);
        r2.setFillType(XYSplineRenderer.FillType.TO_ZERO);
        r1.setGradientPaintTransformer(null);
        r2.setGradientPaintTransformer(null);
        r1.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        r2.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYSplineRenderer r1 = new XYSplineRenderer();
        XYSplineRenderer r2 = new XYSplineRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Rectangle2D legendShape = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        XYSplineRenderer r1 = new XYSplineRenderer();
        r1.setLegendLine(legendShape);
        XYSplineRenderer r2 = (XYSplineRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYSplineRenderer r1 = new XYSplineRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYSplineRenderer r1 = new XYSplineRenderer();
        XYSplineRenderer r2 = (XYSplineRenderer) TestUtilities.serialised(r1);
    }
}
