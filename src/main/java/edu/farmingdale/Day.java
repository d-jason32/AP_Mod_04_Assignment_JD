package edu.farmingdale;

import java.util.ArrayList;

/**
 * Represents the day of a month that has weather measurements.
 *
 * @author Jason Devaraj
 * @version 0.1
 * @param date the day the weather measurement took place
 * @param temperature the temperature in degrees recorded that day
 * @param humidity the humidity recorded that day
 * @param precipitation the amount of precipitation recorded that day
 */
public record Day(String date, double temperature, int humidity, double precipitation) {

    /**
     * Takes a list of csvs and populates a new list with a Day's weather measurements.
     *
     * @param readFile the csv list
     * @return An ArrayList that consists of Day records.
     */
    public static ArrayList<Day> parseFile(ArrayList<String> readFile) {
        ArrayList<Day> parsedFile = new ArrayList<>();

        readFile.forEach((n) -> {
            // Put each comma separated value into a list.
            String[] parts = n.split(",");

            String date = parts[0];
            double temperature = Double.parseDouble(parts[1]);
            int humidity = Integer.parseInt(parts[2]);
            double precipitation = Double.parseDouble(parts[3]);

            // Create new Day record with the parsed data.
            Day newDay = new Day(date, temperature, humidity, precipitation);

            parsedFile.add(newDay);
        });
        return parsedFile;
    }

    /**
     * Assigns a category to a certain day.
     * @param dayList a list that contains records of Day measurements
     * @return A list of strings that represent a day and its category.
     */
    public static ArrayList<String> returnCategories(ArrayList<Day> dayList){
        ArrayList<String> list = new ArrayList<>();

        dayList.forEach((day)-> {
            String s = switch (day){
                // When temperature is above 50, day is categorized by hot.
                case Day d when day.temperature > 50  -> day.date + " Category: " + "hot";
                // When temperature is above 30, day is categorized by warm.
                case Day d when day.temperature > 30 -> day.date + " Category: " + "warm";
                // When temperature is above or equal to0, day is categorized by cold.
                case Day d when day.temperature >= 0 -> day.date + " Category: " + "cold";
                default -> "Error";
            };
            list.add(s);
        });
        return list;
    }

    /**
     * Determines the number of days in a month that had rain.
     * @param dayList a list that contains records of Day measurements
     * @return An integer that represents the number of rainy days in a month.
     */
    public static int numRainyDays(ArrayList<Day> dayList){
        long numRainy =  dayList.stream()
                // Filter for days with more than 0 inches of precipitation.
                .filter(day -> day.precipitation > 0)
                .count();

        return (int) numRainy;
    }

    /**
     * Determines the number of days in a month that had a temperature above 50 degrees.
     * @param dayList a list that contains records of Day measurements
     * @return An integer that represents the numbers of days in a month that were above 50 degrees.
     */
    public static int daysOver50(ArrayList<Day> dayList){
        long daysOver50 = dayList.stream()
                        // Filter for days that have a temperature greater than 50.
                        .filter(day -> day.temperature > 50)
                        .count();

        return (int) daysOver50;
    }

    /**
     * Averages all the temperatures in a month and returns the result.
     * @param dayList a list that contains records of Day measurements
     * @return A double that represents the average temperature in a month.
     */
    public static double getAverageTemperature(ArrayList<Day> dayList){
        double total = dayList.stream()
                .mapToDouble(day -> day.temperature)
                .sum();

        return total / dayList.size();
    }

    /**
     * Creates a Java Text Block containing all the weather information and returns the result.
     * @param averageTemp A double that represents the average temperature in a month.
     * @param daysOver50 An integer that represents the numbers of days in a month that were above 50 degrees.
     * @param numRainyDays An integer that represents the number of rainy days in a month.
     * @param categories A list of strings that represent a day and its category.
     * @return
     */
    public static String getTextBlock(double averageTemp, long daysOver50, long numRainyDays, ArrayList<String> categories){
        // Combine elements of the list into a string with each elements
        // separated by a new line.
        String list = String.join("\n", categories);

        return """
               Average Temperature of the Month: %.2f
               Number of days over 50 degrees: %d
               Number of rainy days: %d
               Categories list:
               %s
               """.formatted(averageTemp, daysOver50, numRainyDays, list);
    }
}
