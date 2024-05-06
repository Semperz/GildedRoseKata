package edu.badpals.GildedRose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    GildedRose app = null;
    @Test
    public void updateItemsNormalItemsTest(){
        Updateable[] items = new Updateable[]{
                new NormalItem("Dexterity Vest", 7, 9),
                new NormalItem("Dexterity Vest", 0, 8)
        };

        app = new GildedRose(items);
        for (int day = 5; day > 0; day--){ //updates the sellIn
            app.updateItems();
            assertEquals(day+1, app.items[0].getSellIn());
            assertEquals(day-6, app.items[1].getSellIn());
        }

        app = new GildedRose(items);
        for (int day = 2; day > 0; day--){ //updates the quality
            app.updateItems();
            assertEquals(day+1, app.items[0].getQuality());
            assertEquals(0, app.items[1].getQuality());
        }
    }
}
