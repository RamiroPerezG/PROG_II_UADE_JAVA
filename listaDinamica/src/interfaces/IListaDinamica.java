package interfaces;

import modelo.Nodo;

public interface IListaDinamica {
	
	public Nodo getPrimero();
	public void setPrimero(Nodo primero);
	public String toString();
	
	public void agregarUltimo(int d);
	public void agregarPrimero(int d);
	public void agregarGenerico(int d, int pos);
	
	//Si queres que retorne algo se lo pones (int o Nodo)
	public int eliminar(int pos);
	public int eliminarPrimero();
	public int eliminarUltimo();
	
	public int obtenerPrimero();
	public int obtenerUltimo();
	public int obtenerGenerico(int pos);
	
	public boolean estaVacia();
	public int cantidadElementos();
	public void mostrarLista();
}
