package edu.farmingdale;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
        }
    }

    record Day()
}

/*
Develop a Weather Data Analyzer Application&nbsp;using modern Java features
such as the enhanced switch statement, text blocks, lambdas, markdown support
in Javadoc, and new features introduced from Java 15 to Java 23.
The application should be designed without explicit classes
(e.g., only records, interfaces, and functional programming)
and should demonstrate efficient code organization.
The project will be uploaded to GitHub with a comprehensive README.md file.

Features to Implement:

Parse weather data (e.g., temperature, humidity, precipitation) from a CSV file.

Provide the following functionalities:

Average temperature for a specific month.

Days with temperatures above a given threshold.

Count of rainy days.

Use an enhanced switch statement to determine weather categories
(e.g., "Hot", "Warm", "Cold").

Include lambdas and streams to process weather data efficiently.

Use Modern Java Features:

Use Java Records to represent weather data.

Use the enhanced switch (introduced in Java 14 and finalized in later versions).

Use Text Blocks for generating output (introduced in Java 15).

Use Pattern Matching for switch or any other feature from Java 15–23

(e.g., String.stripIndent, virtual threads if relevant).

Technical Constraints:

Do not use explicit classes. The design should leverage records,
interfaces, and functional constructs.

Documentation:
Use markdown Javadoc for all methods and features.
Include code examples in the Javadoc using the markdown support
introduced in JDK 18.

Submission:
Upload the complete project to a GitHub repository with a detailed README.md file.

 */