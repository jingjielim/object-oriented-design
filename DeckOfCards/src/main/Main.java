package main;

import java.util.ArrayList;

public class Main {
    /**
     7.1 Design the data structures for a generic deck of cards. Explain how you would subclass the data structures to
     implement BlackJack.

     we need to recognize that a "generic" deck of cards can mean many things. Generic could mean a standard deck of cards
     that can play a poker-like game, or it could even stretch to Uno or Baseball cards. It is important to ask your
     interviewer what she means by generic.

     Let's assume that the interviewer clarifies that the deck is a standard 52-card set, like you might see used in a
     blackjack or poker game. If so, the design might look like this project.
     */
    public static void main(String[] args) {
        int numHands = 5;
        BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
        automator.initializeDeck();
        boolean success = automator.dealInitial();
        if (!success){
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            automator.printHandsAndScore();
            ArrayList<Integer> blackjacks = automator.getBlackJacks();
            if (blackjacks.size() > 0){
                System.out.print("Blackjack at ");
                for (int i = 0; i < blackjacks.size(); i++) {
                    System.out.print(i + ", ");
                }
                System.out.println("");
            } else{
                success = automator.playAllHands();
                if (!success){
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n--Completed Game--");
                    automator.printHandsAndScore();
                    ArrayList<Integer> winners = automator.getWinners();
                    if (winners.size() > 0){
                        System.out.print("Winners: ");
                        for (int i :
                                winners) {
                            System.out.println(i + ", ");
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Draw. All players have busted");
                    }
                }
            }
        }
    }

}
