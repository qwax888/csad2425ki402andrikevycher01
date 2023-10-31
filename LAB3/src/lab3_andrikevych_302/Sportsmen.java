/**

 * 
 */
package lab3_andrikevych_302;

/**
 * 
 */


public class Sportsmen extends Human implements Athlete {
    private String sport;
    private int medals;

    public Sportsmen(String name, int age, Address address, String sport) {
        super(name, age, address);
        this.sport = sport;
        this.medals = 0;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getMedals() {
        return medals;
    }

    public void winMedal() {
        medals++;
        logEvent(getName() + " won a medal in " + sport + ". Total medals: " + medals);
    }

    @Override
    public void introduceYourself() {
        System.out.println("Hello, my name is " + getName() + ", I am " + getAge() + " years old, and I am a " + sport + " athlete.");
        logEvent(getName() + " introduced themselves as a " + sport + " athlete.");
    }

    @Override
    public void train() {
        System.out.println(getName() + " is training for their next " + sport + " event.");
        logEvent(getName() + " is training for their next " + sport + " event.");
    }
}

interface Athlete {
    void train();
}
