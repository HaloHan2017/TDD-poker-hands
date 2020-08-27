package com.example;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {
    private List<Poker> getOnePairPokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "C"),
                new Poker("9", "C"),
                new Poker("K", "D"));
    }

    private List<Poker> getTwoPairPokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("5", "D"));
    }

    private List<Poker> getThreeKindsPokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("3", "D"));
    }

    private List<Poker> getStraightPokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("4", "D"),
                new Poker("5", "S"),
                new Poker("6", "C"),
                new Poker("7", "D"));
    }

    private List<Poker> getFlushPokers() {
        return Arrays.asList(new Poker("2", "H"),
                new Poker("3", "H"),
                new Poker("5", "H"),
                new Poker("9", "H"),
                new Poker("8", "H"));
    }

    private List<Poker> getFullHousePokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
    }

    private List<Poker> getFourKindsPokers() {
        return Arrays.asList(new Poker("3", "H"),
                new Poker("3", "D"),
                new Poker("3", "S"),
                new Poker("5", "C"),
                new Poker("3", "C"));
    }

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
        assertEquals(result, "White wins.");
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
    public void should_return_compare_result_when_compare_pokers_given_one_pair_poker() {
        //given
        List<Poker> blackPokers = Arrays.asList(new Poker("2", "H"),
                new Poker("3", "D"),
                new Poker("5", "S"),
                new Poker("9", "C"),
                new Poker("A", "D"));
        List<Poker> whitePokers = getOnePairPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_two_pair_poker() {
        //given
        List<Poker> blackPokers = getOnePairPokers();
        List<Poker> whitePokers = getTwoPairPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_three_kinds_poker() {
        //given
        List<Poker> blackPokers = getTwoPairPokers();
        List<Poker> whitePokers = getThreeKindsPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_straight_poker() {
        //given
        List<Poker> blackPokers = getThreeKindsPokers();
        List<Poker> whitePokers = getStraightPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_flush_poker() {
        //given
        List<Poker> blackPokers = getStraightPokers();
        List<Poker> whitePokers = getFlushPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_full_house_poker() {
        //given
        List<Poker> blackPokers = getFlushPokers();
        List<Poker> whitePokers = getFullHousePokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_four_kinds_poker() {
        //given
        List<Poker> blackPokers = getFullHousePokers();
        List<Poker> whitePokers = getFourKindsPokers();
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins.");
    }

    @Test
    public void should_return_compare_result_when_compare_pokers_given_straight_flush_poker() {
        //given
        List<Poker> blackPokers = getFourKindsPokers();
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
