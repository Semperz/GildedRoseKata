package edu.badpals.GildedRose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemTest {
    static NormalItem item = new NormalItem("Dexterity Vest", 0, 3);
    @Test
    public void qualityAndSellInPositiveTest(){
        item.updateQuality();
        assertEquals(2, item.getQuality()); //Actual Item quality = 2, sellIn = 0
    }
    @Test
    public void updateSellInTest(){
        item.updateSellIn();
        assertEquals(-1, item.getSellIn()); //Actual Item quality = 2, sellIn = -1
    }
    @Test
    public void SellInNegativeTest() {
        item.updateQuality();
        assertEquals(0, item.getQuality()); //Actual Item quality = 0, sellIn = -1
    }

    @Test
    public void qualityZeroTest() {
        item.updateQuality();
        assertEquals(0, item.getQuality()); //Actual Item quality = 0, sellIn = -1
    }

    @Test
    public void getNameTest(){
        assertEquals("Dexterity Vest", item.getName());
    }
    @Test

    public void qualityNotNegativeTest(){
        NormalItem item2 = new NormalItem("Elixir of the mongoose", -1, 1); //updateQuality does not accept negative quality
        item2.updateQuality();
        assertEquals(0, item2.getQuality());
    }


}
