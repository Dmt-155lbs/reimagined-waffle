package TDA;

public interface Graph<V,E> {

    /** Returns the number of vertices of the graph */
    int numVertices();
  
    /** Returns the number of edges of the graph */
    int numEdges();
  
    /** Returns the vertices of the graph as an iterable collection */
    Iterable<Vertex<V>> vertices();
  
    /** Returns the edges of the graph as an iterable collection */
    Iterable<Edge<E>> edges();

    int outDegree(Vertex<V> v) throws IllegalArgumentException;
  
    int inDegree(Vertex<V> v) throws IllegalArgumentException;
  

    Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException;
  
    Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException;
  
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException;
  
    Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException;
  
    /** Returns the vertex that is opposite vertex v on edge e. */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;
  
    /** Inserts and returns a new vertex with the given element. */
    Vertex<V> insertVertex(V element);
  
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException;
  
    /** Removes a vertex and all its incident edges from the graph. */
    void removeVertex(Vertex<V> v) throws IllegalArgumentException;
  
    /** Removes an edge from the graph. */
    void removeEdge(Edge<E> e) throws IllegalArgumentException;
  }