import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int N, M, f;
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        System.out.println("Здравствуйте! Ответьте на несколько нетрудных вопросов!");
        logger.log("Здороваемся с пользователем");
        System.out.println("Сколько будет чисел в нашем списке?");
        logger.log("Запрашиваем величину списка");
        while (true) {
            try {
                N = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод!");
                logger.log("Юзер ввёл число в неверном формате");
                continue;
            }
            if (N < 1) {
                System.out.println("Количество должно быть положительным целым числом!");
                logger.log("Юзер ввёл неположительное число");
                continue;
            }
            logger.log("Получена длина списка: " + N);
            break;
        }
        System.out.println("Каким будет наибольшее возможное число в нашем списке?");
        logger.log("Запрашиваем ограничение на максимальное значение");
        while (true) {
            try {
                M = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод!");
                logger.log("Юзер ввёл число в неверном формате");
                continue;
            }
            if (M < 1) {
                System.out.println("Это должно быть положительное целое число!");
                logger.log("Юзер ввёл слишком маленькое число");
                continue;
            }
            logger.log("Получено пороговое значение для генерации: " + M);
            break;
        }

    }
}
