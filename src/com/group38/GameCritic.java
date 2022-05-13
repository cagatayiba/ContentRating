package com.group38;

public class GameCritic extends Worker implements IGameCritic{
    private static final int MAX_SHIFT_HOUR = 8;
    private int remainingShiftHour ;

    public GameCritic(String name, Assignment assignment, float opinion) {
        super(name, assignment , opinion);
        this.remainingShiftHour = MAX_SHIFT_HOUR;
    }
    public GameCritic(String name, float opinion) {
        super(name, opinion);
        this.remainingShiftHour = MAX_SHIFT_HOUR;
    }
    public boolean assignTo(Assignment assignment){
        if (assignment instanceof Game){
            if(isAssignable()){
                setAssignment(assignment);
                setCurrentWorkLoad(assignment.getRequiredWorkload());
                return true;
            }else{
                System.out.printf("Game critic " + getName() + " is not assignable ");
                if(isShiftOver()){
                    System.out.printf("his/her shift is over");
                }else{
                    System.out.printf("he/she has already has an assignment");
                }
                return false;
            }

        }else{
            System.out.println("A game critic can only be assigned to games");
            return false;
        }

    }
    public  boolean workHourly(){
        if (isAssigned()){
            if (isShiftOver()){
                System.out.println(getName() + " cant work since his/her shift is over");
                return false;
            }else{
                if (isFinishedAssignment()){
                    System.out.println(getName() + " has already finished his/her assignment.");
                    return false;
                }

                setCurrentWorkLoad(getCurrentWorkLoad() - 1);
                if (getCurrentWorkLoad() == 0){
                    evaluateAssignment();
                }
                remainingShiftHour --;
                return true;
            }

        }else{
            System.out.println(getName() + " cant work since he/she is not assigned to an assignment");
            return false;
        }

    }

    @Override
    public boolean isShiftOver() {
        return (remainingShiftHour <= 0);
    }

    public void resetShift(){
        remainingShiftHour = MAX_SHIFT_HOUR;
    }
}
