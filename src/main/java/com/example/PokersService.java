package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.PokerUtil.convertPoker;

public class PokersService {
    private Map<Integer, String> map = new HashMap<>();

    {
        map.put(11, "Jack");
        map.put(12, "Queen");
        map.put(13, "King");
        map.put(14, "Ace");
    }

    public String comparePokers(List<Poker> blackPokers, List<Poker> whitePokers) {
        Integer maxPokerNumberOfBlack = convertPoker(getMaxPoker(blackPokers).getNumber());
        Integer maxPokerNumberOfWhite = convertPoker(getMaxPoker(whitePokers).getNumber());
        if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
            return "Black wins. - with high card: " + map.get(maxPokerNumberOfBlack);
        }
        return "White wins. - with high card: " + map.get(maxPokerNumberOfWhite);
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
