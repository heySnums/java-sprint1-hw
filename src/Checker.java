import java.util.Scanner;

class InputChecker {

    //Метод проверяет инпут на правильность ввода номера месяца или дня
    void checkDateInput(Scanner scanner, int[] userInput, boolean day) {
        StepTracker stepTracker = new StepTracker();
        String s; // вводим переменную для очищения сканнера
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
    //Метод проверяет инпут на правильность ввода количества шагов
    void checkStepsInput(Scanner scanner, int[] userInput) {
        String s; // вводим переменную для очищения сканнера

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
    //Метод проверяет инпут на правильность ввода номера меню
    // для меню можно input обрабатывать строку с равнивать со строками "1", "2", "3","4". Но для однообразия решил  оставить такой же принцип как и везде

    void checkMenuInput(Scanner scanner, int[] userInput) {
        String s; // вводим переменную для очищения сканнера

        while (true) {
            if (scanner.hasNextInt()) { // Проверяем инпут. Д.б Integer
                userInput[0] = scanner.nextInt();
                s = scanner.nextLine(); //  очищаем Сканер
                return;
            } else {// если введена не цифра
                s = scanner.next(); //  очищаем Сканер
                System.out.println("Пожалуйста введите целое положительное число");
            }
        }
    }
}
