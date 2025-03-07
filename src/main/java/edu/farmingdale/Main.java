package edu.farmingdale;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Day> dayList = new ArrayList<>();
        Day one = new Day("hi", 4, 4, 4);
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

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

