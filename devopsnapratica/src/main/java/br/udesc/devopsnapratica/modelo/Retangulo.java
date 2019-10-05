package br.udesc.devopsnapratica.modelo;

public class Retangulo implements FormaGeometrica {

	private int base;
	private int altura;
	
	public Retangulo() {
		
	}
	
	public Retangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public int calcularPerimetro() {
		return base * 2 + altura * 2;
	}

	public int calcularArea() {
		return base * altura;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
}
