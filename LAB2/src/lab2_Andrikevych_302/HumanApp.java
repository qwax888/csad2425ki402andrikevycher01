/**


 * 
 */
package lab2_Andrikevych_302;

/**
 * 
 */
public class HumanApp {
	public static void main(String[] args) {
        Address address1 = new Address("123 Main St", "Cityville");
        Address address2 = new Address("456 Elm St", "Townsville");
        
        Human person1 = new Human("John", 30, address1);
        Human person2 = new Human("Alice", 25);
        
        System.out.println("Person 1:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Address: " + person1.getAddressDetails());
        System.out.println("Is Adult: " + person1.isAdult());
        
        System.out.println("\nPerson 2:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Address: " + person2.getAddressDetails());
        System.out.println("Is Adult: " + person2.isAdult());
        
        // Celebrate John's birthday
        person1.celebrateBirthday();
        System.out.println("\nAfter celebrating John's birthday:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        
        // Move Alice to a new address
        person2.move(address2);
        System.out.println("\nAfter moving Alice to a new address:");
        System.out.println("Name: " + person2.getName());
        System.out.println("New Address: " + person2.getAddressDetails());
        
        // Introduce themselves
        person1.introduceYourself();
        person2.introduceYourself();
        
        // Change Alice's name and address
        person2.setName("Alicia");
        person2.setAddress(address1);
        System.out.println("\nAfter changing Alicia's name and address:");
        System.out.println("Name: " + person2.getName());
        System.out.println("New Address: " + person2.getAddressDetails());
        
        // Close log file
        person1.closeLogFile();
        person2.closeLogFile();
    }
}

