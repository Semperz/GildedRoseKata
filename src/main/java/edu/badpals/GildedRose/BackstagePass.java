package edu.badpals.GildedRose;

public class BackstagePass extends Item implements Updateable {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn > 10) {
            quality += 1;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn >= 0){
            quality += 3;
        } else{
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
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