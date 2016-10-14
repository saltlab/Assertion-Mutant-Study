package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link CategoryAxis} class.
 */
public class CategoryAxisTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = new CategoryAxis("Test");
        a1.setLowerMargin(0.15);
        a2.setLowerMargin(0.15);
        a1.setUpperMargin(0.15);
        a2.setUpperMargin(0.15);
        a1.setCategoryMargin(0.15);
        a2.setCategoryMargin(0.15);
        a1.setMaximumCategoryLabelWidthRatio(0.98f);
        a2.setMaximumCategoryLabelWidthRatio(0.98f);
        a1.setCategoryLabelPositionOffset(11);
        a2.setCategoryLabelPositionOffset(11);
        a1.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        a2.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        a1.addCategoryLabelToolTip("Test", "Check");
        a2.addCategoryLabelToolTip("Test", "Check");
        a1.addCategoryLabelURL("Test", "http://www.jfree.org/");
        a2.addCategoryLabelURL("Test", "http://www.jfree.org/");
        a1.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 21));
        a2.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 21));
        a1.setTickLabelPaint("C1", Color.red);
        a2.setTickLabelPaint("C1", Color.red);
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        a2.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = new CategoryAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryAxis a1 = new CategoryAxis("Test");
        CategoryAxis a2 = (CategoryAxis) a1.clone();
    }

    /**
     * Confirm that cloning works.  This test customises the font and paint
     * per category label.
     */
    public void testCloning2() throws CloneNotSupportedException {
        CategoryAxis a1 = new CategoryAxis("Test");
        a1.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 15));
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        CategoryAxis a2 = (CategoryAxis) a1.clone();
        a1.setTickLabelFont("C1", null);
        a2.setTickLabelFont("C1", null);
        a1.setTickLabelPaint("C1", Color.yellow);
        a2.setTickLabelPaint("C1", Color.yellow);
        a1.addCategoryLabelToolTip("C1", "XYZ");
        a2.addCategoryLabelToolTip("C1", "XYZ");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryAxis a1 = new CategoryAxis("Test Axis");
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        CategoryAxis a2 = (CategoryAxis) TestUtilities.serialised(a1);
    }
}
