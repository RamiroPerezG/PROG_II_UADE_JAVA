package interfaces;

import modelo.Persona; 

public interface INodo {

	Persona getDato();
	void setDato(Persona dato);
	INodo getIzq();
	void setIzq(INodo izq); 
	INodo getDer();
	void setDer(INodo der);
	
}
