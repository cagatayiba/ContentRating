package com.group38;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentRetrieval {
    private List<Assignment> assignments ;
    private int currentDay ;
    private int cursor;
    public ContentRetrieval(){
        assignments  = new ArrayList<Assignment>(100);
        currentDay = 1;
    }
    public ContentRetrieval(List<Assignment> givenList){
        this();
        adAll(givenList);
    }
    public int getCurrentDay(){
        return currentDay;
    }
    public List<Assignment> getDailyContents(){   // return contents of the one day
        List<Assignment> temp  = new ArrayList<Assignment>(50);
        Assignment token = null;
        Iterator<Assignment> iter = assignments.iterator();
        while (iter.hasNext()){
            token = iter.next();
            if(token.getArrivalDay() != currentDay){
                break;
            }
            temp.add(token);
            iter.remove();
        }
        currentDay ++ ;
        return temp ;
    }
    public void displayContents(){
        for (Assignment token : assignments){
            System.out.println(token);
        }
    }


    private void adAll(List<Assignment> a){
        assignments.addAll(a);
        GeneralizedSort.bubbleSort(assignments);
    }

}
