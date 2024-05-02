package edu.badpals.GildedRose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemTest {
    @ParameterizedTest
    @CsvSource({
            "0,  3, 2",
            "-1,  3, 1",
            "0,  0, 0",
            "-1,  1, 0"
    })
    public void qualityTest(int sellIn, int quality, int resoult){
        NormalItem item = new NormalItem("Dexterity Vest", sellIn, quality);
        item.updateQuality();
        assertEquals(resoult, item.getQuality());
    }
    @Test
    public void updateSellInTest(){
        NormalItem item = new NormalItem("Dexterity Vest", 0, 2);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }

    @Test
    public void getNameTest(){
        NormalItem item = new NormalItem("Dexterity Vest", 0, 0);
        assertEquals("Dexterity Vest", item.getName());
    }


}
