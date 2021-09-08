import java.util.*;

public class Main {
    static int N, M, f;
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Здороваемся с пользователем");
        System.out.println("Здравствуйте! Ответьте на несколько нетрудных вопросов!");
        logger.log("Запрашиваем величину списка");
        while (true) {
            System.out.println("Сколько будет чисел в нашем списке?");
            try {
                N = scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.log("Юзер ввёл число в неверном формате");
                System.out.println("Неправильный ввод!");
                scanner = new Scanner(System.in);
                continue;
            }
            if (N < 1) {
                logger.log("Юзер ввёл неположительное число");
                System.out.println("Количество должно быть положительным целым числом!");
                continue;
            }
            logger.log("Получена длина списка: " + N);
            break;
        }
        logger.log("Запрашиваем ограничение на максимальное значение");
        while (true) {
            System.out.println("Каким будет наибольшее возможное число в нашем списке?");
            try {
                M = scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.log("Юзер ввёл число в неверном формате");
                System.out.println("Неправильный ввод!");
                scanner = new Scanner(System.in);
                continue;
            }
            if (M < 1) {
                logger.log("Юзер ввёл слишком маленькое число");
                System.out.println("Это должно быть положительное целое число!");
                continue;
            }
            logger.log("Получено пороговое значение для генерации: " + M);
            break;
        }

        list = new ArrayList<>(N);
        Random random = new Random();
        for (int i = 0; i < N; i++)
            list.add( random.nextInt(M + 1));
        logger.log("Сгенерировали список по заданным параметрам");
        System.out.print("Вот случайный список:");
        for (Integer i : list) System.out.print( " " + i );
        System.out.println();

        logger.log("Запрашиваем порог фильтрации");
        while (true) {
            System.out.println("Меньшие какого числа мы теперь исключим значения?");
            try {
                f = scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.log("Юзер ввёл число в неверном формате");
                System.out.println("Неправильный ввод!");
                scanner = new Scanner(System.in);
                continue;
            }
            if (f < 1 || f > M) {
                logger.log("Юзер ввёл некорректное значение порога");
                System.out.println("Это должно быть число в рамках диапазона!");
                continue;
            }
            logger.log("Получено пороговое значение для фильтрации: " + f);
            break;
        }
        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(list);

        logger.log("Выводим результат");
        System.out.print("Вот отфильтрованный список:");
        for (Integer i : filteredList) System.out.print( " " + i );
        System.out.println();
        logger.log("Завершаем работу программы");
        System.out.println("Спасибо за работу!");
    }
}
