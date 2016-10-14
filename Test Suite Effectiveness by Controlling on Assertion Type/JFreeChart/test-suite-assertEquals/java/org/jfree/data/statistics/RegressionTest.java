package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

/**
 * Tests for the {@link Regression} class.
 */
public class RegressionTest {

    /**
     * Checks the results of an OLS regression on sample dataset 1.
     */
    public void testOLSRegression1a() {
        double[][] data = createSampleData1();
        double[] result1 = Regression.getOLSRegression(data);
    }

    /**
     * Checks the results of an OLS regression on sample dataset 1 AFTER
     * converting it to an XYSeries.
     */
    public void testOLSRegression1b() {
        double[][] data = createSampleData1();
        XYSeries series = new XYSeries("Test");
        for (int i = 0; i < 11; i++) {
            series.add(data[i][0], data[i][1]);
        }
        XYDataset ds = new XYSeriesCollection(series);
        double[] result2 = Regression.getOLSRegression(ds, 0);
    }

    /**
     * Checks the results of a power regression on sample dataset 1.
     */
    public void testPowerRegression1a() {
        double[][] data = createSampleData1();
        double[] result = Regression.getPowerRegression(data);
    }

    /**
     * Checks the results of a power regression on sample dataset 1 AFTER
     * converting it to an XYSeries.
     */
    public void testPowerRegression1b() {
        double[][] data = createSampleData1();
        XYSeries series = new XYSeries("Test");
        for (int i = 0; i < 11; i++) {
            series.add(data[i][0], data[i][1]);
        }
        XYDataset ds = new XYSeriesCollection(series);
        double[] result = Regression.getPowerRegression(ds, 0);
    }

    /**
     * Checks the results of an OLS regression on sample dataset 2.
     */
    public void testOLSRegression2a() {
        double[][] data = createSampleData2();
        double[] result = Regression.getOLSRegression(data);
    }

    /**
     * Checks the results of an OLS regression on sample dataset 2 AFTER
     * converting it to an XYSeries.
     */
    public void testOLSRegression2b() {
        double[][] data = createSampleData2();
        XYSeries series = new XYSeries("Test");
        for (int i = 0; i < 10; i++) {
            series.add(data[i][0], data[i][1]);
        }
        XYDataset ds = new XYSeriesCollection(series);
        double[] result = Regression.getOLSRegression(ds, 0);
    }

    /**
     * Checks the results of a power regression on sample dataset 2.
     */
    public void testPowerRegression2a() {
        double[][] data = createSampleData2();
        double[] result = Regression.getPowerRegression(data);
    }

    /**
     * Checks the results of a power regression on sample dataset 2 AFTER
     * converting it to an XYSeries.
     */
    public void testPowerRegression2b() {
        double[][] data = createSampleData2();
        XYSeries series = new XYSeries("Test");
        for (int i = 0; i < 10; i++) {
            series.add(data[i][0], data[i][1]);
        }
        XYDataset ds = new XYSeriesCollection(series);
        double[] result = Regression.getPowerRegression(ds, 0);
    }

    /**
     * Creates and returns a sample dataset.
     * <P>
     * The data is taken from Table 11.2, page 313 of "Understanding Statistics"
     * by Ott and Mendenhall (Duxbury Press).
     *
     * @return The sample data.
     */
    private double[][] createSampleData1() {
        double[][] result = new double[11][2];
        result[0][0] = 2.00;
        result[0][1] = 1.60;
        result[1][0] = 2.25;
        result[1][1] = 2.00;
        result[2][0] = 2.60;
        result[2][1] = 1.80;
        result[3][0] = 2.65;
        result[3][1] = 2.80;
        result[4][0] = 2.80;
        result[4][1] = 2.10;
        result[5][0] = 3.10;
        result[5][1] = 2.00;
        result[6][0] = 2.90;
        result[6][1] = 2.65;
        result[7][0] = 3.25;
        result[7][1] = 2.25;
        result[8][0] = 3.30;
        result[8][1] = 2.60;
        result[9][0] = 3.60;
        result[9][1] = 3.00;
        result[10][0] = 3.25;
        result[10][1] = 3.10;
        return result;
    }

    /**
     * Creates a sample data set.
     *
     * @return The sample data.
     */
    private double[][] createSampleData2() {
        double[][] result = new double[10][2];
        result[0][0] = 2;
        result[0][1] = 56.27;
        result[1][0] = 3;
        result[1][1] = 41.32;
        result[2][0] = 4;
        result[2][1] = 31.45;
        result[3][0] = 5;
        result[3][1] = 30.05;
        result[4][0] = 6;
        result[4][1] = 24.69;
        result[5][0] = 7;
        result[5][1] = 19.78;
        result[6][0] = 8;
        result[6][1] = 20.94;
        result[7][0] = 9;
        result[7][1] = 16.73;
        result[8][0] = 10;
        result[8][1] = 14.21;
        result[9][0] = 11;
        result[9][1] = 12.44;
        return result;
    }
}
