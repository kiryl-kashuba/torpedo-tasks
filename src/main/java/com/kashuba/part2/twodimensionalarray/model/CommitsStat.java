package com.kashuba.part2.twodimensionalarray.model;

public class CommitsStat {

    private final String name;
    private Integer commitsNumber;
    private Integer monthsNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommitsStat that = (CommitsStat) o;

        if (!name.equals(that.name)) return false;
        if (!commitsNumber.equals(that.commitsNumber)) return false;
        return monthsNumber.equals(that.monthsNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + commitsNumber.hashCode();
        result = 31 * result + monthsNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CommitStat{" +
                "name='" + name + '\'' +
                ", commitNumber=" + commitsNumber +
                ", monthNumber=" + monthsNumber +
                '}';
    }

    public CommitsStat(String name) {
        this.name = name;
        this.commitsNumber = 0;
        this.monthsNumber = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getCommitsNumber() {
        return commitsNumber;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public void addCommits(Integer commitsNumber) {
        this.commitsNumber += commitsNumber;
        monthsNumber++;
    }
}
