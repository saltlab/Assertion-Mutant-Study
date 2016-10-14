package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.Year;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link PeriodAxisLabelInfo} class.
 */
public class PeriodAxisLabelInfoTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        PeriodAxisLabelInfo info2 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        Class c1 = Day.class;
        Class c2 = Month.class;
        DateFormat df1 = new SimpleDateFormat("d");
        DateFormat df2 = new SimpleDateFormat("MMM");
        RectangleInsets sp1 = new RectangleInsets(1, 1, 1, 1);
        RectangleInsets sp2 = new RectangleInsets(2, 2, 2, 2);
        Font lf1 = new Font("SansSerif", Font.PLAIN, 10);
        Font lf2 = new Font("SansSerif", Font.BOLD, 9);
        Paint lp1 = Color.black;
        Paint lp2 = Color.blue;
        boolean b1 = true;
        boolean b2 = false;
        Stroke s1 = new BasicStroke(0.5f);
        Stroke s2 = new BasicStroke(0.25f);
        Paint dp1 = Color.red;
        Paint dp2 = Color.green;
        info1 = new PeriodAxisLabelInfo(c2, df1, sp1, lf1, lp1, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c1, df1, sp1, lf1, lp1, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df1, sp1, lf1, lp1, b1, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp1, lf1, lp1, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp1, lf1, lp1, b1, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf1, lp1, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf1, lp1, b1, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp1, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp1, b1, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b1, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b1, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s1, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s1, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp1);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp1);
        info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp2);
        info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp2);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        PeriodAxisLabelInfo info2 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        int h1 = info1.hashCode();
        int h2 = info2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        PeriodAxisLabelInfo info2 = (PeriodAxisLabelInfo) info1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        PeriodAxisLabelInfo info2 = (PeriodAxisLabelInfo) TestUtilities.serialised(info1);
    }

    /**
     * A test for the createInstance() method.
     */
    public void testCreateInstance() {
        TimeZone zone = TimeZone.getTimeZone("GMT");
        PeriodAxisLabelInfo info = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        Day d = (Day) info.createInstance(new Date(0L), zone, Locale.UK);
        info = new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("YYYY"));
        Year y = (Year) info.createInstance(new Date(0L), zone, Locale.UK);
    }
}
