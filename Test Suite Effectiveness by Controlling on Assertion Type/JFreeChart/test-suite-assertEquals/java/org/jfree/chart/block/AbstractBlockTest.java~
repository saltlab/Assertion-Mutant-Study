package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link AbstractBlock} class.
 */
public class AbstractBlockTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = new EmptyBlock(1.0, 2.0);
        b1.setID("Test");
        b2.setID("Test");
        b1.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        b2.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        b1.setFrame(new BlockBorder(Color.red));
        b2.setFrame(new BlockBorder(Color.red));
        b1.setPadding(new RectangleInsets(2.0, 4.0, 6.0, 8.0));
        b2.setPadding(new RectangleInsets(2.0, 4.0, 6.0, 8.0));
        b1.setWidth(1.23);
        b2.setWidth(1.23);
        b1.setHeight(4.56);
        b2.setHeight(4.56);
        b1.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        b2.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        b1 = new EmptyBlock(1.1, 2.0);
        b2 = new EmptyBlock(1.1, 2.0);
        b1 = new EmptyBlock(1.1, 2.2);
        b2 = new EmptyBlock(1.1, 2.2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        Rectangle2D bounds1 = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        b1.setBounds(bounds1);
        EmptyBlock b2 = null;
        try {
            b2 = (EmptyBlock) b1.clone();
        } catch (CloneNotSupportedException e) {
            fail(e.toString());
        }
        bounds1.setFrame(2.0, 4.0, 6.0, 8.0);
        b2.setBounds(new Rectangle2D.Double(2.0, 4.0, 6.0, 8.0));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = (EmptyBlock) TestUtilities.serialised(b1);
    }
}
