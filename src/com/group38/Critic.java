package com.group38;

public interface Critic {
    public boolean isFinishedAssignment();
    public boolean isShiftOver();
    public boolean isAssignable();
    public boolean workHourly();
    public Assignment handOverAssignment();
    public String giveReport();
    public boolean assignTo(Assignment assignment);
    public float getOpinion();
    public String getName();
    public boolean isAssigned();
    public void resetShift();

}
