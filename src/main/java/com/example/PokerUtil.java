package com.example;

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
                return 1;
            default:
                return Integer.parseInt(number);
        }
    }
}
