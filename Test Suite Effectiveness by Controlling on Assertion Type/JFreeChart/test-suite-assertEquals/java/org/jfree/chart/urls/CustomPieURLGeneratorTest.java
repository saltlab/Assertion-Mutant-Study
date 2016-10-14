package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CustomPieURLGenerator} class.
 */
public class CustomPieURLGeneratorTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        CustomPieURLGenerator g1 = new CustomPieURLGenerator();
        CustomPieURLGenerator g2 = new CustomPieURLGenerator();
        Map m1 = new HashMap();
        m1.put("A", "http://www.jfree.org/");
        g1.addURLs(m1);
        g2.addURLs(m1);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CustomPieURLGenerator g1 = new CustomPieURLGenerator();
        Map m1 = new HashMap();
        m1.put("A", "http://www.jfree.org/");
        g1.addURLs(m1);
        CustomPieURLGenerator g2 = (CustomPieURLGenerator) g1.clone();
        Map m2 = new HashMap();
        m2.put("B", "XYZ");
        g1.addURLs(m2);
    }

    /**
     * Checks that the class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CustomPieURLGenerator g1 = new CustomPieURLGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CustomPieURLGenerator g1 = new CustomPieURLGenerator();
        Map m1 = new HashMap();
        m1.put("A", "http://www.jfree.org/");
        g1.addURLs(m1);
        CustomPieURLGenerator g2 = (CustomPieURLGenerator) TestUtilities.serialised(g1);
    }
}
