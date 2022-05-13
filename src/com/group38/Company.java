package com.group38;

import java.util.*;

public class Company {
    private Stack<Assignment> gameContents ;
    private Stack<Assignment> movieContents ;
    private Queue<Critic> notAssignedCritics ;
    private List<Critic> assignedCritic ;
    private List<Assignment> evaluatedAssignments ;
    public Company(){

    }
    public Company (List<Critic> critics){
        notAssignedCritics = new LinkedList<Critic>() ;
        setCritics(critics);
        gameContents = new Stack<Assignment>();
        movieContents = new Stack<Assignment>();
        assignedCritic = new ArrayList<Critic>();
        evaluatedAssignments = new ArrayList<Assignment>();
    }
    public void getAssignments(List<Assignment> given){
        Iterator<Assignment> iter = given.iterator();
        Assignment token = null;
        while (iter.hasNext()){
            token = iter.next();
            getToken(token);
        }

    }
    public void runForOneDay(){                         //Company works for 24 hours
        newDay();
        for(int hour = 0 ; hour < 24 ; hour++){
            giveAssignments();
            work();
            receiveAssignments();
            if (!checkWorkers()){            // if everyone's shift is over no need to further execution
                break;
            }
        }

    }
    private void giveAssignments() {
        if (!checkContents()){
            return;
        }
        Iterator<Critic> iter = notAssignedCritics.iterator();
        Critic token = null;
        while (iter.hasNext()) {
            token = iter.next();
            if (token.isAssignable()) {
                if (token instanceof GameCritic) {
                    if (!(gameContents.empty())) {
                        token.assignTo(gameContents.pop());
                        assignedCritic.add(token);
                        iter.remove();
                    }
                } else if (token instanceof MovieCritic) {
                    if (!(movieContents.isEmpty())) {
                        token.assignTo(movieContents.pop());
                        assignedCritic.add(token);
                        iter.remove();
                    }
                }
            }

        }
    }
    public void displayOutline(){
        for(Assignment token : evaluatedAssignments){
            token.printRatingReport();
        }
    }
    private void receiveAssignments(){
        Iterator<Critic> iter = assignedCritic.iterator();
        Critic critic = null;
        while (iter.hasNext()){
            critic = iter.next();
            if (critic.isFinishedAssignment()){
                evaluatedAssignments.add(critic.handOverAssignment());
                notAssignedCritics.add(critic);
                iter.remove();
            }
        }
    }
    private void work(){
        for(Critic critic : assignedCritic){
            if(!critic.isShiftOver()){
                critic.workHourly();
                System.out.println(critic.giveReport());
            }
        }
    }
    private void newDay(){
        Iterator<Critic> iter = null;
        iter = notAssignedCritics.iterator();
        while(iter.hasNext()){
            iter.next().resetShift();
        }
        iter = assignedCritic.iterator();
        while(iter.hasNext()){
            iter.next().resetShift();
        }

    }
    // checkWorkers returns false if all worker's shift (time that a worker must work in a day)  is over
    private boolean checkWorkers(){
        Iterator<Critic> iter = null;
        iter = notAssignedCritics.iterator();
        while(iter.hasNext()){
            if (!iter.next().isShiftOver()){
                return true;
            }
        }
        iter = assignedCritic.iterator();
        while(iter.hasNext()){
            if (!iter.next().isShiftOver()){
                return true;
            }
        }
        return false;

    }
    // checkWorkers returns true if there is contents
    private boolean checkContents(){
        return !(gameContents.isEmpty() && movieContents.isEmpty());
    }
    private void getToken(Assignment token){
        if (token instanceof Game){
            gameContents.push(token);
        }else if(token instanceof Movie){
            movieContents.push(token);
        }else{
            System.out.println("an assignment can only be two types");
            System.exit(0);
        }
    }
    private void setCritics(List<Critic> given){
        for (Critic critic : given){
            notAssignedCritics.add(critic);
        }

    }
}
