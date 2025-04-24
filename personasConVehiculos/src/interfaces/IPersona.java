package interfaces;

import modelo.ListaDoblementeEnlazada;

public interface IPersona {
	public int getDni();

    public void setDni(int dni);

    public String getNombre();

    public void setNombre(String nombre);

    public ListaDoblementeEnlazada getListaVehiculos();

    public void setListaVehiculos(ListaDoblementeEnlazada listaVehiculos);

  
    public void mostrarPersona();
}
