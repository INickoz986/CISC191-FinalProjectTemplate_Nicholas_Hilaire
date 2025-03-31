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
    private int fuel; // TODO: Consider adding a comment explaining that fuel is a stat for the fighter.

    //Constructor to Initialize the private objects in infantryUnit and Unit class.
    public Fighter(String unitName, String unitType, String specialization, int price, int armor,
                   int health, int sightRange, double unseenRange, int speed,
                   int weight, String abilities, int fuel)
    {
        // Inheretence so InfantryUnit Class can inherent and actually utilize the methods from the Unit super class.
        super (unitName, unitType, specialization, price, armor, health, sightRange, unseenRange,speed, weight, abilities);

        //Setters created to set the value of the variable in the InfantryUnit Class
        this.fuel = fuel;
    }

        // Returns the value that is in the CSV file as extra stat.
        public int getFuel()
        {
            return fuel; // TODO: Maybe add validation to check if fuel is negative or invalid.
        }

            // Method created to change ExtraStat title in CSV to fuel and return that corresponding value
    // TODO: In the toString method, it may be better to format the output more clearly, like adding spaces or separators for readability.
            @Override
            public String toString()
            { // TODO: Add space after "fuel=" for better formatting: "fuel = " + fuel
                return super.toString() + "fuel= " + fuel;
            }


}
