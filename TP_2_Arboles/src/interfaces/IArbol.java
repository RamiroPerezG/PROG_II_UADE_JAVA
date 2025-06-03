package interfaces;

public interface IArbol {
	
	void agregar(int dni, String nombre);
	INodo buscar(int dni);
	INodo eliminar(int dni);
	void recorInorden();
	void recorPreorden();
	void recorPostorden();
	
}