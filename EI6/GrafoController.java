package EI6;

import java.util.HashSet;
import java.util.Set;

import TDA.AdjacencyMapGraph;
import TDA.Edge;
import TDA.Entry;
import TDA.GraphAlgorithms;
import TDA.Map;
import TDA.Position;
import TDA.PositionalList;
import TDA.ProbeHashMap;
import TDA.UnsortedTableMap;
import TDA.Vertex;

public class GrafoController {
	
	private AdjacencyMapGraph<PuntoArista, String> grafo;
	private GraphAlgorithms ga;
	
	public GrafoController() {
		grafo=new AdjacencyMapGraph<>(false);
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
	
	
	public String vertice() {
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
	
	public int gradoVertice(Vertex<PuntoArista>v) {
		return grafo.outDegree(v);
	}
	
	public String getArista(Vertex<PuntoArista>v, Vertex<PuntoArista>w) {
		return "\nArista que conecta a "+v.getElement()+" con "+w.getElement()+": "+grafo.getEdge(v,w).getElement();
	}

	public String aristasVertice(Vertex<PuntoArista> v) {
		String s="\nAristas que llegan a "+v.getElement()+"\n";
		for (Edge<String> e:grafo.outgoingEdges(v)) {
			s+=e.getElement()+" ";
		}
		return s;
	}
	
	
	public String verticeOpuesto(Vertex<PuntoArista>v, Edge<String> e) {
		return "\nVertice opuesto a "+v.getElement()+" en la arista "+e.getElement()+": "+grafo.opposite(v, e).getElement().toString();
	}

	public String verticesConectados(Edge<String> e) {
		String s="\nVertices conectados por la arista "+e.getElement()+"\n";
		Vertex<PuntoArista>[] v=grafo.endVertices(e);
		for (int i=0; i<v.length; i++) {
			s+=v[i].getElement()+" ";
		}
		return s;
	}
	
	

	
	public String BFSCompleto() {
		String s="";
		Map<Vertex<PuntoArista>, Edge<String>> mapa=ga.BFSComplete(grafo);
		for (Entry<Vertex<PuntoArista>, Edge<String>> e:mapa.entrySet()) {
			s+=e.getKey().getElement()+" "+e.getValue().getElement()+"\n";
		}
		return s;
	}
	
	public String BFS(Vertex<PuntoArista> v) {
		String s="\nRecorrido BFS para "+v.getElement()+"\n";
		Map<Vertex<PuntoArista>,Edge<String>> forest=new UnsortedTableMap<>();
		Set<Vertex<PuntoArista>> known=new HashSet<>();
		ga.BFS(grafo, v, known, forest);
		
		for (Entry<Vertex<PuntoArista>, Edge<String>> e:forest.entrySet()) {
			s+=e.getKey().getElement()+" "+e.getValue().getElement()+"\n";
		}
		return s;
		
		
	}
	
	public String path(Vertex<PuntoArista>v, Vertex<PuntoArista>w) {
		Map<Vertex<PuntoArista>,Edge<String>> forest=new ProbeHashMap<>();
		Set<Vertex<PuntoArista>> known=new HashSet<>();
		ga.DFS(grafo, v, known, forest);
		String s="\nAristas para llegar de "+v.getElement()+" a "+w.getElement()+": ";
		PositionalList<Edge<String>> p=ga.constructPath(grafo, v, w, forest);
		for (Position<Edge<String>> i:p.positions()) {
			s+=i.getElement().getElement()+" ";
		}
		return s;
	}
	
	public String DFSCompleto() {
		
		String s="";
		Map<Vertex<PuntoArista>, Edge<String>> mapa=ga.DFSComplete(grafo);
		for (Entry<Vertex<PuntoArista>, Edge<String>> e:mapa.entrySet()) {
			s+=e.getKey().getElement()+" "+e.getValue().getElement()+"\n";
			
		}
		return s;
		
	}
	
	public String DFS(Vertex<PuntoArista> v) {
		
		String s="\nRecorrido DFS para "+v.getElement()+"\n";
		Map<Vertex<PuntoArista>,Edge<String>> forest=new UnsortedTableMap<>();
		Set<Vertex<PuntoArista>> known=new HashSet<>();
		ga.DFS(grafo, v, known, forest);
		
		for (Entry<Vertex<PuntoArista>, Edge<String>> e:forest.entrySet()) {
			s+=e.getKey().getElement()+" "+e.getValue().getElement()+"\n";
			
		}
		return s;
		
	}

}
