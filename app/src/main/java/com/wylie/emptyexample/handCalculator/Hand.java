package com.wylie.emptyexample.handCalculator;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<CardType> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(CardType cardType){
        if (cards.contains(cardType)){
            int index = cards.indexOf(cardType);
            cards.get(index).add(cardType.getValue());
        } else {
            cards.add(cardType);
        }
    }

    public void remove(CardType cardType){
        if (cards.contains(cardType)){
            int index = cards.indexOf(cardType);
            CardType foundCard = cards.get(index);
            foundCard.remove(1);
            if (foundCard.getCount() <= 0){
                cards.remove(cardType);
            }
        }
    }

    public List<CardType> getCards(){
        return cards;
    }

    public int getValue(){
        int value = 0;
        for (CardType cardType: cards){
            value += cardType.getValue();
        }

        return value;
    }
}
