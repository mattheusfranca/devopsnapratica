package br.udesc.devopsnapratica.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class RetanguloTest {

	@Test
	public void deveCalcularPerimetroRetangulo() {
		int base = 4;
		int altura = 5;
		Retangulo retangulo = new Retangulo(base, altura);
		int perimetro = retangulo.calcularPerimetro();
		assertEquals(18, perimetro, "O perímetro deve ser 18");
	}
	
	@Test
	public void deveCalcularAreaRetangulo() {
		int base = 4;
		int altura = 5;
		Retangulo retangulo = new Retangulo(base, altura);
		int area = retangulo.calcularArea();
		assertEquals(20, area, "A área deve ser 20");
	}
}
