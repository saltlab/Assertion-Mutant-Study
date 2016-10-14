package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Some tests for the {@link MonthDateFormat} class.
 */
public class MonthDateFormatTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MonthDateFormat mf1 = new MonthDateFormat();
        MonthDateFormat mf2 = new MonthDateFormat();
        boolean[] showYear1 = new boolean[12];
        showYear1[0] = true;
        boolean[] showYear2 = new boolean[12];
        showYear1[1] = true;
        mf1 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.US, 1, showYear1, new SimpleDateFormat("yy"));
        mf2 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.US, 1, showYear1, new SimpleDateFormat("yy"));
        mf1 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 1, showYear1, new SimpleDateFormat("yy"));
        mf2 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 1, showYear1, new SimpleDateFormat("yy"));
        mf1 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear1, new SimpleDateFormat("yy"));
        mf2 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear1, new SimpleDateFormat("yy"));
        mf1 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear2, new SimpleDateFormat("yy"));
        mf2 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear2, new SimpleDateFormat("yy"));
        mf1 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear2, new SimpleDateFormat("yyyy"));
        mf2 = new MonthDateFormat(TimeZone.getTimeZone("PST"), Locale.FRANCE, 2, showYear2, new SimpleDateFormat("yyyy"));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        MonthDateFormat mf1 = new MonthDateFormat();
        MonthDateFormat mf2 = new MonthDateFormat();
        int h1 = mf1.hashCode();
        int h2 = mf2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        MonthDateFormat mf1 = new MonthDateFormat();
        MonthDateFormat mf2 = null;
        mf2 = (MonthDateFormat) mf1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MonthDateFormat mf1 = new MonthDateFormat();
        MonthDateFormat mf2 = (MonthDateFormat) TestUtilities.serialised(mf1);
    }
}
