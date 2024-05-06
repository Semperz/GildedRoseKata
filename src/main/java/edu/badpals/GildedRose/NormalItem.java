package edu.badpals.GildedRose;

public class NormalItem extends Item implements Updateable{

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateQuality() {
        if (sellIn < 0){
            quality -= 2;
        } else{
            quality -= 1;
        }
        if (quality < 0){
            quality  = 0;
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
        return this.sellIn;
    }
    public String getName() {
        return this.name;
    }

}
