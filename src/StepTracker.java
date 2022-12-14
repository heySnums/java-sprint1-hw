public class StepTracker {
    int goal = 10000;
    int[][] steps = new int[12][30];

    //1. Метолд печатает в консоль раскладку шагов за месяц

    void logoutSteps(int month) {
        System.out.print("       "); // отступ
        for (int i = 0; i < steps[month].length - 1; i++) {
            System.out.print((i + 1) + " день: " + steps[month][i] + ", ");
            if ((i + 1) % 10 == 0) {
                System.out.println("  "); // перенос строки для лучшего вида
                System.out.print("       "); // отступ
            }
        }
        System.out.println(steps[month].length + " день: " + steps[month][steps[month].length - 1]); // последний член выведен из цикла, так как надо закончить без запятой
    }

    //2. Метод возвращает суммарное количество шагов за месяц
    int summarySteps(int month) {
        int summ = 0;
        for (int i = 0; i < steps[month].length; i++) {
            summ = summ + steps[month][i];
        }
        return summ;
    }

    //3. Метод возвращает максимальное кол-во шакгов
    int findMaxSteps(int month) {
        int max = 0;
        for (int i = 0; i < steps[month].length; i++) {
            if (max < steps[month][i]) {
                max = steps[month][i];
            }
        }
        return max;
    }

    //4. Метод возвращает среднее количество шагов за месяц
    int findAverageSteps(int month) {
        return summarySteps(month) / steps[month].length;
    }

    //5. Метод возвращает суммарное количество км за месяц
    double convertToKm(int month) {
        Converter converter = new Converter();
        return converter.convertStepToMeter(summarySteps(month));
    }

    //6. Метод возвращает суммарное количество сожженных килокалорий за месяц
    double convertToKCal(int month) {
        Converter converter = new Converter();
        return converter.convertStepToKCAL(summarySteps(month));
    }

    // 7. Метод возвращает максимальный стрик заверщенных целей
    int findBestStreak(int month) {
        int maxStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i < steps[month].length; i++) {
            if (steps[month][i] >= goal) {
                currentStreak = currentStreak + 1;
            } else {
                if (maxStreak < currentStreak) {
                    maxStreak = currentStreak;
                }
                currentStreak = 0;
            }
        }
        if (maxStreak < currentStreak) {
            maxStreak = currentStreak;
        }
        return maxStreak;
    }

    //8. Метод печатает в консоль всю статистику за месяц
    void printStatistic(int month) {
        System.out.println("В " + month + " месяце вы достигли следующих результатов:");
        System.out.println("    1. Ваша ежедневная активность выглядит так:");
        logoutSteps(month);
        System.out.println("    2. Максимальное количество шагов пройденное за день " + findMaxSteps(month) + ".");
        System.out.println("    3. В среднем в день Вы проходили " + findAverageSteps(month) + " шагов.");
        System.out.println("    4. Всего Вы прошли " + convertToKm(month) + " километров.");
        System.out.println("    5. При этом Вы сожгли " + convertToKCal(month) + " килокалорий.");
        System.out.println("    6. Лучшая серия активных дней: " + findBestStreak(month));
    }
}
