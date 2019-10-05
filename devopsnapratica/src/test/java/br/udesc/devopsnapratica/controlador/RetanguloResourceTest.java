package br.udesc.devopsnapratica.controlador;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class RetanguloResourceTest {

	@Test
	public void testCalcularPerimetroRetanguloEndpoint() {
	String jsonEntrada = "{ \"base\": 4, \"altura\": 5 }";
    	
    	given()
          .when()
          .contentType(ContentType.JSON)
          .body(jsonEntrada)
          .post("/retangulo/perimetro")
          .then()
             .statusCode(200)
             .body(containsString("18"));
	}
	
	@Test
	public void testCalcularAreaRetanguloEndpoint() {
		String jsonEntrada = "{ \"base\": 4, \"altura\": 5 }";
    	
		given()
        .when()
        .contentType(ContentType.JSON)
        .body(jsonEntrada)
        .post("/retangulo/area")
        .then()
           .statusCode(200)
           .body(containsString("20"));
	}
}
