package edu.badpals.GildedRose.domain;

public class Conjured extends Item implements Updateable {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn < 0){
            quality -= 4;
        } else{
            quality -= 2;
        }
        if (quality < 0){
            quality  = 0;
        }
    }


    @Override
    public void updateSellIn() {
        sellIn-=1;
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
