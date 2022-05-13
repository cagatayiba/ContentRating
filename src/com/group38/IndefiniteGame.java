package com.group38;

public class IndefiniteGame extends RateableAssignment implements Game{
    int evalTime;
    public static final GameType TYPE = GameType.INDEFINITE;
    public IndefiniteGame (int day, float rating , String name , int evalTime){
        super(day , rating , name);
        this.evalTime = evalTime;
        setRequiredWorkLoad(4);
    }

    public int getEvalTime() {
        return evalTime;
    }

    @Override
    public GameType getGameType() {
        return TYPE;
    }

    @Override
    public float rate(float criticsOpinion) {
        float rate = (float)(getAvrgRating() + ((10 - getEvalTime()) * 0.25)  + criticsOpinion);
        setRate(rate);
        setStatus(true);
        return rate;
    }

    @Override
    public void printRatingReport(){
        String rating = isEvaluated() ? Float.toString(getRate())  : " not rated";
        System.out.println(getName() +  ", " + rating);
    }

    public String toString(){
        String temp = TYPE + " GAME\n";
        temp += super.toString() + " evaluation time: "  + getEvalTime() + "\n";
        return temp;
    }
}
