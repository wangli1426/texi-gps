package edu.illinois.adsc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Created by Robert on 12/10/16.
 */
public class ZOrderCodingTest extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ZOrderCodingTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ZOrderCodingTest.class);
    }

    public void testZOrderCoding() {
        ZOrderCoding zOrderCoding = new ZOrderCoding(256);
        assertEquals(0, zOrderCoding.getZCode(0, 0));
        assertEquals(1, zOrderCoding.getZCode(1, 0));
        assertEquals(12, zOrderCoding.getZCode(2, 2));
        assertEquals(52, zOrderCoding.getZCode(6, 4));
    }


    public void testZOrderCodingRectangleSearch1() {
        ZOrderCoding zOrderCoding = new ZOrderCoding(256);
        List<Integer> codes = zOrderCoding.getZCodesInRectangle(0, 4, 0, 1);
        assertEquals(10, codes.size());
        assertTrue(codes.contains(0));
        assertTrue(codes.contains(1));
        assertTrue(codes.contains(2));
        assertTrue(codes.contains(3));
        assertTrue(codes.contains(4));
        assertTrue(codes.contains(5));
        assertTrue(codes.contains(6));
        assertTrue(codes.contains(7));
        assertTrue(codes.contains(16));
        assertTrue(codes.contains(18));
    }

    public void testZOrderCodingRectangleSearch2() {
        ZOrderCoding zOrderCoding = new ZOrderCoding(256);
        List<Integer> codes = zOrderCoding.getZCodesInRectangle(4, 5, 6, 7);
        assertTrue(codes.contains(56));
        assertTrue(codes.contains(57));
        assertTrue(codes.contains(58));
        assertTrue(codes.contains(59));
    }

    public void testZOrderIntervalsOfCodesRectangleSearch() {
        ZOrderCoding zOrderCoding = new ZOrderCoding(256);
        Intervals intervals = zOrderCoding.getIntervalsOfCodesInRectangle(4, 5, 6, 7);
        assertEquals("[56,59]", intervals.toString());
    }

    public void testZOrderMaxValue() {
        ZOrderCoding zOrderCoding = new ZOrderCoding(8);
        assertEquals(64, zOrderCoding.getMaxZCode());
    }

}
