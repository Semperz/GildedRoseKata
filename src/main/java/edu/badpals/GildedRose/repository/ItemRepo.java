package edu.badpals.GildedRose.repository;

import edu.badpals.GildedRose.domain.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.List;

@ApplicationScoped
public class ItemRepo implements PanacheRepositoryBase<Item, Long> {

    public Item cargaItem(String nombre){
        List<Item> items = this.listAll();
        return items.stream().filter(item -> item.name.equals(nombre)).findFirst().orElse(new Item());
    }

}
