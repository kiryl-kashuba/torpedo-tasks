package com.kashuba.part2.twodimensionalarray.model;

import java.util.Objects;

public class AverageCommits {

    private final String name;
    private final Double averageCommitsNumber;

    public AverageCommits(String name, Double averageCommitsNumber) {
        this.name = name;
        this.averageCommitsNumber = averageCommitsNumber;
    }

    public Double getAverageCommitsNumber() {
        return averageCommitsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AverageCommits that = (AverageCommits) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(averageCommitsNumber, that.averageCommitsNumber);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (averageCommitsNumber != null ? averageCommitsNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AverageCommits{" +
                "name='" + name + '\'' +
                ", AverageCommits=" + averageCommitsNumber +
                '}';
    }
}
