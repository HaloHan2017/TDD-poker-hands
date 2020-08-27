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
        int priorityOfBlackPokers = getPriorityOfPokers(blackPokers);
        int priorityOfWhitePokers = getPriorityOfPokers(whitePokers);
        if (priorityOfBlackPokers == priorityOfWhitePokers) {
            // the same priority
            Integer maxPokerNumberOfBlack = convertPoker(getMaxPoker(blackPokers).getNumber());
            Integer maxPokerNumberOfWhite = convertPoker(getMaxPoker(whitePokers).getNumber());
            if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
                return "Black wins. - with high card: " + map.get(maxPokerNumberOfBlack);
            }
            return "White wins. - with high card: " + map.get(maxPokerNumberOfWhite);
        } else if (priorityOfBlackPokers < priorityOfWhitePokers) {
            return "White wins.";
        } else {
            return "Black wins.";
        }
    }

    private int getPriorityOfPokers(List<Poker> pokers) {
        if (PokerUtil.hasStraightFlush(pokers)) {
            return 8;
        }
        if (PokerUtil.hasFourKinds(pokers)) {
            return 7;
        }
        if (PokerUtil.hasFullHouse(pokers)) {
            return 6;
        }
        if (PokerUtil.hasFlush(pokers)) {
            return 5;
        }
        if (PokerUtil.hasStraight(pokers)) {
            return 4;
        }
        if (PokerUtil.hasThreeKinds(pokers)) {
            return 3;
        }
        if (PokerUtil.hasTwoPair(pokers)) {
            return 2;
        }
        if (PokerUtil.hasOnePair(pokers)) {
            return 1;
        }
        return 0;
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
