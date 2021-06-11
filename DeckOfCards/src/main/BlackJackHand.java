package main;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
  public BlackJackHand() {

  }

  public int score() {
    ArrayList<Integer> scores = possibleScores();
    int minOver = Integer.MAX_VALUE;
    int maxUnder = Integer.MIN_VALUE;
    for (int score : scores){
      if (score > 21 && score < minOver){
        minOver = score;
      } else if (score <= 21 && score > maxUnder){
        maxUnder = score;
      }
    }
    return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
  }

  public ArrayList<Integer> possibleScores() {
    ArrayList<Integer> scores = new ArrayList<>();
    if (cards.isEmpty()) return scores;
    for (BlackJackCard card : cards) {
      addCardToScoresList(card, scores);
    }
    return scores;
  }

  private void addCardToScoresList(BlackJackCard card, ArrayList<Integer> scores) {
    if(scores.isEmpty()){
      scores.add(0);
    }
    int length = scores.size();
    for (int i = 0; i < length; i++) {
      int score = scores.get(i);
        scores.set(i, score + card.minValue());
        if (card.isAce()) {
          scores.add(score + card.maxValue());
        }
    }
  }

  public boolean isBusted(){
    return score()>21;
  }

  public boolean isBlackJack(){
    if (cards.size() != 2) return false;
    else {
      return score() == 21;
    }
  }
}
