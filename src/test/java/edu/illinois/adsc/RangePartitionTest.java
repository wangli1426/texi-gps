package edu.illinois.adsc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by Robert on 12/10/16.
 */
public class RangePartitionTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RangePartitionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RangePartitionTest.class);
    }

    public void testPartitionInt() {
        RangePartition partition = new RangePartition(10, 0, 100);
        assertEquals(0, partition.getPartition(-10000));
        assertEquals(0, partition.getPartition(-5));
        assertEquals(0, partition.getPartition(0));
        assertEquals(1, partition.getPartition(11));
        assertEquals(9, partition.getPartition(100));
    }

    public void testPartitionDouble() {
        RangePartition partition = new RangePartition(10, -100.0, 100.0);
        assertEquals(0, partition.getPartition(-10000));
        assertEquals(0, partition.getPartition(-99));
        assertEquals(5, partition.getPartition(0));
        assertEquals(9, partition.getPartition(99));
        assertEquals(9, partition.getPartition(1000000));
    }


}
