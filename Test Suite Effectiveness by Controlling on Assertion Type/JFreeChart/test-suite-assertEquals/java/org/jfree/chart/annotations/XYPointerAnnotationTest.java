package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYPointerAnnotation} class.
 */
public class XYPointerAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYPointerAnnotation a1 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        XYPointerAnnotation a2 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        a1 = new XYPointerAnnotation("Label2", 10.0, 20.0, Math.PI);
        a2 = new XYPointerAnnotation("Label2", 10.0, 20.0, Math.PI);
        a1.setX(11.0);
        a2.setX(11.0);
        a1.setY(22.0);
        a2.setY(22.0);
        a1.setAngle(Math.PI / 4.0);
        a2.setAngle(Math.PI / 4.0);
        a1.setTipRadius(20.0);
        a2.setTipRadius(20.0);
        a1.setBaseRadius(5.0);
        a2.setBaseRadius(5.0);
        a1.setArrowLength(33.0);
        a2.setArrowLength(33.0);
        a1.setArrowWidth(9.0);
        a2.setArrowWidth(9.0);
        Stroke stroke = new BasicStroke(1.5f);
        a1.setArrowStroke(stroke);
        a2.setArrowStroke(stroke);
        a1.setArrowPaint(Color.blue);
        a2.setArrowPaint(Color.blue);
        a1.setLabelOffset(10.0);
        a2.setLabelOffset(10.0);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        XYPointerAnnotation a1 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        XYPointerAnnotation a2 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYPointerAnnotation a1 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        XYPointerAnnotation a2 = a2 = (XYPointerAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        XYPointerAnnotation a1 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYPointerAnnotation a1 = new XYPointerAnnotation("Label", 10.0, 20.0, Math.PI);
        XYPointerAnnotation a2 = (XYPointerAnnotation) TestUtilities.serialised(a1);
    }
}
