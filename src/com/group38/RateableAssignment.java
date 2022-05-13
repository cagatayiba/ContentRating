package com.group38;

public abstract class RateableAssignment implements Assignment{
    private int arrivalDay ;
    private float averageRating ;
    private String name ;
    private float workLoad;
    private float rate ;
    private boolean status;

    public RateableAssignment(int day, float rating , String name){
        arrivalDay = day;
        averageRating = rating;
        this.name = name;
        status = false;
    }
    public abstract void printRatingReport();
    public abstract float rate(float criticsOpinion);
    protected void setRate(float rate){
        this.rate = rate;
    }

    public void setStatus(boolean b){
        status = b;
    }

    public float getRequiredWorkload(){return workLoad;}
    protected void setRequiredWorkLoad (float workLoad){this.workLoad = workLoad;}

    @Override
    public float getAvrgRating() {
        return averageRating;
    }

    @Override
    public int getArrivalDay() {
        return arrivalDay;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public float getRate() {
        return rate;
    }

    @Override
    public boolean isEvaluated() {
        return status;
    }

    public int compareTo(Object o) {
        if(o == null){
            System.out.println("compareTo argument is null");
            System.exit(0);
        }else{
            if(o instanceof RateableAssignment){
                RateableAssignment other = (RateableAssignment) o;
                int otherDay = other.getArrivalDay();
                return (otherDay > this.arrivalDay) ? -1 : ((otherDay == this.arrivalDay) ? 0 : +1);
            }else{
                System.out.println("compareTo argument is not an instance of RateableAssignment class ");
                System.exit(0);
            }
        }
        System.out.println("this should not be happen"); // compiler gives error missing return statement however it is impossible to this part of code being executed
        return 0;

    }


    public String toString(){
        return "arrival day : " + getArrivalDay() + " name: " + getName() + " average rating : " + getAvrgRating() + " workload : "
                +getRequiredWorkload() + " status : " + isEvaluated() + " rating from critic : " + getRate();
    }
}
