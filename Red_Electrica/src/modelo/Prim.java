package modelo;

import java.util.ArrayList; // Clase que implementa una lista dinámica
import java.util.Comparator; // Interfaz para definir reglas de comparación entre objetos
import java.util.HashSet; // Clase que implementa un conjunto sin elementos repetidos
import java.util.List; // Interfaz que representa una lista ordenada
import java.util.Map; // Interfaz que representa una estructura clave → valor --> Sirve para usar mapas de forma genérica
import java.util.PriorityQueue; // Clase que implementa una cola con prioridad --> Los elementos se ordenan automáticamente segun el orden logico. Ej: numeros de menor a mayor
import java.util.Set; // Interfaz que representa un conjunto de elementos unicos --> Sirve para usar sets de forma genérica

import interfaces.INodo;

public class Prim {

    public static void ejecutar(Grafo grafo, int nodoInicio) {
        Map<Integer, Nodo> nodos = grafo.getNodos();

        // Verificar si el nodo de inicio existe en el grafo
        if (!nodos.containsKey(nodoInicio)) {
            System.out.println("La calle " + nodoInicio + " no existe.");
            return;
        }

        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<Arista> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        List<Arista> mst = new ArrayList<>();

        // Comenzar desde el nodo especificado
        visitados.add(nodoInicio);
        agregarAristas(grafo.getNodo(nodoInicio), visitados, cola);

        // Mientras haya aristas y no se haya completado el MST
        while (!cola.isEmpty() && visitados.size() < nodos.size()) {
            Arista arista = cola.poll();

            // Si el destino ya fue visitado, se descarta (evita ciclos)
            if (visitados.contains(arista.destino)) continue;

            // Agregar arista al MST
            mst.add(arista);
            visitados.add(arista.destino);

            // Agregar nuevas aristas desde el nuevo nodo visitado
            agregarAristas(grafo.getNodo(arista.destino), visitados, cola);
        }

        // Mostrar el árbol de expansión mínima
        System.out.println("\nCableado de red electrica desde la calle " + nodoInicio + ":");
        for (Arista a : mst) {
            System.out.println(a.origen + " - " + a.destino + " (peso=" + a.peso + ")");
        }
    }
    
    // Agrega a la cola todas las aristas desde un nodo no visitado
    private static void agregarAristas(Nodo nodo, Set<Integer> visitados, PriorityQueue<Arista> cola) {
        List<INodo> vecinos = nodo.getVecinos();
        List<Integer> pesos = nodo.getPesos();
        int origen = nodo.getValor();

        for (int i = 0; i < vecinos.size(); i++) {
            int destino = vecinos.get(i).getValor();
            int peso = pesos.get(i);
            if (!visitados.contains(destino)) {
                cola.add(new Arista(origen, destino, peso));
            }
        }
    }

    // Clase interna para representar una arista
    private static class Arista {
        int origen, destino, peso;

        Arista(int o, int d, int p) {
            origen = o;
            destino = d;
            peso = p;
        }
    }
}