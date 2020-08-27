package com.example;

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

    public static boolean hasOnePair(List<Poker> pokers) {
        Map<String, Long> map = pokers.stream().map(Poker::getNumber).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return pokers.size()-1 == map.size();
    }

    public static boolean hasTwoPair(List<Poker> pokers) {
        Map<String, Long> map = pokers.stream().map(Poker::getNumber).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = 0;
        for (Long value : map.values()) {
            if(value == 2){
                count++;
            }
        }
        return count == 2;
    }
}
