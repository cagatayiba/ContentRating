package com.group38;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileIO file = new FileIO("contents.csv");
        ContentRetrieval c = new ContentRetrieval(file.getAssignments());
        Simulator simulator = new Simulator(c);
        simulator.simulateFiveDay();
    }


}

