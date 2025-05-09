package com.kashuba.part2.listofnames;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testModifyNames() {
        Solution solution = new Solution();
        List<String> names = List.of("Anna", "Bartek", "Celina", "Adam", "Aga", "Filip");

        solution.modifyNames(names);
    }
}