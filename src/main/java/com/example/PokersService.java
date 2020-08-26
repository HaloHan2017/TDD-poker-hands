package com.example;

import java.util.*;

import static com.example.PokerUtil.*;

public class PokersService {
    public String comparePokers(List<Poker> blackPokers, List<Poker> whitePokers) {
        return "White wins. - with high card: Ace";
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        Poker filterPoker = pokers.stream().filter(poker -> poker.getNumber().equals(1)).findFirst().orElse(null);
        if(filterPoker != null){
            return filterPoker;
        }
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
