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
    public void should_return_13_when_convert_poker_given_K() {
        //given
        String poker = "K";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 13);
    }

    @Test
    public void should_return_14_when_convert_poker_given_A() {
        //given
        String poker = "A";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 14);
    }

    @Test
    public void should_return_10_when_convert_poker_given_T() {
        //given
        String poker = "T";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 10);
    }

    @Test
    public void should_return_11_when_convert_poker_given_J() {
        //given
        String poker = "J";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 11);
    }

    @Test
    public void should_return_12_when_convert_poker_given_Q() {
        //given
        String poker = "Q";
        //when
        Integer pokerNumber = PokerUtil.convertPoker(poker);
        //then
        assertEquals((int) pokerNumber, 12);
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_one_pair_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("2", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("A", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "C"),
                new Poker("9", "C"),
                new Poker("K", "D"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_two_pair_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "C"),
                new Poker("9", "C"),
                new Poker("K", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("5", "D"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_three_kinds_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("5", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("3", "D"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_straight_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("3", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("4", "D"),
                new Poker("5", "S"),
                new Poker("6", "C"),
                new Poker("7", "D"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_flush_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("4", "D"),
                new Poker("5", "S"),
                new Poker("6", "C"),
                new Poker("7", "D"));
        List<Poker> whitePokers = Arrays.asList(new Poker("2", "H"),
                new Poker("3", "H"),
                new Poker("5", "H"),
                new Poker("9", "H"),
                new Poker("8", "H"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_full_house_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("2", "H"),
                new Poker("3", "H"),
                new Poker("5", "H"),
                new Poker("9", "H"),
                new Poker("8", "H"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_four_kinds_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("3", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_straight_flush_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("3", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
        List<Poker> whitePokers = Arrays.asList(new Poker("3", "C"),
                new Poker("4", "C"),
                new Poker("5", "C"),
                new Poker("6", "C"),
                new Poker("7", "C"));
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }
}
