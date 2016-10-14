package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CategoryLineAnnotation} class.
 */
public class CategoryLineAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        BasicStroke s1 = new BasicStroke(1.0f);
        BasicStroke s2 = new BasicStroke(2.0f);
        CategoryLineAnnotation a1 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, s1);
        CategoryLineAnnotation a2 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, s1);
        a1.setCategory1("Category A");
        a2.setCategory1("Category A");
        a1.setValue1(0.15);
        a2.setValue1(0.15);
        a1.setCategory2("Category B");
        a2.setCategory2("Category B");
        a1.setValue2(0.25);
        a2.setValue2(0.25);
        a1.setPaint(Color.yellow);
        a2.setPaint(Color.yellow);
        a1.setStroke(s2);
        a2.setStroke(s2);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        CategoryLineAnnotation a1 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, new BasicStroke(1.0f));
        CategoryLineAnnotation a2 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, new BasicStroke(1.0f));
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryLineAnnotation a1 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, new BasicStroke(1.0f));
        CategoryLineAnnotation a2 = (CategoryLineAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CategoryLineAnnotation a1 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, new BasicStroke(1.0f));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryLineAnnotation a1 = new CategoryLineAnnotation("Category 1", 1.0, "Category 2", 2.0, Color.red, new BasicStroke(1.0f));
        CategoryLineAnnotation a2 = (CategoryLineAnnotation) TestUtilities.serialised(a1);
    }
}
