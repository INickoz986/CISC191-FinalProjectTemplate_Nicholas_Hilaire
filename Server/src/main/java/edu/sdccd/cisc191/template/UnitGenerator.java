package edu.sdccd.cisc191.template;

public class UnitGenerator {

    public static Unit createUnit(String[] stats) {
        // TODO: Clean up input strings
        for (int i = 0; i < stats.length; i++) {
            stats[i] = stats[i].replaceAll("\"", "").trim();
        }

        // TODO: Extract unit info from stats array
        String unitType = stats.length > 0 ? stats[0] : "";
        String unitName = stats.length > 1 ? stats[1] : "";
        String specialization = stats.length > 2 ? stats[2] : "";
        int price = parseIntSafe(stats, 3, 0);
        int armor = parseIntSafe(stats, 4, 0);
        int health = parseIntSafe(stats, 5, 0);
        int sightRange = parseIntSafe(stats, 6, 0);
        double unseenRange = parseDoubleSafe(stats, 7, 0.0);
        int speed = parseIntSafe(stats, 8, 0);
        int weight = parseIntSafe(stats, 9, 0);
        String abilities = stats.length > 10 ? stats[10] : "";
        int extra = parseIntSafe(stats, 11, 0);

        // TODO: Create unit object based on unitType
        if (unitType.equalsIgnoreCase("Tank")) {
            return new Tank(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else if (unitType.equalsIgnoreCase("Fighter")) {
            return new Fighter(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else if (unitType.equalsIgnoreCase("Infantry")) {
            return new InfantryUnit(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else {
            // TODO: Return default Unit if unitType not recognized
            return new Unit(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities);
        }
    }

    // TODO: Safely parse int from stats
    private static int parseIntSafe(String[] stats, int index, int defaultValue) {
        if (stats.length > index && !stats[index].isEmpty()) {
            try {
                return Integer.parseInt(stats[index]);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse int at index " + index + ": " + stats[index]);
            }
        }
        return defaultValue;
    }

    // TODO: Safely parse double from stats
    private static double parseDoubleSafe(String[] stats, int index, double defaultValue) {
        if (stats.length > index && !stats[index].isEmpty()) {
            try {
                return Double.parseDouble(stats[index]);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse double at index " + index + ": " + stats[index]);
            }
        }
        return defaultValue;
    }
}
