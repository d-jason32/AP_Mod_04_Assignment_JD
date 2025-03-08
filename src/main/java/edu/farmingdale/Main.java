package edu.farmingdale;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) {
        // Generate list from csv file.
        ArrayList<String> readFile = readFile("weatherdata.csv");
        //
        ArrayList<Day> parsedFile = Day.parseFile(readFile);

        int numRainyDays = Day.numRainyDays(parsedFile);
        int daysOver50 = Day.daysOver50(parsedFile);
        double averageTemp = Day.getAverageTemperature(parsedFile);
        ArrayList<String> categories = Day.returnCategories(parsedFile);
        String textBlock = Day.getTextBlock(averageTemp, daysOver50, numRainyDays, categories);

        System.out.println(textBlock);
    }

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
        dataList.remove(0);
        return dataList;
    }

}

// Refactor
// readme file
// markdown support in javadoc. Add javadoc comments. // include code examples
// pattern matching for switch
