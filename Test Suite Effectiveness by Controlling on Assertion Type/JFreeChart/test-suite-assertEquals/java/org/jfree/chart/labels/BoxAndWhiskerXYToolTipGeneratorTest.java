package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link BoxAndWhiskerXYToolTipGenerator} class.
 */
public class BoxAndWhiskerXYToolTipGeneratorTest {

    /**
     * A series of tests for the equals() method.
     */
    public void testEquals() {
        BoxAndWhiskerXYToolTipGenerator g1 = new BoxAndWhiskerXYToolTipGenerator();
        BoxAndWhiskerXYToolTipGenerator g2 = new BoxAndWhiskerXYToolTipGenerator();
        g1 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g1 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("MMM-yyyy"), new DecimalFormat("0.0"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g1 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.00"));
        g2 = new BoxAndWhiskerXYToolTipGenerator("{0} --> {1} {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0.0"));
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        BoxAndWhiskerXYToolTipGenerator g1 = new BoxAndWhiskerXYToolTipGenerator();
        BoxAndWhiskerXYToolTipGenerator g2 = new BoxAndWhiskerXYToolTipGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BoxAndWhiskerXYToolTipGenerator g1 = new BoxAndWhiskerXYToolTipGenerator();
        BoxAndWhiskerXYToolTipGenerator g2 = (BoxAndWhiskerXYToolTipGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        BoxAndWhiskerXYToolTipGenerator g1 = new BoxAndWhiskerXYToolTipGenerator();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BoxAndWhiskerXYToolTipGenerator g1 = new BoxAndWhiskerXYToolTipGenerator();
        BoxAndWhiskerXYToolTipGenerator g2 = (BoxAndWhiskerXYToolTipGenerator) TestUtilities.serialised(g1);
    }
}
