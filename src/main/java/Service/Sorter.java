package Service;

import Model.City;

import java.util.*;

/**
 * Class Sorter have single static method
 */

public class Sorter {

    /**
     * Method copies List from input to a new ArrayList, sorts it and creates new TreeMap
     * TreeMap key provided by cityList getRegion
     * TreeMap value is a counter of times same getRegion value faced throughout cityList
     * if cityList is empty returns null
     * @param cityList
     * @return TreeMap<String, Integer> or null
     */

    public static Map<String, Integer> cityByRegionCount(List<City> cityList){

        if (cityList.isEmpty()||(cityList == null))
            return null;

        Map<String, Integer> output= new TreeMap<>();

        List<City> cities = new ArrayList<>(cityList);
        Collections.copy(cities, cityList);
        cities.sort(Comparator.comparing(City::getRegion));

        String district = cities.get(0).getRegion();
        Integer counter = 0;
        while (!cities.isEmpty()){
            if (district.equals(cities.get(0).getRegion())) {
                counter++;
                cities.remove(0);
            } else {
                output.put(district, counter);
                district = cities.get(0).getRegion();
                counter = 0;
            }
        }
        output.put(district, counter);

        return output;
    }
}
