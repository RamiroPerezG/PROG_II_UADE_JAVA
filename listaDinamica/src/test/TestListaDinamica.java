package test;

import modelo.ListaDinamica;

public class TestListaDinamica {

	public static void main(String[] args) {
		
		ListaDinamica l = new ListaDinamica();
		System.out.print(l.estaVacia()+"\n");
		l.agregarPrimero(10);
		l.agregarPrimero(20);
		l.agregarUltimo(5);
		l.mostrarLista();
		System.out.print(l.estaVacia()+"\n");
		System.out.println(l.cantidadElementos());
		System.out.println(l.obtenerGenerico(1));
		System.out.println(l.busquedaLineal(5));
		
		System.out.println(l.eliminarPrimero());
		l.mostrarLista();

	}

}
