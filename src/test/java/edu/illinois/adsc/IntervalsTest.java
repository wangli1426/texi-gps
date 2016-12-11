package edu.illinois.adsc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Random;

/**
 * Created by Robert on 12/11/16.
 */
public class IntervalsTest extends TestCase {

    public IntervalsTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(IntervalsTest.class);
    }


    public void testAddSinglePoint() {
        Intervals intervals = new Intervals();
        intervals.addPoint(10);
        assertEquals("[10,10]", intervals.toString());
    }

    public void testAddTwoOverlappingPoints() {
        Intervals intervals = new Intervals();
        intervals.addPoint(10);
        intervals.addPoint(11);
        assertEquals("[10,11]", intervals.toString());
    }

    public void testAddTwoNonOverlappingPoints() {
        Intervals intervals = new Intervals();
        intervals.addPoint(10);
        intervals.addPoint(8);
        intervals.addPoint(12);
        System.out.println(intervals.toString());
        assertEquals("[8,8][10,10][12,12]", intervals.toString());
    }

    public void testAddAnInternalInterval() {
        Intervals intervals = new Intervals();
        intervals.addInterval(new Interval(10, 20));
        intervals.addPoint(15);
        intervals.addInterval(new Interval(12, 18));
        assertEquals("[10,20]", intervals.toString());
    }

    public void testAddConnectPoint() {
        Intervals intervals = new Intervals();
        intervals.addInterval(new Interval(0,5));
        intervals.addInterval(new Interval(7,10));
        intervals.addPoint(6);
        assertEquals("[0,10]", intervals.toString());
    }

    public void testValidityAfterPointInsertionTest1() {
        Intervals intervals = new Intervals();
        Random random = new Random(0);
        final int points = 1000;
        final int range = 1000;
        for (int i = 0; i < points; i++) {
            intervals.addPoint(random.nextInt(range));
        }

        Interval last = null;
        for (Interval interval: intervals.intervals) {
            if (last != null) {
                assertTrue(interval.low <= interval.high);
                assertTrue(last.high < interval.low - 1);
            }
            last = interval;
        }
    }

    public void testValidityAfterPointInsertionTest2() {
        Intervals intervals = new Intervals();
        Random random = new Random(0);
        final int points = 20000;
        final int range = 1000;
        for (int i = 0; i < points; i++) {
            intervals.addPoint(random.nextInt(range));
        }

        Interval last = null;
        for (Interval interval: intervals.intervals) {
            if (last != null) {
                assertTrue(interval.low <= interval.high);
                assertTrue(last.high < interval.low - 1);
            }
            last = interval;
        }
    }

    public void testValidityAfterIntervalInsertionTest1() {
        Intervals intervals = new Intervals();
        Random random = new Random(0);
        final int numberOfInsertions = 1000;
        final int range = 1000;
        for (int i = 0; i < numberOfInsertions; i++) {
            final int a = random.nextInt(range);
            final int b = random.nextInt(range);
            intervals.addInterval(new Interval(Math.min(a, b), Math.max(a, b)));
        }

        Interval last = null;
        for (Interval interval: intervals.intervals) {
            if (last != null) {
                assertTrue(interval.low <= interval.high);
                assertTrue(last.high < interval.low - 1);
            }
            last = interval;
        }
    }


}
