package edu.badpals.GildedRose.repository;

import edu.badpals.GildedRose.domain.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;

@ApplicationScoped
public class ItemRepo implements PanacheRepositoryBase<Item, Long> {
}
