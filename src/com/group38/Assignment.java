package com.group38;

public interface Assignment extends Rateable, Comparable{
    public float getAvrgRating();
    public int getArrivalDay();
    public String getName();
    public float getRate();
    public boolean isEvaluated();
    public float getRequiredWorkload(); // getting required workload in hours i.e for a 144 min movie 2.4
    public void printRatingReport();
    //public String toString();
}
