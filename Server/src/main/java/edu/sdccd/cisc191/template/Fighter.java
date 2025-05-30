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
        // Inheretence so InfantryUnit Class can inherent and actually utilize the methods from the Unit super class.
        super (unitName, unitType, specialization, price, armor, health, sightRange, unseenRange,speed, weight, abilities);

        //Setters created to set the value of the variable in the InfantryUnit Class
        this.fuel = fuel;
    }

        // Returns the value that is in the CSV file as extra stat.
        public int getFuel()
        {
            return fuel;
        }
    // TODO: Add validation to ensure fuel is not negative.
    // TODO: Override equals() and hashCode() for better collection support and comparisons.


    // TODO: Implement actual calculation based on fuel and other stats.

        public int calculateRange() {
        return fuel * 10;
        }

            // Method created to change ExtraStat title in CSV to fuel and return that corresponding value
            @Override
            public String toString()
            {
                return super.toString() + "fuel= " + fuel;
            }


}
