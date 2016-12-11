package edu.illinois.adsc;

import junit.framework.TestCase;

/**
 * Created by Robert on 12/11/16.
 */
public class CityTest extends TestCase{

    public void testCityIntervals() {
        City city = new City(0, 100, 0, 200, 10);
        Intervals intervals = city.getZCodeIntervalsUnderARectagle(20, 30, 80, 100);
        assertEquals("[36,39]", intervals.toString());
    }
}
