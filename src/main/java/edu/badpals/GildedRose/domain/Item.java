package edu.badpals.GildedRose.domain;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name="t_items")
public class Item{

    @Column(name = "item_nom")
    public String name = "";

    @Column(name = "item_sellin")
    public int sellIn = 0;

    @Column(name = "item_quality")
    public int quality = 0;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item() {}

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
