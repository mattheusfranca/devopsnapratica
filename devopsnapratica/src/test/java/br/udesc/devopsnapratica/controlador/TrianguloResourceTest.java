package br.udesc.devopsnapratica.controlador;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

//import com.google.gson.Gson;

import br.udesc.devopsnapratica.exception.NaoFormaTrianguloException;
import br.udesc.devopsnapratica.modelo.TipoTriangulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class TrianguloResourceTest {

    @Test
    public void testTipoTrianguloEndpoint() throws NaoFormaTrianguloException {
    	String jsonEntrada = "{ \"ladoA\": 3, \"ladoB\": 3, \"ladoC\": 3 }";
    	
    	given()
          .when()
          .contentType(ContentType.JSON)
          .body(jsonEntrada)
          .post("/triangulo/tipo")
          .then()
             .statusCode(200)
             .body(containsString(TipoTriangulo.EQUILATERO.toString()));
    }
    
    @Test
    public void testNaoFormaTriangulo() {
    	String jsonEntradaIncorreta = "{ \"ladoA\": 30, \"ladoB\": 3, \"ladoC\": 3 }";
    	given()
          .when()
          .contentType(ContentType.JSON)
          .body(jsonEntradaIncorreta)
          .post("/triangulo/tipo")
          .then()
             .statusCode(400)
             .body(containsString("Não forma triangulo"));
    }
}
