package edu.badpals.GildedRose;

import edu.badpals.GildedRose.domain.Item;
import edu.badpals.GildedRose.repository.ItemRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigInteger;
import java.util.Optional;

@ApplicationScoped
public class ServicesGuilded {
    @Inject
    ItemRepo itemRepo;

    public ServicesGuilded(){}

    public Item cargaItem(Long id){
        Optional<Item> item = itemRepo.findByIdOptional(id);
        return item.orElseGet(Item::new);
    }

    @Transactional
    public Item crearItem(Item item){
        itemRepo.persist(item);
        return this.cargaItem(item.getId());
    }

    @Transactional
    public void deleteItem(Item item){
        itemRepo.delete(item);
    }
}
