package com.group38;

public class CasualGame extends RateableAssignment implements Game{
    int matchDuration ;
    public static final GameType TYPE = GameType.CASUAL;

    public CasualGame(int day, float rating , String name , int matchDuration){
        super(day , rating , name);
        this.matchDuration = matchDuration;
        setRequiredWorkLoad(3*matchDuration);
    }

    public int getMatchDuration() {
        return matchDuration;
    }

    @Override
    public GameType getGameType() {
        return TYPE;
    }

    @Override
    public float rate(float criticsOpinion) {
        float rate = getAvrgRating() + ((matchDuration - 3) * 3) + criticsOpinion;
        setRate(rate);
        setStatus(true);
        return  rate;
    }

    @Override
    public void printRatingReport(){
        String rating = isEvaluated() ? Float.toString(getRate())  : " not rated";
        System.out.println(getName() +  ", " + rating);
    }

    public String toString(){
        String temp = TYPE + " GAME\n";
        temp += super.toString() + " match duration : "  + getMatchDuration() + "\n";
        return temp;
    }
}
