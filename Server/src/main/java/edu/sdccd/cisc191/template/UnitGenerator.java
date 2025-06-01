package edu.sdccd.cisc191.template;

/**
 * Author Nicholas Hilaire
 *
 * References:
 * - "Get Substring from String in Java" by Tom Hombergs
 * - Java read from URL stream (StackOverflow)
 * - Read a File from Resources Directory
 * - "Java: CSV File Easy Read/Write"
 * - "How to correctly use parseInt in Java"
 */

public class UnitGenerator {

    public static Unit createUnit(String[] stats) {
        // clean up strings
        for (int i = 0; i < stats.length; i++) {
            stats[i] = stats[i].replaceAll("\"", "").trim();
        }

        // pull values from array
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

        // return a specific unit type based on the string
        if (unitType.equalsIgnoreCase("Tank")) {
            return new Tank(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else if (unitType.equalsIgnoreCase("Fighter")) {
            return new Fighter(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else if (unitType.equalsIgnoreCase("Infantry")) {
            return new InfantryUnit(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities, extra);
        } else {
            // fallback if type isn’t recognized
            return new Unit(unitName, unitType, specialization, price, armor, health, sightRange, unseenRange, speed, weight, abilities);
        }
    }

    // safe way to get an int from array
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

    // safe way to get a double from array
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
