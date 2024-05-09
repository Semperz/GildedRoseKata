package edu.badpals.GildedRose;

import java.util.Arrays;
import java.util.List;

public class GildedRose {
    List<Updateable> items = null;

    public GildedRose(List<Updateable> items) {
        this.items = items;
    }
    public void updateItems(){
        items.forEach(this::updateItem);
    }
    private void updateItem(Updateable item){
        item.updateQuality();
        item.updateSellIn();
    }
}
