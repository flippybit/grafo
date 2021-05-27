package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrafoDirigido {

	ArrayList<Vertice> vertices;
	ArrayList<Arista> aristas;

	public GrafoDirigido(ArrayList<Vertice> vertices, ArrayList<Arista> aristas) {
		super();
		this.vertices = vertices;
		this.aristas = aristas;
	}

	public GrafoDirigido() {
		super();
		this.vertices= new ArrayList<Vertice>();
		this.aristas= new ArrayList<Arista>();
	}
		

	// comprobar si las listas con nodos y arcos estan vacias
	public boolean esVacio() {
		if (this.aristas.size() == 0 && this.vertices.size() == 0)
			return true;
		else
			return false;
	}

	// insertar vertice dentro de la lista del grafo
	public void insertarVertice(Clave c, InfoVertice v) {
		
		Vertice verticeNuevo = new Vertice();
		verticeNuevo.setClave(c);
		verticeNuevo.setInformacion(v);
		this.vertices.add(verticeNuevo);

	}

	public void modificarVertice(Clave c, InfoVertice v) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.vertices.size() && encontrado != false) {

			if (this.vertices.get(i).getClave().getClave() == c.getClave()) {
				this.vertices.get(i).setInformacion(v);
				encontrado = true;
			}

			i++;
		}

	}

	public void eliminarVertice(Clave c) {
		if (existeVertice(c)) {
			int i = 0;
			boolean encontrado = false;
			while (i < this.vertices.size() && encontrado != false) {

				if (this.vertices.get(i).getClave().getClave() == c.getClave()) {
					encontrado = true;
					this.vertices.remove(i);

					// remove aristas tmb ?==
				} else {

					i++;
				}
			}
		}
	}

	public boolean existeVertice(Clave c) {

		int i = 0;
		boolean encontrado = false;
		while (i < this.vertices.size() && encontrado != true) {

			if (this.vertices.get(i).getClave().getClave() == c.getClave()) {
				encontrado = true;
			} else {
				i++;
			}
		}

		return encontrado;
	}

	public void insertarArista(Clave o, Clave d, Coste c) {

		Arista aristaNueva = new Arista(o, d, c);
		this.aristas.add(aristaNueva);

	}

	public void modificarArista(Clave o, Clave d, Coste c) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.aristas.size() && encontrado != true) {
			Arista aristaActual = this.aristas.get(i);
			if (aristaActual.getOrigen().getClave() == o.getClave()
					&& aristaActual.getDestino().getClave() == d.getClave()) {
				encontrado = true;

				aristaActual.setCoste(c);

			} else {
				i++;
			}

		}
	}

	public void eliminarArista(Clave o, Clave d) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.aristas.size() && encontrado != true) {

			if (this.aristas.get(i).getOrigen().getClave() == o.getClave()
					&& this.aristas.get(i).getDestino().getClave() == d.getClave()) {
				// ELIMINO ARISTA
				this.aristas.remove(i);
			}
		}
	}

	public Coste costeArista(Clave o, Clave d) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.aristas.size() && encontrado != true) {

			if (this.aristas.get(i).getOrigen().getClave() == o.getClave()
					&& this.aristas.get(i).getDestino().getClave() == d.getClave()) {
				// devuelvo coste
				return this.aristas.get(i).getCoste();
			} else {
				i++;
			}
		}

		return null;
	}

	public boolean existeArista(Clave o, Clave d) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.aristas.size() && encontrado != true) {
			Arista aristaActual = this.aristas.get(i);
			if (aristaActual.getOrigen().getClave() == o.getClave()
					&& aristaActual.getDestino().getClave() == d.getClave()) {
				encontrado = true;
			} else {
				i++;
			}
		}
		return encontrado;
	}

	// Busco todas las ocurrencias de la clave que sean "destino" dentro de la lista
	// de aristas.
	// (A,B) (A,C) (A,D) (B,C)
	// grado entrada del vertice C = 2
	// grado entrada del vertice A = 0
	public int gradoEntrada(Clave v) {
		int grado = 0;
		for (int i = 0; i < this.aristas.size(); i++) {
			if (this.aristas.get(i).getDestino() == v)
				grado++;
		}
		return grado;
	}

	// Busco todas las ocurrencias de la clave que sean origen en lista aristas
	// (A,B) (A,C) (A,D) (B,C)
	// grado de salida vertice A = 3
	// grado de salida vertice C = 0
	public int gradoSalida(Clave v) {
		int grado = 0;
		for (int i = 0; i < this.aristas.size(); i++) {
			if (this.aristas.get(i).getOrigen() == v)
				grado++;
		}
		return grado;
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public ArrayList<Clave> listaVertices() {
		// ArrayList<NOSE> = []
		ArrayList<Clave> lista_vertices = new ArrayList<>();

		for (int i = 0; i < this.vertices.size(); i++) {
			// anadir a la lista
			lista_vertices.add(this.vertices.get(i).getClave());
		}
		// devolver lista
		return lista_vertices;
	}

	public ArrayList<Clave> listaSucesores(Clave v) {

		ArrayList<Clave> lista_sucesores = new ArrayList<>();
		for (int i = 0; i < this.aristas.size(); i++) {

			if (this.aristas.get(i).getOrigen().getClave() == v.getClave()) {
				// anadir a la lista de sucesores
				lista_sucesores.add(this.aristas.get(i).getDestino());
			}
		}

		return lista_sucesores;
	}

	public ArrayList<Clave> listaPredecesores(Clave v) {
		// lista de predecesores
		ArrayList<Clave> lista_predecesores = new ArrayList<>();
		for (int i = 0; i < this.aristas.size(); i++) {

			if (this.aristas.get(i).getDestino().getClave() == v.getClave()) {
				// añadir a la lista de predecesores
				lista_predecesores.add(aristas.get(i).getOrigen());
			}

		}
		// detino =V
		return lista_predecesores;
	}

	 public ArrayList<Clave> listaAdyacentes(Clave v) {
		 ArrayList<Clave> lista_predecesores = new ArrayList<>();
		 ArrayList<Clave> lista_sucesores = new ArrayList<>();
		
		 lista_predecesores = listaPredecesores(v);
		 lista_sucesores = listaSucesores(v);
		 
		 ArrayList<Clave> lista_adyacentes = (ArrayList<Clave>) Stream.of(lista_predecesores, lista_sucesores)
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
		 
		 return lista_adyacentes;
	 }
	
	
	@Override
	public String toString() {
		return "GrafoDirigido [vertices=" + vertices + "/n , aristas=" + aristas + "] /n";
	}

	// Sólo si el grafo es NO DIRIGIDO, suponer la siguiente operación

	// en sustitución de las dos anteriores:

//	public ArrayList<Clave> listaAdyacentes(Clave v) {
//	}
}

