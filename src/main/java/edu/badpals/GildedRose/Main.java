package edu.badpals.GildedRose;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

            List<Updateable> items = new ArrayList<>();
            items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
            items.add(new AgedBrie("Aged Brie", 2, 0));
            items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
            items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
            items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80));
            items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
            items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49));
            items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49));
            items.add(new Conjured("Conjured Mana Cake", 3, 6));

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Updateable item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateItems();
        }
    }
}
