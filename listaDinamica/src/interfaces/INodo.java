package interfaces;

import modelo.Nodo;

public interface INodo {

	public int getDato();
	public Nodo getSig();
	public void setSig(Nodo sig);
	public String toString();
}
