package org.jfree.data.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.MultiValueCategoryDataset;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for the {@link DatasetUtilities} class.
 */
public class DatasetUtilitiesTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * Some tests to verify that Java does what I think it does!
     */
    public void testJava() {
    }

    /**
     * Some tests for the calculatePieDatasetTotal() method.
     */
    public void testCalculatePieDatasetTotal() {
        DefaultPieDataset d = new DefaultPieDataset();
        d.setValue("A", 1.0);
        d.setValue("B", 3.0);
    }

    /**
     * Some tests for the findDomainBounds() method.
     */
    public void testFindDomainBounds() {
        XYDataset dataset = createXYDataset1();
        Range r = DatasetUtilities.findDomainBounds(dataset);
    }

    /**
     * This test checks that the standard method has 'includeInterval'
     * defaulting to true.
     */
    public void testFindDomainBounds2() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.findDomainBounds(dataset);
    }

    /**
     * This test checks that when the 'includeInterval' flag is false, the
     * bounds come from the regular x-values.
     */
    public void testFindDomainBounds3() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.findDomainBounds(dataset, false);
    }

    /**
     * This test checks that the correct values are returned if the x and
     * y values fall outside the intervals.
     */
    public void testFindDomainBounds4() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 0.8, 3.2, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.findDomainBounds(dataset);
    }

    /**
     * This test checks that NaN values are ignored.
     */
    @Test
    public void testFindDomainBounds_NaN() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 1.0, 2.0, Double.NaN };
        double[] x1Start = new double[] { 0.9, 1.9, Double.NaN };
        double[] x1End = new double[] { 1.1, 2.1, Double.NaN };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.findDomainBounds(dataset);
        assertEquals(0.9, r.getLowerBound(), EPSILON);
        r = DatasetUtilities.findDomainBounds(dataset, false);
    }

    /**
     * Some tests for the iterateDomainBounds() method.
     */
    public void testIterateDomainBounds() {
        XYDataset dataset = createXYDataset1();
        Range r = DatasetUtilities.iterateDomainBounds(dataset);
    }

    /**
     * Check that NaN values in the dataset are ignored.
     */
    public void testIterateDomainBounds_NaN() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[] x = new double[] { 1.0, 2.0, Double.NaN, 3.0 };
        double[] y = new double[] { 9.0, 8.0, 7.0, 6.0 };
        dataset.addSeries("S1", new double[][] { x, y });
        Range r = DatasetUtilities.iterateDomainBounds(dataset);
    }

    /**
     * Check that NaN values in the IntervalXYDataset are ignored.
     */
    public void testIterateDomainBounds_NaN2() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { Double.NaN, 2.0, 3.0 };
        double[] x1Start = new double[] { 0.9, Double.NaN, 2.9 };
        double[] x1End = new double[] { 1.1, Double.NaN, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.iterateDomainBounds(dataset, false);
        r = DatasetUtilities.iterateDomainBounds(dataset, true);
    }

    /**
     * Some tests for the findRangeBounds() for a CategoryDataset method.
     */
    public void testFindRangeBounds_CategoryDataset() {
        CategoryDataset dataset = createCategoryDataset1();
        Range r = DatasetUtilities.findRangeBounds(dataset);
    }

    /**
     * Some tests for the findRangeBounds() method on an XYDataset.
     */
    public void testFindRangeBounds() {
        XYDataset dataset = createXYDataset1();
        Range r = DatasetUtilities.findRangeBounds(dataset);
    }

    /**
     * A test for the findRangeBounds(XYDataset) method using
     * an IntervalXYDataset.
     */
    public void testFindRangeBounds2() {
        YIntervalSeriesCollection dataset = new YIntervalSeriesCollection();
        Range r = DatasetUtilities.findRangeBounds(dataset);
        YIntervalSeries s1 = new YIntervalSeries("S1");
        dataset.addSeries(s1);
        r = DatasetUtilities.findRangeBounds(dataset);
        s1.add(1.0, 2.0, 1.5, 2.5);
        r = DatasetUtilities.findRangeBounds(dataset);
        r = DatasetUtilities.findRangeBounds(dataset, false);
        s1.add(2.0, 2.0, 1.4, 2.1);
        r = DatasetUtilities.findRangeBounds(dataset);
        YIntervalSeries s2 = new YIntervalSeries("S2");
        dataset.addSeries(s2);
        r = DatasetUtilities.findRangeBounds(dataset);
        s2.add(1.0, 2.0, 1.9, 2.6);
        r = DatasetUtilities.findRangeBounds(dataset);
        r = DatasetUtilities.findRangeBounds(dataset, false);
    }

    /**
     * Some tests for the iterateRangeBounds() method.
     */
    public void testIterateRangeBounds_CategoryDataset() {
        CategoryDataset dataset = createCategoryDataset1();
        Range r = DatasetUtilities.iterateRangeBounds(dataset, false);
    }

    /**
     * Some checks for the iterateRangeBounds() method.
     */
    public void testIterateRangeBounds2_CategoryDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Range r = DatasetUtilities.iterateRangeBounds(dataset, false);
        dataset.addValue(1.23, "R1", "C1");
        r = DatasetUtilities.iterateRangeBounds(dataset, false);
        dataset.addValue(null, "R2", "C1");
        r = DatasetUtilities.iterateRangeBounds(dataset, false);
        dataset.addValue(Double.NaN, "R2", "C1");
        r = DatasetUtilities.iterateRangeBounds(dataset, false);
    }

    /**
     * Some checks for the iterateRangeBounds() method using an
     * IntervalCategoryDataset.
     */
    public void testIterateRangeBounds3_CategoryDataset() {
        Number[][] starts = new Double[2][3];
        Number[][] ends = new Double[2][3];
        starts[0][0] = new Double(1.0);
        starts[0][1] = new Double(2.0);
        starts[0][2] = new Double(3.0);
        starts[1][0] = new Double(11.0);
        starts[1][1] = new Double(12.0);
        starts[1][2] = new Double(13.0);
        ends[0][0] = new Double(4.0);
        ends[0][1] = new Double(5.0);
        ends[0][2] = new Double(6.0);
        ends[1][0] = new Double(16.0);
        ends[1][1] = new Double(15.0);
        ends[1][2] = new Double(14.0);
        DefaultIntervalCategoryDataset d = new DefaultIntervalCategoryDataset(starts, ends);
        Range r = DatasetUtilities.iterateRangeBounds(d, false);
        r = DatasetUtilities.iterateRangeBounds(d, true);
    }

    /**
     * Some tests for the iterateRangeBounds() method.
     */
    public void testIterateRangeBounds() {
        XYDataset dataset = createXYDataset1();
        Range r = DatasetUtilities.iterateRangeBounds(dataset);
    }

    /**
     * Check the range returned when a series contains a null value.
     */
    @Test
    public void testIterateRangeBounds2() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, null);
        s1.add(3.0, 3.3);
        XYSeriesCollection dataset = new XYSeriesCollection(s1);
        Range r = DatasetUtilities.iterateRangeBounds(dataset);
        assertEquals(1.1, r.getLowerBound(), EPSILON);
    }

    /**
     * Some checks for the iterateRangeBounds() method.
     */
    public void testIterateRangeBounds3() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        Range r = DatasetUtilities.iterateRangeBounds(dataset);
        XYSeries s1 = new XYSeries("S1");
        dataset.addSeries(s1);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s1.add(1.0, 1.23);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s1.add(2.0, null);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s1.add(3.0, Double.NaN);
        r = DatasetUtilities.iterateRangeBounds(dataset);
    }

    /**
     * Some checks for the range bounds of a dataset that implements the
     * {@link IntervalXYDataset} interface.
     */
    public void testIterateRangeBounds4() {
        YIntervalSeriesCollection dataset = new YIntervalSeriesCollection();
        Range r = DatasetUtilities.iterateRangeBounds(dataset);
        YIntervalSeries s1 = new YIntervalSeries("S1");
        dataset.addSeries(s1);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s1.add(1.0, 2.0, 1.5, 2.5);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s1.add(2.0, 2.0, 1.4, 2.1);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        YIntervalSeries s2 = new YIntervalSeries("S2");
        dataset.addSeries(s2);
        r = DatasetUtilities.iterateRangeBounds(dataset);
        s2.add(1.0, 2.0, 1.9, 2.6);
        r = DatasetUtilities.iterateRangeBounds(dataset);
    }

    /**
     * Some tests for the findMinimumDomainValue() method.
     */
    public void testFindMinimumDomainValue() {
        XYDataset dataset = createXYDataset1();
        Number minimum = DatasetUtilities.findMinimumDomainValue(dataset);
    }

    /**
     * Some tests for the findMaximumDomainValue() method.
     */
    public void testFindMaximumDomainValue() {
        XYDataset dataset = createXYDataset1();
        Number maximum = DatasetUtilities.findMaximumDomainValue(dataset);
    }

    /**
     * Some tests for the findMinimumRangeValue() method.
     */
    public void testFindMinimumRangeValue() {
        CategoryDataset d1 = createCategoryDataset1();
        Number min1 = DatasetUtilities.findMinimumRangeValue(d1);
        XYDataset d2 = createXYDataset1();
        Number min2 = DatasetUtilities.findMinimumRangeValue(d2);
    }

    /**
     * Some tests for the findMaximumRangeValue() method.
     */
    public void testFindMaximumRangeValue() {
        CategoryDataset d1 = createCategoryDataset1();
        Number max1 = DatasetUtilities.findMaximumRangeValue(d1);
        XYDataset dataset = createXYDataset1();
        Number maximum = DatasetUtilities.findMaximumRangeValue(dataset);
    }

    /**
     * A quick test of the min and max range value methods.
     */
    public void testMinMaxRange() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100.0, "Series 1", "Type 1");
        dataset.addValue(101.1, "Series 1", "Type 2");
        Number min = DatasetUtilities.findMinimumRangeValue(dataset);
        Number max = DatasetUtilities.findMaximumRangeValue(dataset);
    }

    /**
     * A test to reproduce bug report 803660.
     */
    public void test803660() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100.0, "Series 1", "Type 1");
        dataset.addValue(101.1, "Series 1", "Type 2");
        Number n = DatasetUtilities.findMaximumRangeValue(dataset);
    }

    /**
     * A simple test for the cumulative range calculation.  The sequence of
     * "cumulative" values are considered to be { 0.0, 10.0, 25.0, 18.0 } so
     * the range should be 0.0 -> 25.0.
     */
    public void testCumulativeRange1() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10.0, "Series 1", "Start");
        dataset.addValue(15.0, "Series 1", "Delta 1");
        dataset.addValue(-7.0, "Series 1", "Delta 2");
        Range range = DatasetUtilities.findCumulativeRangeBounds(dataset);
    }

    /**
     * A further test for the cumulative range calculation.
     */
    public void testCumulativeRange2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-21.4, "Series 1", "Start Value");
        dataset.addValue(11.57, "Series 1", "Delta 1");
        dataset.addValue(3.51, "Series 1", "Delta 2");
        dataset.addValue(-12.36, "Series 1", "Delta 3");
        dataset.addValue(3.39, "Series 1", "Delta 4");
        dataset.addValue(38.68, "Series 1", "Delta 5");
        dataset.addValue(-43.31, "Series 1", "Delta 6");
        dataset.addValue(-29.59, "Series 1", "Delta 7");
        dataset.addValue(35.30, "Series 1", "Delta 8");
        dataset.addValue(5.0, "Series 1", "Delta 9");
        Range range = DatasetUtilities.findCumulativeRangeBounds(dataset);
    }

    /**
     * A further test for the cumulative range calculation.
     */
    public void testCumulativeRange3() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15.76, "Product 1", "Labour");
        dataset.addValue(8.66, "Product 1", "Administration");
        dataset.addValue(4.71, "Product 1", "Marketing");
        dataset.addValue(3.51, "Product 1", "Distribution");
        dataset.addValue(32.64, "Product 1", "Total Expense");
        Range range = DatasetUtilities.findCumulativeRangeBounds(dataset);
    }

    /**
     * Check that the findCumulativeRangeBounds() method ignores Double.NaN
     * values.
     */
    public void testCumulativeRange_NaN() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10.0, "Series 1", "Start");
        dataset.addValue(15.0, "Series 1", "Delta 1");
        dataset.addValue(Double.NaN, "Series 1", "Delta 2");
        Range range = DatasetUtilities.findCumulativeRangeBounds(dataset);
    }

    /**
     * Test the creation of a dataset from an array.
     */
    public void testCreateCategoryDataset1() {
        String[] rowKeys = { "R1", "R2", "R3" };
        String[] columnKeys = { "C1", "C2" };
        double[][] data = new double[3][];
        data[0] = new double[] { 1.1, 1.2 };
        data[1] = new double[] { 2.1, 2.2 };
        data[2] = new double[] { 3.1, 3.2 };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
    }

    /**
     * Test the creation of a dataset from an array.  This time is should fail
     * because the array dimensions are around the wrong way.
     */
    public void testCreateCategoryDataset2() {
        boolean pass = false;
        String[] rowKeys = { "R1", "R2", "R3" };
        String[] columnKeys = { "C1", "C2" };
        double[][] data = new double[2][];
        data[0] = new double[] { 1.1, 1.2, 1.3 };
        data[1] = new double[] { 2.1, 2.2, 2.3 };
        CategoryDataset dataset = null;
        try {
            dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Test for a bug reported in the forum:
     *
     * http://www.jfree.org/phpBB2/viewtopic.php?t=7903
     */
    public void testMaximumStackedRangeValue() {
        double v1 = 24.3;
        double v2 = 14.2;
        double v3 = 33.2;
        double v4 = 32.4;
        double v5 = 26.3;
        double v6 = 22.6;
        Number answer = new Double(Math.max(v1 + v2 + v3, v4 + v5 + v6));
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(v1, "Row 0", "Column 0");
        d.addValue(v2, "Row 1", "Column 0");
        d.addValue(v3, "Row 2", "Column 0");
        d.addValue(v4, "Row 0", "Column 1");
        d.addValue(v5, "Row 1", "Column 1");
        d.addValue(v6, "Row 2", "Column 1");
        Number max = DatasetUtilities.findMaximumStackedRangeValue(d);
    }

    /**
     * Some checks for the findStackedRangeBounds() method.
     */
    @Test
    public void testFindStackedRangeBounds_CategoryDataset1() {
        CategoryDataset d1 = createCategoryDataset1();
        Range r = DatasetUtilities.findStackedRangeBounds(d1);
        assertEquals(15.0, r.getUpperBound(), EPSILON);
        d1 = createCategoryDataset2();
        r = DatasetUtilities.findStackedRangeBounds(d1);
    }

    /**
     * Some checks for the findStackedRangeBounds() method.
     */
    public void testFindStackedRangeBounds_CategoryDataset2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Range r = DatasetUtilities.findStackedRangeBounds(dataset);
        dataset.addValue(5.0, "R1", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, 3.0);
        dataset.addValue(-1.0, "R2", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, 3.0);
        dataset.addValue(null, "R3", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, 3.0);
        dataset.addValue(Double.NaN, "R4", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, 3.0);
    }

    /**
     * Some checks for the findStackedRangeBounds(CategoryDataset,
     * KeyToGroupMap) method.
     */
    public void testFindStackedRangeBounds_CategoryDataset3() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        KeyToGroupMap map = new KeyToGroupMap("Group A");
        Range r = DatasetUtilities.findStackedRangeBounds(dataset, map);
        dataset.addValue(1.0, "R1", "C1");
        dataset.addValue(2.0, "R2", "C1");
        dataset.addValue(3.0, "R3", "C1");
        dataset.addValue(4.0, "R4", "C1");
        map.mapKeyToGroup("R1", "Group A");
        map.mapKeyToGroup("R2", "Group A");
        map.mapKeyToGroup("R3", "Group B");
        map.mapKeyToGroup("R4", "Group B");
        r = DatasetUtilities.findStackedRangeBounds(dataset, map);
        dataset.addValue(null, "R5", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, map);
        dataset.addValue(Double.NaN, "R6", "C1");
        r = DatasetUtilities.findStackedRangeBounds(dataset, map);
    }

    /**
     * Some checks for the findStackedRangeBounds() method.
     */
    public void testFindStackedRangeBoundsForTableXYDataset1() {
        TableXYDataset d2 = createTableXYDataset1();
        Range r = DatasetUtilities.findStackedRangeBounds(d2);
    }

    /**
     * Some checks for the findStackedRangeBounds() method.
     */
    public void testFindStackedRangeBoundsForTableXYDataset2() {
        DefaultTableXYDataset d = new DefaultTableXYDataset();
        Range r = DatasetUtilities.findStackedRangeBounds(d);
    }

    /**
     * Tests the stacked range extent calculation.
     */
    public void testStackedRangeWithMap() {
        CategoryDataset d = createCategoryDataset1();
        KeyToGroupMap map = new KeyToGroupMap("G0");
        map.mapKeyToGroup("R2", "G1");
        Range r = DatasetUtilities.findStackedRangeBounds(d, map);
    }

    /**
     * Some checks for the isEmptyOrNull(XYDataset) method.
     */
    public void testIsEmptyOrNullXYDataset() {
        XYSeriesCollection dataset = null;
        dataset = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("S1");
        dataset.addSeries(s1);
        s1.add(1.0, 2.0);
        s1.clear();
    }

    /**
     * Some checks for the limitPieDataset() methods.
     */
    @Test
    public void testLimitPieDataset() {
        DefaultPieDataset d1 = new DefaultPieDataset();
        PieDataset d2 = DatasetUtilities.createConsolidatedPieDataset(d1, "Other", 0.05);
        d1.setValue("Item 1", 1.0);
        d1.setValue("Item 2", 49.50);
        d1.setValue("Item 3", 49.50);
        d2 = DatasetUtilities.createConsolidatedPieDataset(d1, "Other", 0.05);
        d1.setValue("Item 4", 1.0);
        d2 = DatasetUtilities.createConsolidatedPieDataset(d1, "Other", 0.05, 2);
        assertEquals("Other", d2.getKey(2));
    }

    /**
     * Some checks for the sampleFunction2D() method.
     */
    public void testSampleFunction2D() {
        Function2D f = new LineFunction2D(0, 1);
        XYDataset dataset = DatasetUtilities.sampleFunction2D(f, 0.0, 1.0, 2, "S1");
    }

    /**
     * A simple check for the findMinimumStackedRangeValue() method.
     */
    public void testFindMinimumStackedRangeValue() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Number min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
        dataset.addValue(1.0, "R1", "C1");
        min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
        dataset.addValue(2.0, "R2", "C1");
        min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
        dataset.addValue(-3.0, "R3", "C1");
        min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
        dataset.addValue(Double.NaN, "R4", "C1");
        min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
    }

    /**
     * A simple check for the findMaximumStackedRangeValue() method.
     */
    public void testFindMinimumStackedRangeValue2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-1.0, "R1", "C1");
        Number min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
        dataset.addValue(-2.0, "R2", "C1");
        min = DatasetUtilities.findMinimumStackedRangeValue(dataset);
    }

    /**
     * A simple check for the findMaximumStackedRangeValue() method.
     */
    @Test
    public void testFindMaximumStackedRangeValue() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Number max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        dataset.addValue(1.0, "R1", "C1");
        max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        dataset.addValue(2.0, "R2", "C1");
        max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        dataset.addValue(-3.0, "R3", "C1");
        max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        dataset.addValue(Double.NaN, "R4", "C1");
        max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        assertEquals(3.0, max.doubleValue(), EPSILON);
    }

    /**
     * A simple check for the findMaximumStackedRangeValue() method.
     */
    public void testFindMaximumStackedRangeValue2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-1.0, "R1", "C1");
        Number max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
        dataset.addValue(-2.0, "R2", "C1");
        max = DatasetUtilities.findMaximumStackedRangeValue(dataset);
    }

    /**
     * Creates a dataset for testing.
     *
     * @return A dataset.
     */
    private CategoryDataset createCategoryDataset1() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(1.0, "R0", "C0");
        result.addValue(1.0, "R1", "C0");
        result.addValue(1.0, "R2", "C0");
        result.addValue(4.0, "R0", "C1");
        result.addValue(5.0, "R1", "C1");
        result.addValue(6.0, "R2", "C1");
        return result;
    }

    /**
     * Creates a dataset for testing.
     *
     * @return A dataset.
     */
    private CategoryDataset createCategoryDataset2() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(1.0, "R0", "C0");
        result.addValue(-2.0, "R1", "C0");
        result.addValue(2.0, "R0", "C1");
        result.addValue(-1.0, "R1", "C1");
        return result;
    }

    /**
     * Creates a dataset for testing.
     *
     * @return A dataset.
     */
    private XYDataset createXYDataset1() {
        XYSeries series1 = new XYSeries("S1");
        series1.add(1.0, 100.0);
        series1.add(2.0, 101.0);
        series1.add(3.0, 102.0);
        XYSeries series2 = new XYSeries("S2");
        series2.add(1.0, 103.0);
        series2.add(2.0, null);
        series2.add(3.0, 105.0);
        XYSeriesCollection result = new XYSeriesCollection();
        result.addSeries(series1);
        result.addSeries(series2);
        result.setIntervalWidth(0.0);
        return result;
    }

    /**
     * Creates a sample dataset for testing purposes.
     *
     * @return A sample dataset.
     */
    private TableXYDataset createTableXYDataset1() {
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        XYSeries s1 = new XYSeries("Series 1", true, false);
        s1.add(1.0, 1.0);
        s1.add(2.0, 2.0);
        dataset.addSeries(s1);
        XYSeries s2 = new XYSeries("Series 2", true, false);
        s2.add(1.0, -2.0);
        s2.add(2.0, -1.0);
        dataset.addSeries(s2);
        return dataset;
    }

    /**
     * This test checks that the correct values are returned if the x-values 
     * fall outside the intervals (it is not required that they do).
     */
    public void testIterateToFindDomainBounds_IntervalXYDataset() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 0.8, 3.2, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, 5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.iterateToFindDomainBounds(dataset, Arrays.asList("S1"), true);
    }

    /**
     * This test checks that the correct values are returned if the y-values
     * fall outside the intervals (it is not required that they do).
     */
    public void testIterateToFindRangeBounds_IntervalXYDataset() {
        DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
        double[] x1 = new double[] { 0.8, 3.2, 3.0 };
        double[] x1Start = new double[] { 0.9, 1.9, 2.9 };
        double[] x1End = new double[] { 1.1, 2.1, 3.1 };
        double[] y1 = new double[] { 4.0, -5.0, 6.0 };
        double[] y1Start = new double[] { 1.09, 2.09, 3.09 };
        double[] y1End = new double[] { 1.11, 2.11, 3.11 };
        double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End };
        dataset.addSeries("S1", data1);
        Range r = DatasetUtilities.iterateToFindRangeBounds(dataset, Arrays.asList("S1"), new Range(0.0, 4.0), true);
    }

    /**
     * Some checks for the iteratorToFindRangeBounds(XYDataset...) method.
     */
    public void testIterateToFindRangeBounds1_XYDataset() {
        boolean pass = false;
        try {
            DatasetUtilities.iterateToFindRangeBounds(null, new ArrayList(), new Range(0.0, 1.0), true);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            DatasetUtilities.iterateToFindRangeBounds(new XYSeriesCollection(), null, new Range(0.0, 1.0), true);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            DatasetUtilities.iterateToFindRangeBounds(new XYSeriesCollection(), new ArrayList(), null, true);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some tests for the iterateToFindRangeBounds() method.
     */
    public void testIterateToFindRangeBounds2_XYDataset() {
        List visibleSeriesKeys = new ArrayList();
        Range xRange = new Range(0.0, 10.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        Range r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        XYSeries s1 = new XYSeries("A");
        dataset.addSeries(s1);
        visibleSeriesKeys.add("A");
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s1.add(1.0, null);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s1.add(2.0, Double.NaN);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s1.add(3.0, 5.0);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s1.add(4.0, 6.0);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        XYSeries s2 = new XYSeries("B");
        dataset.addSeries(s2);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        visibleSeriesKeys.add("B");
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s2.add(5.0, 15.0);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        s2.add(15.0, 150.0);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, xRange, false);
        r = DatasetUtilities.iterateToFindRangeBounds(dataset, visibleSeriesKeys, new Range(0.0, 20.0), false);
    }

    /**
     * Some checks for the iterateToFindRangeBounds() method when applied to
     * a BoxAndWhiskerXYDataset.
     */
    public void testIterateToFindRangeBounds_BoxAndWhiskerXYDataset() {
        DefaultBoxAndWhiskerXYDataset dataset = new DefaultBoxAndWhiskerXYDataset("Series 1");
        List visibleSeriesKeys = new ArrayList();
        visibleSeriesKeys.add("Series 1");
        Range xRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        dataset.add(new Date(50L), new BoxAndWhiskerItem(5.0, 4.9, 2.0, 8.0, 1.0, 9.0, 0.0, 10.0, new ArrayList()));
    }

    /**
     * Some checks for the iterateToFindRangeBounds(CategoryDataset...)
     * method.
     */
    public void testIterateToFindRangeBounds_StatisticalCategoryDataset() {
        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
        List visibleSeriesKeys = new ArrayList();
        dataset.add(1.0, 0.5, "R1", "C1");
        visibleSeriesKeys.add("R1");
    }

    /**
     * Some checks for the iterateToFindRangeBounds(CategoryDataset...) method
     * with a {@link MultiValueCategoryDataset}.
     */
    public void testIterateToFindRangeBounds_MultiValueCategoryDataset() {
        DefaultMultiValueCategoryDataset dataset = new DefaultMultiValueCategoryDataset();
        List visibleSeriesKeys = new ArrayList();
        List values = Arrays.asList(new Double[] { new Double(1.0) });
        dataset.add(values, "R1", "C1");
        visibleSeriesKeys.add("R1");
        values = Arrays.asList(new Double[] { new Double(2.0), new Double(3.0) });
        dataset.add(values, "R1", "C2");
        values = Arrays.asList(new Double[] { new Double(-1.0), new Double(-2.0) });
        dataset.add(values, "R2", "C1");
        visibleSeriesKeys.add("R2");
    }

    /**
     * Some checks for the iterateRangeBounds() method when passed an
     * IntervalCategoryDataset.
     */
    public void testIterateRangeBounds_IntervalCategoryDataset() {
        TestIntervalCategoryDataset d = new TestIntervalCategoryDataset();
        d.addItem(1.0, 2.0, 3.0, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(2.5, 2.0, 3.0, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(4.0, 2.0, 3.0, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(null, new Double(2.0), new Double(3.0), "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(null, null, null, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(new Double(1.0), null, null, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(null, new Double(1.0), null, "R1", "C1");
        d = new TestIntervalCategoryDataset();
        d.addItem(null, null, new Double(1.0), "R1", "C1");
    }

    /**
     * A test for bug 2849731.
     */
    public void testBug2849731() {
        TestIntervalCategoryDataset d = new TestIntervalCategoryDataset();
        d.addItem(2.5, 2.0, 3.0, "R1", "C1");
        d.addItem(new Double(4.0), null, null, "R2", "C1");
    }

    /**
     * Another test for bug 2849731.
     */
    public void testBug2849731_2() {
        XYIntervalSeriesCollection d = new XYIntervalSeriesCollection();
        XYIntervalSeries s = new XYIntervalSeries("S1");
        s.add(1.0, Double.NaN, Double.NaN, Double.NaN, 1.5, Double.NaN);
        d.addSeries(s);
        Range r = DatasetUtilities.iterateDomainBounds(d);
        s.add(1.0, 1.5, Double.NaN, Double.NaN, 1.5, Double.NaN);
        r = DatasetUtilities.iterateDomainBounds(d);
        s.add(1.0, Double.NaN, 0.5, Double.NaN, 1.5, Double.NaN);
        r = DatasetUtilities.iterateDomainBounds(d);
    }

    /**
     * Yet another test for bug 2849731.
     */
    public void testBug2849731_3() {
        XYIntervalSeriesCollection d = new XYIntervalSeriesCollection();
        XYIntervalSeries s = new XYIntervalSeries("S1");
        s.add(1.0, Double.NaN, Double.NaN, 1.5, Double.NaN, Double.NaN);
        d.addSeries(s);
        Range r = DatasetUtilities.iterateRangeBounds(d);
        s.add(1.0, 1.5, Double.NaN, Double.NaN, Double.NaN, 2.5);
        r = DatasetUtilities.iterateRangeBounds(d);
        s.add(1.0, Double.NaN, 0.5, Double.NaN, 3.5, Double.NaN);
        r = DatasetUtilities.iterateRangeBounds(d);
    }

    /**
     * Check the findYValue() method with a dataset that is in ascending order 
     * of x-values.
     */
    public void testFindYValue() {
        XYSeries series = new XYSeries("S1");
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        series.add(1.0, 5.0);
        series.add(2.0, 10.0);
    }

    /**
     * Check the findYValue() method with a dataset that is not sorted.
     */
    public void testFindYValueNonSorted() {
        XYSeries series = new XYSeries("S1", false);
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        series.add(1.0, 5.0);
        series.add(0.0, 10.0);
        series.add(4.0, 20.0);
    }

    /**
     * Check the findYValue() method with a dataset that allows duplicate
     * values.
     */
    @Test
    public void testFindYValueWithDuplicates() {
        XYSeries series = new XYSeries("S1", true, true);
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        series.add(1.0, 5.0);
        assertEquals(5.0, DatasetUtilities.findYValue(dataset, 0, 1.0), EPSILON);
        series.add(1.0, 10.0);
        series.add(2.0, 10.0);
    }
}