/**
 * TAD Grafo Dirigido y TAD Grafo No Dirigido
 * 
 * public class Grafo<Clave, InfoVertice, Coste> {
 * 
 * private class NodoVertice { ... }
 * 
 * private class NodoArista { ... } Lista<NodoVertice> vertices;
 * 
 * Lista<Lista<NodoArista>> aristas;
 * 
 * public Grafo() { } public boolean esVacio() { }
 * 
 * public void insertarVertice(Clave c, InfoVertice v) { } public void
 * modificarVertice(Clave c, InfoVertice v) { } public void
 * eliminarVertice(Clave c) { } public boolean existeVertice(Clave c) { }
 * 
 * public void insertarArista(Clave o, Clave d, Coste c) { }
 * 
 * public void modificarArista(Clave o, Clave d, Coste c) { }
 * 
 * public void eliminarArista(Clave o, Clave d) { }
 * 
 * public Coste costeArista(Clave o, Clave d) { }
 * 
 * public boolean existeArista(Clave o, Clave d) { }
 * 
 * public int gradoEntrada(Clave v) { }
 * 
 * public int gradoSalida(Clave v) { }
 * 
 * public int numVertices() { }
 * 
 * public Lista<Clave> listaVertices() { }
 * 
 * public Lista<Clave> listaSucesores(Clave v) { }
 * 
 * public Lista<Clave> listaPredecesores(Clave v) { }
 * 
 * // Sólo si el grafo es NO DIRIGIDO, suponer la siguiente operación
 * 
 * // en sustitución de las dos anteriores:
 * 
 * public Lista<Clave> listaAdyacentes(Clave v) { }
 * 
 * }
 **/
