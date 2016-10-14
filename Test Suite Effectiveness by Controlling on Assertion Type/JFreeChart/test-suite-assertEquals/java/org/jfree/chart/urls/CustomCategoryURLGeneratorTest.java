package org.jfree.chart.urls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CustomCategoryURLGenerator} class.
 */
public class CustomCategoryURLGeneratorTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        CustomCategoryURLGenerator g1 = new CustomCategoryURLGenerator();
        CustomCategoryURLGenerator g2 = new CustomCategoryURLGenerator();
        List u1 = new java.util.ArrayList();
        u1.add("URL A1");
        u1.add("URL A2");
        u1.add("URL A3");
        g1.addURLSeries(u1);
        List u2 = new java.util.ArrayList();
        u2.add("URL A1");
        u2.add("URL A2");
        u2.add("URL A3");
        g2.addURLSeries(u2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CustomCategoryURLGenerator g1 = new CustomCategoryURLGenerator();
        List u1 = new java.util.ArrayList();
        u1.add("URL A1");
        u1.add("URL A2");
        u1.add("URL A3");
        g1.addURLSeries(u1);
        CustomCategoryURLGenerator g2 = (CustomCategoryURLGenerator) g1.clone();
        List u2 = new java.util.ArrayList();
        u2.add("URL XXX");
        g1.addURLSeries(u2);
        g2.addURLSeries(new java.util.ArrayList(u2));
    }

    /**
     * Checks that the class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CustomCategoryURLGenerator g1 = new CustomCategoryURLGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        List u1 = new java.util.ArrayList();
        u1.add("URL A1");
        u1.add("URL A2");
        u1.add("URL A3");
        List u2 = new java.util.ArrayList();
        u2.add("URL B1");
        u2.add("URL B2");
        u2.add("URL B3");
        CustomCategoryURLGenerator g1 = new CustomCategoryURLGenerator();
        g1.addURLSeries(u1);
        g1.addURLSeries(u2);
        CustomCategoryURLGenerator g2 = (CustomCategoryURLGenerator) TestUtilities.serialised(g1);
    }

    /**
     * Some checks for the addURLSeries() method.
     */
    public void testAddURLSeries() {
        CustomCategoryURLGenerator g1 = new CustomCategoryURLGenerator();
        g1.addURLSeries(null);
        List list1 = new java.util.ArrayList();
        list1.add("URL1");
        g1.addURLSeries(list1);
        list1.clear();
    }
}
