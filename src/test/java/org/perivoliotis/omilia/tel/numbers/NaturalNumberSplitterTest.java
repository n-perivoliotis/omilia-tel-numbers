package org.perivoliotis.omilia.tel.numbers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberSplitterTest {

    NaturalNumberSplitter naturalNumberSplitter = new NaturalNumberSplitter();

    @Test
    void shouldSplitTwoDigitsAtMiddlePosition() {

        String[] array = new String[]{"2", "69", "70"};
        String[] splitArray = naturalNumberSplitter.createSplitArray(array, 1, 1);

        assertAll("splitArray",
                () -> assertEquals("2", splitArray[0]),
                () -> assertEquals("60", splitArray[1]),
                () -> assertEquals("9", splitArray[2]),
                () -> assertEquals("70", splitArray[3])
        );
    }

    @Test
    void shouldSplitTwoDigitsAtStartPosition() {

        String[] array = new String[]{"21", "69", "70"};
        String[] splitArray = naturalNumberSplitter.createSplitArray(array, 0, 1);

        assertAll("splitArray",
                () -> assertEquals("20", splitArray[0]),
                () -> assertEquals("1", splitArray[1]),
                () -> assertEquals("69", splitArray[2]),
                () -> assertEquals("70", splitArray[3])
        );
    }

    @Test
    void shouldSplitTwoDigitsAtEndPosition() {

        String[] array = new String[]{"2", "69", "76"};
        String[] splitArray = naturalNumberSplitter.createSplitArray(array, 2, 1);

        assertAll("splitArray",
                () -> assertEquals("2", splitArray[0]),
                () -> assertEquals("69", splitArray[1]),
                () -> assertEquals("70", splitArray[2]),
                () -> assertEquals("6", splitArray[3])
        );
    }

    @Test
    void shouldSplitThreeDigits() {

        String[] array = new String[]{"2", "698", "70"};
        String[] splitArray = naturalNumberSplitter.createSplitArray(array, 1, 2);

        assertAll("splitArray",
                () -> assertEquals("2", splitArray[0]),
                () -> assertEquals("600", splitArray[1]),
                () -> assertEquals("98", splitArray[2]),
                () -> assertEquals("70", splitArray[3])
        );
    }

    @Test
    void shouldCreateAllTwoDigitsSplits() {

        String[] array = new String[]{"2", "69", "76"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberSplitter.generateTwoDigitSplits(array, result);

        assertEquals(4, result.size());
    }

    @Test
    void shouldNotCreateTwoDigitsSplitsWhenNoTwoDigitNumbersExist() {

        String[] array = new String[]{"2", "69546", "765"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberSplitter.generateTwoDigitSplits(array, result);

        assertEquals(1, result.size());
    }

    @Test
    void shouldNotCreateTwoDigitsSplitsEmptyArray() {

        String[] array = new String[]{};
        Set<List<String>> result = new HashSet<>();
        naturalNumberSplitter.generateTwoDigitSplits(array, result);

        assertEquals(1, result.size());
    }

    @Test
    void shouldCreateAllThreeDigitsSplits() {

        String[] array = new String[]{"2", "698", "769"};
        Set<List<String>> result = new HashSet<>();
        naturalNumberSplitter.generateThreeDigitSplits(array, result);

        assertEquals(4, result.size());
    }

    @Test
    void shouldCreateAllTwoAndThreeDigitsSplits() {

        String[] array = new String[]{"21", "60", "769"};
        Set<List<String>> result = naturalNumberSplitter.split(array);

        assertEquals(6, result.size());
    }
}