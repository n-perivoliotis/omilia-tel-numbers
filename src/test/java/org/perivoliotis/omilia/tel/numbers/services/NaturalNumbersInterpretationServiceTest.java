package org.perivoliotis.omilia.tel.numbers.services;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NaturalNumbersInterpretationServiceTest {

    NaturalNumbersInterpretationService service = new NaturalNumbersInterpretationService();

    @Test
    void shouldFindAllPossibleInterpretations() {

        String[] array = new String[]{"2", "10", "69", "30", "6", "6", "4"};
        Set<String> mergeArray = service.execute(array);

        String[] array1 = new String[]{"0", "0", "30", "69", "700", "24", "1", "3", "50", "2"};
        Set<String> mergeArray1 = service.execute(array1);

        assertEquals(4, mergeArray.size());
        assertEquals(16, mergeArray1.size());
    }

}