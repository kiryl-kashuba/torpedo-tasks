package com.kashuba.part2.listofnames;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Solution {

    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    public void modifyNames(List<String> names) {
        List<String> modifiedNames = names.stream()
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .toList();

        printNames(modifiedNames);
    }

    private void printNames(List<String> modifiedList) {
        Consumer<String> printConsumer = logger::info;

        Optional.ofNullable(modifiedList)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        names -> names.forEach(printConsumer),
                        () -> logger.info("No results")

                );
    }
}
