package com.group38;

public abstract  class Worker implements Critic {
    private String name;
    private Assignment assignment ;
    private float currentWorkLoad ;    // needed work that must be done in order to finish the assignment (in hours for game critics in minutes for movie critic)
    private float opinion ;

    public Worker(){};

    public Worker (String name, float opinion){
        this.name = name;
        this.opinion = opinion;
    }

    public Worker(String name, Assignment assignment, float opinion) {
        this.name = name;
        this.assignment = assignment;
        this.opinion = opinion;
        setCurrentWorkLoad(assignment.getRequiredWorkload());
    }
    protected Assignment getAssignment(){return assignment;}
    protected void setAssignment(Assignment assignment){this.assignment = assignment ;}
    protected float getCurrentWorkLoad() {return currentWorkLoad;}
    protected void setCurrentWorkLoad(float currentWorkLoad) {this.currentWorkLoad = currentWorkLoad;}
    public float getOpinion(){return opinion;}
    public String getName(){return name;}

    public abstract void resetShift();
    public abstract boolean isShiftOver();
    public abstract boolean assignTo(Assignment assignment);
    public abstract boolean workHourly();

    public boolean isAssignable(){
        return (!isShiftOver() && assignment == null);
    }
    public boolean isFinishedAssignment(){
        return (currentWorkLoad == 0 && isAssigned());
    }
    public boolean isAssigned(){
        return (assignment != null);
    }

    public Assignment handOverAssignment(){
        Assignment temp = assignment;
        assignment = null;
        return temp;
    }

    public String giveReport(){
        if (isAssigned()){
            String evaluationStatus = isFinishedAssignment() ? "evaluated" : "works on" ;
            return getName()  + " "  + evaluationStatus + " (" + assignment.getName() + ")";
        }else{
            return "critic isn't working on anything"; // this should not happen
        }

    }

    protected void evaluateAssignment(){
        assignment.rate(opinion);
    }




}
