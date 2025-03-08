package edu.farmingdale;

import java.util.ArrayList;

public record Day(String date, double temperature, int humidity, double precipitation) {
    public static ArrayList<Day> parseFile(ArrayList<String> readFile) {
        ArrayList<Day> parsedFile = new ArrayList<>();

        readFile.forEach((n) -> {
            String[] parts = n.split(",");

            String date = parts[0];
            double temperature = Double.parseDouble(parts[1]);
            int humidity = Integer.parseInt(parts[2]);
            double precipitation = Double.parseDouble(parts[3]);

            Day newDay = new Day(date, temperature, humidity, precipitation);

            parsedFile.add(newDay);
        });
        return parsedFile;
    }

    public static ArrayList<String> returnCategories(ArrayList<Day> dayList){
        ArrayList<String> list = new ArrayList<>();
        dayList.forEach((day)-> {

            String s = switch (day){
                case Day d when day.temperature > 50  -> day.date + " Category: " + "hot";
                case Day d when day.temperature > 30 -> day.date + " Category: " + "warm";
                case Day d when day.temperature >= 0 -> day.date + " Category: " + "cold";
                default -> "Error";
            };
            list.add(s);
        });
        return list;
    }

    public static int numRainyDays(ArrayList<Day> dayList){
        int numRainyDays = (int) dayList.stream()
                .filter(day -> day.precipitation > 0)
                .count();

        return numRainyDays;
    }

    public static int daysOver50(ArrayList<Day> dayList){
        long daysOver50 =
                dayList.stream()
                        .filter(day -> day.temperature > 50)
                        .count();

        return (int) daysOver50;
    }

    public static double getAverageTemperature(ArrayList<Day> dayList){
        double total = dayList.stream()
                .mapToDouble(day -> day.temperature)
                .sum();

        return total / dayList.size();
    }


    public static String getTextBlock(double averageTemp, long daysOver50, long numRainyDays, ArrayList<String> categories){
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
