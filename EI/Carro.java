package EI;

public class Carro {
	private String marca;
	
	public Carro(String marca){
		this.marca = marca;
		
	}
	
	public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Carro [Marca=" + marca + "]";
    }
    
    



}
