package main;

public class Arista {
	
	private Clave origen;
	private Clave destino;
	private Coste coste;

	public Arista(Clave origen, Clave destino, Coste coste) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.coste = coste;
	}
	
	@Override
	public String toString() {
		return "Arista [origen=" + origen + ", destino=" + destino + ", coste=" + coste + "]";
	}

	
	// constructor sin coste
	public Arista (Clave origen, Clave destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}
	

	public Clave getOrigen() {
		return origen;
	}

	public void setOrigen(Clave origen) {
		this.origen = origen;
	}

	public Clave getDestino() {
		return destino;
	}

	public void setDestino(Clave destino) {
		this.destino = destino;
	}

	public Arista() {
		super();
	}

	public Coste getCoste() {
		return coste;
	}

	public void setCoste(Coste coste) {
		this.coste = coste;
	}


	
}
