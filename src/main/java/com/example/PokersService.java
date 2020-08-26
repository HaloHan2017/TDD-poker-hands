package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        String calculatedResult = getCalculateResultOfPokers(blackPokers);
        Integer maxPokerNumberOfBlack = convertPoker(getMaxPoker(blackPokers).getNumber());
        Integer maxPokerNumberOfWhite = convertPoker(getMaxPoker(whitePokers).getNumber());
        if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
            return "Black wins. - with high card: " + map.get(maxPokerNumberOfBlack);
        }
        return "White wins. - with high card: " + map.get(maxPokerNumberOfWhite);
    }

    private String getCalculateResultOfPokers(List<Poker> pokers) {
        Map<String, Long> map = pokers.stream().map(Poker::getNumber).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int mapSize = map.values().size();
        if (mapSize == 5) {
            return "No Pair";
        } else if (mapSize == 4) {// 一对
            for (String key : map.keySet()) {
                if (map.get(key).longValue() == 2) {
                    return "With Pair" + key;
                }
            }
        }
        return "";
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
