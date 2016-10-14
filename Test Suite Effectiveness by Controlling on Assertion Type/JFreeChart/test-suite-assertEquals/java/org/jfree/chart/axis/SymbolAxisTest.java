package org.jfree.chart.axis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link SymbolAxis} class.
 */
public class SymbolAxisTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        String[] tickLabels = new String[] { "One", "Two", "Three" };
        SymbolAxis a1 = new SymbolAxis("Test Axis", tickLabels);
        SymbolAxis a2 = (SymbolAxis) TestUtilities.serialised(a1);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        SymbolAxis a1 = new SymbolAxis("Axis", new String[] { "A", "B" });
        SymbolAxis a2 = (SymbolAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        SymbolAxis a1 = new SymbolAxis("Axis", new String[] { "A", "B" });
        SymbolAxis a2 = new SymbolAxis("Axis", new String[] { "A", "B" });
        a1 = new SymbolAxis("Axis 2", new String[] { "A", "B" });
        a2 = new SymbolAxis("Axis 2", new String[] { "A", "B" });
        a1 = new SymbolAxis("Axis 2", new String[] { "C", "B" });
        a2 = new SymbolAxis("Axis 2", new String[] { "C", "B" });
        a1.setGridBandsVisible(false);
        a2.setGridBandsVisible(false);
        a1.setGridBandPaint(Color.black);
        a2.setGridBandPaint(Color.black);
        a1.setGridBandAlternatePaint(Color.red);
        a2.setGridBandAlternatePaint(Color.red);
    }
}
