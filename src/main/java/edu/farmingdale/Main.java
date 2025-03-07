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

        /**
         *
         */
        dayList.stream()
                .filter(day -> day.temperature > 50)
                .forEach(day -> System.out.println("Over 50 degrees: " + day.date));
    }



    record Day(String date, double temperature, int humidity, double precipitation) {}


}

