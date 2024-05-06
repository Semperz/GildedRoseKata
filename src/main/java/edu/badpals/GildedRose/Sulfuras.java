package edu.badpals.GildedRose;

public class Sulfuras extends Item implements Updateable{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
    }

    @Override
    public void updateSellIn() {
    }

    @Override
    public int getQuality() {
        return this.quality;
    }

    @Override
    public int getSellIn() {
        return this.sellIn;
    }
    public String getName() {
        return this.name;
    }
}
