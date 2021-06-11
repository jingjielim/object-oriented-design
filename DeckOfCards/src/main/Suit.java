package main;

public enum Suit {
  Club(0),
  Diamond(1),
  Heart(2),
  Spade(3);
  private int value;

  Suit(int v) {
    this.value = v;
  }

  public int getValue() {
    return value;
  }

  public static Suit getSuitFromValue(int value) {
    for (Suit s: Suit.values()){
      if (s.value == value) {
        return s;
      }
    }
    return null;
  }
}
