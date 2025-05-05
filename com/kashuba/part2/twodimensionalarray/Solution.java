package com.kashuba.part2.twodimensionalarray;

import com.kashuba.part2.twodimensionalarray.model.AverageCommits;
import com.kashuba.part2.twodimensionalarray.model.CommitsStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  // return the list with Comparator to have an order
  // HashMap<String, Integer[][]> or HashMap<String, List<Integer>>
  public List<AverageCommits> calculateAverage(String[][] monthCommits) {
    Map<String, CommitsStat> countedMonthCommits = gridToMap(monthCommits);
    List<AverageCommits> sortedCommitsStats = mapToList(countedMonthCommits);

    sortedCommitsStats.sort((a, b) -> Double.compare(b.getAverageCommits(), a.getAverageCommits()));
    return sortedCommitsStats;
  }


  private List<AverageCommits> mapToList(Map<String, CommitsStat> countedMonthCommits) {
    List<AverageCommits> sortedCommitsStats = new ArrayList<>();

    for (Map.Entry<String, CommitsStat> countedMonthCommit : countedMonthCommits.entrySet()) {
      String name = countedMonthCommit.getKey();
      CommitsStat value = countedMonthCommit.getValue();

      Double average = (double) value.getCommitsNumber() / value.getMonthsNumber();

      sortedCommitsStats.add(new AverageCommits(name, average));
    }

    return sortedCommitsStats;
  }

  private Map<String, CommitsStat> gridToMap(String[][] monthCommits) {
    Map<String, CommitsStat> countedMonthCommits = new HashMap<>();

    for (String[] monthCommit : monthCommits) {
      String name = capitalizeFirstLetter(monthCommit[0]);
      Integer commitsNumber = Integer.parseInt(monthCommit[1]);

      countedMonthCommits.computeIfAbsent(name, k -> new CommitsStat(name))
          .addCommits(commitsNumber);
    }
    return countedMonthCommits;
  }

  private String capitalizeFirstLetter(String name) {
    if (name == null || name.isEmpty()) {
      return name;
    }
    name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    return name;
  }
}
