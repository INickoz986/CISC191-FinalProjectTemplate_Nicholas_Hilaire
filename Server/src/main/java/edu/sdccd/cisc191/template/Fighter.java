package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */


// Fighter class inherits the methods of Unit Class.
public class Fighter extends Unit
{
    private int fuel;

    //Constructor to Initialize the private objects in infantryUnit and Unit class.
    public Fighter(String unitName, String unitType, String specialization, int price, int armor,
                   int health, int sightRange, double unseenRange, int speed,
                   int weight, String abilities, int fuel)
    {
        // TODO: Make sure the fuel value is being set correctly
        super (unitName, unitType, specialization, price, armor, health, sightRange, unseenRange,speed, weight, abilities);

        //Setters created to set the value of the variable in the InfantryUnit Class
        this.fuel = fuel;
    }

    // Returns the value that is in the CSV file as extra stat.
    public int getFuel()
    {
        return fuel;
    }

    // Method created to change ExtraStat title in CSV to fuel and return that corresponding value
    @Override
    public String toString()
    {
        // TODO: Check if the fuel is displayed correctly in the string
        return super.toString() + "fuel= " + fuel;
    }

}
