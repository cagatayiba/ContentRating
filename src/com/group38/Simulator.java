package com.group38;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static List<Critic> defaultCritics ;
    private  ContentRetrieval contentDelivery ;
    private Company company ;
    public Simulator(){

    }

    public Simulator(ContentRetrieval contentDelivery) {
        this.contentDelivery = contentDelivery;
        defaultCritics = new ArrayList<Critic>();
        initializeCritics();
        this.company  = new Company(defaultCritics);
    }

    public  void simulateFiveDay(){
        for (int dayCount = 1 ; dayCount < 6 ; dayCount ++ ){
            System.out.printf("DAY: %d\n"  , dayCount );
            company.getAssignments(contentDelivery.getDailyContents());
            company.runForOneDay();
        }
        System.out.println("RATINGS : \n");
        company.displayOutline();
    }
    public void initializeCritics(){
        MovieCritic M1 = new MovieCritic("1. Movie Critic" , (float)0.1);
        MovieCritic M2 = new MovieCritic("2. Movie Critic" , (float)- 0.2);
        MovieCritic M3 = new MovieCritic("3. Movie Critic" , (float)0.3);
        GameCritic G1 = new GameCritic("1. Game Critic" , (float)5.0);
        GameCritic G2 = new GameCritic("2. Game Critic" , (float)9.0);
        GameCritic G3 = new GameCritic("3. Game Critic" , (float)-3.0);
        GameCritic G4 = new GameCritic("4. Game Critic" , (float)2.0);
        GameCritic G5 = new GameCritic("5. Game Critic" , (float)-7.0);
        defaultCritics.add(M1);
        defaultCritics.add(M2);
        defaultCritics.add(M3);
        defaultCritics.add(G1);
        defaultCritics.add(G2);
        defaultCritics.add(G3);
        defaultCritics.add(G4);
        defaultCritics.add(G5);
    }

}
