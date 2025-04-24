package modelo;

public class Nodo {

	private int dato;
	private Nodo sig;
	
	public Nodo(int dato) {
		super();
		this.dato = dato;
		this.sig = null;
	}
	public int getDato() {
		return dato;
	}
	public Nodo getSig() {
		return sig;
	}
	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + "]";
	}

	
	
}