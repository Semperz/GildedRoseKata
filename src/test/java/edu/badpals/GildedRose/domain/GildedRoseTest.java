package edu.badpals.GildedRose.domain;

import edu.badpals.GildedRose.domain.GildedRose;
import edu.badpals.GildedRose.domain.NormalItem;
import edu.badpals.GildedRose.domain.Updateable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    GildedRose app = null;
    @Test
    public void updateItemsNormalItemsTest() {
        List<Updateable> items = new ArrayList<>();
        items.add(new NormalItem("Dexterity Vest", 7, 9));
        items.add(new NormalItem("Dexterity Vest", 0, 8));


        app = new GildedRose(items);
        for (int day = 5; day > 0; day--){ //updates the sellIn
            app.updateItems();
            assertEquals(day+1, app.items.get(0).getSellIn());
            assertEquals(day-6, app.items.get(1).getSellIn());
        }

        app = new GildedRose(items);
        for (int day = 2; day > 0; day--){ //updates the quality
            app.updateItems();
            assertEquals(day+1, app.items.get(0).getQuality());
            assertEquals(0, app.items.get(1).getQuality());
        }
    }
}
