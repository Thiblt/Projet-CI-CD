package fr.diginamic.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testLevenshteinDistanceSameStrings() {
        assertEquals(0, StringUtils.levenshteinDistance("test", "test"));
    }

    @Test
    public void testLevenshteinDistanceInsertions() {
        assertEquals(1, StringUtils.levenshteinDistance("test", "tests"));
    }

    @Test
    public void testLevenshteinDistanceDeletions() {
        assertEquals(1, StringUtils.levenshteinDistance("tests", "test"));
    }

    @Test
    public void testLevenshteinDistanceReplacements() {
        assertEquals(1, StringUtils.levenshteinDistance("test", "tast"));
    }

    @Test
    public void testLevenshteinDistanceEmptyStrings() {
        assertEquals(0, StringUtils.levenshteinDistance("", ""));
    }

    @Test
    public void testLevenshteinDistanceFirstStringEmpty() {
        assertEquals(4, StringUtils.levenshteinDistance("", "test"));
    }

    @Test
    public void testLevenshteinDistanceSecondStringEmpty() {
        assertEquals(4, StringUtils.levenshteinDistance("test", ""));
    }

    @Test
    public void testLevenshteinDistanceComplexeDifference() {
        assertEquals(4, StringUtils.levenshteinDistance("trompette", "tremper"));
    }
}