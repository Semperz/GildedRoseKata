package edu.badpals.GildedRose;

import edu.badpals.GildedRose.domain.Item;
import edu.badpals.GildedRose.repository.ItemRepo;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
public class ServicesGuildedTest {

    @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    ServicesGuilded servicio;


    @Inject
    ItemRepo itemRepo;

    @Test
    public void test_mapping_normalItem() {
        Item elixir = em.find(Item.class, 2000L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.name).isEqualTo(("Elixir of the Mongoose"));
        Assertions.assertThat(elixir.quality).isEqualTo(7);
        Assertions.assertThat(elixir.sellIn).isEqualTo(15);
    }

    @Test
    public void test_carga_normalItem() {
        Item elixir = servicio.cargaItem(2000L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.name).isEqualTo(("Elixir of the Mongoose"));
        Assertions.assertThat(elixir.quality).isEqualTo(7);
        Assertions.assertThat(elixir.sellIn).isEqualTo(15);
    }

    @Test
    public void test_carga_normalItem_no_existe() {
        Item elixir = servicio.cargaItem(2L);
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.name).isEmpty();
        Assertions.assertThat(elixir.quality).isZero();
        Assertions.assertThat(elixir.sellIn).isZero();
    }

    @Test
    public void test_carga_items(){
        Assertions.assertThat(servicio).isNotNull();

        List<Item> items = servicio.cargaItems("Elixir of the Mongoose");
        Assertions.assertThat(items).isNotEmpty().hasSize(2);
        Assertions.assertThat(items.get(0)).hasFieldOrPropertyWithValue("name", "Elixir of the Mongoose");
        Assertions.assertThat(items.get(1)).hasFieldOrPropertyWithValue("quality", 10);

        // test no existe el item
        Assertions.assertThat(servicio.cargaItems("Varita de Sauco")).isEmpty();
    }

    @Test
    @Transactional
    public void test_crea_normalItem() {

        Integer largo = itemRepo.listAll().size();
        Item item = new Item("Sulfura", 50, 3);
        Item item2 = servicio.crearItem(item);
        Assertions.assertThat(item2.name).isEqualTo("Sulfura");
        Assertions.assertThat(item2.sellIn).isEqualTo(50);
        Assertions.assertThat(item2.quality).isEqualTo(3);

        Assertions.assertThat(itemRepo.listAll().size()).isEqualTo(largo + 1);
    }

    @Test
    @Transactional
    public void test_delete_normalItem() {


        Item item = new Item("Sulfura", 50, 3);
        servicio.crearItem(item);

        Integer largo = itemRepo.listAll().size();

        servicio.deleteItem(item);

        Assertions.assertThat(itemRepo.listAll().size()).isEqualTo(largo - 1);
    }

}
