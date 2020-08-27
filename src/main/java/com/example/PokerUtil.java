package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerUtil {

    public static Integer convertPoker(String number) {
        switch (number) {
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(number);
        }
    }

    private static Map<String, Long> getContainerMap(List<Poker> pokers) {
        Map<String, Long> map = pokers.stream().map(Poker::getNumber).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map;
    }

    public static boolean hasOnePair(List<Poker> pokers) {
        Map<String, Long> map = getContainerMap(pokers);
        return pokers.size() - 1 == map.size();
    }

    public static boolean hasTwoPair(List<Poker> pokers) {
        Map<String, Long> map = getContainerMap(pokers);
        int count = 0;
        for (Long value : map.values()) {
            if (value == 2) {
                count++;
            }
        }
        return count == 2;
    }

    public static boolean hasThreeKinds(List<Poker> pokers) {
        Map<String, Long> map = getContainerMap(pokers);
        return (pokers.size() - map.size() == 2) && !hasTwoPair(pokers);
    }

    public static boolean hasStraight(List<Poker> pokers) {
        for (int i = 1; i < pokers.size(); i++) {
            if (Integer.parseInt(pokers.get(i).getNumber()) - Integer.parseInt(pokers.get(i - 1).getNumber()) != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasFlush(List<Poker> pokers) {
        Map<String, Long> map = pokers.stream().map(Poker::getType).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.size() == 1;
    }

    public static boolean hasFullHouse(List<Poker> pokers) {
        Map<String, Long> map = getContainerMap(pokers);
        if(map.size() != 2){
            return false;
        }
        int count = 0;
        for (Long value : map.values()) {
            if(value != 2 && value != 3){
                count ++;
            }
        }
        return count == 0;
    }

    public static boolean hasFourKinds(List<Poker> pokers) {
        Map<String, Long> map = getContainerMap(pokers);
        int count = 0;
        for (Long value : map.values()) {
            if(value == 4){
                count = 1;
            }
        }
        return (pokers.size() - map.size() == 3) && (count == 1);
    }

    public static boolean hasStraightFlush(List<Poker> pokers) {
        return hasStraight(pokers) && hasFlush(pokers);
    }
}
