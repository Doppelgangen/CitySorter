import Model.City;
import Service.ArrayService;
import Service.Parser;
import Service.Sorter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/makarovviktor/Desktop/Testing/Java.txt";
        List<City> cityCatalog = Parser.cityList(filePath);

        if (cityCatalog == null)
            return;

        int choice;
        boolean active = true;
        menu();

        while (active) {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    for (City city : cityCatalog)
                        System.out.println(city);
                    break;

                case 2:
//                  Sort by Comparator
//                  Collections.sort(cityCatalog, new CityNameComparator());
                    cityCatalog.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                    break;

                case 3:
//                  Collections.sort(cityCatalog, new CityDistrictComparator());
                    cityCatalog.sort((o1, o2) -> (o1.getDistrict().compareTo(o2.getDistrict())) == 0
                            ? o1.getName().compareToIgnoreCase(o2.getName())
                            : o1.getDistrict().compareTo(o2.getDistrict()));
                    break;

                case 4:
                    City[] cityArray = ArrayService.listToArray(cityCatalog);
                    if (cityArray == null)
                    {
                        System.out.println("Пустой массив.");
                        break;
                    }
                    Integer[] mostPopulatedCity = ArrayService.getBiggestPopulation(cityArray);
                    if (mostPopulatedCity == null)
                    {
                        System.out.println("Город не найден.");
                        break;
                    }
                    System.out.println("[" + mostPopulatedCity[0]
                            + "] = " + mostPopulatedCity[1]);
                    cityArray = null;
                    mostPopulatedCity = null;
                    break;

                case 5:
                    Map<String, Integer> citiesByRegion = Sorter.cityByRegionCount(cityCatalog);
                    if (citiesByRegion == null){
                        System.out.println("Сортировка не произведена.");
                        break;
                    }
                    System.out.println(citiesByRegion);
                    citiesByRegion = null;
                    break;

                case 6:
                    cityCatalog = null;
                    cityCatalog = Parser.cityList(filePath);
                    if (cityCatalog == null)
                        return;
                    System.out.println("Чтение успешно.");
                    break;

                case 7:
                    menu();
                    break;

                case 0:
                    System.out.println("Выход.");
                    active = false;
                    break;

                default:
                    System.out.println("Пожалуйста, повторите ввод.");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Выберите желаемое действие с каталогом городов:");
        System.out.println("1. Вывести список городов.");
        System.out.println("2. Отсортировать список городов по названию.");
        System.out.println("3. Отсортировать список городов по федеральному округу.");
        System.out.println("4. Индекс города с наибольшим населением.");
        System.out.println("5. Вывести количество городов в разрезе регионов.");
        System.out.println("6. Повторно считать города из файла.");
        System.out.println("7. Повторно вывести данное меню.");
        System.out.println("0. Завершить выполнение.");
    }
}
