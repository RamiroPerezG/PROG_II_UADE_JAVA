package interfaces;

public interface IArbol {
	
	void agregar(int dni, String nombre);
	INodo buscarDni(int dni);
	INodo buscarNombre(String nombre);
	INodo eliminarDni(int dni);
	INodo eliminarNombre(String nombre);
	void recorInorden();
	void recorPreorden();
	void recorPostorden();
	
}