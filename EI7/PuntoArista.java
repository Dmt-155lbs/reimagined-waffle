package EI7;

public class PuntoArista {
	
	private String id;
	private int numero;

    public PuntoArista(int numero, String id) {
        this.id = id;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }
    
    public int getNumero() {
        return numero;
    }
   

    @Override
    public String toString() {
        return "Número del vértice: " + numero + " Vertice: " + id +  "; " ;
    }

	
	

}
