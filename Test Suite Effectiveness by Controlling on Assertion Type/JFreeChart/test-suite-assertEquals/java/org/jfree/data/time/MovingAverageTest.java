package org.jfree.data.time;

import static org.junit.Assert.assertEquals;
import org.jfree.date.MonthConstants;
import org.junit.Test;

/**
 * Tests for the {@link MovingAverage} class.
 */
public class MovingAverageTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * A test for the values calculated from a time series.
     */
    public void test1() {
        TimeSeries source = createDailyTimeSeries1();
        TimeSeries maverage = MovingAverage.createMovingAverage(source, "Moving Average", 3, 3);
        double value = maverage.getValue(0).doubleValue();
        value = maverage.getValue(1).doubleValue();
        value = maverage.getValue(2).doubleValue();
        value = maverage.getValue(3).doubleValue();
        value = maverage.getValue(4).doubleValue();
        value = maverage.getValue(5).doubleValue();
        value = maverage.getValue(6).doubleValue();
    }

    /**
     * Creates a sample series.
     *
     * @return A sample series.
     */
    private TimeSeries createDailyTimeSeries1() {
        TimeSeries series = new TimeSeries("Series 1", Day.class);
        series.add(new Day(11, MonthConstants.AUGUST, 2003), 11.2);
        series.add(new Day(13, MonthConstants.AUGUST, 2003), 13.8);
        series.add(new Day(17, MonthConstants.AUGUST, 2003), 14.1);
        series.add(new Day(18, MonthConstants.AUGUST, 2003), 12.7);
        series.add(new Day(19, MonthConstants.AUGUST, 2003), 16.5);
        series.add(new Day(20, MonthConstants.AUGUST, 2003), 15.6);
        series.add(new Day(25, MonthConstants.AUGUST, 2003), 19.8);
        series.add(new Day(27, MonthConstants.AUGUST, 2003), 10.7);
        series.add(new Day(28, MonthConstants.AUGUST, 2003), 14.3);
        return series;
    }
}
