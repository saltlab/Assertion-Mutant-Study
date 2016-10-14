package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Tests for the {@link Statistics} class.
 */
public class StatisticsTest {

    /**
     * Some checks for the calculateMean(Number[]) and
     * calculateMean(Number[], boolean) methods.
     */
    public void testCalculateMean_Array() {
        boolean pass = false;
        try {
            Statistics.calculateMean((Number[]) null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            Statistics.calculateMean((Number[]) null, false);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        Number[] values = new Number[] { new Double(1.0) };
        values = new Number[] { new Double(1.0), null };
        values = new Number[] { new Double(1.0), new Double(Double.NaN) };
    }

    /**
     * Some checks for the calculateMean(Collection) and
     * calculateMean(Collection, boolean) methods.
     */
    public void testCalculateMean_Collection() {
        boolean pass = false;
        try {
            Statistics.calculateMean((Collection) null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            Statistics.calculateMean((Collection) null, false);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        List values = new ArrayList();
        values.add(new Double(9.0));
        values.add(null);
        values.clear();
        values.add(new Double(9.0));
        values.add(new Double(Double.NaN));
        values = new ArrayList();
        values.add(new Double(9.0));
        values.add(new Double(3.0));
        values.add(new Double(2.0));
        values.add(new Double(2.0));
        double mean = Statistics.calculateMean(values);
        values.add(new Double(Double.NaN));
    }

    static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the calculateMedian(List, boolean) method.
     */
    public void testCalculateMedian() {
        List list = new ArrayList();
        list.add(null);
        boolean pass = false;
        try {
            Statistics.calculateMedian(list, false);
        } catch (NullPointerException e) {
            pass = true;
        }
        pass = false;
        try {
            Statistics.calculateMedian(list, true);
        } catch (NullPointerException e) {
            pass = true;
        }
        list.clear();
        list.add("Not a number");
        pass = false;
        try {
            Statistics.calculateMedian(list, false);
        } catch (ClassCastException e) {
            pass = true;
        }
        pass = false;
        try {
            Statistics.calculateMedian(list, true);
        } catch (ClassCastException e) {
            pass = true;
        }
    }

    /**
     * A test for the calculateMedian() method.
     */
    public void testCalculateMedian1() {
        List values = new ArrayList();
        values.add(new Double(1.0));
        double median = Statistics.calculateMedian(values);
    }

    /**
     * A test for the calculateMedian() method.
     */
    public void testCalculateMedian2() {
        List values = new ArrayList();
        values.add(new Double(2.0));
        values.add(new Double(1.0));
        double median = Statistics.calculateMedian(values);
    }

    /**
     * A test for the calculateMedian() method.
     */
    public void testCalculateMedian3() {
        List values = new ArrayList();
        values.add(new Double(1.0));
        values.add(new Double(2.0));
        values.add(new Double(3.0));
        values.add(new Double(6.0));
        values.add(new Double(5.0));
        values.add(new Double(4.0));
        double median = Statistics.calculateMedian(values);
    }

    /**
     * A test for the calculateMedian() method.
     */
    public void testCalculateMedian4() {
        List values = new ArrayList();
        values.add(new Double(7.0));
        values.add(new Double(2.0));
        values.add(new Double(3.0));
        values.add(new Double(5.0));
        values.add(new Double(4.0));
        values.add(new Double(6.0));
        values.add(new Double(1.0));
        double median = Statistics.calculateMedian(values);
    }

    /**
     * A test using some real data that caused a problem at one point.
     */
    public void testCalculateMedian5() {
        List values = new ArrayList();
        values.add(new Double(11.228692993861783));
        values.add(new Double(11.30823353859889));
        values.add(new Double(11.75312904769314));
        values.add(new Double(11.825102897465314));
        values.add(new Double(10.184252778401783));
        values.add(new Double(12.207951828057766));
        values.add(new Double(10.68841994040566));
        values.add(new Double(12.099522004479438));
        values.add(new Double(11.508874945056881));
        values.add(new Double(12.052517729558513));
        values.add(new Double(12.401481645578734));
        values.add(new Double(12.185377793028543));
        values.add(new Double(10.666372951930315));
        values.add(new Double(11.680978041499548));
        values.add(new Double(11.06528277406718));
        values.add(new Double(11.36876492904596));
        values.add(new Double(11.927565516175939));
        values.add(new Double(11.39307785978655));
        values.add(new Double(11.989603679523857));
        values.add(new Double(12.009834360354864));
        values.add(new Double(10.653351822461559));
        values.add(new Double(11.851776254376754));
        values.add(new Double(11.045441544755946));
        values.add(new Double(11.993674040560624));
        values.add(new Double(12.898219965238944));
        values.add(new Double(11.97095782819647));
        values.add(new Double(11.73234406745488));
        values.add(new Double(11.649006017243991));
        values.add(new Double(12.20549704915365));
        values.add(new Double(11.799723639384919));
        values.add(new Double(11.896208658005628));
        values.add(new Double(12.164149111823424));
        values.add(new Double(12.042795103513766));
        values.add(new Double(12.114839532596426));
        values.add(new Double(12.166609097075824));
        values.add(new Double(12.183017546225935));
        values.add(new Double(11.622009125845342));
        values.add(new Double(11.289365786738633));
        values.add(new Double(12.462984323671568));
        values.add(new Double(11.573494921030598));
        values.add(new Double(10.862867940485804));
        values.add(new Double(12.018186939664872));
        values.add(new Double(10.418046849313018));
        values.add(new Double(11.326344465881341));
        double median = Statistics.calculateMedian(values, true);
        Collections.sort(values);
        double median2 = Statistics.calculateMedian(values, false);
    }

    /**
     * A test for the calculateMedian() method.
     */
    public void testCalculateMedian6() {
        List values = new ArrayList();
        values.add(new Double(7.0));
        values.add(new Double(2.0));
        values.add(new Double(3.0));
        values.add(new Double(5.0));
        values.add(new Double(4.0));
        values.add(new Double(6.0));
        values.add(new Double(1.0));
        double median = Statistics.calculateMedian(values, 0, 2);
    }

    /**
     * A simple test for the correlation calculation.
     */
    public void testCorrelation1() {
        Number[] data1 = new Number[3];
        data1[0] = new Double(1);
        data1[1] = new Double(2);
        data1[2] = new Double(3);
        Number[] data2 = new Number[3];
        data2[0] = new Double(1);
        data2[1] = new Double(2);
        data2[2] = new Double(3);
        double r = Statistics.getCorrelation(data1, data2);
    }

    /**
     * A simple test for the correlation calculation.
     *
     * http://trochim.human.cornell.edu/kb/statcorr.htm
     */
    public void testCorrelation2() {
        Number[] data1 = new Number[20];
        data1[0] = new Double(68);
        data1[1] = new Double(71);
        data1[2] = new Double(62);
        data1[3] = new Double(75);
        data1[4] = new Double(58);
        data1[5] = new Double(60);
        data1[6] = new Double(67);
        data1[7] = new Double(68);
        data1[8] = new Double(71);
        data1[9] = new Double(69);
        data1[10] = new Double(68);
        data1[11] = new Double(67);
        data1[12] = new Double(63);
        data1[13] = new Double(62);
        data1[14] = new Double(60);
        data1[15] = new Double(63);
        data1[16] = new Double(65);
        data1[17] = new Double(67);
        data1[18] = new Double(63);
        data1[19] = new Double(61);
        Number[] data2 = new Number[20];
        data2[0] = new Double(4.1);
        data2[1] = new Double(4.6);
        data2[2] = new Double(3.8);
        data2[3] = new Double(4.4);
        data2[4] = new Double(3.2);
        data2[5] = new Double(3.1);
        data2[6] = new Double(3.8);
        data2[7] = new Double(4.1);
        data2[8] = new Double(4.3);
        data2[9] = new Double(3.7);
        data2[10] = new Double(3.5);
        data2[11] = new Double(3.2);
        data2[12] = new Double(3.7);
        data2[13] = new Double(3.3);
        data2[14] = new Double(3.4);
        data2[15] = new Double(4.0);
        data2[16] = new Double(4.1);
        data2[17] = new Double(3.8);
        data2[18] = new Double(3.4);
        data2[19] = new Double(3.6);
        double r = Statistics.getCorrelation(data1, data2);
    }

    /**
     * Some checks for the getStdDev() method.
     */
    public void testGetStdDev() {
        boolean pass = false;
        try {
            Statistics.getStdDev(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            Statistics.getStdDev(new Double[0]);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }
}
