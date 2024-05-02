package edu.badpals.GildedRose;

import java.util.Arrays;

public class GuildedRose {
    Updateable[] items = null;

    public GuildedRose(Updateable[] items) {
        this.items = items;
    }
    public void updateItems(){
        Arrays.stream(items).forEach(this::updateItem);
    }
    public void updateItem(Updateable item){
        item.updateQuality();
        item.updateSellIn();
    }
}
