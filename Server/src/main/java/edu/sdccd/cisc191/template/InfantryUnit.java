package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */

// Infantry class inherits the methods of Unit Class.
public class InfantryUnit extends Unit
{
    private int manpower;

    //Constructor to Initialize the private objects in infantryUnit and Unit class.
    public InfantryUnit(String unitName, String unitType, String specialization, int price, int armor,
                        int health, int sightRange, double unseenRange, int speed,
                        int weight, String abilities, int manpower)
    {
        // Inheretence so InfantryUnit Class can inherent and actually utilize the methods from the Unit super class.
        super (unitName, unitType, specialization, price, armor, health, sightRange, unseenRange,speed, weight, abilities);

        //Setters created to set the value of the variable in the InfantryUnit Class
        this.manpower = manpower;
    }

    // Returns the value that is in the CSV file as extra stat.
    public int getManpower()
    {
        return manpower;
    }

    // TODO: Add validation to ensure manpower is a positive number.
    // TODO: Check if the `manpower` value is not null or invalid before using it.
    // Method created to change ExtraStat title in CSV to manpower and return that corresponding value
    @Override
    public String toString()
    {
        return super.toString() + "manpower= " + manpower;
    }

    // TODO: Test the toString method to ensure it formats the output correctly.
}
