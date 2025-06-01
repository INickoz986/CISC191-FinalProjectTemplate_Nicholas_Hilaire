package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */

// Fighter unit extends Unit
public class Fighter extends Unit
{
    //TODO: stores fuel value
    private int fuel;

    // sets everything up, including what's in Unit
    public Fighter(String unitName, String unitType, String specialization, int price, int armor,
                   int health, int sightRange, double unseenRange, int speed,
                   int weight, String abilities, int fuel)
    {
        //TODO: call parent constructor first
        super(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities);
        this.fuel = fuel;
    }

    //TODO: just returns fuel value
    public int getFuel()
    {
        return fuel;
    }

    // includes fuel in the output
    @Override
    public String toString()
    {
        return super.toString() + "fuel= " + fuel;
    }
}
