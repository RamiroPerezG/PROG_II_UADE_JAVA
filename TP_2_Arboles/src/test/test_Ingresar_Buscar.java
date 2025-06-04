package test;

import interfaces.INodo;
import interfaces.IArbol;
import modelo.Arbol;

public class test_Ingresar_Buscar {

	public static void main(String[] args) {
		
		IArbol Arbol = new Arbol();
		
		Arbol.agregar(123456,"D");  // #4
		Arbol.agregar(234568, "I");  // #9
		Arbol.agregar(124265, "E");  // #5
		Arbol.agregar(111234, "B");  // #2
		Arbol.agregar(752635, "O");  // #15
		Arbol.agregar(688523, "M");  // #13
		Arbol.agregar(698223, "N");  // #14
		Arbol.agregar(102355, "A");  // #1
		Arbol.agregar(124447, "F");  // #6
		Arbol.agregar(266532, "J");  // #10
		Arbol.agregar(156889, "H");  // #8
		Arbol.agregar(123455, "C");  // #3
		Arbol.agregar(155566, "G");  // #7
		Arbol.agregar(444556, "L");  // #12
		Arbol.agregar(332562, "K");  // #11
		
		System.out.print("Busqueda de 124447: "); // #6
		INodo nodo = Arbol.buscarDni(124447);
		System.out.println(nodo.getDato().toString());
		
		System.out.print("Busqueda de 332562: "); // #11
		nodo = Arbol.buscarDni(332562);
		System.out.println(nodo.getDato().toString());
		
		System.out.print("Busqueda de E: ");
		nodo = Arbol.buscarNombre("E");
		System.out.println(nodo.getDato().toString());

	}

}
