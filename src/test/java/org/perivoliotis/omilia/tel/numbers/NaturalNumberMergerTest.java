package org.perivoliotis.omilia.tel.numbers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberMergerTest {

    NaturalNumberMerger naturalNumberMerger = new NaturalNumberMerger();

    @Test
    void shouldMergeTwoDigitsAtMiddlePosition() {

        String[] array = new String[]{"2", "70", "3", "12"};
        String[] mergeArray = naturalNumberMerger.createMergeArray(array, 1);

        assertAll("mergeArray",
                () -> assertEquals("2", mergeArray[0]),
                () -> assertEquals("73", mergeArray[1]),
                () -> assertEquals("12", mergeArray[2])
        );
    }

    @Test
    void shouldMergeTwoDigitsAtStartPosition() {

        String[] array = new String[]{"20", "7", "3"};
        String[] mergeArray = naturalNumberMerger.createMergeArray(array, 0);

        assertAll("mergeArray",
                () -> assertEquals("27", mergeArray[0]),
                () -> assertEquals("3", mergeArray[1])
        );
    }

    @Test
    void shouldMergeTwoDigitsAtEndPosition() {

        String[] array = new String[]{"2", "70", "3"};
        String[] mergeArray = naturalNumberMerger.createMergeArray(array, 1);

        assertAll("mergeArray",
                () -> assertEquals("2", mergeArray[0]),
                () -> assertEquals("73", mergeArray[1])
        );
    }

    @Test
    void shouldMergeThreeDigits() {

        String[] array = new String[]{"2", "700", "35", "12"};
        String[] mergeArray = naturalNumberMerger.createMergeArray(array, 1);

        assertAll("mergeArray",
                () -> assertEquals("2", mergeArray[0]),
                () -> assertEquals("735", mergeArray[1]),
                () -> assertEquals("12", mergeArray[2])
        );
    }

    @Test
    void shouldCreateAllTwoDigitsMerges() {

        String[] array = new String[]{"2", "60", "9", "30", "1"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberMerger.generateTwoDigitMerges(array, result);

        assertEquals(4, result.size());
    }

    @Test
    void shouldNotCreateTwoDigitsMergesWith10() {

        String[] array = new String[]{"2", "10", "9", "30", "1"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberMerger.generateTwoDigitMerges(array, result);

        assertEquals(2, result.size());
    }

    @Test
    void shouldNotCreateTwoDigitsMergesWhenNotDividedBy10() {

        String[] array = new String[]{"2", "23", "9", "30", "1"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberMerger.generateTwoDigitMerges(array, result);

        assertEquals(2, result.size());
    }

    @Test
    void shouldNotCreateTwoDigitsMergesWhenFollowedByNon1Digit() {

        String[] array = new String[]{"2", "20", "90", "30", "1"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberMerger.generateTwoDigitMerges(array, result);

        assertEquals(2, result.size());
    }

    @Test
    void shouldCreateAllThreeDigitsMerges() {

        String[] array = new String[]{"2", "600", "76", "100", "1"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberMerger.generateThreeDigitMerges(array, result);

        assertEquals(4, result.size());
    }
    
}