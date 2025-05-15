package TDA;

public class AdjacencyMapGraph<V,E> implements Graph<V,E> {
	private class InnerVertex<V> implements Vertex<V>{
		private V element;
		private Position<Vertex<V>> pos;
		private Map<Vertex<V>,Edge<E>>outgoing, incoming;
		
		public InnerVertex(V elem, boolean graphisDirected) {
			element=elem;
			outgoing=new ProbeHashMap<>();
			if (graphisDirected)
				incoming=new ProbeHashMap<>();
			else
				incoming=outgoing;
		}
		
		public V getElement() {return element;}
		public void setPosition(Position<Vertex<V>> p) {pos=p;}
		public Position<Vertex<V>> getPosition(){return pos;}
		public Map<Vertex<V>, Edge<E>> getOutgoing(){return outgoing;}
		public Map<Vertex<V>, Edge<E>> getIncoming(){return incoming;}
		public boolean validate(Graph<V,E> graph) {
	        return (AdjacencyMapGraph.this == graph && pos != null);
	      }
	}
	
	private class InnerEdge<E> implements Edge<E>{
		private E element;
		private Position<Edge<E>>pos;
		private Vertex<V>[] endpoints;
		
		public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
			element=elem;
			endpoints=(Vertex<V>[]) new Vertex[] {u,v};
		}
		
		public E getElement() {return element;}
		public Vertex<V>[] getEndpoints(){return endpoints;}
		public void setPosition(Position<Edge<E>> p) {pos=p;}
		public Position<Edge<E>> getPosition(){return pos;}
		public boolean validate(Graph<V,E> graph) {
	        return AdjacencyMapGraph.this == graph && pos != null;
	      }
	}
	
    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

    public AdjacencyMapGraph(boolean directed) { isDirected = directed; }
  
    /** Returns the number of vertices of the graph */
    public int numVertices() { return vertices.size(); }
  
    /** Returns the vertices of the graph as an iterable collection */
    public Iterable<Vertex<V>> vertices() { return vertices; }
  
    /** Returns the number of edges of the graph */
    public int numEdges() { return edges.size(); }
  
    /** Returns the edges of the graph as an iterable collection */
    public Iterable<Edge<E>> edges() { return edges; }
  
    /**
     * Returns the number of edges for which vertex v is the origin.
     * Note that for an undirected graph, this is the same result
     * returned by inDegree(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public int outDegree(Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> vert = validate(v);
      return vert.getOutgoing().size();
    }
  
    /**
     * Returns an iterable collection of edges for which vertex v is the origin.
     * Note that for an undirected graph, this is the same result
     * returned by incomingEdges(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> vert = validate(v);
      return vert.getOutgoing().values();   // edges are the values in the adjacency map
    }
  
    /**
     * Returns the number of edges for which vertex v is the destination.
     * Note that for an undirected graph, this is the same result
     * returned by outDegree(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public int inDegree(Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> vert = validate(v);
      return vert.getIncoming().size();
    }
  
    /**
     * Returns an iterable collection of edges for which vertex v is the destination.
     * Note that for an undirected graph, this is the same result
     * returned by outgoingEdges(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> vert = validate(v);
      return vert.getIncoming().values();   // edges are the values in the adjacency map
    }
  
    /** Returns the edge from u to v, or null if they are not adjacent. */
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> origin = validate(u);
      return origin.getOutgoing().get(v);    // will be null if no edge from u to v
    }
  
    /**
     * Returns the vertices of edge e as an array of length two.
     * If the graph is directed, the first vertex is the origin, and
     * the second is the destination.  If the graph is undirected, the
     * order is arbitrary.
     */
    public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
      InnerEdge<E> edge = validate(e);
      return edge.getEndpoints();
    }
  
    /** Returns the vertex that is opposite vertex v on edge e. */
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e)
                                                 throws IllegalArgumentException {
      InnerEdge<E> edge = validate(e);
      Vertex<V>[] endpoints = edge.getEndpoints();
      if (endpoints[0] == v)
        return endpoints[1];
      else if (endpoints[1] == v)
        return endpoints[0];
      else
        throw new IllegalArgumentException("v is not incident to this edge");
    }
  
    /** Inserts and returns a new vertex with the given element. */
    public Vertex<V> insertVertex(V element) {
      InnerVertex<V> v = new InnerVertex<>(element, isDirected);
      v.setPosition(vertices.addLast(v));
      return v;
    }
  
    /**
     * Inserts and returns a new edge between vertices u and v, storing given element.
     *
     * @throws IllegalArgumentException if u or v are invalid vertices, or if an edge already exists between u and v.
     */
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element)
                                                 throws IllegalArgumentException {
      if (getEdge(u,v) == null) {
        InnerEdge<E> e = new InnerEdge<>(u, v, element);
        e.setPosition(edges.addLast(e));
        InnerVertex<V> origin = validate(u);
        InnerVertex<V> dest = validate(v);
        origin.getOutgoing().put(v, e);
        dest.getIncoming().put(u, e);
        return e;
      } else
        throw new IllegalArgumentException("Edge from u to v exists");
    }
  
    /** Removes a vertex and all its incident edges from the graph. */
    public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
      InnerVertex<V> vert = validate(v);
      // remove all incident edges from the graph
      for (Edge<E> e : vert.getOutgoing().values())
        removeEdge(e);
      for (Edge<E> e : vert.getIncoming().values())
        removeEdge(e);
      // remove this vertex from the list of vertices
      vertices.remove(vert.getPosition());
      vert.setPosition(null);             // invalidates the vertex
    }
  
    public void removeEdge(Edge<E> e) throws IllegalArgumentException {
        InnerEdge<E> edge = validate(e);
        Vertex<V>[] verts = edge.getEndpoints(); // obtenemos los endpoints como Vertex<V>[]
        
        // Convertimos cada vértice a InnerVertex de forma segura
        InnerVertex<V> vOrig = validate(verts[0]);
        InnerVertex<V> vDest = validate(verts[1]);

        // eliminamos esta arista de las adyacencias de los vértices
        vOrig.getOutgoing().remove(vDest);
        vDest.getIncoming().remove(vOrig);

        // eliminamos esta arista de la lista de aristas
        edges.remove(edge.getPosition());
        edge.setPosition(null); // invalida la arista
    }

  
    @SuppressWarnings({"unchecked"})
    private InnerVertex<V> validate(Vertex<V> v) {
      if (!(v instanceof InnerVertex)) throw new IllegalArgumentException("Invalid vertex");
      InnerVertex<V> vert = (InnerVertex<V>) v;     // safe cast
      if (!vert.validate(this)) throw new IllegalArgumentException("Invalid vertex");
      return vert;
    }
  
    @SuppressWarnings({"unchecked"})
    private InnerEdge<E> validate(Edge<E> e) {
      if (!(e instanceof InnerEdge)) throw new IllegalArgumentException("Invalid edge");
      InnerEdge<E> edge = (InnerEdge<E>) e;     // safe cast
      if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
      return edge;
    }
    
    
}
