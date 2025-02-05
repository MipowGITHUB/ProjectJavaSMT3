package main;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MaxFinderTest {

    @Test
    public void testFindMaxWithPositiveNumbers() {
        assertEquals(3, MaxFinder.findMax(1, 2, 3));
        assertEquals(3, MaxFinder.findMax(3, 2, 1));
        assertEquals(3, MaxFinder.findMax(2, 3, 1));
    }

    @Test
    public void testFindMaxWithNegativeNumbers() {
        assertEquals(-1, MaxFinder.findMax(-1, -2, -3));
        assertEquals(-1, MaxFinder.findMax(-3, -2, -1));
        assertEquals(-1, MaxFinder.findMax(-2, -1, -3));
    }

    @Test
    public void testFindMaxWithZeroAndPositiveNumbers() {
        assertEquals(1, MaxFinder.findMax(0, 0, 1));
        assertEquals(1, MaxFinder.findMax(1, 0, 0));
        assertEquals(1, MaxFinder.findMax(0, 1, 0));
    }
}