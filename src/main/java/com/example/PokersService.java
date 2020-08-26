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
        Poker maxPokerOfBlack = getMaxPoker(blackPokers);
        Poker maxPokerOfWhite = getMaxPoker(whitePokers);
        Integer maxPokerNumberOfBlack = convertPoker(maxPokerOfBlack.getNumber());
        Integer maxPokerNumberOfWhite = convertPoker(maxPokerOfWhite.getNumber());

        if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
            return "Black wins. - with high card: " + map.get(maxPokerNumberOfBlack);
        }
        return "White wins. - with high card: " + map.get(maxPokerNumberOfWhite);
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        Poker filterPoker = pokers.stream().filter(poker -> poker.getNumber().equals(1)).findFirst().orElse(null);
        if (filterPoker != null) {
            return filterPoker;
        }
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
