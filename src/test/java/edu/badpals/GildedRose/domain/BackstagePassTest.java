package edu.badpals.GildedRose.domain;

import edu.badpals.GildedRose.domain.BackstagePass;
import edu.badpals.GildedRose.domain.Updateable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassTest {

    @ParameterizedTest
    @CsvSource({
            "15, 1, 2",
            "10, 1, 3",
            "5, 1, 4",
            "0,  1, 4",
            "-1 , 50, 0"
    })
    public void qualityTest(int sellIn, int quality, int resoult){
        Updateable item = new BackstagePass("Backstage Pass", sellIn, quality);
        item.updateQuality();
        assertEquals(resoult, item.getQuality());
    }
    @Test
    public void updateSellInTest(){
        Updateable item = new BackstagePass("Backstage Pass", 0, 2);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }

    @Test
    public void getNameTest(){
        BackstagePass item = new BackstagePass("Backstage Pass", 0, 0);
        assertEquals("Backstage Pass", item.getName());
    }
}

