package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerUtilTest {
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
}
