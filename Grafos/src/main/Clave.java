package main;

public class Clave {
	private char clave;

	@Override
	public String toString() {
		return "Clave [clave=" + clave + "]";
	}

	public char getClave() {
		return clave;
	}

	public void setClave(char clave) {
		this.clave = clave;
	}

	public Clave(char clave) {
		super();
		this.clave = clave;
	}
	

}
