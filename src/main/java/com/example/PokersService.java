package com.example;

import java.util.List;

import static com.example.PokerUtil.convertPoker;

public class PokersService {
    private static final String WHITE_WINS = "White wins.";
    private static final String BLACK_WINS = "Black wins.";

    public String comparePokers(List<Poker> blackPokers, List<Poker> whitePokers) {
        int priorityOfBlackPokers = getPriorityOfPokers(blackPokers);
        int priorityOfWhitePokers = getPriorityOfPokers(whitePokers);
        if (priorityOfBlackPokers == priorityOfWhitePokers) {
            // the same priority
            Integer maxPokerNumberOfBlack = convertPoker(getMaxPoker(blackPokers).getNumber());
            Integer maxPokerNumberOfWhite = convertPoker(getMaxPoker(whitePokers).getNumber());
            if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
                return BLACK_WINS;
            }
            return WHITE_WINS;
        } else if (priorityOfBlackPokers < priorityOfWhitePokers) {
            return WHITE_WINS;
        } else {
            return BLACK_WINS;
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
