package de.bcxp.challenge;

import java.util.List;

class WeatherService implements WeatherInterface  {

    private static final String WEATHER_SEPERATOR = ",";

    /*
    @Override
    public String getSmallestTemperatureSpread(List<String> weather) {
     
        int minDiffernce = Integer.MAX_VALUE;
        int postitionOfSmallest = 0;
        for (int i = 0; i < weather.size(); i++) {
             String text = (String) weather.get(i);
             String [] myArray = text.split(WEATHER_SEPERATOR);
    
    
            int maxTemp = Integer.parseInt(myArray[2]);
            int minTmp = Integer.parseInt(myArray[1]);
    
             int difference = minTmp- maxTemp;
            
             if(difference < minDiffernce){
                minDiffernce = difference; 
                postitionOfSmallest = i;
            }
        }
        String[] fields = weather.get(postitionOfSmallest).split(WEATHER_SEPERATOR);
        String dayWithSmallestTemperatureSpread = fields[0];
        return dayWithSmallestTemperatureSpread;
    }

    */


@Override
public String getSmallestTemperatureSpread(List<String> weather) {
    int minDifference = Integer.MAX_VALUE;
    String dayWithSmallestTemperatureSpread = null;

    for (String line : weather) {
        String[] fields = line.split(WEATHER_SEPERATOR);
        int maxTemp = Integer.parseInt(fields[2]);
        int minTemp = Integer.parseInt(fields[1]);
        int difference = minTemp - maxTemp;

        if (difference < minDifference) {
            minDifference = difference;
            dayWithSmallestTemperatureSpread = fields[0];
        }
    }

    if (dayWithSmallestTemperatureSpread == null) {
        System.out.println("No data found.");
        return null;
    } else {
        return dayWithSmallestTemperatureSpread;
    }
}


   
    
 }

