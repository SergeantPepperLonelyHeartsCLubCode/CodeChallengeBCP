package de.bcxp.challenge.weather;

import java.util.List;

public class WeatherService implements WeatherInterface {

    private static final String WEATHER_SEPERATOR = ",";

    @Override
    public String getSmallestTemperatureSpread(List<String> weather) {
        int minDifference = Integer.MAX_VALUE;
        String dayWithSmallestTemperatureSpread = null;

        for (String line : weather) {
            String[] fields = line.split(WEATHER_SEPERATOR);

            if (fields.length > 2) {

                Integer difference = null;

                if (isInteger(fields[2]) && isInteger(fields[1])) {
                    int maxTemp = Integer.parseInt(fields[1]);
                    int minTemp = Integer.parseInt(fields[2]);
                    
                    if (maxTemp > minTemp) {
                        difference = maxTemp - minTemp;
                    }

                    if (difference != null && difference < minDifference) {
                        minDifference = difference;
                        dayWithSmallestTemperatureSpread = fields[0];
                    }
                }
            }
        }

        if (dayWithSmallestTemperatureSpread == null) {
            System.out.println("No data found.");
            return null;
        } else {
            return dayWithSmallestTemperatureSpread;
        }
    }

    public boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
