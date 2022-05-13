package com.group38;

public class StoryGame extends RateableAssignment implements Game{
    private int storyDuration ;
    public static final GameType TYPE = GameType.STORY;

    public StoryGame(int day, float rating , String name , int storyDuration){
        super(day , rating , name);
        this.storyDuration = storyDuration;
        setRequiredWorkLoad(storyDuration);
    }

    public int getStoryDuration() {
        return storyDuration;
    }

    @Override
    public GameType getGameType() {
        return TYPE;
    }


    @Override
    public float rate(float criticsOpinion) {
        float rate = (float)(getAvrgRating() + (getStoryDuration() * 0.25) + criticsOpinion);
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
        temp += super.toString() + " story duration : "  + getStoryDuration() + "\n";
        return temp;
    }
}
