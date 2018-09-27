import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Витя on 27.09.2018.
 */
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double array[] = new double[10];
        String helper[];
        boolean complete = false;

        System.out.println("Для перечисления чисел используйте одно нажатие на пробел.");
        System.out.println("Нажатие на пробел более одного раза приведёт к ошибке.");
        System.out.println("Действительные числа разделяйте точкой. Например: 0.5");
        System.out.println("Введите 10 чисел:");

        // Повторяем до тех пор, пока ввод не станет корректным
        do {
            // Т.к. мы не можем доверять пользователю используем try-catch
            try {
                helper = scanner.nextLine().split(" ");
                // Сообщаем пользователю о некорректном вводе, иначе продолжаем работу
                if (helper.length != 10) {
                    System.out.println("Вы ввели не 10 чисел. Попробуйте снова.");
                } else {
                    for (int i = 0; i < helper.length; i++) {
                        array[i] = Double.parseDouble(helper[i]);
                    }
                    complete = true;
                }
            } catch (Throwable e) {
                // Непредвиденые обстоятельства
                System.out.println("Произошла неизвестная ошибка. Попробуйте снова.");
            }
        } while (!complete);

        // Если всё ОК, сортируем и выводим
        Arrays.sort(array);
        for (double i : array) {
            System.out.print(i + " ");
        }
    }
}
