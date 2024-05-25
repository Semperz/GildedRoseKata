package edu.badpals.GildedRose.domain;

import edu.badpals.GildedRose.domain.Sulfuras;
import edu.badpals.GildedRose.domain.Updateable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    @ParameterizedTest
    @CsvSource({
            "1,  80, 80",
            "-1,  80, 80",
            "0,  80, 80"
    })
    public void qualityTest(int sellIn, int quality, int resoult){
        Updateable item = new Sulfuras("Sulfuras", sellIn, quality);
        item.updateQuality();
        assertEquals(resoult, item.getQuality());
    }
    @Test
    public void updateSellInTest(){
        Updateable item = new Sulfuras("Sulfuras", 0, 80);
        item.updateSellIn();
        assertEquals(0, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }

    @Test
    public void getNameTest(){
        Sulfuras item = new Sulfuras("Sulfuras", 0, 0);
        assertEquals("Sulfuras", item.getName());
    }


}
