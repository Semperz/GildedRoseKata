package edu.badpals.GildedRose;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ResourcesTest {

    @Inject
    ResourceGuilded resources;

    @Test
    public void test_wellcome() {
        given()
                .contentType(ContentType.TEXT)
                .when()
                .get("/wellcome")
                .then()
                .statusCode(200)
                .body(is("Wellcome!"));
    }

    @Test
    public void test_get_item() {

        given()
                .pathParam("name", "Elixir of the Mongoose")
                .when()
                .get("/item/{name}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Elixir of the Mongoose"),
                        "quality", equalTo(7),
                        "sellIn", equalTo(15),
                        "id", equalTo(2000));

        given()
                .pathParam("name", "Varita de Sauco")
                .when()
                .get("/item/{name}")
                .then()
                .statusCode(404);
    }

    @Test
    public void test_post_item() {

        given()
                .body("{\"name\": \"Resurrection Stone\", \"sellIn\": \"10\", \"quality\": \"666\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/item")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Resurrection Stone"),
                        "quality", equalTo(666),
                        "sellIn", equalTo(10),
                        "id", equalTo(1));
    }



    @Test
    public void test_get_items() throws Exception {

        given()
                .pathParam("name", "Elixir of the Mongoose")
                .when()
                .get("/items/{name}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(2),
                        "name", containsInAnyOrder("Elixir of the Mongoose", "Elixir of the Mongoose"),
                        "quality", containsInAnyOrder(10, 7),
                        "sellIn", containsInAnyOrder(15, 5));


        given()
                .pathParam("name", "Varita de Sauco")
                .when()
                .get("/items/{name}")
                .then()
                .statusCode(404);
    }
    @Test
    public void test_delete_item() {

        given()
                .body("{\"name\": \"+5 Dexterity Vest\", \"quality\": \"20\", \"sellIn\": \"12\", \"id\": \"1000\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/item/")
                .then()
                .statusCode(200)
                .body("$.size()", is(0));
    }
}