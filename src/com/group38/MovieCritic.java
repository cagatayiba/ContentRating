package com.group38;

public class MovieCritic extends Worker{
    private int moviesEvaluatedThisShift ;  // shift means day here

    public MovieCritic(String name, float opinion) {
        super(name, opinion);
        resetShift();
    }

    public MovieCritic(String name, Assignment assignment, float opinion) {
        super(name, assignment, opinion);
        resetShift();
    }



    @Override
    public void resetShift() {
        moviesEvaluatedThisShift = 0  ;
    }

    @Override
    public boolean isShiftOver() {
        return (moviesEvaluatedThisShift == 1);
    }

    @Override
    public boolean assignTo(Assignment assignment) {
        if (assignment instanceof Movie){
            if (isAssignable()){
                setAssignment(assignment);
                setCurrentWorkLoad(assignment.getRequiredWorkload());
                return true;
            }else {
                System.out.printf("Movie critic " + getName() + " is not assignable ");
                if (!isAssigned()) {
                    System.out.printf("his/her shift is over\n");

                } else {
                    System.out.printf("he/she has already has an assignment\n");

                }
                return false;
            }
        }else{
            System.out.println("A movie critic can only be assigned to movies");
            return false;
        }
    }

    @Override
    public boolean workHourly() {
        if (isAssigned()){
            if (isShiftOver()){
                System.out.println(getName() + " cant work since his/her shift is over");
                return false;
            }else{
                if (isFinishedAssignment()){
                    System.out.println(getName() + " has already finished his/her assignment.");
                    return false;
                }
                setCurrentWorkLoad(getCurrentWorkLoad() - 60);    // current workload is in minutes for movie critic thus we subtract 60
                if (getCurrentWorkLoad() < 0){                    // when movie critics works one hour workload may be negative but we reset it to 0
                    setCurrentWorkLoad(0);                        // negative workload is meaningless
                }
                if (getCurrentWorkLoad() == 0){
                    evaluateAssignment();
                    moviesEvaluatedThisShift ++;
                }
                return true;
            }

        }else{
            System.out.println(getName() + " cant work since he/she is not assigned to an assignment");
            return false;
        }

    }
}
