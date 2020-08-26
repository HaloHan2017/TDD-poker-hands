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
        Integer result = getCalculateResultOfPokers(blackPokers,whitePokers);
        int priorityOfBlackPokers = getPriorityOfPokers(blackPokers);
        int priorityOfWhitePokers = getPriorityOfPokers(whitePokers);
        if(priorityOfBlackPokers < priorityOfWhitePokers){
            return "White wins.";
        }else if(priorityOfBlackPokers > priorityOfWhitePokers){
            return "Black wins.";
        }else {
            // the same priority
            return null;
        }
        if(result == 0){
            Integer maxPokerNumberOfBlack = convertPoker(getMaxPoker(blackPokers).getNumber());
            Integer maxPokerNumberOfWhite = convertPoker(getMaxPoker(whitePokers).getNumber());
            if (maxPokerNumberOfBlack > maxPokerNumberOfWhite) {
                return "Black wins. - with high card: " + map.get(maxPokerNumberOfBlack);
            }
            return "White wins. - with high card: " + map.get(maxPokerNumberOfWhite);
        }else if(result == 1){
            return "White wins.";
        }else if (result == 2){
            return "White wins.";
        }
        return  "";
    }

    private int getPriorityOfPokers(List<Poker> pokers) {
        if(PokerUtil.hasOnePair(pokers)){
            return 1;
        }
        return 0;
    }

    private Integer getCalculateResultOfPokers(List<Poker> blackPokers, List<Poker> whitePokers) {
        Map<String, Long> mapOfBlack = blackPokers.stream().map(Poker::getNumber).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> mapOfWhite = whitePokers.stream().map(Poker::getNumber).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return judgeByMap(mapOfBlack, mapOfWhite);
    }

    private Integer judgeByMap(Map<String, Long> mapOfBlack, Map<String, Long> mapOfWhite) {
        int mapOfBlackSize = mapOfBlack.values().size();
        int mapOfWhiteSize = mapOfWhite.values().size();
        if (mapOfBlackSize == 5 && mapOfWhiteSize == 5) { // 0对 vs 0对
            return 0;
        } else if (mapOfBlackSize == 5 && mapOfWhiteSize == 4) {// 0对 vs 1对
            return 1;
        }else if(mapOfBlackSize == 4 && mapOfWhiteSize == 3){// 1对 vs 2对
            return 2;
        }
        return null;
    }

    public Poker getMaxPoker(List<Poker> pokers) {
        return pokers.stream().max((o1, o2) -> {
            Integer i1 = convertPoker(o1.getNumber());
            Integer i2 = convertPoker(o2.getNumber());
            return i1.compareTo(i2);
        }).orElse(null);
    }
}
