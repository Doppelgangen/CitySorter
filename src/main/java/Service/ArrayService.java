package Service;

import Model.City;

import java.util.List;

/**
 * ArrayService provides service functions with List<City>
 */

public class ArrayService {

    /**
     * Converts provided List<City> to array City[] of same size
     * If provided null - returns null
     * @param cityList
     * @return City[] or null
     */

    public static City[] listToArray(List<City> cityList){
        if (cityList == null)
            return null;
        City[] cityArray = new City[cityList.size()];
        cityList.toArray(cityArray);
        return cityArray;
    }

    /**
     * Returns Integer[2] where
     * Integer[0] is index of city with biggest population in provided array of the city
     * Integer[1] is value of population
     * @param cityArray
     * @return Integer[2] or null
     */

    public static Integer[] getBiggestPopulation(City[] cityArray){

        if (cityArray == null)
            return null;

        Integer[] out = new Integer[]{0, 0};
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getPopulation() > out[1]){
                out[1] = cityArray[i].getPopulation();
                out[0] = i;
            }
        }
//        City city = Arrays.stream(cityArray).max((a, b) -> Integer.compare(a.getPopulation(), b.getPopulation()))
//                .orElse(null);

        return out;
    }
}
