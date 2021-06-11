package main;

import java.util.ArrayList;
import java.util.Random;

public class Deck <T extends Card> {
  private ArrayList<T> cards; // all cards, dealt or not
  private int dealtIndex = 0; // marks index of first undealt card

  public Deck(ArrayList<T> deckOfCards){
    this.cards = deckOfCards;
  }

  public void shuffle(){
    for (int i = 0; i < cards.size(); i++) {
      Random random = new Random();
    }
  }
}
