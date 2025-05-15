package EI7;

import TDA.AdjacencyMapGraph;
import TDA.Edge;
import TDA.GraphAlgorithms;
import TDA.PositionalList;
import TDA.Vertex;

public class GrafoController {
	
	private AdjacencyMapGraph<PuntoArista, String> grafo;
	
	public GrafoController() {
		grafo=new AdjacencyMapGraph<>(true);
	}
	
	public Vertex<PuntoArista> addVertice(PuntoArista s) {
		return grafo.insertVertex(s);
		
	}
	
	public Edge<String> addArista(Vertex<PuntoArista>v, Vertex<PuntoArista>w, String c) {
		return grafo.insertEdge(v,w,c);
	}
	
	
	public void removerVertice(Vertex<PuntoArista>v) {
		grafo.removeVertex(v);
		
	}
	
	public int numeroVertices() {
		return grafo.numVertices();
		
	}
	
	
	
	public int numeroAristas() {
		return grafo.numEdges();
	}
	
	
	public String vertices() {
		String s="\nVértices:\n";
		for (Vertex<PuntoArista> v:grafo.vertices()) {
			s+=v.getElement()+" ";
		}
		return s;
	}
	
	public String aristas() {
		String s="\nAristas: \n";
		for (Edge<String> e:grafo.edges()) {
			s+=e.getElement()+" ";
		}
		return s;
	}
	
	public int gradoIncomingCompu(Vertex<PuntoArista>v) {
		return grafo.inDegree(v);
	}
	
	public int gradoOutgoingCompu(Vertex<PuntoArista>v) {
		return grafo.outDegree(v);
	}
	
	
	public String conexionesSalida(Vertex<PuntoArista>v) {
		String s="\nConexiones de Salida para: "+v.getElement()+"\n";
		for (Edge<String>e:grafo.outgoingEdges(v)) {
			s+=e.getElement()+"\n";
		}
		return s;
	}
	
	public String conexionesEntrada(Vertex<PuntoArista>v) {
		String s="\nConexiones de Entrada para: "+v.getElement()+"\n";
		for (Edge<String>e:grafo.incomingEdges(v)) {
			s+=e.getElement()+"\n";
		}
		return s;
	}
	
	public void transitiveClosure() {
		GraphAlgorithms.transitiveClosure(grafo);
	}
	
	public String topological() {
		String s="\nTopological Sort:\n";
		PositionalList<Vertex<PuntoArista>> list=GraphAlgorithms.topologicalSort(grafo);
		for (Vertex<PuntoArista>v:list) {
			s+=v.getElement()+"\n";
		}
		return s;
	}
	
	public boolean isDAG() {
		// Obtener la lista del ordenamiento topológico
	    PositionalList<Vertex<PuntoArista>> list = GraphAlgorithms.topologicalSort(grafo);

	    // Verificar si el tamaño de la lista coincide con el número de vértices
	    if (list != null && list.size() == grafo.numVertices()) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	
	public String drawing() {
		String s="";
		for (Vertex<PuntoArista> v : grafo.vertices()) {
	        for (Edge<String> e : grafo.outgoingEdges(v)) {
	            Vertex<PuntoArista> opposite = grafo.opposite(v, e);
	            s+=v.getElement();
	            if (e.getElement()==null)
	            	s+=" -Transitivo-> "+opposite.getElement() + "\n";
	            else
	            	s+=" -"+e.getElement()+"-> "+opposite.getElement() + "\n";
	        }
		}
		return s;
	}
	
	
	
	

}
