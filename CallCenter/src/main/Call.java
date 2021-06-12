package main;

import java.util.Random;

public class Call {
    private Rank rank;

    public Call(){
        this.rank = Rank.RESPONDENT;
    }

    public Rank getRank(){
        return this.rank;
    }

    public void incrementRank(){
        if (this.rank == Rank.RESPONDENT){
            this.rank = Rank.MANAGER;
        } else if (this.rank == Rank.MANAGER){
            this.rank = Rank.DIRECTOR;
        } else {
            System.out.println("Error. No more escalation possible.");
        }
    }

    public boolean canHandle() {
        if (rank == Rank.DIRECTOR){
            return true;
        } else {
            Random random = new Random();
            return random.nextBoolean();
        }
    }

    public void completed() {
        System.out.println("Call completed");
    }
}
