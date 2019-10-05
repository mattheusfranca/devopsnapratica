package br.udesc.devopsnapratica.modelo;

import br.udesc.devopsnapratica.exception.NaoFormaTrianguloException;

public class Triangulo implements FormaGeometrica {

	private int ladoA;
	private int ladoB;
	private int ladoC;
	
	public Triangulo() {
		
	}
	
	public Triangulo(int ladoA, int ladoB, int ladoC) throws NaoFormaTrianguloException {
		
		if(!formaTriangulo(ladoA, ladoB, ladoC))
			throw new  NaoFormaTrianguloException();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	private boolean formaTriangulo(double ladoA, double ladoB, double ladoC) {
		if(ladoA < (ladoB+ladoC) && ladoB < (ladoA + ladoC) && ladoC < (ladoA + ladoB)) {
			return true;			
		}
		return false;
	}
	
	public int getLadoA() {
		return ladoA;
	}

	public int getLadoB() {
		return ladoB;
	}

	public int getLadoC() {
		return ladoC;
	}

	public TipoTriangulo getTipoTriangulo() {
		if (ladoA == ladoB || ladoB == ladoC || ladoC == ladoA) {
            if (ladoA == ladoB && ladoB == ladoC) {
                return TipoTriangulo.EQUILATERO;
            } else {
            	return TipoTriangulo.ISOSCELES;
            }
        }
        else return TipoTriangulo.ESCALENO;
     }

	public void setLadoA(int ladoA) {
		this.ladoA = ladoA;
	}

	public void setLadoB(int ladoB) {
		this.ladoB = ladoB;
	}

	public void setLadoC(int ladoC) {
		this.ladoC = ladoC;
	}

	@Override
	public int calcularPerimetro() {
		return ladoA + ladoB + ladoC;
	}

}
