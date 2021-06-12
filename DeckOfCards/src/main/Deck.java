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
      int j = random.nextInt(cards.size() - 1);
      T currCard = cards.get(i);
      T swapCard = cards.get(j);
      cards.set(i, swapCard);
      cards.set(j, currCard);
    }
  }

  public int remainingCards(){
    return cards.size() - dealtIndex;
  }

  public T[] dealHand(int number) {
    if (remainingCards() < number){
      return null;
    }

    T[] hand = (T[]) new Card[number];
    int count = 0;
    while (count < number){
      T card = dealCard();
      if (card != null){
        hand[count] = card;
        count++;
      }
    }
    return hand;
  }

  public T dealCard(){
    if (remainingCards() == 0) {
      return null;
    }
    T card = cards.get(dealtIndex);
    card.markUnavailable();
    dealtIndex++;

    return card;
  }

  public void print(){
    for (Card card: cards) {
      card.print();
    }
  }
}
