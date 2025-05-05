package com.kashuba.part2.twodimensionalarray.model;

import java.util.Objects;

public class AverageCommits {

    private final String name;
    private Double AverageCommits;

    public AverageCommits(String name, Double averageCommits) {
        this.name = name;
        AverageCommits = averageCommits;
    }

    public String getName() {
        return name;
    }

    public Double getAverageCommits() {
        return AverageCommits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AverageCommits that = (AverageCommits) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(AverageCommits, that.AverageCommits);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (AverageCommits != null ? AverageCommits.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AverageCommits{" +
                "name='" + name + '\'' +
                ", AverageCommits=" + AverageCommits +
                '}';
    }


}
