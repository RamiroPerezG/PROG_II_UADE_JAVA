package modelo;

import interfaces.INodoDoble;

public class NodoDoble implements INodoDoble {
	
	    private Vehiculo dato;
	    private NodoDoble siguiente;
	    private NodoDoble anterior; 

	    // Constructor
	    public NodoDoble(Vehiculo dato) {
	        this.dato = dato;
	        this.siguiente = null;
	        this.anterior = null;
	    }

		@Override
		public Vehiculo getDato() {
	        return dato;
	    }

		@Override
		public void setDato(Vehiculo dato) {
	        this.dato = dato;
	    }

		@Override
		public NodoDoble getSiguiente() {
	        return siguiente;
	    }

		@Override
		public void setSiguiente(NodoDoble siguiente) {
	        this.siguiente = siguiente;
	    }

		@Override
		public NodoDoble getAnterior()  {
	        return anterior;
	    }

		@Override
		public void setAnterior(NodoDoble anterior){
	        this.anterior = anterior;
	    }

		
	    
}


