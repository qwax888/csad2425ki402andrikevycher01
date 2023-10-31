/**
 * 
 */
package lab6_Andrikevych_302;

/**
 * 
 */
import java.util.Arrays;

public class Array<T extends Comparable<T>> {
    private T[] array;
    private int size;
    
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Розмір масиву повинен бути більше нуля.");
        }
        array = (T[]) new Comparable[capacity];
        size = 0;
    }
    
    public void add(T element) {
        if (size == array.length) {
            // Збільшення розміру масиву при необхідності
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
        array[size] = element;
        size++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неправильний індекс.");
        }
        return array[index];
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неправильний індекс.");
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedElement;
    }
    
    public int size() {
        return size;
    }
    
    public T findMax() {
        if (size == 0) {
            throw new IllegalStateException("Масив пустий.");
        }
        T maxElement = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i].compareTo(maxElement) > 0) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }
    
    
}
