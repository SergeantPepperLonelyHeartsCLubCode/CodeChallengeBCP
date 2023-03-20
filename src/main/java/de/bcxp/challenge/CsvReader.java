package de.bcxp.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CsvReader implements InputFileReaderInterface {
    

    private static final String COMMA_DELIMITER = ";";
    private static final String RELATIVEPATH = "src/main/resources/de/bcxp/challenge/";

    WeatherService weatherService = new WeatherService();
    CountryService countryService = new CountryService();

    //Reads in table from CSV File and converts it to List with the entries
    public List<String> readFile(String fileName) throws IOException {
    List<String> records = new ArrayList<>();
    try (
        FileReader fr = new FileReader(RELATIVEPATH + fileName);
        BufferedReader br = new BufferedReader(fr);
        Stream<String> lines = br.lines();
    ) {
      
     //Converting to List and removing empty lines
      List<String> result = lines.collect(Collectors.toList());
      result.removeIf(str -> str.isEmpty());

      return result;
    }
}


public String interpretFile(List<String> fileContent, FileType fileType) {

    FileType type = fileType;
    String result = null;
    //Switch case for different functions
    switch (type) {
        case WEATHER:
            fileContent.remove(0);
            WeatherService weatherService = new WeatherService();
             result = weatherService.getSmallestTemperatureSpread(fileContent);
            break;
        case COUNTRIES:
            fileContent.remove(0);
            result =  countryService.getHighestPopulationDensity(fileContent);
            break;
        default:
            System.out.println("Invalid filetype.");
            break;
    }

   return result;
}






        

    





     

}
