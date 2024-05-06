package edu.badpals.GildedRose;

public class AgedBrie extends Item implements Updateable{

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn < 0 ){
            quality += 2;
        } else{
            quality += 1;
        }
        if (quality > 50){
            quality = 50;
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
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
