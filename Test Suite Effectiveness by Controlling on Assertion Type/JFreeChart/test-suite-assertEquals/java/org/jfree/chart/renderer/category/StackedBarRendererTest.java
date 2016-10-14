package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StackedBarRenderer} class.
 */
public class StackedBarRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        StackedBarRenderer r1 = new StackedBarRenderer();
        StackedBarRenderer r2 = new StackedBarRenderer();
        r1.setRenderAsPercentages(true);
        r2.setRenderAsPercentages(true);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        StackedBarRenderer r1 = new StackedBarRenderer();
        StackedBarRenderer r2 = new StackedBarRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StackedBarRenderer r1 = new StackedBarRenderer();
        StackedBarRenderer r2 = (StackedBarRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StackedBarRenderer r1 = new StackedBarRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StackedBarRenderer r1 = new StackedBarRenderer();
        StackedBarRenderer r2 = (StackedBarRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        StackedBarRenderer r = new StackedBarRenderer();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "R1", "C1");
        dataset.addValue(-2.0, "R1", "C2");
        dataset.addValue(null, "R1", "C3");
        dataset.addValue(2.0, "R2", "C1");
        dataset.addValue(null, "R2", "C2");
    }
}
