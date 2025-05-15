package EI4;

import TDA.*;

public class EI4 {

	public static void main(String[] args) {
		
		System.out.println("Linked Binary Tree \n");
		
		// Usar un árbol binario
        TreeManager<String> binaryTreeManager = new TreeManager<>(true);
        binaryTreeManager.addRoot("Root");
        binaryTreeManager.addLeft("Left Child", "Root");
        binaryTreeManager.addRight("Right Child", "Root");
        binaryTreeManager.addLeft("Left Grandchild", "Left Child");
        
        
        // Mostrar el tamaño del árbol
        System.out.println("Tamaño del árbol: " + binaryTreeManager.getTreeSize());

        
        
        System.out.println("Inorder Traversal (Binary Tree):");
        for (String element : binaryTreeManager.inorderTraversal()) {
            System.out.println(element);
        }

        // Usar un árbol general
        TreeManager<String> generalTreeManager = new TreeManager<>(false);
        generalTreeManager.addRoot("Root");
        generalTreeManager.addChild("Child1", "Root");
        generalTreeManager.addChild("Child2", "Root");
        generalTreeManager.addChild("Child3", "Child1");
        
        System.out.println("\n");
        System.out.println("Linked Tree \n");
 
        
        // Mostrar el tamaño del árbol
        System.out.println("Tamaño del árbol: " + generalTreeManager.getTreeSize1());

        System.out.println("Preorder Traversal (General Tree):");
        for (String element : generalTreeManager.preorderTraversal()) {
            System.out.println(element);
        }
        
        System.out.println("Postorder Traversal (General Tree):");
        for (String element : generalTreeManager.postorderTraversal()) {
            System.out.println(element);
        }
		
		//NO HACER CASO
		/*TreeManager<String> manager = new TreeManager<>();

        // Agregar elementos al árbol
        manager.addRoot("Root");
        manager.addLeft("Left Child", "Root");
        manager.addRight("Right Child", "Root");
        manager.addLeft("Left Grandchild", "Left Child");

        // Mostrar el tamaño del árbol
        System.out.println("Tamaño del árbol: " + manager.getTreeSize());

        // Mostrar los recorridos del árbol
        System.out.println("Recorrido Preorden:");
        for (String element : manager.getPreorderTraversal()) {
            System.out.println(element);
        }

        System.out.println("Recorrido Inorden:");
        for (String element : manager.getInorderTraversal()) {
            System.out.println(element);
        }

        System.out.println("Recorrido Postorden:");
        for (String element : manager.getPostorderTraversal()) {
            System.out.println(element);
        }
     */
	}

}
