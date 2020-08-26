package com.example;


import org.testng.annotations.Test;

public class PokerHandsTest {
    @Test
    public void should_return_compare_result_when_compare_pokers_given_white_pokers_max() {
        //given
        String[] blackPokers = {"2H","3D","5S","9C","KD"};
        String[] whitePokers = {"2C","3H","4S","8C","AD"};
        //when
        PokersService pokersService = new PokersService();
        String result = pokersService.comparePokers(blackPokers,whitePokers);
        //then
        assertsEquals(result,"White wins. - with high card: Ace");
    }
}
