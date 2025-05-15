package EI;

import TDA.SinglyLinkedList;
import java.util.Scanner;

public class EI1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Carro> listaDeCarros = new SinglyLinkedList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Agregar un carro al inicio");
            System.out.println("2. Agregar un carro al final");
            System.out.println("3. Mostrar el primer carro");
            System.out.println("4. Mostrar el último carro");
            System.out.println("5. Eliminar el primer carro");
            System.out.println("6. Mostrar el tamaño de la lista");
            System.out.println("7. Salir");

            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca del carro: ");
                    String marcaInicio = scanner.nextLine();
                    listaDeCarros.addFirst(new Carro(marcaInicio));
                    System.out.println("Carro agregado al inicio.");
                    break;

                case 2:
                    System.out.print("Ingrese la marca del carro: ");
                    String marcaFinal = scanner.nextLine();
                    listaDeCarros.addLast(new Carro(marcaFinal));
                    System.out.println("Carro agregado al final.");
                    break;

                case 3:
                    Carro primerCarro = listaDeCarros.first();
                    if (primerCarro != null) {
                        System.out.println("Primer carro: " + primerCarro);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 4:
                    Carro ultimoCarro = listaDeCarros.last();
                    if (ultimoCarro != null) {
                        System.out.println("Último carro: " + ultimoCarro);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 5:
                    Carro carroEliminado = listaDeCarros.removeFirst();
                    if (carroEliminado != null) {
                        System.out.println("Eliminado: " + carroEliminado);
                    } else {
                        System.out.println("No hay carros para eliminar.");
                    }
                    break;

                case 6:
                    System.out.println("Tamaño de la lista: " + listaDeCarros.size());
                    break;

                case 7:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}





/*package EI;
import TDA.SinglyLinkedList;

public class EI1 {

	public static void main(String[] args) {
		
		// Crear una lista enlazada de carros
        SinglyLinkedList<Carro> listaDeCarros = new SinglyLinkedList<>();

        // Agregar algunos carros a la lista
        listaDeCarros.addFirst(new Carro("Toyota", "Corolla"));
        listaDeCarros.addLast(new Carro("Honda", "Civic"));
        listaDeCarros.addLast(new Carro("Ford", "Focus"));

        // Mostrar el primer y último carro
        System.out.println("Primer carro: " + listaDeCarros.first());  // Debería ser Toyota Corolla
        System.out.println("Último carro: " + listaDeCarros.last());   // Debería ser Ford Focus

        // Eliminar el primer carro y mostrar la lista actualizada
        System.out.println("Eliminando el primer carro: " + listaDeCarros.removeFirst()); // Debería eliminar Toyota Corolla
        System.out.println("Nuevo primer carro: " + listaDeCarros.first());  // Debería ser Honda Civic

        // Tamaño actual de la lista de carros
        System.out.println("Tamaño de la lista de carros: " + listaDeCarros.size()); // Debería ser 2

        // Recorrer y mostrar todos los carros en la lista
        Carro currentCarro = listaDeCarros.first();
        while (currentCarro != null) {
            System.out.println("Carro: " + currentCarro);
            currentCarro = currentCarro.getSiguiente();
        }
    }
	

}
*/