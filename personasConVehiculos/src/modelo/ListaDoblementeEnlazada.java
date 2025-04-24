package modelo;

import interfaces.IListaDoblementeEnlazada;
import interfaces.INodoDoble;


public class ListaDoblementeEnlazada implements IListaDoblementeEnlazada {
	private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

	@Override
	public boolean esVacia(){
        return primero == null;
    }

	@Override
	public void insertarPrimero(Vehiculo dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }

	@Override
	public void insertarUltimo(Vehiculo dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
    }

	@Override
	public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

	@Override
	public int cantidadElementos() {
        int contador = 0;
        INodoDoble actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

	@Override
	public void mostrarListaDesdeInicio() {
        INodoDoble actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

	@Override
	public void mostrarListaDesdeFinal() {
        INodoDoble actual = ultimo;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        }
    }

    
}
