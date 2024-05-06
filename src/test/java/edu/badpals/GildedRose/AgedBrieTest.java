package edu.badpals.GildedRose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @ParameterizedTest
    @CsvSource({
            "0,  1, 2",
            "0,  50, 50",
            "-1,  1, 3",
            "-1,  49, 50"
    })
    public void qualityTest(int sellIn, int quality, int resoult){
        Updateable item = new AgedBrie("Aged Brie", sellIn, quality);
        item.updateQuality();
        assertEquals(resoult, item.getQuality());
    }
    @Test
    public void updateSellInTest(){
        Updateable item = new AgedBrie("Aged Brie", 0, 2);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }

    @Test
    public void getNameTest(){
        AgedBrie item = new AgedBrie("Aged Brie", 0, 0);
        assertEquals("Aged Brie", item.getName());
    }


}

