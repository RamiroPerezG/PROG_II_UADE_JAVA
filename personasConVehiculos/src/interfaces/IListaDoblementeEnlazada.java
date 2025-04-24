package interfaces;


import modelo.Vehiculo;

public interface IListaDoblementeEnlazada {
	public boolean esVacia();

    public void insertarPrimero(Vehiculo dato);

    public void insertarUltimo(Vehiculo dato);

    public Vehiculo obtenerPrimero();

    public int cantidadElementos();

    public void mostrarListaDesdeInicio();
    public void mostrarListaDesdeFinal();
}
