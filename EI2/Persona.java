package EI2;

public class Persona {
	
	private String nombre;
	
	public Persona (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre;
	}

}
