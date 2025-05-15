package EI6;

import TDA.Edge;
import TDA.Vertex;

public class MainEI6 {

	public static void main(String[] args) {
		GrafoController grafo=new GrafoController();
		PuntoArista s1=new PuntoArista("A");
		PuntoArista s2=new PuntoArista("B");
		PuntoArista s3=new PuntoArista("C");
		PuntoArista s4=new PuntoArista("D");
		PuntoArista s5=new PuntoArista("E");
		PuntoArista s6=new PuntoArista("F");
		PuntoArista s7=new PuntoArista("G");
		
		Vertex<PuntoArista> v1=grafo.addVertice(s1);
		Vertex<PuntoArista> v2=grafo.addVertice(s2);
		Vertex<PuntoArista> v3=grafo.addVertice(s3);
		Vertex<PuntoArista> v4=grafo.addVertice(s4);
		Vertex<PuntoArista> v5=grafo.addVertice(s5);
		Vertex<PuntoArista> v6=grafo.addVertice(s6);
		Vertex<PuntoArista> v7=grafo.addVertice(s7);
		
		Edge<String>e1=grafo.addArista(v1, v2, "AB");
		Edge<String>e2=grafo.addArista(v2, v5, "BE");
		Edge<String>e3=grafo.addArista(v1, v3, "AC");
		Edge<String>e4=grafo.addArista(v3, v4, "CD");
		Edge<String>e5=grafo.addArista(v4, v7, "DG");
		Edge<String>e6=grafo.addArista(v5, v6, "EF");
		Edge<String>e7=grafo.addArista(v4, v5, "DE");
		
		System.out.println("\nNúmero de vértices");
		System.out.println(grafo.numeroVertices());
		System.out.println("\nNúmero de aristas");
		System.out.println(grafo.numeroAristas());
		
		//Vertices Aristas y Aristas que llegan a un vertice
		System.out.println(grafo.vertice());
		System.out.println(grafo.aristas());
		System.out.println(grafo.aristasVertice(v3));
		
		
		System.out.println("\nNúmero de aristas que llegan al vertice 4");
		System.out.println(grafo.gradoVertice(v4));
		
		//Arista que conecta a vertice
		System.out.println(grafo.getArista(v5,v6));
		
		//Vertice opuesto y vertices conectados por la arista
		System.out.println(grafo.verticeOpuesto(v1, e1));
		System.out.println(grafo.verticesConectados(e4));

		System.out.println("\nRecorrido DFS Completo");
		System.out.println(grafo.DFSCompleto());
		System.out.println(grafo.DFS(v7));
		
		System.out.println("\nRecorrido BFS Completo");
		System.out.println(grafo.BFSCompleto());
		System.out.println(grafo.BFS(v4));
		
		
		System.out.println("\nCaminos");
		System.out.println(grafo.path(v1, v7));
		System.out.println(grafo.path(v6, v1));
		System.out.println(grafo.path(v4, v6));
		
		System.out.println("\nEliminación del vertice 7");
		grafo.removerVertice(v7);
		/*System.out.println("\nNúmero de aristas que llegan al vertice 4 luego de la eliminación del vertice 7");
		System.out.println(grafo.gradoVertice(v4));*/

	}

}
