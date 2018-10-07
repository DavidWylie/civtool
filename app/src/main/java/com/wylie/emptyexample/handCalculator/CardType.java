package com.wylie.emptyexample.handCalculator;

import java.util.Objects;

public class CardType {

    private String name;
    private int count;

    public CardType(String name) {
        this.name = name;
        this.count = 1;
    }

    public void add(int number){
        count += number;
    }

    public void remove(int number) {
        count -= number;
    }

    public int getCount() {
        return count;
    }

    public int getValue(){
        return count * count;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardType cardType = (CardType) o;
        return Objects.equals(name, cardType.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
