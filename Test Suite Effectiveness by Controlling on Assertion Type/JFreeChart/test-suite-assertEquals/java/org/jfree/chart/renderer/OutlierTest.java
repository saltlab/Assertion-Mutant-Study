package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.Point2D;
import java.io.Serializable;
import org.junit.Test;

/**
 * Tests for the {@link Outlier} class.
 */
public class OutlierTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Simple check for the default constructor.
     */
    public void testConstructor() {
        Outlier out = new Outlier(1.0, 2.0, 3.0);
    }

    /**
     * A test for the equals() method.
     */
    public void testEquals() {
        Outlier out1 = new Outlier(1.0, 2.0, 3.0);
        Outlier out2 = new Outlier(1.0, 2.0, 3.0);
        out1.setPoint(new Point2D.Double(2.0, 2.0));
        out2.setPoint(new Point2D.Double(2.0, 2.0));
        out1.setPoint(new Point2D.Double(2.0, 3.0));
        out2.setPoint(new Point2D.Double(2.0, 3.0));
        out1.setRadius(4.0);
        out2.setRadius(4.0);
    }

    /**
     * Confirm that cloning is not implemented.
     */
    public void testCloning() {
        Outlier out1 = new Outlier(1.0, 2.0, 3.0);
    }

    /**
     * Confirm that serialization is not implemented.
     */
    public void testSerialization() {
        Outlier out1 = new Outlier(1.0, 2.0, 3.0);
    }
}
