package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */
// TODO (Module 3): Consider making Tank an abstract class for common tank behaviors
// Tank class inherits the methods of Unit Class.
public class Tank extends Unit
{
    private int RearArmor;

    // TODO (Module 6): Provide a method to serialize Tank stats to an output stream
    //Constructor to Initialize the private objects in tank and Unit class.
    public Tank(String unitName, String unitType, String specialization, int price, int armor,
                int health, int sightRange, double unseenRange, int speed,
                int weight, String abilities, int RearArmor)
    {
        // Inheretence so Tank Class can inherent and actually utilize the methods from the Unit super class.
        super (unitName, unitType, specialization, price, armor, health, sightRange, unseenRange,speed, weight, abilities);

        //Setters created to set the value of the variable in the Tank Class
        this.RearArmor = RearArmor;
    }

    // Returns the value that is in the CSV file as extra stat.
    public int getRearArmor()
    {
        return RearArmor;
    }

    // Method created to change ExtraStat title in CSV to RearArmor and return that corresponding value
    @Override
    public String toString()
    {
        return super.toString() + "RearArmor: " + RearArmor;
    }


}
