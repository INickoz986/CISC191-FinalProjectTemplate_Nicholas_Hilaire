package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 * References: "Bro code: Java: Inheritance" https://www.youtube.com/watch?v=Zs342ePFvRI
 */



public class Unit
{

    // TODO (10. Searching and Sorting): Implement Comparable<Unit> to allow sorting units by price or another attribute.
    // TODO (3. OOP): Add a static method to search for a Unit by name in a list of units.

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

    {
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
            this.unitName = unitName;
        }

        public String getUnitType()
        {
            return unitType;
        }

        public void setUnitType(String unitType)
        {
            this.unitType = unitType;
        }

        public String getSpecialization()
        {
            return specialization;
        }

        public void setSpecialization(String specialization)
        {
            this.specialization = specialization;
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
            this.armor = armor;
        }

        public int getHealth()
        {
            return health;
        }
        public void setHealth(int health)
        {
            this.health = health;
        }

        public int getSightRange()
        {
            return sightRange;
        }

        public void setSightRange(int sightRange)
        {
            this.sightRange = sightRange;
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
            this.weight = weight;
        }

        public String getAbilities()
        {
            return abilities;
        }
        public void setAbilities(String abilities)
        {
            this.abilities = abilities;
        }

    /**
     * Compare this Unit to another by price.
     * Useful for sorting units.
     */
    public int compareByPrice(Unit other) {
        return Integer.compare(this.price, other.price);
    }

    /**
     * Static method to search for a unit by name in a list.
     * Returns the first matching unit or null if not found.
     */
    public static Unit searchByName(java.util.List<Unit> units, String name) {
        for (Unit unit : units) {
            if (unit.getUnitName().equalsIgnoreCase(name)) {
                return unit;
            }
        }
        return null;
    }



    // Takes the previous get Methods and translates the data into the specific unit stat.
            @Override
            public String toString()
            {
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
            }

}

