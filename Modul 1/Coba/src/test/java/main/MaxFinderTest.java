package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxFinderTest {
    @Test
    public void testFindMaxWithPositiveNumbers() {
        assertEquals(3, MaxFinder.findMax(1, 2, 3));
    }
    @Test
    public void testFindMaxWithNegativeNumbers() {
        assertEquals(-1, MaxFinder.findMax(-1, -2, -3));
    }
    @Test
    public void testFindMaxWithZeroandPositiveNumbers() {
        assertEquals(0, MaxFinder.findMax(0, 0, 1));
    }


}