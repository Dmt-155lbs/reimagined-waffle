package EI2;

import TDA.SinglyLinkedList;
import TDA.LinkedQueue;
import TDA.LinkedStack;
import java.util.Scanner;

//EJEMPLO APLICADO A LINKEDQUEUE

public class EI2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedQueue<Persona> colaPersonas = new LinkedQueue<>();
		boolean continuar = true;
		
		while(continuar) {
			System.out.println("\nMenú de Opciones: ");
			System.out.println("1. Agregar personas a la cola ");
			System.out.println("2. Remover personas de la cola y mostrar sus nombres");
			System.out.println("3. Tamanio de la lista");
			System.out.println("4. Mostrar primera persona en la cola sin quitarla");
			System.out.println("5. Salir");
			
			System.out.println("Ingrese una opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcion) {
			
			case 1:
				System.out.println("Ingrese el nombre");
				String nombre = scanner.nextLine();
				colaPersonas.enqueue(new Persona(nombre));
				System.out.println("Persona registrada exitosamente");
				break;
				
			case 2:
				
				while (!colaPersonas.isEmpty()) {
					Persona persona = colaPersonas.dequeue();
					System.out.println("Atendiendo a: " + persona);
				}
				
				break;
			
			case 3:
				System.out.println("Tamaño de la lista: " + colaPersonas.size());
                break;
                
			case 4:
				
				Persona primerPersona = colaPersonas.first();
				if(primerPersona != null) {
					System.out.println("Primera persona: " + primerPersona);
				} else {
					System.out.println("La lista esta vacia");
				}
				break;
				
			case 5:
				continuar = false;
				System.out.println("Saliendo del sistema...");
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
				
			
			}
			
			
			
		}
		
		scanner.close();

	}

}




//EJEMPLO APLICADO A LINKEDSTACK
/*public class EI2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedStack<Persona> listapersonas = new LinkedStack<>();
		boolean continuar = true;
		
		while(continuar) {
			System.out.println("\nMenú de Opciones: ");
			System.out.println("1. Agregar nombre ");
			System.out.println("2. Eliminar primer nombre");
			System.out.println("3. Tamanio de la lista");
			System.out.println("4. Primer elemento(nombre)");
			System.out.println("5. Salir");
			
			System.out.println("Ingrese una opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcion) {
			
			case 1:
				System.out.println("Ingrese el nombre");
				String nombre = scanner.nextLine();
				listapersonas.push(new Persona(nombre));
				System.out.println("Persona registrada exitosamente");
				break;
				
			case 2:
				Persona eliminarPersona = listapersonas.top();
				if (eliminarPersona != null) {
					eliminarPersona = listapersonas.pop();
				} else {
					System.out.println("La lista esta vacia");
				}
				
				break;
			
			case 3:
				System.out.println("Tamaño de la lista: " + listapersonas.size());
                break;
                
			case 4:
				
				Persona primerPersona = listapersonas.top();
				if(primerPersona != null) {
					System.out.println("Primera persona: " + primerPersona);
				} else {
					System.out.println("La lista esta vacia");
				}
				break;
				
			case 5:
				continuar = false;
				System.out.println("Saliendo del sistema");
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
				
			
			}
			
			
			
		}
		
		scanner.close();

	}

}*/
