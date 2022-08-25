import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        InputChecker inputChecker = new InputChecker();
        int[] userInput = new int[1];
        while (true) {
            printMenu(stepTracker);
            inputChecker.checkMenuInput(scanner, userInput);
            switch (userInput[0]) {
                case 1:
                    saveSteps(scanner, stepTracker);    //запись  шагов
                    break;
                case 2:
                    printMonthStat(scanner, stepTracker); //печать статистики
                    break;
                case 3:
                    changeGoal(scanner, stepTracker);   // изменение цели
                    break;
                case 4:
                    sayGoodbye();                       // Прощание
                    return;
                default:
                System.out.println("Такой команды нет");
            }
        }
    }

    // 1. Метод печатает в консоль меню
    public static void printMenu(StepTracker stepTracker) {
        System.out.println("##################################");
        System.out.println("Выберете номер желаемого действия");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Вывести статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день. Текущая цель: " + stepTracker.goal + " шага(ов);");
        System.out.println("4. Выйти из приложения.");
    }

    //2. запись шагов в паиять .steps
    public static void saveSteps(Scanner scanner, StepTracker stepTracker) {
        int[] userInput = new int[2];
        int[] stepInput = new int[1];
        InputChecker inputChecker = new InputChecker();
        inputChecker.checkDateInput(scanner, userInput, false);
        inputChecker.checkDateInput(scanner, userInput, true);
        System.out.println("Введите количество шагов пройденных за " + userInput[1] + " день " + userInput[0] + " месяца.");
        inputChecker.checkStepsInput(scanner, stepInput);
        stepTracker.steps[userInput[0]][userInput[1] - 1] = stepInput[0];
    }

    //3. метод печатает в консоль стаистику за введенный пользователем месяц
    public static void printMonthStat(Scanner scanner, StepTracker stepTracker) {
        int[] userInput = new int[2];
        InputChecker inputChecker = new InputChecker();
        inputChecker.checkDateInput(scanner, userInput, false);
        stepTracker.printStatistic(userInput[0]); // выовдим статисткуу за месяц
    }

    //4. Метод  изменяет  целевой показатель .goal
    public static void changeGoal(Scanner scanner, StepTracker stepTracker) {
        int[] stepInput = new int[1];
        InputChecker inputChecker = new InputChecker();
        System.out.println("Введите новую цель. Ты же её увеличишь? Увеличишь же ??..");
        inputChecker.checkStepsInput(scanner, stepInput);
        stepTracker.goal = stepInput[0];
    }

    //5. Метод печатает в конслоль прощания с пользователем
    // вывел в отдельный метод, так как можно реализовать разные проания в зависимости от активности пользователя
    // в ТЗ этого нет, а просто так реализовывать не интересно
    public static void sayGoodbye() {
        System.out.println("Чмоки Чмоки");
    }


}
