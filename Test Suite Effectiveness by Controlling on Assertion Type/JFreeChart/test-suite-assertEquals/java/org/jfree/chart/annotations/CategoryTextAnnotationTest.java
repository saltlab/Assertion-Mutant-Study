package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CategoryTextAnnotation} class.
 */
public class CategoryTextAnnotationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CategoryTextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        CategoryTextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0);
        a1.setCategory("Category 2");
        a2.setCategory("Category 2");
        a1.setCategoryAnchor(CategoryAnchor.START);
        a2.setCategoryAnchor(CategoryAnchor.START);
        a1.setValue(0.15);
        a2.setValue(0.15);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashcode() {
        CategoryTextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        CategoryTextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryTextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        CategoryTextAnnotation a2 = (CategoryTextAnnotation) a1.clone();
    }

    /**
     * Checks that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        CategoryTextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryTextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        CategoryTextAnnotation a2 = (CategoryTextAnnotation) TestUtilities.serialised(a1);
    }
}
