package modelo;

import interfaces.INodo;

public class Nodo implements INodo{

	private Persona dato;
	private INodo der;
	private INodo izq;
	
	public Nodo(Persona dato) {
		this.dato = dato;
		this.der = null;
		this.izq = null;
	}

	public Persona getDato() {
		return dato;
	}

	public void setDato(Persona dato) {
		this.dato = dato;
	}

	public INodo getDer() {
		return der;
	}

	public void setDer(INodo der) {
		this.der = der;
	}

	public INodo getIzq() {
		return izq;
	}

	public void setIzq(INodo izq) {
		this.izq = izq;
	}
	
	
}
