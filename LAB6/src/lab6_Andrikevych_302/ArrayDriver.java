/**
 * 
 */
package lab6_Andrikevych_302;

/**
 * 
 */
import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        // Порівнюємо за віком
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        // Порівнюємо за ціною
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}

public class ArrayDriver {
    public static void main(String[] args) {
        Array<Person> personArray = new Array<>(5);
        personArray.add(new Person("Alice", 30));
        personArray.add(new Person("Bob", 25));
        personArray.add(new Person("Charlie", 35));

        System.out.println("Максимальний вік: " + personArray.findMax());

        Array<Product> productArray = new Array<>(3);
        productArray.add(new Product("Laptop", 999.99));
        productArray.add(new Product("Smartphone", 499.99));
        productArray.add(new Product("Tablet", 299.99));

        System.out.println("Максимальна ціна: " + productArray.findMax());
    }
}
