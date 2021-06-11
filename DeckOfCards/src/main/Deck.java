package main;

import java.util.ArrayList;

public class Deck <T extends Card> {
  private ArrayList<T> cards; // all cards, dealt or not
  private int dealtIndex = 0; // marks index of first undealt card

  public Deck(){

  }

  public void shuffle(){

  }
}
