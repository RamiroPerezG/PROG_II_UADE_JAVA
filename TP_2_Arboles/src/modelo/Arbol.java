package modelo;

import interfaces.INodo;
import interfaces.IArbol;

public class Arbol implements IArbol {

	private INodo raiz;
	
	public Arbol() {
		this.raiz = null;
	}
	
	@Override
	public void agregar(int dni, String nombre) {
		Persona p = new Persona(dni, nombre);
		raiz = agregarRecursivo(raiz, p);
	}
	
	private INodo agregarRecursivo(INodo nodo, Persona p) {
		
		if(nodo == null) {
			return new Nodo(p);
		}
		
		if(p.getDni() < nodo.getDato().getDni()) {
			nodo.setIzq(agregarRecursivo(nodo.getIzq(), p));
		}
		else if (p.getDni() > nodo.getDato().getDni()) {
			nodo.setDer(agregarRecursivo(nodo.getDer(), p));
		}

		return nodo;
	}
	
	@Override
	public INodo buscar(int dni) {
		return buscarRecursivo(raiz,dni);
	}
	
	private INodo buscarRecursivo(INodo nodo, int dni) {
		if(nodo == null || nodo.getDato().getDni() == dni) {
			return nodo;
		}
		else if(dni < nodo.getDato().getDni()) {
			return buscarRecursivo(nodo.getIzq(),dni);
		}
		else {
			return buscarRecursivo(nodo.getDer(),dni);
		}
	}
	
	public INodo eliminar(int dni) {
		return eliminarRecursivo(raiz, dni);
	}
	
	public INodo eliminarRecursivo(INodo nodo, int dni) {
		if(nodo == null) {
			return nodo;
		}
		if(dni < nodo.getDato().getDni()) {
			nodo.setIzq(eliminarRecursivo(nodo.getIzq(),dni));
		}else if(dni > nodo.getDato().getDni()) {
			nodo.setDer(eliminarRecursivo(nodo.getDer(),dni));
		}else {
			if(nodo.getIzq() == null && nodo.getDer() == null) {
				nodo = null;
			}else if(nodo.getDer() != null) {
				nodo.setDato(encontrarMin(nodo).getDato());
				nodo.setDer(eliminarRecursivo(nodo.getDer(),nodo.getDato().getDni()));
			}else {
				nodo.setDato(encontrarMax(nodo).getDato());
				nodo.setIzq(eliminarRecursivo(nodo.getIzq(),nodo.getDato().getDni()));
			}
		}
		return nodo;
	}
	
	private INodo encontrarMin(INodo nodo) {
		nodo = nodo.getDer();
		while(nodo.getIzq() != null) {
			nodo = nodo.getIzq();
		}
		return nodo;
	}
	
	private INodo encontrarMax(INodo nodo) {
		nodo = nodo.getIzq();
		while(nodo.getDer() != null) {
			nodo = nodo.getDer();
		}
		return nodo;
	}

	
	@Override
	public void recorInorden() {
		recorInordenRecursivo(raiz);
	}
	
	private void recorInordenRecursivo(INodo nodo) {
		if(nodo != null) {
			recorInordenRecursivo(nodo.getIzq());
			System.out.print(nodo.getDato() + " ");
			recorInordenRecursivo(nodo.getDer());
		}
	}
	
	public void recorPreorden() {
		recorPreordenRecursivo(raiz);
	}
	
	private void recorPreordenRecursivo(INodo nodo) {
		if(nodo != null) {
			System.out.print(nodo.getDato() + " ");
			recorPreordenRecursivo(nodo.getIzq());
			recorPreordenRecursivo(nodo.getDer());
		}
	}
	
	public void recorPostorden() {
		recorPostordenRecursivo(raiz);
	}
	
	private void recorPostordenRecursivo(INodo nodo) {
		if(nodo != null) {
			recorPostordenRecursivo(nodo.getIzq());
			recorPostordenRecursivo(nodo.getDer());
			System.out.print(nodo.getDato() + " ");
		}
	}
}