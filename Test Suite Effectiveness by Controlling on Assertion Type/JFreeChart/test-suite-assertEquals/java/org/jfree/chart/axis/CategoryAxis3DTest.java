package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link CategoryAxis3D} class.
 */
public class CategoryAxis3DTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryAxis3D a1 = new CategoryAxis3D("Test");
        CategoryAxis3D a2 = (CategoryAxis3D) a1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryAxis3D a1 = new CategoryAxis3D("Test Axis");
        CategoryAxis3D a2 = (CategoryAxis3D) TestUtilities.serialised(a1);
    }
}
