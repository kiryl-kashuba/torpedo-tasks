package com.kashuba.part2.listofnames;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Solution {

    public void modifyNames(List<String> names) {
        List<String> modifiedNames = names.stream()
                .filter(s -> "A".indexOf(s.charAt(0)) == 0)
                .map(String::toUpperCase)
                .toList();

        printNames(modifiedNames);
    }


    private void printNames(List<String> modifiedList) {
        Consumer<String> printConsumer = System.out::println;

        Optional<List<String>> optionalNames = Optional.of(modifiedList);
        optionalNames.ifPresentOrElse(
                names -> modifiedList.forEach(printConsumer),
                () -> System.out.println("No results")

        );
    }
}
