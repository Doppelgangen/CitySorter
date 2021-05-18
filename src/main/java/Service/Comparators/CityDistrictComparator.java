package Service.Comparators;

import Model.City;

import java.util.Comparator;

/**
 * Compares cities by district and afterwards by name
 */

public class CityDistrictComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        int output = o1.getDistrict().compareTo(o2.getDistrict());
        if (output == 0)
        {
            output = o1.getName().compareToIgnoreCase(o2.getName());
        }
        return output;
    }
}
