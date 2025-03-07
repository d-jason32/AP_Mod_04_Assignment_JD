package edu.farmingdale;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> dataList = new ArrayList<>();
        ArrayList<Day> dayList = new ArrayList<>();

        /*
        Try-catch statement that opens and reads weatherdata.csv.
        Creates player objects and populates pqList1 with player objects.
         */
        try {
            FileReader fr = new FileReader("weatherdata.csv");
            Scanner infile = new Scanner(fr);
            String data;

            while (infile.hasNext()) {
                data = infile.nextLine();

                dataList.add(data);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Removes first object
        dataList.remove(0);

        /**
         * Parses each csv line into a Day record.
         */
        dataList.forEach( (n) -> {
            String[] parts = n.split(",");

            String date = parts[0];
            double temperature = Double.parseDouble(parts[1]);
            int humidity = Integer.parseInt(parts[2]);
            double precipitation = Double.parseDouble(parts[3]);

            Day newDay = new Day(date, temperature, humidity, precipitation);

            dayList.add(newDay);
        });



        double total = dayList.stream()
                .mapToDouble(day -> day.temperature)
                .sum();

        double averageTemp = total / dayList.size();


        System.out.println("Average Temp: " + averageTemp);

        /**
         *
         */
        long daysOver50 = dayList.stream()
                .filter(day -> day.temperature > 50)
                .count();

        System.out.println("Days over 50 degrees: " + daysOver50);

        long numRainyDays = dayList.stream()
                .filter(day -> day.precipitation > 0)
                .count();

        System.out.println("Rainy Days: " + numRainyDays);

        dayList.forEach((day)-> {
            String category = "cold";

            if (day.temperature > 30) {category = "warm";}
            if (day.temperature > 50) {category = "hot";}

            String s = switch (category){
                case "hot" -> day.date + " Category: " + "hot";
                case "warm" -> day.date + " Category: " + "warm";
                case "cold" -> day.date + " Category: " + "cold";
                default -> "Error";
            };

            System.out.println(s);
        });
    }

    record Day(String date, double temperature, int humidity, double precipitation) {}

}

