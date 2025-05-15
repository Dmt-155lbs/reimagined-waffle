package EI4;

import java.util.List;

public class TreeManager <E> {
	
	private TreeController<E> treeController;

    // Constructor que inicializa el tipo de árbol
    public TreeManager(boolean isBinaryTree) {
        treeController = new TreeController<>(isBinaryTree);
    }

    public void addRoot(E element) {
        treeController.addRoot(element);
    }

    public void addLeft(E element, E parentElement) {
        treeController.addLeft(element, parentElement);
    }

    public void addRight(E element, E parentElement) {
        treeController.addRight(element, parentElement);
    }

    public void addChild(E element, E parentElement) {
        treeController.addChild(element, parentElement);
    }

    public List<E> preorderTraversal() {
        return (List<E>) treeController.preorderTraversal();
    }

    public List<E> inorderTraversal() {
        return (List<E>) treeController.inorderTraversal();
    }

    public List<E> postorderTraversal() {
        return (List<E>) treeController.postorderTraversal();
    }
    
    // Obtener el tamaño del árbol
    public int getTreeSize() {
        return treeController.size();
    }
    
    // Obtener el tamaño del árbol
    public int getTreeSize1() {
        return treeController.size1();
    }
	
    //NO HACER CASO
	/*private TreeController<E> treeController;

    public TreeManager() {
        treeController = new TreeController<>();
    }

    // Llamada para agregar un elemento al árbol
    public void addRoot(E element) {
        treeController.addRoot(element);
    }

    // Llamada para agregar un hijo izquierdo
    public void addLeft(E element, E parentElement) {
        treeController.addLeft(element, parentElement);
    }

    // Llamada para agregar un hijo derecho
    public void addRight(E element, E parentElement) {
        treeController.addRight(element, parentElement);
    }

    // Obtener el tamaño del árbol
    public int getTreeSize() {
        return treeController.size();
    }

    // Métodos de recorridos (preorder, inorder, postorder)
    public Iterable<E> getPreorderTraversal() {
        return treeController.preorderTraversal();
    }

    public Iterable<E> getInorderTraversal() {
        return treeController.inorderTraversal();
    }

    public Iterable<E> getPostorderTraversal() {
        return treeController.postorderTraversal();
    }
	*/

}
