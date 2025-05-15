package TDA;

import java.util.ArrayList;

public class LinkedTree<E> extends AbstractTree<E>{

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private ArrayList<Node<E>> children;  
        
        public Node(E e, Node<E> above, ArrayList<Node<E>> kids) {
            element=e;
            parent=above;
            children=kids;
        }
        
        public E getElement() {return element;}
        public Node<E> getParent() {return parent;}
        public ArrayList<Node<E>> getChildren() {return children;}
        
        public void setElement(E e) {element=e;}
        public void setParent(Node<E> parentNode) {parent=parentNode;}
        
        public void addChild(Node<E> child) {
            child.setParent(this);
            children.add(child);
        }

        public void removeChild(Node<E> child) {
            child.setParent(null);
            children.remove(child);
        }
        public void setChildren(ArrayList<Node<E>> children) { this.children = children; }
    }
    
    protected Node<E> root=null;
    private int size=0;
    
    public LinkedTree() {}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) 
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) 
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    public int size() {
        return size;
    }
    
    public Position<E> root() throws IllegalStateException {
        if (root==null) throw new IllegalStateException("Tree is empty");
        return root;
    }
    
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node=validate(p);
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
    	Node<E> node=validate(p);
        ArrayList<Position<E>> positions = new ArrayList<>();
        for (Node<E> child : node.getChildren()) {
            positions.add(child);
        }
        return positions;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getChildren().size();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (root != null) throw new IllegalStateException("Tree already has a root");
        root = new Node<>(e, null, new ArrayList<Node<E>>());
        size=1;
        return root;
    }

    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        Node<E> child = new Node<>(e, parent, new ArrayList<Node<E>>());
        parent.addChild(child);
        size++;
        return child;
    }
    
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node=validate(p);
        E temp=node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedTree<E> t1, LinkedTree<E> t2) throws IllegalArgumentException {
        Node<E> node=validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("Position must be a leaf");
        size+=t1.size()+t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.getChildren().add(t1.root);
            t1.root=null;
            t1.size=0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.getChildren().add(t2.root);
            t2.root=null;
            t2.size=0;
        }

    }
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node=validate(p);

        Node<E> parent=node.getParent();
        if (node==root) {
            if (!node.getChildren().isEmpty()) {
                root=node.getChildren().get(0);
                root.setParent(null);
                for (int i = 1; i<node.getChildren().size(); i++) {
                    root.addChild(node.getChildren().get(i));
                }
            } 
            else {
                root = null;
            }
        } 
        else {
        	if (!node.getChildren().isEmpty()) {
                for (Node<E> child : node.getChildren()) {
                    parent.addChild(child);
                }
            }
            parent.removeChild(node);
        }

        size--;
        E temp=node.getElement();
        node.setElement(null);
        node.setParent(null);
        node.setChildren(null);
        return temp;
    }
}
