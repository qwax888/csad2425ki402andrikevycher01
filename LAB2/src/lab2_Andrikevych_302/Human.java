/**

 * 
 */
package lab2_Andrikevych_302;

/**
 * 
 */


import java.io.*;



import java.util.*;



public class Human {
    private String name;
    private int age;
    private Address address;
    private PrintWriter logFile;
    private boolean arg;

    public Human(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        try {
            logFile = new PrintWriter(new FileWriter("HumanLog.txt", true));
        } catch (IOException e) {
            System.err.println("Error opening log file.");
        }
        logEvent("Created a new Human: " + name);
        arg =true;
        System.err.println("arg="+ arg);
    }
    

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        logEvent("Created a new Human: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logEvent(this.name + " changed name to " + name);
        this.name = name;
    }

    public int getAge() {
    	System.err.println("arg="+arg);
        return age;
        
    }

    public void setAge(int age) {
        logEvent(name + " changed age to " + age);
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        logEvent(name + " changed address to " + address.getFullAddress());
        this.address = address;
    }

    public void celebrateBirthday() {
        age++;
        logEvent(name + " celebrated a birthday. New age: " + age);
    }

    public void introduceYourself() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
        logEvent(name + " introduced themselves");
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getAddressDetails() {
        if (address != null) {
            return address.getFullAddress();
        } else {
            return "Address not available";
        }
    }

    public void move(Address newAddress) {
        logEvent(name + " moved to a new address: " + newAddress.getFullAddress());
        address = newAddress;
    }

    private void logEvent(String event) {
        if (logFile != null) {
            logFile.println(new Date() + ": " + event);
            logFile.flush();
        }
    }

    public void closeLogFile() {
        if (logFile != null) {
            logFile.close();
        }
    }
}

class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getFullAddress() {
        return street + ", " + city;
    }
}


