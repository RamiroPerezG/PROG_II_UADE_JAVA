package modelo;

import interfaces.IPersona;

public class Persona implements IPersona{
    private int dni;
    private String nombre;
    // Usamos la lista doblemente enlazada
    private ListaDoblementeEnlazada listaVehiculos;

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.listaVehiculos = new ListaDoblementeEnlazada(); // solo se crea la lista
    }

	@Override
	public int getDni() {
        return dni;
    }

	@Override
	public void setDni(int dni) {
        this.dni = dni;
    }

	@Override
	public String getNombre() {
        return nombre;
    }

	@Override
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
	@Override
	public ListaDoblementeEnlazada getListaVehiculos() {
        return listaVehiculos;
    }

	@Override
	public void setListaVehiculos(ListaDoblementeEnlazada listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

	@Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
    }
	
	@Override
	public void mostrarPersona() {
        System.out.println(this);
        listaVehiculos.mostrarListaDesdeInicio(); 
    }

    
}


