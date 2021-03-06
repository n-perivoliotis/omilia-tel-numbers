package org.perivoliotis.omilia.tel.numbers.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NaturalNumberMerger {

    Set<List<String>> merge(String[] array) {
        Set<List<String>> result3D = new HashSet<>();
        Set<List<String>> result2D = new HashSet<>();

        generateThreeDigitMerges(array, result3D);

        result3D.forEach(r -> generateTwoDigitMerges(r.toArray(new String[0]), result2D));
        return result2D;
    }

    void generateTwoDigitMerges(String[] array, Set<List<String>> generatedSet) {

        generatedSet.add(Stream.of(array).collect(Collectors.toList()));

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].length() == 2 && array[i+1].length() == 1 && Integer.parseInt(array[i]) >= 20
                    && Integer.parseInt(array[i]) % 10 == 0) {
                String[] merged = createMergeArray(array, i);
                generateTwoDigitMerges(merged, generatedSet);
            }
        }
    }

    void generateThreeDigitMerges(String[] array, Set<List<String>> generatedSet) {

        generatedSet.add(Stream.of(array).collect(Collectors.toList()));

        for (int i = 0; i < array.length -1; i++) {
            if (array[i].length() == 3 && array[i+1].length() <= 2 && Integer.parseInt(array[i]) >= 100
                    && Integer.parseInt(array[i]) % 10 == 0) {
                String[] merged = createMergeArray(array, i);
                generateThreeDigitMerges(merged, generatedSet);
            }
        }
    }

    String[] createMergeArray(String[] original, int position) {

        String[] mergeArray = new String[original.length-1];

        if (position >= 0) System.arraycopy(original, 0, mergeArray, 0, position);

        mergeArray[position] = String.valueOf(Integer.parseInt(original[position]) + Integer.parseInt(original[position+1]));

        if (original.length - 1 - (position + 1) >= 0)
            System.arraycopy(original, position + 2, mergeArray, position + 1, original.length - 1 - (position + 1));

        return mergeArray;
    }
}
