package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link CompositeTitle} class.
 */
public class CompositeTitleTest {

    /**
     * Some checks for the constructor.
     */
    public void testConstructor() {
        CompositeTitle t = new CompositeTitle();
    }

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        CompositeTitle t1 = new CompositeTitle(new BlockContainer());
        CompositeTitle t2 = new CompositeTitle(new BlockContainer());
        t1.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        t2.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        t1.setBorder(new BlockBorder(Color.red));
        t2.setBorder(new BlockBorder(Color.red));
        t1.setPadding(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        t2.setPadding(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        t1.getContainer().add(new TextTitle("T1"));
        t2.getContainer().add(new TextTitle("T1"));
        t1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        t2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        CompositeTitle t1 = new CompositeTitle(new BlockContainer());
        t1.getContainer().add(new TextTitle("T1"));
        CompositeTitle t2 = new CompositeTitle(new BlockContainer());
        t2.getContainer().add(new TextTitle("T1"));
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        CompositeTitle t1 = new CompositeTitle(new BlockContainer());
        t1.getContainer().add(new TextTitle("T1"));
        t1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        CompositeTitle t2 = null;
        try {
            t2 = (CompositeTitle) t1.clone();
        } catch (CloneNotSupportedException e) {
            fail(e.toString());
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CompositeTitle t1 = new CompositeTitle(new BlockContainer());
        t1.getContainer().add(new TextTitle("T1"));
        t1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        CompositeTitle t2 = (CompositeTitle) TestUtilities.serialised(t1);
    }
}
