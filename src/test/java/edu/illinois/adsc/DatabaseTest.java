package edu.illinois.adsc;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by robert on 14/12/16.
 */
public class DatabaseTest extends TestCase {

    public void testStorage() {
        Database<Integer, Integer> database = new Database<>();
        database.put(1, 2);
        database.put(2, 3);
        database.put(1, 4);
        Collection<Integer> found = database.rangeSearch(1, 3);
        assertEquals(3, found.size());
        assertTrue(found.contains(2));
        assertTrue(found.contains(3));
        assertTrue(found.contains(4));
    }

    public void testPredicate() {
        Database<Integer, Integer> database = new Database<>();
        database.put(1, 2);
        database.put(2, 3);
        database.put(3, 4);
        database.put(4, 5);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Collection<Integer> found = database.reangeSearch(1, 5, predicate);
        assertEquals(2, found.size());
        assertTrue(found.contains(2));
        assertTrue(found.contains(4));


    }
}
