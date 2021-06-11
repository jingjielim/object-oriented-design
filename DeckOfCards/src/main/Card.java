package main;

public abstract class Card {
  private boolean available = true;
  protected int faceValue;
  protected Suit suit;

  public Card(int c, Suit s) {
    this.faceValue = c;
    this.suit = s;
  }

  public abstract int value();

  public Suit suit() {
    return suit;
  }

  public boolean isAvailable() {
    return available;
  }

  public void markAvailable() {
    available = true;
  }

  public void markUnavailable(){
    available = false;
  }

  public void print(){
    String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    System.out.print(faceValues[faceValue-1]);
    switch (suit) {
      case Club:
        System.out.print(" of Clubs");
      case Heart:
        System.out.print(" of Hearts");
      case Diamond:
        System.out.print(" of Diamonds");
      case Spade:
        System.out.print(" of Spades");
    }
  }
}
