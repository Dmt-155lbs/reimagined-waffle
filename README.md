# Ejercicios de Estructuras de Datos

Este conjunto de ejercicios ha sido desarrollado como parte del curso de **Estructuras de Datos**, con el objetivo de aplicar conceptos fundamentales como listas, pilas, colas, árboles, mapas, grafos y colas de prioridad.

---

## Contenido del Proyecto

El proyecto está organizado por entregas (`EI1`, `EI2`, ..., `EI7`) que representan diferentes prácticas o ejercicios evaluados. Además, incluye una carpeta `TDA` que contiene implementaciones propias de las estructuras de datos utilizadas.

---

### EI1 - Manejo de objetos básicos
- `Carro.java`  
- `EI1.java`  
Simula la creación y gestión de objetos básicos. Introducción a listas simples y manipulación de objetos.

---

### EI2 - Manejo de clases personalizadas
- `Persona.java`  
- `EI2.java`  
Introduce la creación de listas personalizadas utilizando estructuras propias. Se enfoca en el almacenamiento y búsqueda de datos en listas enlazadas.

---

### EI3 - Historial de navegador web
- `WebBrowserHistory.java`  
- `EI3.java`  
Implementa una pila (`Stack`) para manejar el historial de navegación. Se trabaja con la lógica de navegación hacia adelante y atrás en un navegador.

---

### EI4 - Árboles
- `TreeController.java`  
- `TreeManager.java`  
- `EI4.java`  
Implementación de árboles generales y binarios. Incluye recorridos como inorden, preorden y postorden.

---

### EI5 - Gestión de estudiantes
- `Estudiante.java`  
- `ControladorEstudiante.java`  
- `EI5.java`  
Uso de listas enlazadas dobles para registrar y mostrar información de estudiantes.

---

### EI6 - Grafo: puntos y aristas
- `PuntoArista.java`  
- `GrafoController.java`  
- `MainEI6.java`  
Implementación de un grafo con lista de adyacencia para representar conexiones entre puntos.

---

### EI7 - Grafo (variante)
- `PuntoArista.java`  
- `GrafoController.java`  
- `MainEI7.java`  
Segunda práctica con grafos. Enfatiza en algoritmos de recorrido y estructuras adaptables de grafos.

---

## TDA (Tipos de Datos Abstractos)

La carpeta `TDA/` contiene implementaciones completas y reutilizables de múltiples estructuras de datos, entre ellas:

- **Listas y pilas:** `ArrayList`, `SinglyLinkedList`, `DoublyLinkedList`, `LinkedStack`, `LinkedQueue`.
- **Árboles:** `LinkedTree`, `LinkedBinaryTree`, `BinaryTree`, `AVLTreeMap`.
- **Mapas y diccionarios:** `Map`, `TreeMap`, `ChainHashMap`, `ProbeHashMap`, `DoubleHashMap`.
- **Grafos:** `Graph`, `AdjacencyMapGraph`, `Vertex`, `Edge`.
- **Colas de prioridad:** `HeapPriorityQueue`, `UnsortedPriorityQueue`, `AdaptablePriorityQueue`.
- **Otros auxiliares:** `Comparator`, `Partition`, `Position`, `Entry`.

Estas clases son base para la mayoría de los ejercicios y promueven la modularidad, reutilización de código y comprensión profunda de los TDA.

---

## Compilación y Ejecución

Este proyecto fue desarrollado en Java (Java 17+) con el sistema modular habilitado (`module-info.java`). Cada entrega puede compilarse y ejecutarse por separado. Por ejemplo:

```bash
javac EI3/*.java TDA/*.java
java EI3.EI3
