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
 * Tests for the {@link ExtendedCategoryAxis} class.
 */
public class ExtendedCategoryAxisTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ExtendedCategoryAxis a1 = new ExtendedCategoryAxis("Test");
        ExtendedCategoryAxis a2 = new ExtendedCategoryAxis("Test");
        a1.addSubLabel("C1", "C1-sublabel");
        a2.addSubLabel("C1", "C1-sublabel");
        a1.setSubLabelFont(new Font("Dialog", Font.BOLD, 8));
        a2.setSubLabelFont(new Font("Dialog", Font.BOLD, 8));
        a1.setSubLabelPaint(Color.red);
        a2.setSubLabelPaint(Color.red);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        ExtendedCategoryAxis a1 = new ExtendedCategoryAxis("Test");
        ExtendedCategoryAxis a2 = new ExtendedCategoryAxis("Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ExtendedCategoryAxis a1 = new ExtendedCategoryAxis("Test");
        ExtendedCategoryAxis a2 = (ExtendedCategoryAxis) a1.clone();
        a1.addSubLabel("C1", "ABC");
        a2.addSubLabel("C1", "ABC");
    }

    /**
     * Confirm that cloning works.  This test customises the font and paint
     * per category label.
     */
    public void testCloning2() throws CloneNotSupportedException {
        ExtendedCategoryAxis a1 = new ExtendedCategoryAxis("Test");
        a1.setTickLabelFont("C1", new Font("Dialog", Font.PLAIN, 15));
        a1.setTickLabelPaint("C1", new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        ExtendedCategoryAxis a2 = (ExtendedCategoryAxis) a1.clone();
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
        ExtendedCategoryAxis a1 = new ExtendedCategoryAxis("Test");
        a1.setSubLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        ExtendedCategoryAxis a2 = (ExtendedCategoryAxis) TestUtilities.serialised(a1);
    }
}
