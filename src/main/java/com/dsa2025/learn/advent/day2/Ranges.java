package com.dsa2025.learn.advent.day2;


public class Ranges {

    private Long firstId;
    private Long secondId;

    public Ranges(Long firstId, Long secondId) {
        this.firstId = firstId;
        this.secondId = secondId;
    }

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    @Override
    public String toString() {
        return "Ranges{" +
                "firstId=" + firstId +
                ", secondId=" + secondId +
                '}';
    }
}
