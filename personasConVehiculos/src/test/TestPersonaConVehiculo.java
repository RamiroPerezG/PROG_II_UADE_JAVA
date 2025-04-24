package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaConVehiculo {

	public static void main(String[] args) {
		 // Crear una persona
        Persona persona = new Persona(39529732, "Leandro Molinas");

        // Crear vehículos
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota Corolla");
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", "Honda Civic");
        Vehiculo vehiculo3 = new Vehiculo("LMN456", "Ford Fiesta");

        // Insertar vehículos a la lista de la persona
        persona.getListaVehiculos().insertarPrimero(vehiculo1); // se inserta al inicio
        persona.getListaVehiculos().insertarUltimo(vehiculo2);  // se inserta al final
        persona.getListaVehiculos().insertarPrimero(vehiculo3); // ahora este queda primero

        // Mostrar persona y su lista de vehículos
        persona.mostrarPersona();		

	}
}
