package edu.badpals.GildedRose;

import java.util.Arrays;

public class GildedRose {
    Updateable[] items = null;

    public GildedRose(Updateable[] items) {
        this.items = items;
    }
    public void updateItems(){
        Arrays.stream(items).forEach(this::updateItem);
    }
    private void updateItem(Updateable item){
        item.updateQuality();
        item.updateSellIn();
    }
}
