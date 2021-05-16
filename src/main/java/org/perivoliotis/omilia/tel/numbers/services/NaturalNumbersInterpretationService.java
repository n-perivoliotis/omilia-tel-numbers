package org.perivoliotis.omilia.tel.numbers.services;

import java.util.Set;
import java.util.stream.Collectors;

public class NaturalNumbersInterpretationService {

    NaturalNumberSplitter splitter = new NaturalNumberSplitter();

    NaturalNumberMerger merger = new NaturalNumberMerger();

    public Set<String> execute(String[] spelledNumber) {

        return splitter.split(spelledNumber).stream()
                .map(sp -> merger.merge(sp.toArray(new String[0])))
                .flatMap(Set::stream)
                .map(sa -> String.join("", sa)).collect(Collectors.toSet());
    }

}
