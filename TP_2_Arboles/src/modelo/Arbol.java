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
	public INodo buscarDni(int dni) {
		return buscarRecursivoDni(raiz,dni);
	}
	
	private INodo buscarRecursivoDni(INodo nodo, int dni) {
		if(nodo == null || nodo.getDato().getDni() == dni) {
			return nodo;
		}
		else if(dni < nodo.getDato().getDni()) {
			return buscarRecursivoDni(nodo.getIzq(),dni);
		}
		else {
			return buscarRecursivoDni(nodo.getDer(),dni);
		}
	}
	
	@Override
	public INodo buscarNombre(String nombre) {
		return buscarRecursivoNombre(raiz,nombre);
	}
	
	private INodo buscarRecursivoNombre(INodo nodo, String nombre) {
		int cmp = nombre.compareTo(nodo.getDato().getNombre());
		if(nodo == null || cmp == 0) {
			return nodo;
		}
		else if(cmp < 0) {
			return buscarRecursivoNombre(nodo.getIzq(),nombre);
		}
		else {
			return buscarRecursivoNombre(nodo.getDer(),nombre);
		}
	}
	
	public INodo eliminarDni(int dni) {
		return eliminarRecursivoDni(raiz, dni);
	}
	
	public INodo eliminarRecursivoDni(INodo nodo, int dni) {
		if(nodo == null) {
			return nodo;
		}
		if(dni < nodo.getDato().getDni()) {
			nodo.setIzq(eliminarRecursivoDni(nodo.getIzq(),dni));
		}else if(dni > nodo.getDato().getDni()) {
			nodo.setDer(eliminarRecursivoDni(nodo.getDer(),dni));
		}else {
			if(nodo.getIzq() == null && nodo.getDer() == null) {
				nodo = null;
			}else if(nodo.getDer() != null) {
				nodo.setDato(encontrarMin(nodo).getDato());
				nodo.setDer(eliminarRecursivoDni(nodo.getDer(),nodo.getDato().getDni()));
			}else {
				nodo.setDato(encontrarMax(nodo).getDato());
				nodo.setIzq(eliminarRecursivoDni(nodo.getIzq(),nodo.getDato().getDni()));
			}
		}
		return nodo;
	}
	
	public INodo eliminarNombre(String nombre) {
		return eliminarRecursivoNombre(raiz, nombre);
	}
	
	public INodo eliminarRecursivoNombre(INodo nodo, String nombre) {
		int cmp = nombre.compareTo(nodo.getDato().getNombre());
		if(cmp < 0) {
			nodo.setIzq(eliminarRecursivoNombre(nodo.getIzq(),nombre));
		}else if(cmp > 0) {
			nodo.setDer(eliminarRecursivoNombre(nodo.getDer(),nombre));
		}else {
			if(nodo.getIzq() == null && nodo.getDer() == null) {
				nodo = null;
			}else if(nodo.getDer() != null) {
				nodo.setDato(encontrarMin(nodo).getDato());
				nodo.setDer(eliminarRecursivoNombre(nodo.getDer(),nodo.getDato().getNombre()));
			}else {
				nodo.setDato(encontrarMax(nodo).getDato());
				nodo.setIzq(eliminarRecursivoNombre(nodo.getIzq(),nodo.getDato().getNombre()));
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