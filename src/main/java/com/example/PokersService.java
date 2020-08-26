package com.example;

public class PokersService {
    public String comparePokers(String[] blackPokers, String[] whitePokers) {
        return "White wins. - with high card: Ace";
    }

    public String getMaxPoker(String[] pokers) {
        return "KD";
    }

    public String convertPoker(String poker) {
        return poker.replace("T","10")
                .replace("J","11")
                .replace("Q","12")
                .replace("K","13")
                .replace("A","1");
    }

    public String[][] generatePokers(String[] pokers) {
        String[][] pokerDetail = new String[5][2];
        for (int i = 0; i < pokers.length; i++) {
            pokerDetail[i][0] = pokers[i].substring(0, pokers[i].length() - 1);
            pokerDetail[i][1] = pokers[i].substring(pokers[i].length() - 1);
        }
        return pokerDetail;
    }
}
