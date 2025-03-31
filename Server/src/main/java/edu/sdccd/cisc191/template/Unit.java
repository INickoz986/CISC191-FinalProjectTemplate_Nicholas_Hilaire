package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */

public class Unit
{
    private String unitName;
    private String unitType;
    private String specialization;
    private int price;
    private int armor;
    private int health;
    private int sightRange;
    private double unseenRange;
    private int speed;
    private int weight;
    private String abilities;


    //  Constructor to Initialize the private objects in the Unit class.
    public Unit(String unitName, String unitType, String specialization, int price, int armor,
                int health, int sightRange, double unseenRange, int speed,
                int weight, String abilities)

    { // TODO: Add comments to explain what each parameter represents for beginners.
        this.unitName = unitName;
        this.unitType = unitType;
        this.specialization = specialization;
        this.price = price;
        this.armor = armor;
        this.health = health;
        this.sightRange = sightRange;
        this.unseenRange = unseenRange;
        this.speed = speed;
        this.weight = weight;
        this.abilities = abilities;
    }

        //Setter so that the code get the data in the CSV file and translate it to code
        public String getUnitName()
        {
            return unitName;
        }

        public void setUnitName(String unitName)
        {
            this.unitName = unitName; // TODO: Consider adding validation to ensure the unit name is not empty.
        }

        public String getUnitType()
        {
            return unitType;
        }

        public void setUnitType(String unitType)
        {
            this.unitType = unitType; // TODO: Consider adding validation for valid unit types (e.g., non-null, non-empty).
        }

        public String getSpecialization()
        {
            return specialization;
        }

        public void setSpecialization(String specialization)
        {
            this.specialization = specialization; // TODO: Maybe validate that specialization is one of the expected values (e.g., not null).
        }

        public int getPrice()
        {
            return price;
        }

        public void setPrice(int price)
        {
            this.price = price;
        }

        public int getArmor()
        {
            return armor;
        }
        public void setArmor(int armor)
        {
            this.armor = armor; // TODO: Add a validation to check if armor value is valid (e.g., non-negative).
        }

        public int getHealth()
        {
            return health;
        }
        public void setHealth(int health)
        {
            this.health = health; // TODO: Validate if health is a reasonable value (e.g., not negative).
        }

        public int getSightRange()
        {
            return sightRange;
        }

        public void setSightRange(int sightRange)
        {
            this.sightRange = sightRange; // TODO: Consider adding checks for sightRange to ensure it's a reasonable value.
        }

        public double getUnseenRange()
        {
            return unseenRange;
        }
        public void setUnseenRange(double unseenRange)
        {
            this.unseenRange = unseenRange;
        }

        public int getSpeed()
        {
            return speed;
        }
        public void setSpeed(int speed)
        {
            this.speed = speed;
        }

        public int getWeight()
        {
            return weight;
        }
        public void setWeight(int weight)
        {
            this.weight = weight; // TODO: Validate if weight is a valid, non-negative value.
        }

        public String getAbilities()
        {
            return abilities;
        }
        public void setAbilities(String abilities)
        {
            this.abilities = abilities; // TODO: Maybe validate that abilities are not null or empty.
        }


        // Takes the previous get Methods and translates the data into the specific unit stat.
            @Override
            public String toString()
            {  // TODO: Make sure the string formatting is clear and consistent. Consider adding spaces for readability.
                return "Unit{" +
                        "unitName='" + unitName + '\'' +
                        ", unitType='" + unitType + '\'' +
                        ", specialization='" + specialization + '\'' +
                        ", price=" + price +
                        ", armor=" + armor +
                        ", health=" + health +
                        ", sightRange=" + sightRange +
                        ", unseenRange=" + unseenRange +
                        ", speed=" + speed +
                        ", weight=" + weight +
                        ", abilities='" + abilities + '\'' +
                        '}';
            } // TODO: Could also consider using String.format() for more control over formatting.

}

