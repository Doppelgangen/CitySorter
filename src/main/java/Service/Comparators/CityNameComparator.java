package Service.Comparators;

import Model.City;

import java.util.Comparator;

/**
 * Compares cities by city name
 */

public class CityNameComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
