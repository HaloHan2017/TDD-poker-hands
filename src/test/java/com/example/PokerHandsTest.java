package com.example;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {
    @Test
    public void should_return_compare_result_when_compare_pokers_given_white_pokers_max() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("2", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("K", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("2", "C"),
                new Poker("3", "H"),
                new Poker("4", "S"),
                new Poker("8", "C"),
                new Poker("A", "D"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins. - with high card: Ace");
    }

    @Test
    public void should_return_max_poker_when_get_max_poker_given_pokers() {
        //given
        List<Poker> pokers = Arrays.asList(
                new Poker("2", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("13", "D"));
        //when
        PokersService pokersService = new PokersService();
        Poker maxPoker = pokersService.getMaxPoker(pokers);
        //then
        assertEquals(maxPoker.getNumber(), "13");
    }

    @Test
    public void should_return_13D_when_convert_poker_given_KD() {
        //given
        String poker = "K";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 13);
    }

    @Test
    public void should_return_1D_when_convert_poker_given_AD() {
        //given
        String poker = "A";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 14);
    }

    @Test
    public void should_return_10D_when_convert_poker_given_TD() {
        //given
        String poker = "T";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 10);
    }

    @Test
    public void should_return_11D_when_convert_poker_given_JD() {
        //given
        String poker = "J";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 11);
    }

    @Test
    public void should_return_12D_when_convert_poker_given_QD() {
        //given
        String poker = "Q";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 12);
    }

}
