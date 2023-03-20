package de.bcxp.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    private String successLabel = "not successful";
    CsvReader csvReader;
    List<String> fileContent;

    @BeforeEach
    void setUp() {
        csvReader = new CsvReader();
        fileContent = new ArrayList<>();
    }
/*  
    @Test
    void weatherTest() throws IOException {
        fileContent = csvReader.readFile("weather2.csv");
        String result = csvReader.interpretFile(fileContent, FileType.WEATHER);
        assertEquals(result, "2", "My expectations were not met");
    }
    */

    @Test
    void countriesTestSuccess() throws IOException {
        fileContent = csvReader.readFile("countries2.csv");
        String result = csvReader.interpretFile(fileContent, FileType.COUNTRIES);
        assertEquals(result, "Wakanda", "My expectations were not met");
    }

    @Test
    void countriesTestWrongAnswer() throws IOException {
        fileContent = csvReader.readFile("countries2.csv");
        String result = csvReader.interpretFile(fileContent, FileType.COUNTRIES);
        assertNotEquals(result, "USA", "My expectations were not met");
    }


}