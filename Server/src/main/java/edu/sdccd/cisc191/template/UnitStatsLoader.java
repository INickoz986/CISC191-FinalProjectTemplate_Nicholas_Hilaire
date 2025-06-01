package edu.sdccd.cisc191.template;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UnitStatsLoader
{
    public static List<Unit> loadUnits(String path)
    {
        List<Unit> units = new ArrayList<>();

        File file = new File(path);
        // TODO: Check alternate resource folder if file not found
        if (!file.exists())
        {
            file = new File("C:\\Users\\Nicko\\IdeaProjects\\CISC191-FinalProjectTemplate\\Server\\src\\main\\resources" + path);
        }

        // TODO: Exit if file still not found
        if (!file.exists())
        {
            System.err.println("File not found: " + path);
            return units;
        }

        // TODO: Read file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            // TODO: Skip header row
            if ((line = br.readLine()) == null)
            {
                return units;
            }

            // TODO: Process each line of CSV
            while ((line = br.readLine()) != null)
            {
                // TODO: Split CSV line accounting for quoted commas
                String[] stats = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // TODO: Trim whitespace from each field
                for (int i = 0; i < stats.length; i++)
                {
                    stats[i] = stats[i].trim();
                }

                // TODO: Create Unit from stats and add to list
                try
                {
                    Unit unit = UnitGenerator.createUnit(stats);
                    units.add(unit);
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Error parsing stats: " + line);
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        // TODO: Return list of loaded units
        return units;
    }
}
