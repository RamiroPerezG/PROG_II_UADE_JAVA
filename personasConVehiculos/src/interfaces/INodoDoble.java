package interfaces;

import modelo.NodoDoble;
import modelo.Vehiculo;

public interface INodoDoble {
	
		
    public Vehiculo getDato();

    public void setDato(Vehiculo dato) ;

   
    public NodoDoble getSiguiente();

    public void setSiguiente(NodoDoble primero);

    
    public NodoDoble getAnterior();

    public void setAnterior(NodoDoble anterior);

	
}

