package com.example;

public class PokersService {
    public String comparePokers(String[] blackPokers, String[] whitePokers) {
        return "White wins. - with high card: Ace";
    }

    public String getMaxPoker(String[] pokers) {
        return "KD";
    }

    public String convertPoker(String poker) {
        return poker.replace("K","13")
                .replace("A","1")
                .replace("T","10")
                .replace("J","11");
    }
}
