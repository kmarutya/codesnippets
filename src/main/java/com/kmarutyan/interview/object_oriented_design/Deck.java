package com.kmarutyan.interview.object_oriented_design;

enum Suit{
    Club(0), Diamond(1), Heart(2), Spade(3);
    int value;
    Suit(int i){
        value = i;
    }
    int getValue(){
        return value;
    }

    Suit getSuitFromValue(int val){
       if (val == 0)
           return Club;
       if(val == 1)
           return Diamond;
       if(val == 2)
           return Heart;
       if(val == 3)
           return Spade;
       throw new RuntimeException("Value is invalid");
    }
}
public class Deck {
}
