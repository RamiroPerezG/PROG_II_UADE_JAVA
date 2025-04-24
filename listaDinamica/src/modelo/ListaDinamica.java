package modelo;


import modelo.Nodo;

public class ListaDinamica {

	private Nodo primero;

	public ListaDinamica(Nodo primero) {
		super();
		this.primero = primero;
	}
	public ListaDinamica() {
		super();
		this.primero = null;
	}
	public Nodo getPrimero() {
		return primero;
	}
	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}
	
	public void mostrarLista() {
		Nodo actual = this.primero;
		while(actual != null) {
			System.out.print(actual.getDato() + "->");
			actual = actual.getSig();
		}
		System.out.println("null");
	}
	
	public void agregarPrimero(int d) {

		Nodo nuevoNodo = new Nodo(d);

		if(!estaVacia()) {
			nuevoNodo.setSig(this.primero);
			this.primero = nuevoNodo;	
		}else {
			this.primero = nuevoNodo;
		}
		
	};
	
	public void agregarUltimo(int d) {
		
		Nodo nuevoNodo = new Nodo(d);
		
		Nodo actual = this.primero;
		
		if(!estaVacia()) {
			while(actual.getSig()!=null) {
				actual = actual.getSig();
			}
			actual.setSig(nuevoNodo);	
		}else {
			agregarPrimero(d);	
		}
	};
	
	public int cantidadElementos() {
		int cantidad= 0;
		Nodo actual = this.primero;
		if(!estaVacia()) {
			cantidad++;
			while(actual.getSig()!=null) {
				actual = actual.getSig();
				cantidad++;
			}
		}else {
			cantidad = -1;
		}
		
		return cantidad;
	};
	public int obtenerGenerico(int pos) {
		
		if(!estaVacia() && pos<cantidadElementos()) {
			int i = 0;
			Nodo actual = this.primero;
			
			while(i < pos) {
				actual = actual.getSig();
				i++;
			}
			return actual.getDato();
		}else {
			return -1;
		}
	};
	
	public boolean estaVacia() {
	
		boolean resp = (primero == null);
		
		return resp;
	};
	
	public int busquedaLineal(int d) {
		int pos = 0;
		Nodo actual = this.primero;
		
		if(!estaVacia()) {
			while(actual.getDato() != d && actual.getSig() != null) {
				actual = actual.getSig();
				pos++;
			}
			if(actual.getDato() != d) {
				return -1;
			}else {
				return pos;
			}
		}else {
			return -1;
		}
	};
	
	public int eliminarPrimero() {
		Nodo elim = this.primero;
		this.primero = this.primero.getSig() ;
		return elim.getDato();
	}
}
