package de.bcxp.challenge.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.bcxp.challenge.countries.CountryService;
import de.bcxp.challenge.weather.WeatherService;

public class CsvReader implements InputFileReaderInterface {

    private static final String COMMA_DELIMITER = ";";
    private static final String RELATIVEPATH = "src/main/resources/de/bcxp/challenge/";

    WeatherService weatherService = new WeatherService();
    CountryService countryService = new CountryService();

    // Reads in table from CSV File and converts it to List with the entries
    public List<String> readFile(String fileName) throws IOException {
        try (
                FileReader fr = new FileReader(RELATIVEPATH + fileName);
                BufferedReader br = new BufferedReader(fr);
                Stream<String> lines = br.lines();) {

            // Converting to List and removing empty lines
            List<String> result = lines.collect(Collectors.toList());
            result.removeIf(str -> str.isEmpty());

            return result;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public String interpretFile(List<String> fileContent, FileType fileType) {

        FileType type = fileType;
        String result = null;

        if (fileContent != null) {

            // Switch case for different functions
            switch (type) {
                case WEATHER:
                    // Removing header of table
                    fileContent.remove(0);
                    result = weatherService.getSmallestTemperatureSpread(fileContent);
                    break;
                case COUNTRIES:
                    fileContent.remove(0);
                    result = countryService.getHighestPopulationDensity(fileContent);
                    break;
                default:
                    System.out.println("Invalid filetype.");
                    break;
            }
        }

        return result;
    }

}
