package br.udesc.devopsnapratica.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.udesc.devopsnapratica.exception.NaoFormaTrianguloException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TrianguloTest {

	@Test
	public void deveCriarTriangulo() throws NaoFormaTrianguloException {
		Triangulo triangulo = new Triangulo(3, 4, 5);
		assertTrue(triangulo != null, "triangulo deve ser diferente de nulo");
		assertEquals(3, triangulo.getLadoA(), "lado A deve ser 3");
		assertEquals(4, triangulo.getLadoB(), "lado B deve ser 4");
		assertEquals(5, triangulo.getLadoC(), "lado C deve ser 5");
	}
	
	 @Test
	 public void deveFalharAoTentarCriarTriangulo() {
	        Exception exception = assertThrows(NaoFormaTrianguloException.class, () ->
	        new Triangulo(3, 4, 50));
	        assertEquals("Não forma triangulo!", exception.getMessage());
	 }
	 
	 @Test
	 public void deveVerificarSeTrianguloEhEquilatero() throws NaoFormaTrianguloException {
		 Triangulo triangulo = new Triangulo(4,4,4);
		 assertEquals(TipoTriangulo.EQUILATERO, triangulo.getTipoTriangulo(), "Tipo do triangulo deve ser equilatero");		 
	 }
	 
	 @Test
	 public void deveVerificarSeTrianguloEhIsosceles() throws NaoFormaTrianguloException {
		 Triangulo triangulo = new Triangulo(4,4,5);
		 assertEquals(TipoTriangulo.ISOSCELES, triangulo.getTipoTriangulo(), "Tipo do triangulo deve ser escaleno");		 
	 }
	 
	 @Test
	 public void deveVerificarSeTrianguloEhEscaleno() throws NaoFormaTrianguloException {
		 Triangulo triangulo = new Triangulo(4,5,6);
		 assertEquals(TipoTriangulo.ESCALENO, triangulo.getTipoTriangulo(), "Tipo do triangulo deve ser escaleno");		 
	 }
	 
	 @Test
	 public void deveCalcularPerimetroTriangulo() throws NaoFormaTrianguloException {
		 Triangulo triangulo = new Triangulo(4,5,6);	
		 int perimetro = triangulo.calcularPerimetro();
		assertEquals(15, perimetro, "O perimétro deve ser 15");
	 }
	 
}
