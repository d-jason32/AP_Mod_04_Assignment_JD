package edu.farmingdale;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Jason Devaraj
 */
public class Main {
    public static void main(String[] args) {
        // Generate list from csv file.
        ArrayList<String> readFile = readFile("weatherdata.csv");
        // Create list of Day records.
        ArrayList<Day> parsedFile = Day.parseFile(readFile);

        // Calculate number of rainy days.
        int numRainyDays = Day.numRainyDays(parsedFile);
        // Calculate number of days over 50 degrees.
        int daysOver50 = Day.daysOver50(parsedFile);
        // Calculate the average temperature of the month.
        double averageTemp = Day.getAverageTemperature(parsedFile);
        // Categorize each day.
        ArrayList<String> categories = Day.returnCategories(parsedFile);
        // Generate text block of the data.
        String textBlock = Day.getTextBlock(averageTemp, daysOver50, numRainyDays, categories);

        System.out.println(textBlock);
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static ArrayList<String> readFile(String fileName){
        ArrayList<String> dataList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(fileName);
            Scanner infile = new Scanner(fr);
            String data;
            while (infile.hasNext()) {
                data = infile.nextLine();
                dataList.add(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Remove first line.
        dataList.removeFirst();
        return dataList;
    }
}

// readme file
// markdown support in javadoc. Add javadoc comments. // include code examples

