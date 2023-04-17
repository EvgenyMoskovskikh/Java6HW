import com.company.helper.ScannerHelper;

import java.util.*;

public class Sem6 {

    public static void viewAllLaptop() {
        System.out.println("Все доступные товары: \n" + initialLaptops());
    }

    public static void viewFilterLaptop() {
        Map<Integer, String> sel = menuFilter(initialFilters());
        sort(sel, initialLaptops());
    }

    public static Map<Integer, String> menuFilter(Map<Integer, String> mapFilters) {
        Map<Integer, String> requestFilter = new HashMap<>();
        while (true) {
            String question = ScannerHelper.getIntFromString("Вы хотите воспользоваться фильтром? да/нет\n");
            if (question.equals("нет") || question.equals("n") || question.equals("no")) {
                System.out.println("ОК");
                break;
            } else if (question.equals("да") || question.equals("y") || question.equals("yes")) {
                printMenuFilter(mapFilters);
                Integer key = ScannerHelper.getIntFromInput("Выберите пункт, по которому нужно отфильтровать: \n");
                infoFilter(key);
                String value = ScannerHelper.getIntFromString("Введите требуемый параметр: ");
                requestFilter.put(key, value);
            } else {
                System.out.println("не понимаю ((");
            }
        }
        return requestFilter;
    }

    private static void infoFilter(int num) {
        if (num == 1) {
            System.out.println("Для фильтра доступны: \n\tHP; Asus; Acer; Apple;");
        } else if (num == 2) {
            System.out.println("Для фильтра доступны: \n\t4; 8;");
        } else if (num == 3) {
            System.out.println("Для фильтра доступны: \n\t500; 128; 450; 350; 256;");
        } else if (num == 4) {
            System.out.println("Для фильтра доступны: \n\tWindows 11; Windows 10; macOs;");
        } else if (num == 5) {
            System.out.println("Для фильтра доступны: \n\twhite; black; silver;");
        } else if (num == 6) {
            System.out.println("Для фильтра доступны: \n\t55000; 48000; 58000;");
        } else {
            System.out.println("такого нет (((");
        }
    }

    private static void printMenuFilter(Map<Integer, String> mapFilters) {
        System.out.println();
        for (int i : mapFilters.keySet()) {
            System.out.println(i + ". " + mapFilters.get(i));
        }
    }

    private static void sort(Map<Integer, String> filters, ArrayList<Laptop> laptops) {
        Set<Laptop> temp = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            for (int item1 : filters.keySet()) {
                if (item1 == 1 && !laptop.getModel().equals(filters.get(item1))) {
                    temp.remove(laptop);
                }

                for (int item2 : filters.keySet()) {
                    String memory = Integer.toString(laptop.getMemory());
                    if (item2 == 2 && !memory.equals(filters.get(item2))) {
                        temp.remove(laptop);
                    }

                    for (int item3 : filters.keySet()) {
                        String hardDrive = Integer.toString(laptop.getHardDrive());
                        if (item3 == 3 && !hardDrive.equals(filters.get(item3))) {
                            temp.remove(laptop);
                        }

                        for (int item4 : filters.keySet()) {
                            if (item4 == 4 && !laptop.getOperatingSystem().equals(filters.get(item4))) {
                                temp.remove(laptop);
                            }

                            for (int item5 : filters.keySet()) {
                                if (item5 == 5 && !laptop.getColor().equals(filters.get(item5))) {
                                    temp.remove(laptop);
                                }

                                for (int item6 : filters.keySet()) {
                                    String price = Integer.toString(laptop.getPrice());
                                    if (item6 == 6 && !price.equals(filters.get(item6))) {
                                        temp.remove(laptop);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (temp.isEmpty()) {
            System.out.println("Извините, по заданным параметрам ноутбуков у нас нет (((");
        } else {
            System.out.println("По вашим параметрам найдено: \n" + temp);
        }
    }

    private static Map<Integer, String> initialFilters() {
        Map<Integer, String> mapFilters = new HashMap<>();
        mapFilters.put(1, "Модель");
        mapFilters.put(2, "ОЗУ");
        mapFilters.put(3, "Объем жесткого диска");
        mapFilters.put(4, "Операционная система");
        mapFilters.put(5, "Цвет");
        mapFilters.put(6, "Цена");
        return mapFilters;
    }

    private static ArrayList<Laptop> initialLaptops() {
        ArrayList<Laptop> laptops = new ArrayList<>();
        Laptop hp1 = new Laptop("HP", 4, 500, "Windows 11", "white", 55000);
        Laptop asus = new Laptop("Asus", 4, 128, "Windows 10", "black", 48000);
        Laptop acer = new Laptop("Acer", 8, 450, "Windows 11", "silver", 58000);
        Laptop hp2 = new Laptop("HP", 8, 350, "Windows 10", "white", 48000);
        Laptop appleAir = new Laptop("Apple", 8, 256, "macOs", "white", 55000);
        Laptop applePro = new Laptop("Apple", 8, 256, "macOs", "silver", 55000);
        Laptop hp3 = new Laptop("HP", 4, 500, "Windows 11", "black", 55000);
        Collections.addAll(laptops, hp1, asus, acer, hp2, appleAir, applePro, hp3);
        return laptops;
    }
}