package Service;

import Model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**Parser class provides single static method*/

public class Parser {

    /**
     * Reads file, provided by filepath and creates new ArrayList of Cities
     * If file not found - prints message to console and returns null.
     * @param filePath
     * @return ArrayList<City> or null
     */

    public static List<City> cityList(String filePath){
        List<City> listOfCities = new ArrayList<>();

        /*File should be like:
        id;
        name;
        region;
        district;
        population;
        foundation;
        id;
        ...etc*/

        File file = new File(filePath);
        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(";\n?");
            while (fileScanner.hasNext()){
                City cityToAdd = new City();
                cityToAdd.setId(fileScanner.nextInt());
                cityToAdd.setName(fileScanner.next());
                cityToAdd.setRegion(fileScanner.next());
                cityToAdd.setDistrict(fileScanner.next());
                cityToAdd.setPopulation(fileScanner.nextInt());
                cityToAdd.setFoundation(fileScanner.nextInt());
                listOfCities.add(cityToAdd);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
        return listOfCities;
    }

}
