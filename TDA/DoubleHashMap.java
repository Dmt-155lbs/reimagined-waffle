package TDA;

import java.util.ArrayList;

import java.util.Random;

public class DoubleHashMap<K,V> extends AbstractHashMap<K,V> {
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);
    private int prime2; // second prime number for double hashing
    private int prime1;

    public DoubleHashMap() { super(); }
    public DoubleHashMap(int cap) { super(cap); }
    public DoubleHashMap(int cap, int p1, int p2) {
        super(cap);
        Random rand = new Random();
        prime2 = p2;
        prime1 = p1;
        scale = prime1;
        shift = 1 + rand.nextInt(prime1 - 1);
    }

    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    private boolean isAvailable(int index) {
        return (table[index] == null || table[index] == DEFUNCT);
    }

    public int findSlot(int h1, K key) {
        int h2 = hashcode2(key);
        int j = h1;

        do {
            if (table[j] == null || table[j] == DEFUNCT) {
                return j; // Retorna la posición si está disponible
            }
            if (table[j].getKey().equals(key)) {
                return j; // Retorna la posición si se encuentra la clave
            }
            j = (j + h2) % capacity; // Calcula la siguiente posición
        } while (j != h1);

        return -1; // No se encontró una posición válida
    }

    protected int hashcode1(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime1) % capacity);
    }

    protected int hashcode2(K key) {
        return (int) ((Math.abs(key.hashCode() * prime2) % prime1) % (capacity - 1) + 1);
    }

    @Override
    protected V bucketGet(int h, K key) {
        int j = findSlot(h, key);
        if (j < 0 || table[j] == null) {
            return null; // Retorna null si no se encuentra el producto
        }
        return table[j].getValue(); // Retorna el valor en la posición encontrada
    }

    @Override
    protected V bucketRemove(int h, K key) {
        int j = findSlot(h, key);
        if (j < 0 || table[j] == null) {
            return null; // Retorna null si no se encuentra el producto
        }
        V value = table[j].getValue();
        table[j] = DEFUNCT; // Elimina la entrada de la tabla
        n--;
        return value; // Retorna el valor eliminado
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        int j = findSlot(h, key);
        if (j < 0) {
            throw new IllegalStateException("No hay espacio disponible para insertar la clave: " + key);
        }

        // Insertar el nuevo entry en la posición j
        table[j] = new MapEntry<>(key, value);
        n++; // Incrementar el tamaño
        return value; // Se puede retornar null o un valor anterior si se desea
    }
   
    @Override
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++)
            if (!isAvailable(h))
                buffer.add(table[h]);
        return buffer;
    }
}