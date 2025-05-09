package com.kashuba.part2.twodimensionalarray;

import com.kashuba.part2.twodimensionalarray.model.AverageCommits;
import com.kashuba.part2.twodimensionalarray.model.CommitsStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<AverageCommits> calculateAverage(String[][] monthCommits) {
        Map<String, CommitsStat> countedMonthCommits = gridToMap(monthCommits);
        List<AverageCommits> sortedCommitsStats = mapToList(countedMonthCommits);

        sortedCommitsStats.sort((a, b) -> Double.compare(b.getAverageCommitsNumber(), a.getAverageCommitsNumber()));
        return sortedCommitsStats;
    }

    private Map<String, CommitsStat> gridToMap(String[][] monthCommits) {
        Map<String, CommitsStat> countedMonthCommits = new HashMap<>();

        for (String[] monthCommit : monthCommits) {
            String rawName = monthCommit[0];
            String commitsNumber = monthCommit[1];
            if (monthCommit.length > 2 || rawName == null ||
                commitsNumber == null || commitsNumber.isEmpty() || rawName.isEmpty()) { // All these "||" in one place is NOT okay. But I don't have better idea for now
                continue;
            }
            int intCommitsNumber;
            try {
                intCommitsNumber = Integer.parseInt(commitsNumber);
            } catch (NumberFormatException e) {
                continue;
            }
            String name = capitalizeFirstLetter(rawName);

            countedMonthCommits.computeIfAbsent(name, k -> new CommitsStat(name))
                    .addCommits(intCommitsNumber);
        }
        return countedMonthCommits;
    }

    private List<AverageCommits> mapToList(Map<String, CommitsStat> countedMonthCommits) { // I shouldn't return it as a List, but I took "presents them as a list" too literal and didn't clarify this moment
        List<AverageCommits> sortedCommitsStats = new ArrayList<>();

        for (Map.Entry<String, CommitsStat> countedMonthCommit : countedMonthCommits.entrySet()) {
            String name = countedMonthCommit.getKey();
            CommitsStat value = countedMonthCommit.getValue();

            Double average = (double) value.getCommitsNumber() / value.getMonthsNumber();

            sortedCommitsStats.add(new AverageCommits(name, average));
        }
        return sortedCommitsStats;
    }


    private String capitalizeFirstLetter(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }
}
