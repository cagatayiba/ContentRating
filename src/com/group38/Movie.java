package com.group38;

public class Movie extends RateableAssignment{
    public int duration ;
    public int year ;
    public Movie(int day , float rating , String name, int duration, int year){
        super(day,rating ,name);
        this.duration = duration;
        this.year = year;
        setRequiredWorkLoad(getDuration()); // required workload in minutes
    }

    public int getDuration() {
        return duration;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void printRatingReport(){
        String rating = isEvaluated() ? Float.toString(getRate())  : " not rated";
        System.out.println(getName() + " " + "(" + getYear() + ")" + ", " + rating);
    }


    @Override
    public float rate(float criticsOpinion) {
        float rate = (float)(getAvrgRating() + ((getDuration() - 150) * 0.01) - ((2021 - year) * 0.01) + criticsOpinion);
        setRate(rate);
        setStatus(true);
        return rate;
    }



    public String toString(){
        String temp = "MOVIE\n";
        temp += super.toString() + " duration : " + getDuration() + " year : " + getYear() + "\n";
        return temp;
    }
}
