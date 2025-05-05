package com.kashuba.part2.twodimensionalarray;

import com.kashuba.part2.twodimensionalarray.model.AverageCommits;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

  private static final Logger logger = Logger.getLogger(SolutionTest.class.getName());


  @Test
  public void testCalculateAverage() {
    Solution solution = new Solution();

    String[][] monthCommits = {{"Mikolaj", "10"}, {"SONIA", "53"}, {"MIKOLAJ", "30"},
        {"SONIA", "40"}, {"HUBERT", "25"}};

    List<AverageCommits> resultList = solution.calculateAverage(monthCommits);
    logger.info(resultList.toString());
  }
}