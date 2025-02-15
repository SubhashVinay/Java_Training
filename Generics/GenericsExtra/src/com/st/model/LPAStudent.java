package com.st.model;

public class LPAStudent extends Student{

    private double percentComplete;

    public LPAStudent() {
        percentComplete=random.nextDouble(100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(),percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
