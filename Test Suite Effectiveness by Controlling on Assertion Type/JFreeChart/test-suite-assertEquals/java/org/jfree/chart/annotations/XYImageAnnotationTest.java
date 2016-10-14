package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Image;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYImageAnnotation} class.
 */
public class XYImageAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Image image = JFreeChart.INFO.getLogo();
        XYImageAnnotation a1 = new XYImageAnnotation(10.0, 20.0, image);
        XYImageAnnotation a2 = new XYImageAnnotation(10.0, 20.0, image);
        a1 = new XYImageAnnotation(10.0, 20.0, image, RectangleAnchor.LEFT);
        a2 = new XYImageAnnotation(10.0, 20.0, image, RectangleAnchor.LEFT);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Image image = JFreeChart.INFO.getLogo();
        XYImageAnnotation a1 = new XYImageAnnotation(10.0, 20.0, image);
        XYImageAnnotation a2 = new XYImageAnnotation(10.0, 20.0, image);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYImageAnnotation a1 = new XYImageAnnotation(10.0, 20.0, JFreeChart.INFO.getLogo());
        XYImageAnnotation a2 = (XYImageAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        XYImageAnnotation a1 = new XYImageAnnotation(10.0, 20.0, JFreeChart.INFO.getLogo());
    }
}
