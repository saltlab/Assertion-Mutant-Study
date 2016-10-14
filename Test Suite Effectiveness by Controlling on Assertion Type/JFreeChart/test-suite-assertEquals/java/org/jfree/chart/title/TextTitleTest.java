package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.HorizontalAlignment;
import org.junit.Test;

/**
 * Tests for the {@link TextTitle} class.
 */
public class TextTitleTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = new TextTitle();
        t1.setText("Test 1");
        t2.setText("Test 1");
        Font f = new Font("SansSerif", Font.PLAIN, 15);
        t1.setFont(f);
        t2.setFont(f);
        t1.setTextAlignment(HorizontalAlignment.RIGHT);
        t2.setTextAlignment(HorizontalAlignment.RIGHT);
        t1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        t2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        t1.setBackgroundPaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.blue));
        t2.setBackgroundPaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.blue));
        t1.setMaximumLinesToDisplay(3);
        t2.setMaximumLinesToDisplay(3);
        t1.setToolTipText("TTT");
        t2.setToolTipText("TTT");
        t1.setURLText(("URL"));
        t2.setURLText(("URL"));
        t1.setExpandToFitSpace(!t1.getExpandToFitSpace());
        t2.setExpandToFitSpace(!t2.getExpandToFitSpace());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = new TextTitle();
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = (TextTitle) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        TextTitle t1 = new TextTitle("Test");
        TextTitle t2 = (TextTitle) TestUtilities.serialised(t1);
        assertEquals(t1, t2);
    }
}
