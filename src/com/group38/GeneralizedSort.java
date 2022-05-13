package com.group38;
import java.util.Collection;
import java.util.List;

public class GeneralizedSort{

    public static void selectionSort(List<Assignment> a){
        int index , indexOfNextSmallest;
        int size = a.size();
        for (index = 0 ; index < size - 1 ; index++){
            indexOfNextSmallest = indexOfSmallest(index, a, size);
            interchange(index , indexOfNextSmallest , a);
        }
    }
    public static void bubbleSort(List<Assignment> a){
        for (int i = 0 ; i < a.size() - 1  ; i++) {
            for (int j = 0; j < a.size() - i - 1; j++){
                if (a.get(j).compareTo(a.get(j+1)) > 0 ) {
                    interchange(j, j+1 , a);
                }
            }
        }
    }
    private static int indexOfSmallest(int startIndex, List<Assignment> x , int size){
        Comparable min  = x.get(startIndex);
        int indexOfMin  = startIndex;
        int index;
        for (index = startIndex + 1; index < size ; index++){
            if(x.get(index).compareTo(min) < 0){
                min = x.get(index);
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }
    private static void interchange(int index, int indexOfSmallest , List<Assignment> list){
        Assignment temp , smallest ;
        temp = list.get(index);
        smallest = list.get(indexOfSmallest);
        list.set(index , smallest);
        list.set(indexOfSmallest , temp);
    }
}
