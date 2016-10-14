package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.Drawable;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYDrawableAnnotation} class.
 */
public class XYDrawableAnnotationTest {

    static class TestDrawable implements Drawable, Cloneable, Serializable {

        /**
         * Default constructor.
         */
        public TestDrawable() {
        }

        /**
         * Draws something.
         * @param g2  the graphics device.
         * @param area  the area in which to draw.
         */
        @Override
        public void draw(Graphics2D g2, Rectangle2D area) {
        }

        /**
         * Tests this object for equality with an arbitrary object.
         * @param obj  the object to test against ({@code null} permitted).
         * @return A boolean.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TestDrawable)) {
                return false;
            }
            return true;
        }

        /**
         * Returns a clone.
         *
         * @return A clone.
         *
         * @throws CloneNotSupportedException if there is a problem cloning.
         */
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        XYDrawableAnnotation a2 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        a1 = new XYDrawableAnnotation(11.0, 20.0, 100.0, 200.0, new TestDrawable());
        a2 = new XYDrawableAnnotation(11.0, 20.0, 100.0, 200.0, new TestDrawable());
        a1 = new XYDrawableAnnotation(11.0, 22.0, 100.0, 200.0, new TestDrawable());
        a2 = new XYDrawableAnnotation(11.0, 22.0, 100.0, 200.0, new TestDrawable());
        a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 200.0, new TestDrawable());
        a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 200.0, new TestDrawable());
        a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, new TestDrawable());
        a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, new TestDrawable());
        a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, 2.0, new TestDrawable());
        a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, 2.0, new TestDrawable());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        XYDrawableAnnotation a2 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        XYDrawableAnnotation a2 = (XYDrawableAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable());
        XYDrawableAnnotation a2 = (XYDrawableAnnotation) TestUtilities.serialised(a1);
    }
}
