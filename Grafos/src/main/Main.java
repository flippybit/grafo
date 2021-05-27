package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {	
		
		// Creo las claves
		Clave A = new Clave ('A');
		Clave B = new Clave ('B');
		Clave C = new Clave ('C');
		Clave D = new Clave ('D');
		Clave E = new Clave ('E');
		Clave F = new Clave ('F');
		Clave G = new Clave ('G');
		Clave H = new Clave ('H');
		
		GrafoDirigido grafo = new GrafoDirigido();
		
		Coste costezero = new Coste(0);
	
		

		grafo.insertarVertice(A, new InfoVertice("Hola soy un vertice/nodo 1 con la clave B"));
		grafo.insertarVertice(B, new InfoVertice("Hola soy un vertice/nodo 1 con la clave B"));
		grafo.insertarVertice(C, new InfoVertice("Hola soy un vertice/nodo 2 con la clave C"));
		grafo.insertarVertice(D, new InfoVertice("Hola soy un vertice/nodo 3 con la clave D"));
		grafo.insertarVertice(E, new InfoVertice("Hola soy un vertice/nodo 4 con la clave E"));
		grafo.insertarVertice(F, new InfoVertice("Hola soy un vertice/nodo 5 con la clave F"));
		grafo.insertarVertice(G, new InfoVertice("Hola soy un vertice/nodo 6 con la clave G"));
		grafo.insertarVertice(H, new InfoVertice("Hola soy un vertice/nodo 6 con la clave G"));
		
		// 
		grafo.insertarArista(A, D, costezero);
		
		// 
		grafo.insertarArista(B, A, costezero);
		grafo.insertarArista(B, E, costezero);
		grafo.insertarArista(B, C, costezero);
		
		
		//
		grafo.insertarArista(C, H, costezero);
		
		//
		grafo.insertarArista(D, F, costezero);
		grafo.insertarArista(D, E, costezero);
		
		//
		grafo.insertarArista(E, G, costezero);
		
		//
		grafo.insertarArista(F, G, costezero);
		
		
		//
		grafo.insertarArista(G,H,costezero);
		
		System.out.println(grafo.toString());
		
		System.out.println("Grado:" + GradoGrafoDirgido(grafo));
		
		System.out.println(esAlcanzable(grafo,H,E));
		
		ComponentesInconexos(grafo,A);

	}

	public static int GradoGrafoDirgido(GrafoDirigido grafo) {
		int entrada = 0;
		int salida = 0;
		int gradoMax = 0;
		int gradoActual = 0;

		for (int i = 0; i < grafo.vertices.size(); i++) {

			entrada = grafo.listaSucesores(grafo.vertices.get(i).getClave()).size();
			salida = grafo.listaPredecesores(grafo.vertices.get(i).getClave()).size();
			gradoActual = entrada - salida;
			if (gradoActual > gradoMax) {
				gradoMax = gradoActual;
			}

		}
		return gradoMax;

	}

/**
 * 
 * Ejercicio 1 (1,5 puntos): Supongamos que tenemos un grafo dirigido G definido
 * mediante el TAD Grafo Dirigido visto en la teoría (ver anexo). Se pide
 * escribir una función en Java que, recibiendo como entrada un grafo dirigido,
 * devuelva como resultado el grado del grafo. Utilizar para ello las
 * operaciones del TAD Grafo Dirigido (ver anexo). Calcular razonadamente su
 * complejidad.
 * 
 * */
 /* Ejercicio 2 (1,5 puntos): Codificar en Java una función booleana que reciba
 * como entrada un grafo dirigido G definido mediante el TAD Grafo Dirigido
 * visto en la teoría, y dos vértices v1 y v2 identificados por sus claves. La
 * función devolverá true si es posible alcanzar v1 desde v2, y falso en caso
 * contrario. Utilizar para ello las operaciones del TAD Grafo Dirigido (ver
 * anexo). Calcular razonadamente su complejidad.
 * 
 * */
public static boolean esAlcanzable(GrafoDirigido grafo , Clave origen , Clave destino) {
	Queue<Clave>cola = new ArrayDeque<>();
	ArrayList <Clave> visitados = new ArrayList<Clave>();
	cola.add(origen);
	visitados.add(origen);
	
	while(!cola.isEmpty()) {
		
		Clave v =cola.poll();
		if(v.getClave()==destino.getClave()) {
			return true ;
		}
		ArrayList<Clave> sucesoresv = grafo.listaSucesores(v);
		for(int i=0;i<sucesoresv.size();i++) {
			
			if(!visitados.contains(sucesoresv.get(i))) {
			 
			 cola.add(sucesoresv.get(i));
			 visitados.add(sucesoresv.get(i));
			}
		}
		
	}

	return false;
}


 /* Ejercicio 3 (1,5 puntos): Se tiene un grafo no dirigido G(V,A) implementado a
 * través del TAD Grafo No Dirigido (ver operaciones en el anexo). Se pide
 * codificar una función en Java que reciba como entrada dicho G y un vértice v
 * V, y que imprima en pantalla todos los vértices del grafo que no están en la
 * misma componente conexa que v.
 * 
 * 
 * 
 * Ejemplo: Para el grafo G de la figura, y suponiendo que el vértice v fuese E,
 * la salida debieran ser los vértices H, G, J e I.).
 * 
 **/

public static void ComponentesInconexos(GrafoDirigido grafo, Clave v) {
	
	ArrayList <Clave> visitados = new ArrayList<Clave>();
	Queue<Clave> por_visitar = new ArrayDeque<>(); 
	System.out.println("por visitar");
	// añadir todos los nodos adyacentes a la cola
	grafo.listaAdyacentes(v).forEach((nodo) -> por_visitar.add(nodo));
	
	// añadir primer nodo como visitado	
	visitados.add(v);
	
	while (!por_visitar.isEmpty()) {
		
		Clave actual = por_visitar.poll();
	
		if(!visitados.contains(actual) && !por_visitar.contains(actual));
		
		grafo.listaAdyacentes(actual).forEach((nodo) -> por_visitar.add(nodo));
	}
	System.out.println("por visitar");

	System.out.println("por visitar" + por_visitar);
	
}








}