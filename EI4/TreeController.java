package EI4;

import java.util.ArrayList;
import java.util.List;

import TDA.LinkedBinaryTree;
import TDA.LinkedBinaryTree.Node;
import TDA.LinkedTree;
import TDA.Position;


public class TreeController<E> {
	
	private LinkedBinaryTree<E> binaryTree;
    private LinkedTree<E> generalTree;
    private boolean isBinaryTree;

    // Constructor para un árbol binario
    public TreeController(boolean isBinaryTree) {
        this.isBinaryTree = isBinaryTree;
        if (isBinaryTree) {
            binaryTree = new LinkedBinaryTree<>();
        } else {
            generalTree = new LinkedTree<>();
        }
    }

    public void addRoot(E element) {
        if (isBinaryTree) {
            binaryTree.addRoot(element);
        } else {
            generalTree.addRoot(element);
        }
    }

    // Para agregar hijo izquierdo en un árbol binario
    public void addLeft(E element, E parentElement) {
        if (isBinaryTree) {
            Position<E> parentNode = findNodeBinary(parentElement, binaryTree.root());
            if (parentNode != null) {
                binaryTree.addLeft(parentNode, element);
            }
        } 
    }

    // Para agregar hijo derecho en un árbol binario
    public void addRight(E element, E parentElement) {
        if (isBinaryTree) {
            Position<E> parentNode = findNodeBinary(parentElement, binaryTree.root());
            if (parentNode != null) {
                binaryTree.addRight(parentNode, element);
            }
        } 
    }

    // Para agregar hijo en un árbol general
    public void addChild(E element, E parentElement) {
        if (!isBinaryTree) {
            Position<E> parentNode = findNodeGeneral(parentElement, generalTree.root());
            if (parentNode != null) {
                generalTree.addChild(parentNode, element);
            }
        }
    }

    // Recorridos para árbol binario
    public Iterable<E> inorderTraversal() {
        if (isBinaryTree) {
            List<E> elements = new ArrayList<>();
            for (Position<E> node : binaryTree.inorder()) {
                elements.add(node.getElement());
            }
            return elements;
        }
        return null;
    }

    public Iterable<E> preorderTraversal() {
        List<E> elements = new ArrayList<>();
        if (isBinaryTree) {
            for (Position<E> node : binaryTree.preorder()) {
                elements.add(node.getElement());
            }
        } else {
            for (Position<E> node : generalTree.preorder()) {
                elements.add(node.getElement());
            }
        }
        return elements;
    }

    public Iterable<E> postorderTraversal() {
        List<E> elements = new ArrayList<>();
        if (!isBinaryTree) {
            for (Position<E> node : generalTree.postorder()) {
                elements.add(node.getElement());
            }
        }
        return elements;
    }

    // Método para encontrar un nodo en un árbol binario
    private Position<E> findNodeBinary(E element, Position<E> node) {
        if (node == null) return null;
        if (node.getElement().equals(element)) return node;
        Position<E> leftResult = findNodeBinary(element, binaryTree.left(node));
        if (leftResult != null) return leftResult;
        return findNodeBinary(element, binaryTree.right(node));
    }

    // Método para encontrar un nodo en un árbol general
    private Position<E> findNodeGeneral(E element, Position<E> node) {
        if (node == null) return null;
        if (node.getElement().equals(element)) return node;
        for (Position<E> child : generalTree.children(node)) {
            Position<E> result = findNodeGeneral(element, child);
            if (result != null) return result;
        }
        return null;
    }
    
    public int size() {
        return binaryTree.size();
    }
    
    public int size1() {
        return generalTree.size();
    }
    
    
    //NO HACER CASO
	/*private LinkedBinaryTree<E> tree;

    public TreeController() {
        tree = new LinkedBinaryTree<>();
    }

    public void addRoot(E element) {
        tree.addRoot(element);
    }

    public void addLeft(E element, E parentElement) {
    	//Esta era la idea↓
        //LinkedBinaryTree.Node<E> parentNode = findNode(parentElement, tree.root());
    	LinkedBinaryTree.Node<E> parentNode = findNode(parentElement, (Node<E>) tree.root());
        if (parentNode != null) {
            tree.addLeft(parentNode, element);
        }
    }

    public void addRight(E element, E parentElement) {
        LinkedBinaryTree.Node<E> parentNode = findNode(parentElement, (Node<E>) tree.root());
        if (parentNode != null) {
            tree.addRight(parentNode, element);
        }
    }

    public int size() {
        return tree.size();
    }

    public Iterable<E> preorderTraversal() {
        List<E> elements = new ArrayList<>();
        //Esta era la idea↓
        //for (LinkedBinaryTree.Node<E> node : tree.preorder()) {
        for (Position<E> node : tree.preorder()) {
            elements.add(node.getElement());
        }
        return elements;
    }

    public Iterable<E> inorderTraversal() {
        List<E> elements = new ArrayList<>();
        //Esta era la idea↓
        //for (LinkedBinaryTree.Node<E> node : tree.inorder()) {
        for (Position<E> node : tree.inorder()) {
            elements.add(node.getElement());
        }
        return elements;
    }

    public Iterable<E> postorderTraversal() {
        List<E> elements = new ArrayList<>();
        //Esta era la idea↓
        //for (LinkedBinaryTree.Node<E> node : tree.postorder()) {
        for (Position<E> node : tree.postorder()) {
            elements.add(node.getElement());
        }
        return elements;
    }

    // Método para encontrar el nodo de un elemento dado
    private LinkedBinaryTree.Node<E> findNode(E element, LinkedBinaryTree.Node<E> node) {
        if (node == null) return null;
        if (node.getElement().equals(element)) return node;
        LinkedBinaryTree.Node<E> leftResult = findNode(element, node.getLeft());
        if (leftResult != null) return leftResult;
        return findNode(element, node.getRight());
    }*/

}
