package EI6;

public class PuntoArista {
	
	private String id;

    public PuntoArista(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
   

    @Override
    public String toString() {
        return "Vertice: " + id + "; " ;
    }

}
