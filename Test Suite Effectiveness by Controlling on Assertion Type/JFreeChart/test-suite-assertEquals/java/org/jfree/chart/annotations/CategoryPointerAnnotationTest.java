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
 * Tests for the {@link CategoryPointerAnnotation} class.
 */
public class CategoryPointerAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CategoryPointerAnnotation a1 = new CategoryPointerAnnotation("Label", "Key 1", 20.0, Math.PI);
        CategoryPointerAnnotation a2 = new CategoryPointerAnnotation("Label", "Key 1", 20.0, Math.PI);
        a1 = new CategoryPointerAnnotation("Label2", "Key 1", 20.0, Math.PI);
        a2 = new CategoryPointerAnnotation("Label2", "Key 1", 20.0, Math.PI);
        a1.setCategory("Key 2");
        a2.setCategory("Key 2");
        a1.setValue(22.0);
        a2.setValue(22.0);
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
        CategoryPointerAnnotation a1 = new CategoryPointerAnnotation("Label", "A", 20.0, Math.PI);
        CategoryPointerAnnotation a2 = new CategoryPointerAnnotation("Label", "A", 20.0, Math.PI);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryPointerAnnotation a1 = new CategoryPointerAnnotation("Label", "A", 20.0, Math.PI);
        CategoryPointerAnnotation a2 = (CategoryPointerAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CategoryPointerAnnotation a1 = new CategoryPointerAnnotation("Label", "A", 20.0, Math.PI);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryPointerAnnotation a1 = new CategoryPointerAnnotation("Label", "A", 20.0, Math.PI);
        CategoryPointerAnnotation a2 = (CategoryPointerAnnotation) TestUtilities.serialised(a1);
    }
}
