import Model.City;
import Service.ArrayService;
import Service.Comparators.CityDistrictComparator;
import Service.Comparators.CityNameComparator;
import Service.Parser;
import Service.Sorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Testing {

    List<City> cityCatalog;

    @Before
    public void initCatalog(){
        cityCatalog = new ArrayList<>();
        cityCatalog.add(new City(11 ,"Алдан","Якутия","Дальневосточный", 21277, 1924));
        cityCatalog.add(new City(8 ,"Александровск-Сахалинский","Сахалинская область","Дальневосточный", 10613, 1869));
        cityCatalog.add(new City(2 ,"Майкоп","Адыгея","Южный", 21277, 1857));
        cityCatalog.add(new City(4 ,"Абаза","Хакасия","Сибирский", 17111, 1867));
        cityCatalog.add(new City(1 ,"Адыгейск","Адыгея","Южный", 12248, 1973));
        cityCatalog.add(new City(3 ,"Горно-Алтайск","Алтай","Сибирский", 56928, 1830));
        cityCatalog.add(new City(5 ,"Абакан","Хакасия","Сибирский", 165183, 1931));
        cityCatalog.add(new City(6 ,"Абдулино","Оренбургская область","Приволжский", 20663, 1795));
        cityCatalog.add(new City(7 ,"Амурск","Хабаровский край","Дальневосточный", 42977, 1958));
        cityCatalog.add(new City(9 ,"Агидель","Башкортостан","Приволжский", 16365, 1980));
        cityCatalog.add(new City(10 ,"Агрыз","Татарстан","Приволжский", 19299, 1646));
    }

    @Test
    public void shouldReadFromFileNotNull(){
        String filePath = "/Users/makarovviktor/Desktop/Testing/Java.txt";
        String output = null;
        try {
            Scanner scanner = new Scanner(new File(filePath));
            output = scanner.next();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(output);
    }

    @Test
    public void shouldReadCorrectValueFromFile(){
        String filePath = "/Users/makarovviktor/Desktop/Testing/Java.txt";
        List<City> cities = Parser.cityList(filePath);
        Assert.assertEquals("Адыгейск",cities.get(0).getName());
    }

    @Test
    public void shouldSortByCityName(){
        Collections.sort(cityCatalog, new CityNameComparator());
        Assert.assertEquals("Абаза", cityCatalog.get(0).getName());
    }

    @Test
    public void shouldSortByDistrictAndName(){
        Collections.sort(cityCatalog, new CityDistrictComparator());
        Assert.assertEquals("Алдан", cityCatalog.get(0).getName());
    }

    @Test
    public void shouldConvertToArray(){
        City[] output = ArrayService.listToArray(cityCatalog);
        Assert.assertNotNull(output[0]);
    }

    @Test
    public void shouldReadCorrectData(){
        City[] cityArray = ArrayService.listToArray(cityCatalog);
        Integer[] biggest = ArrayService.getBiggestPopulation(cityArray);
        Assert.assertArrayEquals(new Integer[]{6, 165183}, biggest);
    }

    @Test
    public void shouldMapData() {
        Map<String, Integer> output = Sorter.cityByRegionCount(cityCatalog);
        Assert.assertEquals(java.util.Optional.of(2).get(), output.get("Адыгея"));
    }

}
