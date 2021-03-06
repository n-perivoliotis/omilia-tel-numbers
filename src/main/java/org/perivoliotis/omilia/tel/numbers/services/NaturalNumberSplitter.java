package org.perivoliotis.omilia.tel.numbers.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NaturalNumberSplitter {

    Set<List<String>> split(String[] array) {
        Set<List<String>> result3D = new HashSet<>();
        Set<List<String>> result2D = new HashSet<>();

        generateThreeDigitSplits(array, result3D);

        result3D.forEach(r -> generateTwoDigitSplits(r.toArray(new String[0]), result2D));
        return result2D;
    }

    void generateTwoDigitSplits(String[] array, Set<List<String>> generatedSet) {

        generatedSet.add(Stream.of(array).collect(Collectors.toList()));

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == 2 && Integer.parseInt(array[i]) > 20 && Integer.parseInt(array[i]) % 10 != 0) {
                String[] split = createSplitArray(array, i, 1);
                generateTwoDigitSplits(split, generatedSet);
            }
        }
    }

    void generateThreeDigitSplits(String[] array, Set<List<String>> generatedSet) {

        generatedSet.add(Stream.of(array).collect(Collectors.toList()));

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == 3 && Integer.parseInt(array[i]) > 100 && Integer.parseInt(array[i]) % 100 != 0) {
                String[] split = createSplitArray(array, i, 2);
                generateThreeDigitSplits(split, generatedSet);
            }
        }
    }

    String[] createSplitArray(String[] original, int position, int powerOfTen) {

        String[] splitArray = new String[original.length+1];

        if (position >= 0) System.arraycopy(original, 0, splitArray, 0, position);

        splitArray[position] = String.valueOf(Integer.parseInt(original[position]) / (int) Math.pow(10, powerOfTen) * (int) Math.pow(10, powerOfTen));
        splitArray[position+1] = String.valueOf(Integer.parseInt(original[position]) % (int) Math.pow(10, powerOfTen));

        if (original.length + 1 - (position + 2) >= 0)
            System.arraycopy(original, position + 1, splitArray, position + 2, original.length + 1 - (position + 2));

        return splitArray;
    }
}
