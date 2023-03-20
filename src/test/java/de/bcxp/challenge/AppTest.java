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
    CsvReader csvReader;
    List<String> fileContent;

    @BeforeEach
    void setUp() {
        csvReader = new CsvReader();
        fileContent = new ArrayList<>();
    }

    @Test
    void weatherTestSuccess() throws IOException {
        fileContent = csvReader.readFile("weatherTest.csv");
        String result = csvReader.interpretFile(fileContent, FileType.WEATHER);
        assertEquals(result, "2", "My expectations were not met");
    }

    @Test
    void weatherTestFail() throws IOException {
        fileContent = csvReader.readFile("weatherTest.csv");
        String result = csvReader.interpretFile(fileContent, FileType.WEATHER);
        assertNotEquals(result, "1", "My expectations were not met");
    }

    @Test
    void countriesTestSuccess() throws IOException {
        fileContent = csvReader.readFile("countriesTest.csv");
        String result = csvReader.interpretFile(fileContent, FileType.COUNTRIES);
        assertEquals(result, "Wakanda", "My expectations were not met");
    }

    @Test
    void countriesTestWrongAnswer() throws IOException {
        fileContent = csvReader.readFile("countriesTest.csv");
        String result = csvReader.interpretFile(fileContent, FileType.COUNTRIES);
        assertNotEquals(result, "USA", "My expectations were not met");
    }


}