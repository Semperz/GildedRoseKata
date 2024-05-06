package edu.badpals.GildedRose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {
    @ParameterizedTest
    @CsvSource({
            "1,  2, 0",
            "-1,  4, 0",
            "-1,  1, 0"
    })
    public void qualityTest(int sellIn, int quality, int resoult){
        Updateable item = new Conjured("Conjured Mana Cake", sellIn, quality);
        item.updateQuality();
        assertEquals(resoult, item.getQuality());
    }
    @Test
    public void updateSellInTest(){
        Updateable item = new Conjured("Conjured Mana Cake", 0, 2);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }

    @Test
    public void getNameTest(){
        Conjured item = new Conjured("Conjured Mana Cake", 0, 0);
        assertEquals("Conjured Mana Cake", item.getName());
    }
}