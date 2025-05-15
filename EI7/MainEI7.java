package EI7;

import TDA.Vertex;

public class MainEI7 {

	public static void main(String[] args) {
		
		PuntoArista s1=new PuntoArista(1, "A");
		PuntoArista s2=new PuntoArista(2, "B");
		PuntoArista s3=new PuntoArista(3, "C");
		PuntoArista s4=new PuntoArista(4, "D");
		PuntoArista s5=new PuntoArista(5, "E");
		PuntoArista s6=new PuntoArista(6, "F");
		PuntoArista s7=new PuntoArista(7, "G");
		PuntoArista s8=new PuntoArista(8, "H");
		PuntoArista s9=new PuntoArista(9, "I");
		PuntoArista s10=new PuntoArista(10, "J");

		
		GrafoController grafo=new GrafoController();
		
		Vertex<PuntoArista>v1=grafo.addVertice(s1);
		Vertex<PuntoArista>v2=grafo.addVertice(s2);
		Vertex<PuntoArista>v3=grafo.addVertice(s3);
		Vertex<PuntoArista>v4=grafo.addVertice(s4);
		Vertex<PuntoArista>v5=grafo.addVertice(s5);
		Vertex<PuntoArista>v6=grafo.addVertice(s6);
		Vertex<PuntoArista>v7=grafo.addVertice(s7);
		Vertex<PuntoArista>v8=grafo.addVertice(s8);
		Vertex<PuntoArista>v9=grafo.addVertice(s9);
		Vertex<PuntoArista>v10=grafo.addVertice(s10);
		
		grafo.addArista(v1, v2, "AB");
		grafo.addArista(v3, v2, "CB");
		grafo.addArista(v5, v3, "EC");
		grafo.addArista(v3, v6, "CF");
		grafo.addArista(v6, v7, "FG");
		grafo.addArista(v2, v4, "BD");
		grafo.addArista(v4, v8, "DH");
		grafo.addArista(v8, v10, "HJ");
		grafo.addArista(v8, v9, "HI");
		System.out.println("Número de Vertices");
		System.out.println(grafo.numeroVertices());
		System.out.println("\nNúmero de Aristas");
		System.out.println(grafo.numeroAristas());
		System.out.println(grafo.vertices());
		System.out.println(grafo.aristas());


		System.out.println("\nGrado de salida para el vertice 5: ");
		System.out.println(grafo.gradoOutgoingCompu(v5));
		System.out.println("\nGrado de entrada para el vertice 2: ");
		System.out.println(grafo.gradoIncomingCompu(v2));
		
		
		System.out.println(grafo.conexionesEntrada(v10));
		System.out.println(grafo.conexionesSalida(v1));
		System.out.println(grafo.conexionesSalida(v2));
		System.out.println(grafo.conexionesSalida(v3));
		System.out.println(grafo.conexionesSalida(v4));
		System.out.println(grafo.conexionesSalida(v5));
		System.out.println(grafo.conexionesSalida(v6));
		System.out.println(grafo.conexionesSalida(v7));
		System.out.println(grafo.conexionesSalida(v8));
		System.out.println(grafo.conexionesSalida(v9));
		System.out.println(grafo.conexionesSalida(v10));


		System.out.println("Grafo Original");
		System.out.println(grafo.drawing());

		
		///////////////////
		System.out.println(grafo.isDAG());
		System.out.println(grafo.topological());
		
		System.out.println("Grafo con cierre transitivo");
		grafo.transitiveClosure();

		System.out.println(grafo.drawing());

		System.out.println("Número de conexiones de Internet luego de cierre transitivo");
		System.out.println(grafo.numeroAristas());

	}

}
