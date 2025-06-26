package test;

import modelo.Grafo;

import modelo.Prim;



public class TestGrafo {
    public static void main(String[] args) {

        // Crear una instancia de grafo vacío
        Grafo grafo = new Grafo();

        // Agregar nodos al grafo (identificados por enteros del 1 al 5)
        grafo.agregarNodo(1);
        grafo.agregarNodo(2);
        grafo.agregarNodo(3);
        grafo.agregarNodo(4);
        grafo.agregarNodo(5);

        // Agregar aristas con pesos entre los nodos 
        grafo.agregarArista(4, 2, 3); // 4 -> 2 con peso 3
        grafo.agregarArista(3, 2, 1); // 3 -> 2 con peso 1
        grafo.agregarArista(1, 4, 2); // 1 -> 4 con peso 2
        grafo.agregarArista(1, 4, 4); // 1 -> 4 con peso 4
        grafo.agregarArista(5, 5, 2); // 5 -> 5 con peso 2
        grafo.agregarArista(5, 1, 3); // 5 -> 1 con peso 3
        grafo.agregarArista(3, 1, 1); // 3 -> 1 con peso 1
        
        // Mostrar la lista de adyacencia del grafo (vecinos y pesos de cada nodo)
        grafo.mostrarListaAdyacencia();

        // Prim para árbol de expansión mínima desde 5
        Prim.ejecutar(grafo, 5);
        
    }
}