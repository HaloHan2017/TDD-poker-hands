package com.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {
    @Test
    public void should_return_compare_result_when_compare_pokers_given_white_pokers_max() {
        //given
        String[] blackPokers = {"2H", "3D", "5S", "9C", "KD"};
        String[] whitePokers = {"2C", "3H", "4S", "8C", "AD"};
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers, whitePokers);
        //then
        assertEquals(result, "White wins. - with high card: Ace");
    }

    @Test
    public void should_return_max_poker_when_get_max_poker_given_pokers() {
        //given
        String[] pokers = {"2H", "3D", "5S", "9C", "13D"};
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.getMaxPoker(pokers);
        //then
        assertEquals(maxPoker, "13");
    }

    @Test
    public void should_return_13D_when_convert_poker_given_KD() {
        //given
        String poker = "KD";
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.convertPoker(poker);
        //then
        assertEquals(maxPoker, "13D");
    }

    @Test
    public void should_return_1D_when_convert_poker_given_AD() {
        //given
        String poker = "AD";
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.convertPoker(poker);
        //then
        assertEquals(maxPoker, "1D");
    }

    @Test
    public void should_return_10D_when_convert_poker_given_TD() {
        //given
        String poker = "TD";
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.convertPoker(poker);
        //then
        assertEquals(maxPoker, "10D");
    }

    @Test
    public void should_return_11D_when_convert_poker_given_JD() {
        //given
        String poker = "JD";
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.convertPoker(poker);
        //then
        assertEquals(maxPoker, "11D");
    }

    @Test
    public void should_return_12D_when_convert_poker_given_QD() {
        //given
        String poker = "QD";
        //when
        PokersService pokersService = new PokersService();
        String maxPoker = pokersService.convertPoker(poker);
        //then
        assertEquals(maxPoker, "12D");
    }

    @Test
    public void should_return_number_and_type_when_generate_pokers_given_one_dimensional_pokers() {
        //given
        String[] pokers = {"2H", "3D", "5S", "9C", "KD"};

        //when
        PokersService pokersService = new PokersService();
        String[][] twoDimensionalPoker = pokersService.generatePokers(pokers);
        //then
        assertEquals("2", twoDimensionalPoker[0][0]);
        assertEquals("H", twoDimensionalPoker[0][1]);
    }
}
