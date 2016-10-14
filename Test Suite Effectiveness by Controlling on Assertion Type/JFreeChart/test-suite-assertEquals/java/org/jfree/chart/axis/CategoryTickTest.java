package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextLine;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link CategoryTick} class.
 */
public class CategoryTickTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Comparable c1 = "C1";
        Comparable c2 = "C2";
        TextBlock tb1 = new TextBlock();
        tb1.addLine(new TextLine("Block 1"));
        TextBlock tb2 = new TextBlock();
        tb1.addLine(new TextLine("Block 2"));
        TextBlockAnchor tba1 = TextBlockAnchor.CENTER;
        TextBlockAnchor tba2 = TextBlockAnchor.BOTTOM_CENTER;
        TextAnchor ta1 = TextAnchor.CENTER;
        TextAnchor ta2 = TextAnchor.BASELINE_LEFT;
        CategoryTick t1 = new CategoryTick(c1, tb1, tba1, ta1, 1.0f);
        CategoryTick t2 = new CategoryTick(c1, tb1, tba1, ta1, 1.0f);
        t1 = new CategoryTick(c2, tb1, tba1, ta1, 1.0f);
        t2 = new CategoryTick(c2, tb1, tba1, ta1, 1.0f);
        t1 = new CategoryTick(c2, tb2, tba1, ta1, 1.0f);
        t2 = new CategoryTick(c2, tb2, tba1, ta1, 1.0f);
        t1 = new CategoryTick(c2, tb2, tba2, ta1, 1.0f);
        t2 = new CategoryTick(c2, tb2, tba2, ta1, 1.0f);
        t1 = new CategoryTick(c2, tb2, tba2, ta2, 1.0f);
        t2 = new CategoryTick(c2, tb2, tba2, ta2, 1.0f);
        t1 = new CategoryTick(c2, tb2, tba2, ta2, 2.0f);
        t2 = new CategoryTick(c2, tb2, tba2, ta2, 2.0f);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Comparable c1 = "C1";
        TextBlock tb1 = new TextBlock();
        tb1.addLine(new TextLine("Block 1"));
        tb1.addLine(new TextLine("Block 2"));
        TextBlockAnchor tba1 = TextBlockAnchor.CENTER;
        TextAnchor ta1 = TextAnchor.CENTER;
        CategoryTick t1 = new CategoryTick(c1, tb1, tba1, ta1, 1.0f);
        CategoryTick t2 = new CategoryTick(c1, tb1, tba1, ta1, 1.0f);
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryTick t1 = new CategoryTick("C1", new TextBlock(), TextBlockAnchor.CENTER, TextAnchor.CENTER, 1.5f);
        CategoryTick t2 = (CategoryTick) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryTick t1 = new CategoryTick("C1", new TextBlock(), TextBlockAnchor.CENTER, TextAnchor.CENTER, 1.5f);
        CategoryTick t2 = (CategoryTick) TestUtilities.serialised(t1);
    }
}
