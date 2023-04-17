public class Seminar6 {
    private static final String TASK_MENU = "Выберите нужный пункт меню: "
            + "\n\t1 - Показать все ноутбуки"
            + "\n\t2 - Искать"
            + "\n\t5 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void taskMenuSeminar6() {
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(TASK_MENU);
            switch (ScannerHelper.getIntFromInput("Выберите задачу: ")) {
                case 1:
                    Seminar6.viewAllLaptop();
                    break;
                case 2:
                    Seminar6.viewFilterLaptop();
                    break;
                case 5:
                    Menu.startMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Такого действия не существует!");
                    break;
            }
        }
        ScannerHelper.close();
    }
}