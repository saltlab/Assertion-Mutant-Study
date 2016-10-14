package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;
import org.junit.Test;

/**
 * Tests for the abstract {@link Title} class.
 */
public class TitleTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        Title t1 = new TextTitle();
        Title t2 = new TextTitle();
        t1.setPosition(RectangleEdge.LEFT);
        t2.setPosition(RectangleEdge.LEFT);
        t1.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        t2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        t1.setVerticalAlignment(VerticalAlignment.BOTTOM);
        t2.setVerticalAlignment(VerticalAlignment.BOTTOM);
        t1.setVisible(false);
        t2.setVisible(false);
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
}
