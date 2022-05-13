package com.group38;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import java.util.StringTokenizer;

public class FileIO {
    File file = null;
    Scanner fileIn = null;
    List<String> lines  =  new ArrayList<String>(100);
    public FileIO(String fileName){
        file = new File(fileName);
    }
    public List<String> getLines(){
        try{
            fileIn  = new Scanner(new FileInputStream(file));
            String line = null;
            while (fileIn.hasNextLine() && ((line = fileIn.nextLine()) != null)){
                lines.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        fileIn.close();
        return lines;
    }
    public List<Assignment> getAssignments(){
        List<Assignment> assignments = new ArrayList<Assignment>();
        Assignment newAssignment = null;
        List<String> lines  = getLines();
        StringTokenizer tokenizer = null;
        int indicator = 0;
        int day = 0 ;
        String name = null;
        for (String token : lines){
            tokenizer = new StringTokenizer(token, "\n,");
            if (! tokenizer.hasMoreTokens()){
                break;
            }
            day = Integer.parseInt(tokenizer.nextToken());
            indicator = Integer.parseInt(tokenizer.nextToken());
            name = tokenizer.nextToken();
            switch (indicator){
                case 0:
                    newAssignment = createMovie(day , name ,tokenizer);
                    break;
                case 1:
                    newAssignment = createIndefiniteGame(day , name , tokenizer);
                    break;
                case 2:
                    newAssignment = createStoryGame(day , name , tokenizer);
                    break;
                case 3:
                    newAssignment = createCasualGame(day, name, tokenizer);
                    break;

            }
            assignments.add(newAssignment);
        }
        return assignments;
    }
    private Assignment createMovie(int day, String name , StringTokenizer tokenizer){
        int year = Integer.parseInt(tokenizer.nextToken());
        int duration  = Integer.parseInt(tokenizer.nextToken());
        float avrgRating  = Float.parseFloat(tokenizer.nextToken());
        return new Movie(day , avrgRating ,name, duration , year );
    }
    private Assignment createIndefiniteGame(int day, String name , StringTokenizer tokenizer){
        int minEvalTime = Integer.parseInt(tokenizer.nextToken());
        float avrgRating  = Float.parseFloat(tokenizer.nextToken());
        return new IndefiniteGame(day , avrgRating , name ,minEvalTime );
    }
    private Assignment createStoryGame(int day, String name , StringTokenizer tokenizer){
        int duration = Integer.parseInt(tokenizer.nextToken());
        float avrgRating  = Float.parseFloat(tokenizer.nextToken());
        return new StoryGame(day , avrgRating  , name , duration);
    }
    private Assignment createCasualGame(int day, String name , StringTokenizer tokenizer){
        int duration = Integer.parseInt(tokenizer.nextToken());
        float avrgRating  = Float.parseFloat(tokenizer.nextToken());
        return new CasualGame(day , avrgRating , name , duration);
    }


}
