package main;

public class Vertice {
	private Clave clave;
	private InfoVertice informacion;
	
	
	public Vertice(Clave clave, InfoVertice informacion) {
		super();
		this.clave = clave;
		this.informacion = informacion;
	}

	public Vertice() {
		super();
	}
	
	public InfoVertice getInformacion() {
		return informacion;
	}

	public void setInformacion(InfoVertice informacion) {
		this.informacion = informacion;
	}

	@Override
	public String toString() {
		return "Vertice [clave=" + clave + ", informacion=" + informacion + "]";
	}

	public Clave getClave() {
		return clave;
	}

	public void setClave(Clave clave) {
		this.clave = clave;
	}





}
