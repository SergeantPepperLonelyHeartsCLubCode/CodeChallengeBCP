package de.bcxp.challenge;

import java.util.List;

class CountryService implements CountryInterface  {

    private static final String COUNTRY_SEPERATOR = ";";

    
    @Override
    public  String getHighestPopulationDensity(List<String> countries){
        
        int highestDensity  = Integer.MIN_VALUE;
        String countryWithHighestDensity = null;
        
        for (String line : countries) {
            String[] fields = line.split(COUNTRY_SEPERATOR);
            System.out.println(fields[0]);
            System.out.println("Fields length " + fields.length);
            int population = Integer.parseInt(correctInputStringMistakes(fields[3]));
            int area = Integer.parseInt(fields[4]);
            int density = population / area;
           
            if (density > highestDensity) {
                highestDensity = density;
                countryWithHighestDensity = fields[0];
            }
        }

        if (countryWithHighestDensity != null) {
            System.out.println(countryWithHighestDensity);
            return countryWithHighestDensity;
        } else {
            System.out.println("No data found.");
            return null;
        }
    }

 private String correctInputStringMistakes(String populationString){
    //Removing everything after an comma
    int index = populationString.indexOf(",");
    if (index != -1) {
        populationString = populationString.substring(0, index);
    }
    //Deleting commas and dots
    populationString = populationString.replaceAll("[.,]", "");
    return populationString;
 }
        


}
