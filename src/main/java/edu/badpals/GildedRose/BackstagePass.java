package edu.badpals.GildedRose;

public class BackstagePass extends Item implements Updateable {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn > 10) {
            quality = Math.min(quality+1,50);
        } else if (sellIn > 5) {
            quality = Math.min(quality+2,50);
        } else if (sellIn >= 0){
            quality = Math.min(quality+3,50);
        } else{
            quality = 0;
        }
    }

    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    public String getName() {
        return this.name;
    }
}