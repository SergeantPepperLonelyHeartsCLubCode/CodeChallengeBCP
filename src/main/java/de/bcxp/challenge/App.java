package de.bcxp.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws IOException
     */
    public static void main(String... args) throws IOException {

        
        // Your preparation code …
        CsvReader fileReader = new CsvReader();
        List<String> fileContent = new ArrayList<>();
        
        
        fileContent = fileReader.readFile("weather.csv");
        String dayWithSmallestTempSpread = fileReader.interpretFile(fileContent,FileType.WEATHER);
        if (dayWithSmallestTempSpread != null) {
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
        }else{
            System.out.println("No Result found");
        }    
        fileContent = fileReader.readFile("countries.csv");
        String countryWithHighestPopulationDensity = fileReader.interpretFile(fileContent,FileType.COUNTRIES);
        if (dayWithSmallestTempSpread != null) {
         System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
         }else{
        System.out.println("No Result found");
    }    
     
    }
}
