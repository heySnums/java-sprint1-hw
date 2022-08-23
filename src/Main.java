import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int[] userInput = new int[1];
        while (true) {
            printMenu(stepTracker);

            checkInput(scanner, userInput);
            if (userInput[0] == 1) {
                saveSteps(scanner, stepTracker);
            } else if (userInput[0] == 2) {
                printMonthStat(scanner, stepTracker);
            } else if (userInput[0] == 3) {
                changeGoal(scanner, stepTracker);
            } else if (userInput[0] == 4) {
                sayGoodbye();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu(StepTracker stepTracker) {
        System.out.println("##################################");
        System.out.println("Выберете номер желаемого действия");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Вывести статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день. Текущая цель: " + stepTracker.goal + " шага(ов);");
        System.out.println("4. Выйти из приложения.");

    }


    public static void printMonthStat(Scanner scanner, StepTracker stepTracker) {
        int[] userInput = new int[2];
        checkInput(scanner, userInput, false);
        stepTracker.printStatistic(userInput[0]); // выовдим статисткуу за месяц
    }

    public static void saveSteps(Scanner scanner, StepTracker stepTracker) {
        int[] userInput = new int[2];
        int[] stepInput = new int[1];
        checkInput(scanner, userInput, false);
        checkInput(scanner, userInput, true);
        System.out.println("Введите количество шагов пройденных за " + userInput[1] + " день " + userInput[0] + " месяца.");
        checkInput(scanner, stepInput);
        stepTracker.steps[userInput[0]][userInput[1] - 1] = stepInput[0];
    }

    public static void changeGoal(Scanner scanner, StepTracker stepTracker) {
        int[] stepInput = new int[1];
        System.out.println("Введите новую цель. Ты же её увеличишь? Увеличишь же ??..");
        checkInput(scanner, stepInput);
        stepTracker.goal = stepInput[0];
    }

    public static void sayGoodbye() {
        System.out.println("Чмоки Чмоки жирный ублюдок");
    }

    public static void checkInput(Scanner scanner, int[] userInput, boolean day) {
        StepTracker stepTracker = new StepTracker();
        String s = ""; // вводим переменную для очищения сканнера
        int userInputMaxLimit;
        int userInputMinLimit;
        int inputId;
        String dayOrMonth;
        if (day) {
            userInputMaxLimit = stepTracker.steps[0].length;
            userInputMinLimit = 1;
            inputId = 1;
            dayOrMonth = "дня";
        } else {
            userInputMaxLimit = stepTracker.steps.length - 1;
            userInputMinLimit = 0;
            inputId = 0;
            dayOrMonth = "месяца";
        }
        System.out.println("Введите номер " + dayOrMonth + " от " + userInputMinLimit + " до " + userInputMaxLimit);
        while (true) {
            if (scanner.hasNextInt()) { // Проверяем инпут. Д.б Integer
                userInput[inputId] = scanner.nextInt();
                if (userInput[inputId] >= userInputMinLimit && userInput[inputId] <= userInputMaxLimit) {
                    s = scanner.nextLine(); //  очищаем Сканер
                    return;
                } else {// если инпут вне допускаемых пределах
                    System.out.println("Пожалуйста введите НОМЕР " + dayOrMonth + " от " + userInputMinLimit + " до " + userInputMaxLimit);
                    s = scanner.nextLine(); //  очищаем Сканер
                }
            } else {// если введена не цифра
                s = scanner.next(); //  очищаем Сканер
                System.out.println("Пожалуйста введите целое число");
            }
        }
    }

    public static void checkInput(Scanner scanner, int[] userInput) {
        String s = ""; // вводим переменную для очищения сканнера

        while (true) {
            if (scanner.hasNextInt()) { // Проверяем инпут. Д.б Integer
                userInput[0] = scanner.nextInt();
                if (userInput[0] >= 0) {
                    s = scanner.nextLine(); //  очищаем Сканер
                    return;
                } else {
                    s = scanner.nextLine(); //  очищаем Сканер
                    System.out.println("Пожалуйста введите целое положительное число");
                }
            } else {// если введена не цифра
                s = scanner.next(); //  очищаем Сканер
                System.out.println("Пожалуйста введите целое положительное число");
            }
        }
    }
}
