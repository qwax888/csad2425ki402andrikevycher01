/**

 * 
 */
package lab3_andrikevych_302;

/**
 * 
 */
public class HumanApp {
	public static void main(String[] args) {
        // Створюємо об'єкт Sportsman
        Address address = new Address("123 Main St", "Cityville");
        Sportsmen sportsman = new Sportsmen("John", 25, address, "Swimmer");

        // Викликаємо методи класу Human
        sportsman.introduceYourself();
        sportsman.setAge(26);
        sportsman.setAddress(new Address("456 Elm St", "Sports City"));
        sportsman.move(new Address("789 Oak St", "Training Town"));
        sportsman.celebrateBirthday();

        // Викликаємо методи класу Sportsman
        sportsman.train();
        sportsman.winMedal();

        // Виводимо інформацію про адресу
        System.out.println(sportsman.getName() + " lives at: " + sportsman.getAddressDetails());

        // Завершуємо роботу з файлом логу
        sportsman.closeLogFile();
    }
}
